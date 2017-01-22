package kiosk;

import data.Vote;
import mocks.TrueValidationServiceMock;
import org.junit.Before;
import org.junit.Test;
import services.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Vote Test. Method from Voting Machine.
 */
public class VoteTest {
    Vote vote;
    VotingMachine votingMachine;

    @Before
    public void setUp() throws Exception {
        this.vote = new Vote("AnyParty");
        this.votingMachine = new VotingMachine();
    }

    @Test(expected = IllegalStateException.class)
    public void TestBadVote() throws Exception {
        this.votingMachine.vote(this.vote);
    }

    @Test
    public void TestGoodVote() throws Exception {
        ActivationCard card = new ActivationCard("Any");
        TrueValidationServiceMock trueValidationServiceMock = new TrueValidationServiceMock();
        VotePrinterImpl votePrinter = new VotePrinterImpl();
        VotesDBImpl votesDB = new VotesDBImpl();
        this.votingMachine.setVotePrinter(votePrinter);
        this.votingMachine.setVotesDB(votesDB);
        this.votingMachine.setValidationService(trueValidationServiceMock);
        this.votingMachine.activateEmission(card);
        this.votingMachine.vote(this.vote);
        List<Vote> lst = new ArrayList<>();
        lst.add(this.vote);
        assertEquals(votesDB.getVotes(),lst);
        // Print
        assertTrue(votingMachine.hasVoted);
    }


}