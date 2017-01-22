package mocks;

import services.VotePrinterImpl;
import data.*;

import java.io.ByteArrayOutputStream;

/**
 * Created by jaume on 22/01/17.
 *
 * Vote Printer Mock.
 */
public class VotePrinterMock extends VotePrinterImpl {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();


}
