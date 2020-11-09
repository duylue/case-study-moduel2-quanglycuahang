package methods;

import create.CreateFile;
import entity.WareHouse;

import java.io.Serializable;
import java.util.ArrayList;

public class ManageWarehouse extends WareHouse implements Serializable {
    CreateFile createFile = new CreateFile();
    public ArrayList<WareHouse> wareHouseArrayList = (ArrayList<WareHouse>) createFile.readFile(fileWareHouse);
    ;
    static final String fileWareHouse = "listProduct.txt";


    public void add(WareHouse w) {
        if (wareHouseArrayList == null) {
            wareHouseArrayList = new ArrayList<>();
        }
        wareHouseArrayList.add(w);
        createFile.writeFile(fileWareHouse, wareHouseArrayList);
    }

    public void read() {
        for (WareHouse s : wareHouseArrayList) {
            System.out.println(s.toString());
        }

    }
    public void update(WareHouse w){
        for (WareHouse s :wareHouseArrayList) {
            if (s.getWareHouseID().equals(w.getWareHouseID())){
             s.setQuantity(s.getQuantity()+w.getQuantity());
             s.setProduct(w.getProduct());
            }
        }

    }
    public void delete(String id){
        for (int i = 0; i < wareHouseArrayList.size(); i++) {
            if (wareHouseArrayList.get(i).getWareHouseID().equals(id)){
                wareHouseArrayList.remove(i);
            }
        }
    }


}
