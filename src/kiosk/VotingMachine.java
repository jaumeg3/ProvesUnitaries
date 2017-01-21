package kiosk;

import data.*;
import services.*;

/**
 * Implements a simplification of Use Case: Emit Vote
 */

public class VotingMachine {
    private ValidationServiceImpl validationService;
    private VotePrinterImpl votePrinter;
    private VotesDBImpl votesDB;
    private SignatureServiceImpl signatureService;
    private MailerServiceImpl mailerService;
    private boolean machineActive;
    private boolean hasVoted;
    private Vote vote;

    VotingMachine() {
        this.validationService = null;
        this.votePrinter = null;
        this.votesDB = null;
        this.signatureService = null;
        this.mailerService = null;
        this.machineActive = false;
        this.hasVoted = false;
        this.vote = null;
    }

    void setValidationService(ValidationServiceImpl validationService) {
        this.validationService = validationService;
    }

    public void setVotePrinter(VotePrinterImpl votePrinter) {
        this.votePrinter = votePrinter;
    }

    public void setVotesDB(VotesDBImpl votesDB) {
        this.votesDB = votesDB;
    }

    public void setSignatureService(SignatureServiceImpl signatureService) {
        this.signatureService = signatureService;
    }

    public void setMailerService(MailerServiceImpl mailerService) {
        this.mailerService = mailerService;
    }

    void activateEmission(ActivationCard card) throws IllegalStateException {
        if (validationService.validate(card) && !this.machineActive) {
            this.machineActive = true;
        }
        else {
            throw new IllegalStateException();
        }
    }

    boolean canVote() {
        return this.machineActive;
    }

    public void vote(Vote vote) throws IllegalStateException {
        if (canVote()) {
            this.vote = vote;
            this.hasVoted = true;
            this.machineActive = false;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void sendReceipt(MailAddress address) throws IllegalStateException {
        if (this.hasVoted && !this.machineActive) {
            this.mailerService.send(address, signatureService.sign(this.vote));
        }
    }
}
