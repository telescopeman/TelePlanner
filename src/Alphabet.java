import java.util.Arrays;

/**
 * From: https://algs4.cs.princeton.edu/55compression/Alphabet.java.html
 * "A data type for alphabets, for use with string-processing code
 * that must convert between an alphabet of size R and the integers
 * 0 through R-1."
 * @author  Robert Sedgewick, Kevin Wayne(?). Abridging by Caleb Copeland.
 */
public class Alphabet {

    /**
     *  The lowercase alphabet { a, b, c, ..., z }.
     */
    public static final Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz");

    /**
     *  The uppercase alphabet { A, B, C, ..., Z }.
     */

    public static final Alphabet UPPERCASE = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZ");

    /**
     *  The protein alphabet { A, C, D, E, F, G, H, I, K, L, M, N, P, Q, R, S, T, V, W, Y }.
     */
    public static final Alphabet PROTEIN = new Alphabet("ACDEFGHIKLMNPQRSTVWY");

    /**
     *  The base-64 alphabet (64 characters).
     */
    public static final Alphabet BASE64 = new Alphabet("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/");

    /**
     *  The ASCII alphabet (0-127).
     */
    public static final Alphabet ASCII = new Alphabet(128);

    /**
     *  The extended ASCII alphabet (0-255).
     */
    public static final Alphabet EXTENDED_ASCII = new Alphabet(256);

    /**
     *  The Unicode 16 alphabet (0-65,535).
     */
    public static final Alphabet UNICODE16      = new Alphabet(65536);


    private final char[] alphabet;     // the characters in the alphabet
    private final int[] inverse;       // indices
    private final int R;         // the radix of the alphabet

    /**
     * Initializes a new alphabet from the given set of characters.
     *
     * @param alpha the set of characters
     */
    public Alphabet(String alpha) {

        // check that alphabet contains no duplicate chars
        boolean[] unicode = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < alpha.length(); i++) {
            char c = alpha.charAt(i);
            if (unicode[c])
                throw new IllegalArgumentException("Illegal alphabet: repeated character = '" + c + "'");
            unicode[c] = true;
        }

        alphabet = alpha.toCharArray();
        R = alpha.length();
        inverse = new int[Character.MAX_VALUE];
        Arrays.fill(inverse, -1);

        // can't use char since R can be as big as 65,536
        for (int c = 0; c < R; c++)
            inverse[alphabet[c]] = c;
    }

    /**
     * Initializes a new alphabet using characters 0 through R-1.
     *
     * @param radix the number of characters in the alphabet (the radix R)
     */
    private Alphabet(int radix) {
        this.R = radix;
        alphabet = new char[R];
        inverse = new int[R];

        // can't use char since R can be as big as 65,536
        for (int i = 0; i < R; i++)
            alphabet[i] = (char) i;
        for (int i = 0; i < R; i++)
            inverse[i] = i;
    }

    /**
     * Initializes a new alphabet using characters 0 through 255.
     */
    public Alphabet() {
        this(256);
    }

    /**
     * Returns true if the argument is a character in this alphabet.
     *
     * @param  c the character
     * @return {@code true} if {@code c} is a character in this alphabet;
     *         {@code false} otherwise
     */
    public boolean contains(char c) {
        return inverse[c] != -1;
    }

    /**
     * Returns the number of characters in this alphabet (the radix).
     *
     * @return the number of characters in this alphabet
     * @deprecated Replaced by {@link #radix()}.
     */
    @Deprecated
    public int R() {
        return R;
    }

    /**
     * Returns the number of characters in this alphabet (the radix).
     *
     * @return the number of characters in this alphabet
     */
    public int radix() {
        return R;
    }

    /**
     * Returns the binary logarithm of the number of characters in this alphabet.
     *
     * @return the binary logarithm (rounded up) of the number of characters in this alphabet
     */
    public int lgR() {
        int lgR = 0;
        for (int t = R-1; t >= 1; t /= 2)
            lgR++;
        return lgR;
    }

    /**
     * Returns the index corresponding to the argument character.
     *
     * @param  c the character
     * @return the index corresponding to the character {@code c}
     * @throws IllegalArgumentException unless {@code c} is a character in this alphabet
     */
    public int toIndex(char c) {
        if (c >= inverse.length || inverse[c] == -1) {
            throw new IllegalArgumentException("Character " + c + " not in alphabet");
        }
        return inverse[c];
    }

    /**
     * Returns the indices corresponding to the argument characters.
     *
     * @param  s the characters
     * @return the indices corresponding to the characters {@code s}
     * @throws IllegalArgumentException unless every character in {@code s}
     *         is a character in this alphabet
     */
    public int[] toIndices(String s) {
        char[] source = s.toCharArray();
        int[] target  = new int[s.length()];
        for (int i = 0; i < source.length; i++)
            target[i] = toIndex(source[i]);
        return target;
    }

    public String toChar(int index)
    {
        return toChar(index,0);
    }

    /**
     * Returns the character corresponding to the argument index.
     *
     * @param  index the index
     * @return the character corresponding to the index {@code index}
     * @throws IllegalArgumentException unless {@code 0 <= index < R}
     */
    private String toChar(int index,int suffix) {
        if (index < 0) {
            throw new IllegalArgumentException("index must be between 0 and " + R + ": " + index);
        }
        else if  (index >= R){
            return toChar(index-R,suffix+1);
        }
        if (suffix > 0)
        {
            return "" + alphabet[index] + suffix;
        }
        else
        {
            return "" + alphabet[index];
        }
    }

    /**
     * Returns the characters corresponding to the argument indices.
     *
     * @param  indices the indices
     * @return the characters corresponding to the indices {@code indices}
     * @throws IllegalArgumentException unless {@code 0 < indices[i] < R}
     *         for every {@code i}
     */
    public String toChars(int[] indices) {
        StringBuilder s = new StringBuilder(indices.length);
        for (int index : indices) s.append(toChar(index));
        return s.toString();
    }
}
