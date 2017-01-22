package services;

import kiosk.ActivationCard;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jaume on 22/01/17.
 *
 * Validation Service Implementation
 */
public class ValidationServiceImplTest {
    private ActivationCard card;
    private ValidationServiceImpl validationService;

    @Before
    public void setUp() throws Exception {
        this.card = new ActivationCard("anyCode");
        this.validationService = new ValidationServiceImpl();
    }

    @Test
    public void TestValidate() throws Exception {
        assertTrue(this.validationService.validate(this.card));
    }

    @Test
    public void TestDeactivate() throws Exception {
        this.validationService.deactivate(this.card);
        assertTrue(!this.validationService.validate(this.card));
    }

}