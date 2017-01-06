package kiosk;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 06/01/17.
 * Activation Card Test
 */

public class ActivationCardTest {

    private ActivationCard testingCard;

    @Before
    public void setUp() throws Exception {
        this.testingCard = new ActivationCard("00000");
    }

    @Test
    public void eraseTest() throws Exception {
        System.out.print("erase Test");
        this.testingCard.erase();
        assertTrue(!this.testingCard.isActive());
    }

    @Test
    public void isActiveTest() throws Exception {
        System.out.print("isActive Test");
        assertTrue(this.testingCard.isActive());
    }

    @Test
    public void getCodeTest() throws Exception {
        System.out.print("getCode Test");
        assertEquals("00000",this.testingCard.getCode());
    }

    @Test
    public void wrongGetCodeTest() throws Exception {
        System.out.print("Wrong getCode Test");
        String wrong = "00001";
        assertEquals(1 , wrong.compareTo(this.testingCard.getCode()));
    }
}