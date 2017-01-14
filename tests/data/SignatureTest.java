package data;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by jaume on 14/01/17.
 * Signature Test
 */
public class SignatureTest {
    @Test
    public void TestToString() throws Exception {
        Signature signature = new Signature("".getBytes());
        String expected = "Signature{signature='" + Arrays.toString("".getBytes())+ "'}";
        assertEquals(expected,signature.toString());
    }

    @Test
    public void TestEquals() throws Exception {
        Signature one = new Signature("".getBytes());
        Signature two = new Signature("".getBytes());
        assertTrue(one.equals(two));
    }

    @Test
    public void TestHashCode() throws Exception {
        Signature one = new Signature("".getBytes());
        Signature two = new Signature("".getBytes());
        assertTrue(one.hashCode() == two.hashCode());
    }

}