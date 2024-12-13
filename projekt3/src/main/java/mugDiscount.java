import java.util.Arrays;

public class mugDiscount implements command{
    private product product = new product("SPECIALCODE", "Company Mug", 0);
    private basket basket;

    public mugDiscount(basket basket) {
        this.basket = basket;
    }

    public void execute() {
        if (basket.getTotalPrice() > 200) {
            basket.addProduct(product);
        }
    }

    public void undo() {
        if (Arrays.stream(basket.getProducts()).anyMatch(product -> product.equals(this.product))) {
        basket.removeProduct(product);
    }
    }
}
