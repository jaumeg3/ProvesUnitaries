package mocks;

import kiosk.ActivationCard;
import services.ValidationServiceImpl;

/**
 * Created by jaume on 21/01/17.
 *
 * Validation Service Mock
 */
public class TrueValidationServiceMock extends ValidationServiceImpl{

    @Override
    public boolean validate(ActivationCard card) {
        return true;
    }
}