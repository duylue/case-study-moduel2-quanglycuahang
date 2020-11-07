package warehouse;

import product.Product;
import staff.ManageStaff;
import staff.Staff;

import java.io.Serializable;
import java.time.LocalDate;

public class WareHouse implements Serializable {
    private String wareHouseID;
    public LocalDate date = LocalDate.now();
    private Product product;
    private int quantity;


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    public String getWareHouseID() {
        return wareHouseID;
    }

    public void setWareHouseID(String wareHouseID) {
        this.wareHouseID = wareHouseID;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "WareHouse{" +" date="+date+
                ", wareHouseID='" + wareHouseID + '\'' +
                ", product=" + getProduct().toString() +
                ", quantity=" + quantity +
                '}';
    }
}
