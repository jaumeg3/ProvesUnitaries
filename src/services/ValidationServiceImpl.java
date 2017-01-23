package services;

import kiosk.ActivationCard;

/**
 * Validation Service Implementation
 */
public class ValidationServiceImpl implements ValidationService {

    /**
     * Validate Method Implementation. Return if the card is active or not.
     * @param card Parameter to evaluate
     * @return Boolean that returns the status of the card.
     */
    public boolean validate(ActivationCard card) {
        return card.isActive();
    }

    /**
     * Deactivate Method Implementation. Erase the card.
     * @param card Parameter to deactivate
     */
    public void deactivate(ActivationCard card) {
        card.erase();
    }

}