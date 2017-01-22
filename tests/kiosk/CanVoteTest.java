package kiosk;

import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Can Vote Test. Method from Voting Machine.
 */
public class CanVoteTest {
    private VotingMachine votingMachine;
    private TrueValidationServiceMock trueValidationServiceMock;
    private ActivationCard card;

    @Before
    public void setUp() throws Exception {
        this.votingMachine = new VotingMachine();
        this.trueValidationServiceMock = new TrueValidationServiceMock();
        this.card = new ActivationCard("AnyCode");
    }

    @Test
    public void TestGoodCanVote() throws Exception {
        this.votingMachine.setValidationService(trueValidationServiceMock);
        this.votingMachine.activateEmission(this.card);
        assertTrue(this.votingMachine.canVote());
    }

    @Test
    public void TestBadCanVote() throws Exception {
        assertTrue(!this.votingMachine.canVote());
    }

}