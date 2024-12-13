import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class commandsTest {

    private basket testBasket;
    private product p1, p2, p3, p4;

    @Before
    public void setUp() {
        testBasket = new basket();

        p1 = new product("P001", "Laptop", 1000.00);
        p2 = new product("P002", "Phone", 300.00);
        p3 = new product("P003", "Headphones", 50.00);
        p4 = new product("P004", "Tablet", 250.00);

        testBasket.addProduct(p1);
        testBasket.addProduct(p2);
        testBasket.addProduct(p3);
        testBasket.addProduct(p4);
    }

    @Test
    public void testMugDiscount() {
        mugDiscount mugDiscountCommand = new mugDiscount(testBasket);
        
        mugDiscountCommand.execute();

        assertTrue(testBasket.getProducts().stream().anyMatch(product -> product.getName().equals("Company Mug")));

        mugDiscountCommand.undo();

        assertFalse(testBasket.getProducts().stream().anyMatch(product -> product.getName().equals("Company Mug")));
    }


    @Test
    public void testPercentageDiscount() {
        double discountPercentage = 30;
        percentageDiscount percentageDiscountCommand = new percentageDiscount(p1, discountPercentage);

        double originalPrice = p1.getPrice();
        percentageDiscountCommand.execute();

        double discountedPrice = p1.getDiscountPrice();
        assertEquals(originalPrice * 0.7, discountedPrice, 0.001);

        percentageDiscountCommand.undo();
        assertEquals(originalPrice, p1.getDiscountPrice(), 0.001);
    }

    @Test
    public void testThreeItemsDiscount() {
        List<product> products = Arrays.asList(p1, p2, p3);
        ThreeItemsDiscount threeItemsDiscountCommand = new ThreeItemsDiscount(products);

        threeItemsDiscountCommand.execute();

        product cheapestProduct = testBasket.getCheapestProduct();
        assertEquals(p3, cheapestProduct);
        assertEquals(0, cheapestProduct.getDiscountPrice(), 0.001);

        threeItemsDiscountCommand.undo();

        for (product product : products) {
            assertEquals(product.getPrice(), product.getDiscountPrice(), 0.001);
        }
    }

    @Test
    public void testTotalPriceDiscount() {
        totalPriceDiscount totalPriceDiscountCommand = new totalPriceDiscount(testBasket);

        double basketTotal = testBasket.getTotalPrice();
        assertTrue(basketTotal > 300);

        totalPriceDiscountCommand.execute();

        assertEquals(basketTotal * 0.95, testBasket.getDiscountedTotal(), 0.001);

        totalPriceDiscountCommand.undo();
        assertEquals(basketTotal, testBasket.getDiscountedTotal(), 0.001);
    }
}
