package data;

import java.util.Arrays;

/**
 * Represents a Signature.
 */
final public class Signature {
    private final byte[] signature;

    /**
     * Constructor of the class
     * @param signature Parameter to create the class
     */
    public Signature(byte[] signature) {
        this.signature = signature;
    }

    /**
     * Get's the signature byte array
     * @return Byte Array with the signature
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * Convert the Signature Array Bytes a String
     * @return String with the name of the party.
     */
    @Override
    public String toString() {
        return "Signature{" +
                "signature='" + Arrays.toString(signature) + '\'' +
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
        Signature sign = (Signature) o;
        return Arrays.equals(signature, sign.signature);
    }

    /**
     * Calculates the hashCode from the signature
     * @return Integer that it's the hashCode.
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(signature);
    }
}