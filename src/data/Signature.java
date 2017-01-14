package data;

import java.util.Arrays;

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
        Signature sign = (Signature) o;
        return Arrays.equals(signature, sign.signature);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(signature);
    }
}