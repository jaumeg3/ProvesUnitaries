package services;

import data.Vote;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Vote Printer Test
 */
public class VotePrinterImplTest {
    private VotePrinterImpl votePrinter;
    private Vote vote;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        this.votePrinter = new VotePrinterImpl();
        this.vote = new Vote("AnyParty");
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

    }

    @Test
    public void TestPrint() throws Exception {
        this.votePrinter.print(this.vote);
        assertEquals("AnyParty",this.outContent.toString());
        assertEquals("",this.errContent.toString());
    }

}