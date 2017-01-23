package kiosk;

/**
 * Created by Jaume on 04/01/17.
 * Activation Card
 */
public class ActivationCard {

    private String code;
    private boolean cardState;

    /**
     * Constructor of the class
     * @param code Parameter to create the object
     */
    public ActivationCard (String code) {
        this.code = code;
        this.cardState = true;
    }

    /**
     * This function deletes the code of the card. It puts the status of the card to false.
     */
    public void erase() {
        this.cardState = false;
    }

    /**
     * This functions prove the status of the card
     * @return Boolean if the card is active or not
     */
    public boolean isActive() {
        return this.cardState;
    }

    /**
     * Get's the code of the Activation Card
     * @return String with the code
     */
    String getCode() {
        return this.code;
    }

    /**
     * Prove if an object is equal to another object of this class.
     * @param o Object
     * @return if the object is equals it returns true, if not it returns false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivationCard card = (ActivationCard) o;
        return code.equals(card.code);
    }

    /**
     * Calculates the hashCode from the code
     * @return Integer that it's the hashCode.
     */
    @Override
    public int hashCode() {
        return code.hashCode();
    }

}