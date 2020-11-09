package warehouse;

import create.Create;
import create.CreateFile;

import java.io.Serializable;
import java.time.LocalDate;

public class Sell extends ManageWarehouse implements Serializable {
    private String nameCustomer;
    private String numberPhone;
    private String idProduct;
    private int quantityPay;
    private String inforProduct;

    public String getInforProduct() {
        return inforProduct;
    }

    public void setInforProduct(String inforProduct) {
        this.inforProduct = inforProduct;
    }

    public int getQuantityPay() {
        return quantityPay;
    }

    public void setQuantityPay(int quantityPay) {
        this.quantityPay = quantityPay;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    CreateFile createFile = new CreateFile();
    static final String fileWareHouse = "listProduct.txt";

    public double pay() {
        double pay = 1;
        for (WareHouse w : wareHouseArrayList) {
            if (w.getProduct().getProductID().equals(getIdProduct())) {
                pay = getQuantityPay() * w.getProduct().getPriceEx();
            }
        }
        return pay;
    }

    public void payProduct() {
        for (WareHouse w : wareHouseArrayList) {
            if (w.getProduct().getProductID().equals(getIdProduct())) {
                setInforProduct(w.getProduct().exportPrice());
                w.setQuantity(w.getQuantity() - getQuantityPay());
            }
        }
        createFile.writeFile(fileWareHouse, wareHouseArrayList);

    }


    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Sell{" +
                "billSellID='" + getWareHouseID() + '\'' +
                ", time=" + LocalDate.now() +
                ", nameCustomer='" + nameCustomer + '\'' +
                ", numberPhone='" + numberPhone + '\'' + " " + getInforProduct() +
                ", quantity=" + getQuantityPay() +
                '}';
    }
}
