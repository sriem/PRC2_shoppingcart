package shoppingcart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * One positive test (testFreeBubbleGum) where you get a gum and
 * one negative test where you should not.
 * @author hom
 */
public class FreeBubbleGumTest {
    private ShoppingCart cart;
    Item cola;
    Item gum;

    @Before
    public void setUp() throws Exception {

        cart = new ShoppingCartImpl();
        cola = new ItemImpl("Cola", 1.25);
        gum = new ItemImpl("SuperGum", 0.20);
    }

    @After
    public void tearDown() throws Exception {
        cart = null;
        gum = null;
        cola = null;
    }

    /*
     * Test method for 'shop.FreeBubbleGum.FreeBubbleGum()'
     * Buy three colas and should get one bubble gum for free.
     */
    @Test
    public void testFreeBubbleGum() {
        FreeBubbleGum freeBubbleGum = new FreeBubbleGum();
        cart.addItems(cola,3);
        cart.addItems(gum, 1);
        assertEquals(3,cart.countItem(cola));
        assertEquals(1,cart.countItem(gum));
        assertEquals(3.75,freeBubbleGum.getSalesPrice(cart),0);

    }

    /*
     * Kid is in shop and tries to get gum for free.
     * Test that no gum is supplied with only one bottle of cola.
     */
    @Test
    public void testKidInShop() {
        FreeBubbleGum freeBubbleGum = new FreeBubbleGum();
        cart.addItems(cola,2);
        cart.addItems(gum, 1);
        assertEquals(2,cart.countItem(cola));
        assertEquals(1,cart.countItem(gum));
        assertEquals(2.70,freeBubbleGum.getSalesPrice(cart),0);
    }
    //End Solution::replacewith::
}
