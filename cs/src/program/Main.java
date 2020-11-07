package program;

import create.Create;
import create.CreateFile;
import product.Product;
import staff.ManageStaff;
import staff.Staff;
import warehouse.ManageBill;
import warehouse.ManageWarehouse;
import warehouse.Sell;
import warehouse.WareHouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Create create = new Create();
        ManageStaff manageStaff = new ManageStaff();
        ManageWarehouse manageWarehouse = new ManageWarehouse();
        Scanner scanner = new Scanner(System.in);
        ManageBill manageBill = new ManageBill();

        do {
            create.menus();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){

                case 1:
                    Sell sell = create.creatBill();
                    System.out.println("Nhập Mã hàng ");
                    String id =scanner.nextLine();
                    sell.setIdProduct(id);
                    System.out.println(sell.toString());
                    sell.payProduct();
                    System.out.println("THÀNH TIỀN "+sell.pay());
                    manageBill.add(sell);
                    break;
                case 2:
                    System.out.println("1 thêm sản phẩm mới");
                    System.out.println("2 update sản phẩm");
                    int choice3 = Integer.parseInt(scanner.nextLine());
                    switch (choice3){
                        case 1:
                            WareHouse wareHouse = create.createWareHouse();
                            manageWarehouse.add(wareHouse);
                            manageWarehouse.read();
                            break;
                        case 2:
                            WareHouse wareHouse2 = create.createWareHouse();
                            manageWarehouse.update(wareHouse2);


                    }

                    break;
                case 3:
                    manageWarehouse.read();
                    break;
                case 4:
                    System.out.println("Nhap ID");
                    manageWarehouse.delete(scanner.nextLine());
                case 5:
                    manageBill.read();
                    System.out.println("DOANG THU NGÀY :" +LocalDate.now()+ " = "+ manageBill.totalPayDay());
                    break;


                case 6:
                    create.menusStaff();
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2){
                        case 1:
                            Staff staff = create.createStaff();
                            manageStaff.add(staff);break;
                        case 2:
                            System.out.println("NHẬP MÃ NHÂN VIÊN");
                            String timekeeping = manageStaff.timekeeping(scanner.nextLine());
                            manageStaff.addTimekeeping(timekeeping);
                            manageStaff.readTimekeeping();
                            break;
                        case 3:
                           manageStaff.delete(scanner.nextLine());
                           break;
                        case 4:
                            Staff staff1 = create.createStaff();
                            manageStaff.update(staff1);
                            break;
                        case 5:
                            manageStaff.read();
                            break;
                        case 6:
                            manageStaff.readInfor();

                    }
                    break;

                case 0 :
                    System.exit(-1);

            }
        }while (true);


    }
}
