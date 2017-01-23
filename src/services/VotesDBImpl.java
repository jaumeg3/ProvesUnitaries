package services;

import data.Vote;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaume on 14/01/17.
 * Votes DB Implementation
 */
public class VotesDBImpl implements VotesDB{

    private List<Vote> dataBase;

    /**
     * Constructor of the class. Initialize a list of votes.
     */
    public VotesDBImpl() {
        this.dataBase = new ArrayList<>();
    }

    /**
     * Register a vote. Includes the vote in the list.
     * @param vote Vote to register
     */
    @Override
    public void registerVote(Vote vote) {
        this.dataBase.add(vote);
    }

    /**
     * Returns a list of the votes
     * @return List of votes
     */
    @Override
    public List<Vote> getVotes() {
        return this.dataBase;
    }
}