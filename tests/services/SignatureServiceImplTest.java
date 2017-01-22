package services;

import data.Signature;
import data.Vote;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 21/01/17.
 *
 * Signature Service Implementation Test.
 */
public class SignatureServiceImplTest {
    private Vote vote;
    private SignatureServiceImpl signatureService;

    @Before
    public void setUp() throws Exception {
        this.vote = new Vote("any");
        this.signatureService = new SignatureServiceImpl();
    }

    @Test
    public void TestSign() throws Exception {
        byte[] expected = this.vote.getOption().getBytes();
        assertEquals(new Signature(expected), this.signatureService.sign(this.vote));
    }

}