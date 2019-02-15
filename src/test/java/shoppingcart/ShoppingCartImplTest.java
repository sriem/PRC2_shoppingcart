package shoppingcart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShoppingCartImplTest {

    private ShoppingCart cart;
    private Item it1, it2, it3;

    @Before
    public void setUp() throws Exception {
        cart = new ShoppingCartImpl();
        it1 = new ItemImpl( "Book", 1.24 );
        it2 = new ItemImpl( "Priceless Item" );
        it3 = new ItemImpl( "Porsche 929", 124000.00 );
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
    }

    /*
     * Test method for 'shop.ShoppingCartImpl.addItems(Item, int)'
     */
    @Test
    public final void testAddItems() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        assertEquals(1, cart.itemCount());
    }

    @Test
    public final void testAddMore() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        assertEquals(1, cart.itemCount());
        cart.addItems(it2, 1);
        assertEquals(2, cart.itemCount());
        cart.addItems(it3, 1);
        assertEquals(3, cart.itemCount());
    }

    @Test (expected = NegativeCountException.class)
    public final void testAddNegativeException() throws NegativeCountException{
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, -1);
    }

    /*
     * Test method for 'shop.ShoppingCartImpl.deleteItems(Item, int)'
     */

    @Test
    public final void testDeleteItems() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        assertEquals(1, cart.itemCount());
        cart.deleteItems(it1,1);
        assertEquals(0, cart.itemCount());
        cart.addItems(it1,2);
        assertEquals(1, cart.itemCount());
        cart.deleteItems(it1,1);
        assertEquals(1, cart.itemCount());
    }

    @Test
    public final void testDeleteAllItems() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        cart.addItems(it2, 1);
        cart.addItems(it3, 1);
        assertEquals(3, cart.itemCount());
        cart.deleteAllItems();
 }


    /*
     * Test method for 'shop.ShoppingCartImpl.countItem(Item)'
     */
    @Test
    public final void testCountItem() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        cart.addItems(it2, 1);
        cart.addItems(it3, 1);
        assertEquals(3, cart.itemCount());


    }
    @Test (expected = NoSuchItemException.class)
    public void testNoSuchItemException() throws NoSuchItemException {
        Item noSuchItem = new ItemImpl("BULLI", 1.00);
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        assertEquals(1, cart.itemCount());
        cart.deleteItems(noSuchItem, 1);
    }
    @Test (expected = NegativeCountException.class)
    public void testNegativeCountException() throws NegativeCountException{
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, -1);
    }

    /*
     * Test method for 'shop.ShoppingCartImpl.getContentsPrice()'
     */
    @Test
    public final void testGetContentsPrice() {
        assertEquals(0, cart.itemCount());
        cart.addItems(it1, 1);
        cart.addItems(it3, 1);
        assertEquals(2, cart.itemCount());
        assertEquals(124001.24, cart.getContentsPrice(),0);
    }
}
