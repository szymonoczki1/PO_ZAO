import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class basketTest {

    private basket basket;
    private product product1;
    private product product2;
    private product product3;

    @Before
    public void setUp() {
        basket = new basket();
        product1 = new product("P001", "Laptop", 2500);
        product2 = new product("P002", "Phone", 1500);
        product3 = new product("P003", "Headphones", 300);
    }

    @Test
    public void testAddProduct() {
        basket.addProduct(product1);
        assertTrue(basket.getProducts().contains(product1));
    }

    @Test
    public void testRemoveProduct() {
        basket.addProduct(product1);
        basket.removeProduct(product1);
        assertFalse(basket.getProducts().contains(product1));
    }

    @Test
    public void testGetTotalPrice() {
        basket.addProduct(product1);
        basket.addProduct(product2);
        assertEquals(4000, basket.getTotalPrice(), 0.01);
    }

    @Test
    public void testSortProductsDesc() {
        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);
        basket.sortProductsDesc();

        assertEquals(product1, basket.getProducts().get(0));
        assertEquals(product2, basket.getProducts().get(1));
        assertEquals(product3, basket.getProducts().get(2));
    }
}
