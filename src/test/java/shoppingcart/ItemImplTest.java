package shoppingcart;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ItemImplTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    /**
     * exercise all getters and setters to satisfy coverage.
     */
    @Test
    public void testItem() {
        long serialBase = ItemImpl.getLastSerialNr();
        ItemImpl it1 = new ItemImpl();
        Item it2 = new ItemImpl("Scrap paper");
        Item it3 = new ItemImpl("Precious ring", 1000.00);
        assertEquals("Serial number generator", serialBase + 3, ItemImpl.getLastSerialNr());
        assertEquals("Serial of 2", serialBase + 2, it2.getSerialNr());
        String it1Name = "New Name";
        it1.setName(it1Name);
        assertEquals("Name", it1Name, it1.getName());
        it2.setPrice(1.25);
        assertEquals("Price", 1.25, it2.getPrice(), 0.005);
        assertEquals("Price", 0.0, it1.getPrice(), 0.005);
    }

    @Test
    public void testToString() {
        Item it = new ItemImpl("Precious ring", 1000.00);

        // do no realy care what an Item looks like in toString
        assertNotNull("There is no string", it.toString());
    }
}
