package services;

import data.Vote;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Votes DB Implementation Test
 */
public class VotesDBImplTest {
    VotesDBImpl votesDB;
    Vote vote;
    List<Vote> expected;

    @Before
    public void setUp() throws Exception {
        this.votesDB = new VotesDBImpl();
        this.vote = new Vote("Any");
        this.expected = new ArrayList<>();
    }

    @Test
    public void TestRegisterVote() throws Exception {
        this.votesDB.registerVote(this.vote);
        this.expected.add(this.vote);
        assertEquals(this.expected,this.votesDB.getVotes());
    }

    @Test
    public void TestGetVotes() throws Exception {
        for (int x=0; x < 3; x++) {
            this.votesDB.registerVote(this.vote);
            this.expected.add(this.vote);
        }
        assertEquals(this.expected, this.votesDB.getVotes());
    }

}