package shoppingcart;

/*
 * Thrown on underflow condition of container.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class NegativeCountException extends RuntimeException {

    /**
     * Implementation serial number.
     */
    private static final long serialVersionUID = 1L;

    public NegativeCountException(String m) {
        super(m);
    }
}
