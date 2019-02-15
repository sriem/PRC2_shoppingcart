package shoppingcart;

/**
 * Specific exception. Extends RuntimeException to make it an unchecked
 * exception. Thrown on retrieval of non-existing item.
 *
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class NoSuchItemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NoSuchItemException( String m ) {
        super( m );
    }

}
