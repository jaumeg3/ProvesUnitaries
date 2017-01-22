package mocks;

import data.Vote;
import services.VotePrinterImpl;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by jaume on 23/01/17.
 *
 * Vote Printer Mock.
 */
public class VotePrinterMock extends VotePrinterImpl {
    public final ByteArrayOutputStream outContentMock = new ByteArrayOutputStream();
    public final ByteArrayOutputStream errContentMock = new ByteArrayOutputStream();


    public void print(Vote vote) {
        System.setOut(new PrintStream(outContentMock));
        System.setErr(new PrintStream(errContentMock));
        System.out.print(vote);
    }

}
