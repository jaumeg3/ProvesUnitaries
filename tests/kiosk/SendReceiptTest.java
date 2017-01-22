package kiosk;

import data.MailAddress;
import data.Vote;
import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;

import javax.swing.table.TableRowSorter;

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

    @Before
    public void setUp() throws Exception {
        this.votingMachine = new VotingMachine();
        this.card = new ActivationCard("AnyCode");
        this.mailAddress = new MailAddress("AnyAddress");
        this.trueValidation = new TrueValidationServiceMock();
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

    }
}