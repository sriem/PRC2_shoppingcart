package shoppingcart;

import java.util.*;
import java.util.Map.Entry;

/**
 * Implements ShoppingCart .
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public class ShoppingCartImpl implements ShoppingCart {

    private final Map<Item, Integer> map;
    private SpecialPriceCalculator calculator = new DefaultCalculator();

    /**
     * Default constructor instantiating map and calculator.
     */
    public ShoppingCartImpl() {
        map = new HashMap<>();
        calculator = new DefaultCalculator();
    }

    /* (non-Javadoc)
     * @see shop.ShoppingCart#addItems(shop.Item, int)
     */
    @Override
    public void addItems(Item anItem, int quantity)
            throws NegativeCountException {
        if (quantity < 0) {
            throw new NegativeCountException("Item count was negative: " + quantity);
        } else {
            map.put(anItem, quantity);
        }
    }

    /* (non-Javadoc)
     * @see shop.ShoppingCart#deleteItems(shop.Item, int)
     */
    @Override
    public void deleteItems(Item anItem, int quantity)
            throws NegativeCountException, NoSuchItemException {
        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            String itemName = entry.getKey().getName();
            Integer actualAmountThisItem = entry.getValue();
            if (itemName.equals(anItem.getName())) {
                if (actualAmountThisItem <= quantity) {
                    map.remove(entry.getKey());
                    return;
                } else {
                    entry.setValue(actualAmountThisItem - quantity);
                    return;
                }

            }
        }
        throw new NoSuchItemException("Your Item was not found.");
    }

    public void deleteAllItems() {
        List<Item> itemsToDelete = new ArrayList<>();
        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            itemsToDelete.add(entry.getKey());
        }
        for (int i = 0; i < itemsToDelete.size();i++){
            map.remove(itemsToDelete.get(i));
        }
    }


    /* (non-Javadoc)
     * @see shop.ShoppingCart#itemCount()
     */
    @Override
    public int itemCount() {
        int counter = 0;
        for (Item key : map.keySet()) {
            counter++;
        }
        return counter;
    }

    /* (non-Javadoc)
     * @see shop.ShoppingCart#countItem(shop.Item)
     */
    @Override
    public int countItem(Item item) throws NoSuchItemException {
        int countItem = 0 ;
        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            if (item.equals(entry.getKey())) {
                countItem+=entry.getValue();
                return countItem;
            }
        }

        throw new NoSuchItemException("Your Item was not found.");
    }

    /* (non-Javadoc)
     * @see shop.ShoppingCart#iterator()
     */
    @Override
    public Iterator<Entry<Item, Integer>> iterator() {
        return map.entrySet().iterator();
    }

    /* (non-Javadoc)
     * @see shop.ShoppingCart#getContentsPrice()
     */
    @Override
    public double getContentsPrice() {
        Iterator<Entry<Item, Integer>> itr = this.iterator();
        double sum = 0;
        Entry<Item, Integer> e;

        for (Map.Entry<Item, Integer> entry : map.entrySet()) {
            int multiplyer = entry.getValue();
            double price = entry.getKey().getPrice();
            double priceSum = multiplyer * price;

            sum += priceSum;
        }
        return sum;
    }

    @Override
    public double getSpecialPrice() {
        if(getContentsPrice() >= 1.25 * 3){
            return getContentsPrice() - 0.20;
        } else {
            return getContentsPrice();
        }

    }

    @Override
    public void setSpecialPriceCalculator(SpecialPriceCalculator cp) {
        if (null != cp) {
            this.calculator = cp;
        }
    }

    /**
     * Default implementation simply returns content price.
     */
    public static class DefaultCalculator implements SpecialPriceCalculator {

        @Override
        public double getSalesPrice(ShoppingCart cart) {
            return cart.getContentsPrice();
        }
    }
}
