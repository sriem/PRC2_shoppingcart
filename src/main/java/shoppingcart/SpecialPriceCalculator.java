package shoppingcart;

/**
 * Allows to calculate prices in case of special offers. 
 * GoF Strategy interface.
 * 
 * @author Pieter van den Hombergh (hom)
 */
public interface SpecialPriceCalculator {

    /**
     * Compute sales price for the content.
     *
     * @param cart
     * @return
     */
    double getSalesPrice( ShoppingCart cart );
}
