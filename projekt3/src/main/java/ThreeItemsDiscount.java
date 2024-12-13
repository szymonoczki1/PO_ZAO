import java.util.*;

public class ThreeItemsDiscount implements command {
    private product[] products;

    public ThreeItemsDiscount(product[] products) {
        this.products = products;
    }

    public void execute() {
        if (products.length >= 3) {
            product smallestProduct = Arrays.stream(products)
                                            .min(Comparator.comparingDouble(product::getPrice))
                                            .orElse(null);
            if (smallestProduct != null) {
                smallestProduct.setDiscountPrice(0);
            }
        }
    }

    public void undo() {
        if (products.length >= 3) {
            for (product product : products) {
                if ((product.getDiscountPrice() == 0) && (product.getPrice() != 0)) {
                    product.setDiscountPrice(product.getPrice());
                }
            }
        }
    }
}
