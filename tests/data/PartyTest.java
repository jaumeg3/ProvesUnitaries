package data;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 14/01/17.
 * Party Test
 */
public class PartyTest {
    @Test
    public void testToString() throws Exception {
        Party party = new Party("");
        String expected = "Party{Name=''}";
        Assert.assertEquals(expected,party.toString());
    }

    @Test
    public void TestEquals() throws Exception {
        Party one = new Party("");
        Party two = new Party("");
        assertTrue(one.equals(two));
    }

    @Test
    public void TestHashCode() throws Exception {
        Party one = new Party("");
        Party two = new Party("");
        assertTrue(one.hashCode() == two.hashCode());
    }

}