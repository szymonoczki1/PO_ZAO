import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class basketTest {
    private basket testBasket;
    private product p1, p2, p3;

    @Before
    public void setUp() {
        testBasket = new basket();

        p1 = new product("P001", "Laptop", 1000.00);
        p2 = new product("P002", "Phone", 500.00);
        p3 = new product("P003", "Headphones", 50.00);

        testBasket.addProduct(p1);
        testBasket.addProduct(p2);
        testBasket.addProduct(p3);
    }

    @Test
    public void testAddProduct() {
        product newProduct = new product("P004", "Monitor", 200.00);
        testBasket.addProduct(newProduct);
        product[] expectedProducts = {p1,p2,p3,newProduct};
        assertTrue(Arrays.equals(testBasket.getProducts(), expectedProducts));
    }

    @Test
    public void testRemoveProduct() {
        testBasket.removeProduct(p3);
        product[] expectedProducts = {p1,p2};
        assertTrue(Arrays.equals(testBasket.getProducts(), expectedProducts));
    }

    @Test
    public void testGetTotalPrice() {
        double expectedTotal = p1.getPrice() + p2.getPrice() + p3.getPrice();
        assertEquals(expectedTotal, testBasket.getTotalPrice(), 0.001);
    }

    @Test
    public void testGetDiscountedTotal() {
        p1.setDiscountPrice(0);
        assertEquals(550.00, testBasket.getDiscountedTotal(), 0.001);
    }

    @Test
    public void testSortProductsDesc() {
        testBasket.sortProductsDesc();
        product[] sortedProducts = testBasket.getProducts();

        assertEquals(p1, sortedProducts[0]);
        assertEquals(p2, sortedProducts[1]);
        assertEquals(p3, sortedProducts[2]);
    }

    @Test
    public void testSortProductsAsc() {
        testBasket.sortProductsAsc();
        product[] sortedProducts = testBasket.getProducts();

        assertEquals(p3, sortedProducts[0]);
        assertEquals(p2, sortedProducts[1]);
        assertEquals(p1, sortedProducts[2]);
    }

    @Test
    public void testGetCheapestProduct() {
        product cheapest = testBasket.getCheapestProduct();
        assertEquals(p3, cheapest);
    }

    @Test
    public void testGetMostExpensiveProduct() {
        product mostExpensive = testBasket.getMostExpensiveProduct();
        assertEquals(p1, mostExpensive);
    }

    @Test
    public void testGetTopNCheapest() {
        product[] topN = testBasket.getTopNCheapest(2);

        assertEquals(2, topN.length);
        assertEquals(p3, topN[0]);
        assertEquals(p2, topN[1]);
    }

    @Test
    public void testGetTopNExpensive() {
        product[] topN = testBasket.getTopNExpensive(2);

        assertEquals(2, topN.length);
        assertEquals(p1, topN[0]);
        assertEquals(p2, topN[1]);
    }
}
