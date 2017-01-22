package kiosk;

import com.sun.jndi.cosnaming.IiopUrl;
import data.MailAddress;
import data.Vote;
import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;
import services.MailerService;
import services.MailerServiceImpl;
import services.SignatureServiceImpl;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Send Receipt Test. Method from Voting Machine.
 */
public class SendReceiptTest {
    VotingMachine votingMachine;
    MailAddress mailAddress;
    ActivationCard card;
    TrueValidationServiceMock trueValidation;
    MailerServiceImpl mailerService;
    SignatureServiceImpl signatureService;


    @Before
    public void setUp() throws Exception {
        this.votingMachine = new VotingMachine();
        this.card = new ActivationCard("AnyCode");
        this.mailAddress = new MailAddress("AnyAddress");
        this.trueValidation = new TrueValidationServiceMock();
        this.mailerService = new MailerServiceImpl();
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

        this.votingMachine.activateEmission(this.card);
        this.votingMachine.vote(vote);
        this.votingMachine.sendReceipt(this.mailAddress);
        assertEquals(this.mailAddress,this.mailerService.address);
        //assertEquals(this.signatureService.sign(vote), this.mailerService.signature);
        //assertTrue(this.mailerService.status);
    }
}