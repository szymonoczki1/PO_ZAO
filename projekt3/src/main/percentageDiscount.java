public class percentageDiscount implements command{
    private double discountPercentage;
    private product product;

    public percentageDiscount(product product, double discountPercentage){
        this.discountPercentage = discountPercentage;
        this.product = product;
    }

    @Override
    public void execute() {
        double price = product.getPrice();
        price = price * (1 - (discountPercentage/100));
        product.setDiscountPrice(price);
    }

    @Override
    public void undo() {
        product.setDiscountPrice(product.getPrice());
    }
}
