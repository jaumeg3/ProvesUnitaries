package kiosk;

import data.Vote;
import org.junit.Before;
import org.junit.Test;
import services.VotePrinter;
import services.VotePrinterImpl;
import services.VotesDB;
import services.VotesDBImpl;

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

    }


}