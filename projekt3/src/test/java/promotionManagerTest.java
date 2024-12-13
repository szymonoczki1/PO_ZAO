import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class promotionManagerTest {

    private promotionManager manager;
    private basket basket;
    private product product1, product2, product3;
    private command mugDiscountCommand;
    private command percentageDiscountCommand;

    @Before
    public void setUp() {
        basket = new basket();
        manager = new promotionManager();

        product1 = new product("P001", "Laptop", 1000.00);
        product2 = new product("P002", "Phone", 500.00);
        product3 = new product("P003", "Tablet", 300.00);

        basket.addProduct(product1);
        basket.addProduct(product2);
        basket.addProduct(product3);

        mugDiscountCommand = new mugDiscount(basket);
        percentageDiscountCommand = new percentageDiscount(product1, 30.0);
    }

    @Test
    public void testAddCommand() {
        manager.addCommand(mugDiscountCommand);
        assertEquals(1, manager.getCommands().size());
        assertEquals(mugDiscountCommand, manager.getCommands().get(0));
    }

    @Test
    public void testExecuteCommands() {
        manager.addCommand(mugDiscountCommand);
        manager.addCommand(percentageDiscountCommand);

        manager.executeCommands();

        double totalPrice = basket.getTotalPrice();
        if (totalPrice > 200) {
            boolean mugExists = false;
            for (product product : basket.getProducts()) {
                if (product != null && product.getCode().equals("SPECIALCODE") &&
                    product.getName().equals("Company Mug") && product.getPrice() == 0) {
                    mugExists = true;
                    break;
                }
            }
            assertTrue(mugExists);
        }

        double discountedPrice = product1.getDiscountPrice();
        double expectedDiscountedPrice = 700.00;  // 1000 * (1 - 30%) = 700.00

        assertEquals(expectedDiscountedPrice, discountedPrice, 0.001);
    }

    @Test
    public void testSortAscendingCommand() {
        command sortAsc = new sortAscendingCommand(basket);
        manager.addCommand(sortAsc);

        manager.executeCommands();

        product[] products = basket.getProducts();
        assertEquals(product3, products[0]);
        assertEquals(product2, products[1]);
        assertEquals(product1, products[2]);

        manager.undoCommands();

        products = basket.getProducts();
        assertEquals(product1, products[0]);
        assertEquals(product2, products[1]);
        assertEquals(product3, products[2]);
    }

    @Test
    public void testSortDescendingCommand() {
        command sortDesc = new sortDescendingCommand(basket);
        manager.addCommand(sortDesc);

        manager.executeCommands();
        product[] products = basket.getProducts();
        assertEquals(product1, products[0]);
        assertEquals(product2, products[1]);
        assertEquals(product3, products[2]);
    }
}
