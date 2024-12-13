import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class productTest {
    private product product1;
    private product product2;
    private product product3;

    @Before
    public void setUp() {
        product1 = new product("P001", "Laptop", 1000.00);
        product2 = new product("P002", "Phone", 500.00);
        product3 = new product("P003", "Headphones", 50.00);
    }

    // test init
    @Test
    public void testConstructor() {
        assertEquals("P001", product1.getCode());
        assertEquals("Laptop", product1.getName());
        assertEquals(1000.00, product1.getPrice(), 0.001);
        assertEquals(1000.00, product1.getDiscountPrice(), 0.001);
    }

    @Test
    public void testSetCode() {
        product1.setCode("P999");
        assertEquals("P999", product1.getCode());
    }

    @Test
    public void testSetName() {
        product1.setName("Gaming Console");
        assertEquals("Gaming Console", product1.getName());
    }

    @Test
    public void testSetPrice() {
        product1.setPrice(1200.00);
        assertEquals(1200.00, product1.getPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPriceNegative() {
        product1.setPrice(-500.00);
    }

    @Test
    public void testSetDiscountPrice() {
        product1.setDiscountPrice(900.00);
        assertEquals(900.00, product1.getDiscountPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetDiscountPriceNegative() {
        product1.setDiscountPrice(-100.00);
    }

    @Test
    public void testCompareTo() {
        assertTrue(product1.compareTo(product2) < 0);  // 1000 > 500
        assertTrue(product2.compareTo(product3) < 0);  // 500 > 50

        product product4 = new product("P004", "Laptop", 1000.00);
        assertEquals(0, product1.compareTo(product4));  // same price and name

        product product5 = new product("P005", "Alpha", 1000.00);
        assertTrue(product1.compareTo(product5) > 0);  // same price L > A so 1
    }
}
