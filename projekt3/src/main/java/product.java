public class product implements Comparable<product> {
    private String code;
    private String name;
    private double price;
    private double discountPrice;

    public product(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discountPrice = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    } 


    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    public double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(double discountPrice) {
        if (discountPrice >= 0) {
            this.discountPrice = discountPrice;
        } else {
            throw new IllegalArgumentException("Price cannot be negative");
        }
    }

    @Override
    public int compareTo(product product2) {
        // double compare zwraca -1 0 1 w zlaeznosci od porownania
        int priceComparison = Double.compare(product2.price, this.price);
        if (priceComparison != 0) {
            return priceComparison;
        }
        // jesli takie same to
        return this.name.compareTo(product2.name);
    }
}
