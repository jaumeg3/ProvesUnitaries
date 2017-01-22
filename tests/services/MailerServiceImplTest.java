package services;

import data.MailAddress;
import data.Signature;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Mailer Service Implementation Test.
 */
public class MailerServiceImplTest {

    @Test
    public void TestSend() throws Exception {
        MailAddress address = new MailAddress("AnyAddress");
        Signature signature = new Signature("Any".getBytes());
        MailerServiceImpl mailerService = new MailerServiceImpl();
        mailerService.send(address,signature);
        assertEquals(address,mailerService.address);
        assertEquals(signature,mailerService.signature);
        assertTrue(mailerService.status);
    }

}