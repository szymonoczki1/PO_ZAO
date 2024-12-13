import java.util.*;

public class ThreeItemsDiscount implements command {
    private List<product> products;

    public ThreeItemsDiscount(List<product> products) {
        this.products = products;
    }

    public void execute() {
        if (products.size() >= 3) {
            double smallestPrice = Double.POSITIVE_INFINITY;
            product smallestProduct = null;
            //look for smallest price in all of the products
            for (product product : products) {
                if (product.getPrice() < smallestPrice) {
                    smallestPrice = product.getPrice();
                    smallestProduct = product;
                }
            }
            
            smallestProduct.setDiscountPrice(0);
        }
    }

    public void undo() {
        if (products.size() >= 3) {
            for (product product : products) {
                if ((product.getDiscountPrice() == 0) && (product.getPrice() != 0)) {
                    product.setDiscountPrice(product.getPrice());
                }
            }
        }
    }
}
