package data;
/**
 * Represents a Party.
 */
final public class Party {
    private final String name;

    public Party(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Party{" +
                "Name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Party party = (Party) o;
        return name.equals(party.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}