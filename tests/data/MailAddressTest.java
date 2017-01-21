package data;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by jaume on 14/01/17.
 * Mail Address Test
 */
public class MailAddressTest {

    @Test
    public void testToString() throws Exception {
        MailAddress mailAddress = new MailAddress("");
        String expected = "MailAddress{address=''}";
        Assert.assertEquals(expected,mailAddress.toString());
    }


    @Test
    public void testEquals() throws Exception {
        MailAddress one = new MailAddress("");
        MailAddress two = new MailAddress("");
        Assert.assertTrue(one.equals(two));
    }

    @Test
    public void testHashCode() throws Exception {
        MailAddress one = new MailAddress("one");
        MailAddress two = new MailAddress("one");
        Assert.assertTrue(one.hashCode() == two.hashCode());
    }

}