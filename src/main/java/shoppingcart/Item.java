package shoppingcart;

/**
 * Item with a name, a price and a serial number. At runtime the serial number
 * must be unique and immutable. Name and price may change.
 *
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */
public interface Item {

    /**
     * Retrieve Item name.
     * @return name
     */
    String getName();

    /**
     * set Item name.
     *
     * @param name of the item
     */
    void setName(String name);

    /**
     * get Item price.
     *
     * @return itemPrice
     */
    double getPrice();

    /**
     * Sets Item price.
     *
     * @param price of the item
     */
    void setPrice(double price);

    /**
     * Get the Item's unique and immutable serial number.
     *
     * @return the serial number.
     */
    long getSerialNr();

}
