package services;

import kiosk.ActivationCard;

/**
 * Validation Service Implementation
 */
public class ValidationServiceImpl implements ValidationService {

    public boolean validate(ActivationCard card) {
        return card.isActive();
    }

    public void deactivate(ActivationCard card) {
        card.erase();
    }

}