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

    public VotesDBImpl() {
        this.dataBase = new ArrayList<>();
    }

    @Override
    public void registerVote(Vote vote) {
        this.dataBase.add(vote);
    }

    @Override
    public List<Vote> getVotes() {
        return this.dataBase;
    }
}