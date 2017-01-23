package data;
/**
 * Represents a Party.
 */
final public class Party {
    private final String name;

    /**
     * Party Constructor
     * @param name Parameter to create a Party
     */
    Party(String name) {
        this.name = name;
    }

    /**
     * Get's the name of the party
     * @return It returns the name of the party.
     */
    public String getName() {
        return name;
    }

    /**
     * Convert the Name Party a String
     * @return String with the name of the party.
     */
    @Override
    public String toString() {
        return "Party{" +
                "Name='" + name + '\'' +
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
        Party party = (Party) o;
        return name.equals(party.name);
    }

    /**
     * Calculates the hashCode from the name of the party
     * @return Integer that it's the hashCode.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}