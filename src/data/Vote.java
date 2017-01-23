package data;
/**
 * Represents a vote.
 */
final public class Vote {
    private final String option;

    /**
     * Constructor of the class
     * @param option parameter to create the object
     */
    public Vote(String option) {
        this.option = option;
    }

    /**
     * Get's the option String
     * @return String with the option
     */
    public String getOption() {
        return option;
    }

    /**
     * Convert the Vote Option a String
     * @return String with the option of the vote.
     */
    @Override
    public String toString() {
        return "Vote{" +
                "option='" + option + '\'' +
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
        Vote vote = (Vote) o;
        return option.equals(vote.option);
    }

    /**
     * Calculates the hashCode from the option
     * @return Integer that it's the hashCode.
     */
    @Override
    public int hashCode() {
        return option.hashCode();
    }
}