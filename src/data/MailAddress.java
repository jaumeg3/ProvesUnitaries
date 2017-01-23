package data;
/**
 * Represents a MailAddress.
 */
final public class MailAddress {
    private final String address;

    /**
     * Mail Address Constructor
     * @param address Parameter to send the receipt.
     */
    public MailAddress(String address) {
        this.address = address;
    }

    /**
     * Get the Mail Address
     * @return return the mail address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Convert the Mail Address a String
     * @return String with the Mail Address
     */
    @Override
    public String toString() {
        return "MailAddress{" +
                "address='" + address + '\'' +
                '}';
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
        MailAddress mailAddress = (MailAddress) o;
        return address.equals(mailAddress.address);
    }

    /**
     * Calculates the hashCode from the mail address
     * @return Integer that it's the hashCode.
     */
    @Override
    public int hashCode() {
        return address.hashCode();
    }
}