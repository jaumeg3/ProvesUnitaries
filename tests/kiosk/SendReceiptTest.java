package kiosk;

import data.MailAddress;
import data.Signature;
import data.Vote;
import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;
import services.MailerServiceImpl;
import services.SignatureServiceImpl;
import services.VotePrinterImpl;
import services.VotesDBImpl;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Send Receipt Test. Method from Voting Machine.
 */
public class SendReceiptTest {
    private VotingMachine votingMachine;
    private MailAddress mailAddress;
    private ActivationCard card;
    private TrueValidationServiceMock trueValidation;
    private MailerServiceImpl mailerService;
    private SignatureServiceImpl signatureService;


    @Before
    public void setUp() throws Exception {
        this.votingMachine = new VotingMachine();
        this.card = new ActivationCard("AnyCode");
        this.mailAddress = new MailAddress("AnyAddress");
        this.trueValidation = new TrueValidationServiceMock();
        this.mailerService = new MailerServiceImpl();
        this.signatureService = new SignatureServiceImpl();
    }

    @Test(expected = IllegalStateException.class)
    public void TestBadMachineSendReceipt() throws Exception {
        this.votingMachine.setValidationService(this.trueValidation);
        this.votingMachine.sendReceipt(this.mailAddress);
    }

    @Test(expected = IllegalStateException.class)
    public void TestBadHasVotedSendReceipt() throws Exception {
        this.votingMachine.setValidationService(this.trueValidation);
        this.votingMachine.activateEmission(this.card);
        this.votingMachine.sendReceipt(this.mailAddress);
    }

    @Test
    public void TestGoodSendReceipt() throws Exception {
        Vote vote = new Vote("AnyVote");
        this.votingMachine.setValidationService(this.trueValidation);
        this.votingMachine.setSignatureService(this.signatureService);
        this.votingMachine.setMailerService(this.mailerService);
        this.votingMachine.setVotesDB(new VotesDBImpl());
        this.votingMachine.setVotePrinter(new VotePrinterImpl());

        this.votingMachine.activateEmission(this.card);
        this.votingMachine.vote(vote);
        this.votingMachine.sendReceipt(this.mailAddress);
        assertEquals(this.mailAddress,this.mailerService.address);
        Signature expect = this.signatureService.sign(vote);
        assertEquals(expect, this.mailerService.signature);
        assertTrue(this.mailerService.status);
    }
}