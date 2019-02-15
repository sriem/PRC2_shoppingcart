/**
 * ShoppingCart interface as base for exercises in JUNIT testing
 */
package shoppingcart;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
/**
 * A shopping cart that can be configured with a calculator .
 * @author Pieter van den Hombergh (879417) {@code p.vandenhombergh@fontys.nl}
 */
public interface ShoppingCart extends Iterable<Map.Entry<Item,Integer>> {

    /**
     * Add this many of item to cart.
     * @param anItem : type
     * @param quantity : the count to add
     * @exception NegativeCountException on negative add
     */
    void addItems(Item anItem,
            int quantity)
            throws NegativeCountException;

    /**
     * Delete this many of item from cart.
     * @param anItem : Item type
     * @param quantity : the count to delete
     * @exception NegativeCountException on underflow
     * @exception NoSuchItemException on non-existing Item
     */
    void deleteItems(Item anItem,
            int quantity)
            throws NegativeCountException,
            NoSuchItemException;

    /**
     * Count all items. 6 Books + 2 Bottles = 8.
     * @return number of items in cart
     */
    int itemCount();

    /**
     * Count items of give type.
     * @param item to count
     * @return the amount of the given item
     */
    int countItem(Item item) throws NoSuchItemException;

    /**
     * Get Iterator.
     * @return iterator of all item,amount pairs in cart.
     * @exception NoSuchItemException on nonexisting Item
     * Note that the Iterator returns a {@code <Item,Integer> pair} as a
     * java.util.Map.Entry
     */
    @Override
    Iterator<Entry<Item, Integer>> iterator();

    /**
     * Get value of contents.
     * @return the price of all goods contained
     */
    double getContentsPrice();

    /**
     * For special sales like with two cola you get a bubble gum for free.
     * @return the sales price
     */
    double getSpecialPrice();

    /**
     * Set prices calculator strategy.
     * @param specialPriceCalculator calculator to use
     */
    void setSpecialPriceCalculator(SpecialPriceCalculator specialPriceCalculator);

    void deleteAllItems();
}
