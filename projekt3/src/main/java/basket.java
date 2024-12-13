import java.util.*;;

//reciever
public class basket {
    private product[] products = new product[0];
    private product[] originalOrder = new product[0];
    private double discountedTotal = -1;

    
    public void addProduct(product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
    }

    public void removeProduct(product product) {
        products = Arrays.stream(products)
                         .filter(p -> !p.equals(product)) // remove product
                         .toArray(product[]::new);
    }

    public double getTotalPrice() {
        return Arrays.stream(products).mapToDouble(product::getPrice).sum();
    }

    public void setDiscountedTotal(double discountedTotalPrice) {
        this.discountedTotal = discountedTotalPrice;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }

    public product[] getProducts() {
        return products;
    }

    public void backupOriginalOrder() {
        originalOrder = Arrays.copyOf(products, products.length);
    }

    public void restoreOriginalOrder() {
        products = Arrays.copyOf(originalOrder, originalOrder.length);
    }

    
    public void sortProductsDesc() {
        // mozliwe dzieki implementacji compareTo w product
        Arrays.sort(products);
    }

    public void sortProductsAsc() {
        // mozliwe dzieki implementacji compareTo w product
        Arrays.sort(products, Comparator.reverseOrder());
    }


    public product getCheapestProduct() {
        // mozliwe dzieki implementacji compareTo w product
        return Arrays.stream(products).max(Comparator.naturalOrder()).orElse(null);
    }

    public product getMostExpensiveProduct() {
        // mozliwe dzieki implementacji compareTo w product
        return Arrays.stream(products).min(Comparator.naturalOrder()).orElse(null);
    }

   
    public product[] getTopNCheapest(int n) {
        // kopiujemy liste bo potrzebne nam jest tylko n elementow nie posortowanie oryginalnej tablicy
        return Arrays.stream(products)
                     .sorted(Comparator.reverseOrder())
                     .limit(n)
                     .toArray(product[]::new);
    }

    public product[] getTopNExpensive(int n) {
        // kopiujemy liste bo potrzebne nam jest tylko n elementow nie posortowanie oryginalnej tablicy
        return Arrays.stream(products)
                     .sorted()
                     .limit(n)
                     .toArray(product[]::new);
    }

}
