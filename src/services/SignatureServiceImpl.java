package services;

import data.Signature;
import data.Vote;

/**
 * Created by jaume on 14/01/17.
 * Signature Service Implementation
 */
public class SignatureServiceImpl implements SignatureService{

    /**
     * Implements the Signature Method.
     * @param vote Parameter that will be signed
     * @return Signature of the vote that you have emmit
     */
    @Override
    public Signature sign(Vote vote) {
        return new Signature(vote.toString().getBytes());
    }
}