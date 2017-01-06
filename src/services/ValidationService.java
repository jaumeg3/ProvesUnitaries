package services;

import kiosk.ActivationCard;

/**
 * Local service for validating activation cards
 */

public interface ValidationService {
    boolean validate(ActivationCard card);
    void deactivate(ActivationCard card);
}
