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

    public VotingMachine() {
        this.validationService = null;
        this.votePrinter = null;
        this.votesDB = null;
        this.signatureService = null;
        this.mailerService = null;
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
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public boolean canVote() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void vote(Vote vote) throws IllegalStateException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    public void sendReceipt(MailAddress address) throws IllegalStateException {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
