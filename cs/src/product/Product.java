package product;

import java.io.Serializable;

public class Product implements Serializable {
    private String productID;
    private String productName;
    private double priceIM;

    public double getPriceEx() {
        return priceEx;
    }

    public void setPriceEx(double priceEx) {
        this.priceEx = priceEx;
    }

    private double priceEx;
    private String size;

    public Product() {
    }

    public Product(String productID, String productName, double price, String size) {
        this.productID = productID;
        this.productName = productName;
        this.priceIM = price;
        this.size = size;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPriceIM() {
        return priceIM;
    }

    public void setPriceIM(double priceIM) {
        this.priceIM = priceIM;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", priceIM=" + priceIM +
                ", priceEx=" + priceEx +
                ", size='" + size + '\'' +
                '}';
    }
    public String exportPrice() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", priceEx=" + priceEx +
                ", size='" + size + '\'' +
                '}';
    }
}
