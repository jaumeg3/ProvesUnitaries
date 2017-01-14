package data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 14/01/17.
 * Vote Test
 */
public class VoteTest {
    @Test
    public void testToString() throws Exception {
        Vote vote = new Vote("");
        String expected = "Vote{option=''}";
        assertEquals(expected,vote.toString());
    }

    @Test
    public void testEquals() throws Exception {
        Vote one = new Vote("");
        Vote two = new Vote("");
        assertTrue(one.equals(two));
    }

    @Test
    public void testHashCode() throws Exception {
        Vote one = new Vote("");
        Vote two = new Vote("");
        assertTrue(one.hashCode() == two.hashCode());
    }

}