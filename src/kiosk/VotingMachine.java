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
    boolean hasVoted;
    private Vote vote;
    private ActivationCard card;

    /**
     * Constructor of the class
     */
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

    /**
     * Set's the validation service
     * @param validationService that you want
     */
    void setValidationService(ValidationServiceImpl validationService) {
        this.validationService = validationService;
    }

    /**
     * Set's the vote printer service
     * @param votePrinter that you want
     */
    void setVotePrinter(VotePrinterImpl votePrinter) {
        this.votePrinter = votePrinter;
    }

    /**
     * Set's the Votes DB service
     * @param votesDB that you want
     */
    void setVotesDB(VotesDBImpl votesDB) {
        this.votesDB = votesDB;
    }

    /**
     * Set's the Signature service
     * @param signatureService that you want
     */
    void setSignatureService(SignatureServiceImpl signatureService) {
        this.signatureService = signatureService;
    }

    /**
     * Set's the mailer service
     * @param mailerService that you want
     */
    void setMailerService(MailerServiceImpl mailerService) {
        this.mailerService = mailerService;
    }

    /**
     * Activate the voting machine if the card is valid and the voting machine it's offline
     * @param card Card to activate the voting machine
     * @throws IllegalStateException if the card is invalid or the machine it's online
     */
    void activateEmission(ActivationCard card) throws IllegalStateException {
        if (validationService.validate(card) && !this.machineActive) {
            this.machineActive = true;
            this.card = card;
        }
        else {
            throw new IllegalStateException();
        }
    }

    /**
     * Prove if the people can vote or not
     * @return Boolean status of the machine
     */
    boolean canVote() {
        return this.machineActive;
    }

    /**
     * Represent's the action of vote
     * @param vote Is the vote
     * @throws IllegalStateException if the people can't vote
     */
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

    /**
     * Send a receipt of the vote that you have done
     * @param address Mail Address where it will send the receipt
     * @throws IllegalStateException if you haven't vote or the machine is online
     */
    void sendReceipt(MailAddress address) throws IllegalStateException {
        if (this.hasVoted && !canVote()) {
            this.mailerService.send(address,this.signatureService.sign(this.vote));
        }
        else {
            throw new IllegalStateException();
        }
    }
}