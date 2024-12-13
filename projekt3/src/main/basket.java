import java.util.*;;

//reciever
public class basket {
    private List<product> products = new ArrayList<>();
    private double discountedTotal = -1;

    
    public void addProduct(product product) {
        products.add(product);
    }

    public void removeProduct(product product) {
        products.remove(product);
    }

    public double getTotalPrice() {
        double total = 0;
        for (product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void setDiscountedTotal(double discountedTotalPrice) {
        this.discountedTotal = discountedTotalPrice;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }

    public List<product> getProducts() { return products; }


    
    public void sortProductsAsc() {
        // mozliwe dzieki implementacji compareTo w product
        Collections.sort(products);
    }

    public void sortProductsDesc() {
        // mozliwe dzieki implementacji compareTo w product
        Collections.sort(products, Collections.reverseOrder());
    }


    public product getCheapestProduct() {
        // mozliwe dzieki implementacji compareTo w product
        return Collections.min(products);
    }

    public product getMostExpensiveProduct() {
        // mozliwe dzieki implementacji compareTo w product
        return Collections.max(products);
    }

   
    public List<product> getTopNCheapest(int n) {
        // kopiujemy liste bo potrzebne nam jest tylko n elementow nie posortowanie oryginalnej tablicy
        List<product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList);
        return sortedList.subList(0, n);
    }

    public List<product> getTopNExpensive(int n) {
        // kopiujemy liste bo potrzebne nam jest tylko n elementow nie posortowanie oryginalnej tablicy
        List<product> sortedList = new ArrayList<>(products);
        Collections.sort(sortedList, Collections.reverseOrder());
        return sortedList.subList(0, n);
    }

}
