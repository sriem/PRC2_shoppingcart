package shoppingcart;

/*
 * Item.
 * @author Pieter van den Hombergh {@code p.vandenhombergh@fontys.nl}
 */

public class ItemImpl implements Item {

    /**
     * class member to produce an auto incrementing number. Numbering starts at
     * 1 (with ++lastSerialNr)
     */
    private static long lastSerialNr = 0;
    /**
     * The unique immutable serial number.
     */
    protected final long serialNr;
    /**
     * Mutable name
     */
    private String name;

    /**
     * Mutable price
     */
    private double price;

    /**
     * Default constructor "Unnamed" price 0.00
     */
    public ItemImpl() {
        this("Unnamed", 0.0);
    }

    /**
     * Initialised with a name, price 0.00.
     *
     * @param name
     */
    public ItemImpl(String name) {
        this(name, 0.0);
    }

    /**
     * Initialized with name and price
     *
     * @param name
     * @param price
     */
    public ItemImpl(String name, double price) {
        serialNr = ++lastSerialNr;
        this.name = name;
        this.price = price;
    }

    /**
     * @see shop.Item#getName()
     */
    public String getName() {
        return name;
    }

    /**
     * @see shop.Item#setName(java.lang.String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @see shop.Item#getPrice()
     */
    public double getPrice() {
        return price;
    }

    /**
     * @see shop.Item#setPrice(double)
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * the number of the last constructed Item
     *
     * @return last serial number given out.
     */
    public static long getLastSerialNr() {
        return lastSerialNr;
    }

    /**
     * @see shop.Item#getSerialNr()
     */
    public long getSerialNr() {
        return serialNr;
    }

    @Override
    public String toString() {
        return getName() + " at " + getPrice();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + (int) (this.serialNr ^ (this.serialNr >>> 32));
        hash = 67 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ItemImpl other = (ItemImpl) obj;
        if (this.serialNr != other.serialNr) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        return true;
    }

}
