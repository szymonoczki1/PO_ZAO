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
        if (basket.getProducts().contains(product)) {
            basket.removeProduct(product);
        }
    }
}
