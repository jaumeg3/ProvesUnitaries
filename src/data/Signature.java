package data;
/**
 * Represents a Signature.
 */
final public class Signature {
    private final byte[] signature;

    public Signature(byte[] signature) {
        this.signature = signature;
    }

    public byte[] getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "Signature{" +
                "signature='" + signature + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Signature signature = (Signature) o;
        return signature.equals(signature.signature);
    }

    @Override
    public int hashCode() {
        return signature.hashCode();
    }
}