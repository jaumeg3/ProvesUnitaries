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
    public void erase() throws Exception {
        System.out.print("erase Test");
        this.testingCard.erase();
        assertTrue(!this.testingCard.isActive());
    }

    @Test
    public void isActive() throws Exception {
        System.out.print("isActive Test");
        assertTrue(this.testingCard.isActive());
    }

    @Test
    public void getCode() throws Exception {
        System.out.print("getCode Test");
        assertEquals("00000",this.testingCard.getCode());
    }
}