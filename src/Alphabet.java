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
     * Returns true if the argument is a character in this alphabet.
     *
     * @param  c the character
     * @return {@code true} if {@code c} is a character in this alphabet;
     *         {@code false} otherwise
     */
    public boolean contains(char c) {
        return inverse[c] != -1;
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
}
