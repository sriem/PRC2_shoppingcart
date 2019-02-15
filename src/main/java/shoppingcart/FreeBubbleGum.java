package shoppingcart;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Concrete SpecialPricecalculator where you get a bubble gum per two bottles of
 * Cola.
 *
 * @author hom
 */
public class FreeBubbleGum implements SpecialPriceCalculator {

    @Override
    public double getSalesPrice( ShoppingCart cart ) {

        return cart.getSpecialPrice();

    }

}
