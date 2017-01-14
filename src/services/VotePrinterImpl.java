package services;

import data.Vote;

/**
 * Created by jaume on 14/01/17.
 * Vote Printer Implementation
 */
public class VotePrinterImpl implements VotePrinter{
    @Override
    public void print(Vote vote) {
        System.out.print(vote);
    }
}