package kiosk;

/**
 * Created by Jaume on 04/01/17.
 * Activation Card
 */
public class ActivationCard {

    private String code;
    private boolean cardState;

    public ActivationCard (String code) {
        this.code = code;
        this.cardState = true;
    }

    public void erase() {
        this.cardState = false;
    }

    public boolean isActive() {
        return this.cardState;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActivationCard card = (ActivationCard) o;
        return code.equals(card.code);
    }

    @Override
    public int hashCode() {
        return code.hashCode();
    }

}