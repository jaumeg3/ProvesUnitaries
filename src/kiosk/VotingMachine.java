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
    private ActivationCard card;

    public VotingMachine() {
        this.validationService = null;
        this.votePrinter = null;
        this.votesDB = null;
        this.signatureService = null;
        this.mailerService = null;
        this.machineActive = false;
        this.hasVoted = false;
        this.vote = null;
    }

    public void setValidationService(ValidationServiceImpl validationService) {
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

    public void activateEmission(ActivationCard card) throws IllegalStateException {
        if (validationService.validate(card) && !this.machineActive) {
            this.machineActive = true;
        }
        else {
            throw new IllegalStateException();
        }
    }

    public boolean canVote() {
        return this.machineActive;
    }

    public void vote(Vote vote) throws IllegalStateException {
        if (canVote()) {
            this.vote = vote;
            this.votesDB.registerVote(vote);
            this.votePrinter.print(vote);
            this.hasVoted = true;
            this.machineActive = false;
            this.validationService.deactivate(this.card);
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void sendReceipt(MailAddress address) throws IllegalStateException {
        if (this.hasVoted && !canVote()) {
            this.mailerService.send(address, signatureService.sign(this.vote));
        }
        else {
            throw new IllegalStateException();
        }
    }
}