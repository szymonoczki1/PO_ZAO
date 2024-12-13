public class totalPriceDiscount implements command {
    private double discountPercentage = 5;
    private basket basket;

    public totalPriceDiscount(basket basket) {
        this.basket = basket;
    }


    @Override
    public void execute() {
        double totalPrice = basket.getTotalPrice();
        if (totalPrice > 300) {
            double totalDiscountMultiplier = (1-(discountPercentage/100));
            basket.setTotalDiscountMultiplier(totalDiscountMultiplier);
        }
    }

    @Override
    public void undo() {
        basket.setTotalDiscountMultiplier(1);
    }
}
