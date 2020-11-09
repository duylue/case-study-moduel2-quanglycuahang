package create;

import product.Product;
import staff.ManageStaff;
import staff.Staff;
import warehouse.ManageBill;
import warehouse.ManageWarehouse;
import warehouse.Sell;
import warehouse.WareHouse;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Create implements Serializable {
    public void menus(){
        ManageStaff manageStaff = new ManageStaff();
        ManageWarehouse manageWarehouse = new ManageWarehouse();
        Scanner scanner = new Scanner(System.in);
        ManageBill manageBill = new ManageBill();
        System.out.println("0 THOÁT");
        System.out.println("1 BÁN HÀNG");
        System.out.println("2 NHẬP HÀNG");
        System.out.println("3 KIỂM KHO");
        System.out.println("4 XÓA SẢN PHẨM");
        System.out.println("5 DOANH THU TRONG NGAY");
        System.out.println("6 QUẢN LÝ NHÂN VIÊN");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){

            case 1:
                Sell sell = creatBill();
                System.out.println("Nhập Mã hàng ");
                String id =scanner.nextLine();
                sell.setIdProduct(id);
                sell.payProduct();
                System.out.println(sell.toString());
                System.out.println("THÀNH TIỀN "+sell.pay());
                manageBill.add(sell);
                break;
            case 2:
                System.out.println("1 thêm sản phẩm mới");
                System.out.println("2 update sản phẩm");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3){
                    case 1:
                        WareHouse wareHouse = createWareHouse();
                        manageWarehouse.add(wareHouse);
                        manageWarehouse.read();
                        break;
                    case 2:
                        WareHouse wareHouse2 = createWareHouse();
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
                menusStaff();
                int choice2 = Integer.parseInt(scanner.nextLine());
                switch (choice2){
                    case 1:
                        Staff staff = createStaff();
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
                        Staff staff1 = createStaff();
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

    }
    public void menusStaff(){
        System.out.println("1 thêm nhân viên");
        System.out.println("2 chấm công ");
        System.out.println("3 xóa nhân viên");
        System.out.println("4 sưa thông tin nhân viên");
        System.out.println("5 xem danh sách nhân viên");
        System.out.println("6 xem thông tin cá nhân nhân viên");

    }
    public Staff createStaff(){
        Scanner scanner = new Scanner(System.in);
        Staff staff = new Staff();
        System.out.println("MÃ NHÂN VIÊN");
        staff.setStaffID(scanner.nextLine());
        System.out.println("TÊN NHÂN VIÊN");
        staff.setFullName(scanner.nextLine());
        System.out.println("CHỨC DANH");
        staff.setPosition(scanner.nextLine());
        System.out.println("PHÒNG LÀM VIỆC");
        staff.setRooms(scanner.nextLine());
        System.out.println("ĐỊA CHỈ");
        staff.setAddress(scanner.nextLine());
        System.out.println("NGÀY SINH");
        staff.setBirth(scanner.nextLine());
        return staff;
    }
    public Product creatProduct(){
        System.out.println("NHẬP KHO");
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        System.out.println("MÃ SẢN PHẨM");
        product.setProductID(scanner.nextLine());
        System.out.println("TÊN SẢN PHẨM");
        product.setProductName(scanner.nextLine());
        System.out.println("SIZE");
        product.setSize(scanner.nextLine());
        System.out.println("GIÁ NHẬP");
        product.setPriceIM(Integer.parseInt(scanner.nextLine()));
        System.out.println("GIÁ BÁN");
        product.setPriceEx(Integer.parseInt(scanner.nextLine()));
        return product;
    }
    public WareHouse createWareHouse(){
        WareHouse wareHouse = new WareHouse();
        System.out.println("NHẬP MÃ PHIẾU");
        wareHouse.setWareHouseID(input());
        Product product = creatProduct();
        System.out.println("SỐ LƯỢNG ");
        wareHouse.setQuantity(Integer.parseInt(input()));
        wareHouse.setProduct(product);
        return wareHouse;
    }
    public Sell creatBill(){
        System.out.println("HÓA ĐƠN");
        Sell sell = new Sell();
        System.out.println("MÃ HÓA ĐƠN");
        sell.setWareHouseID(input());
        LocalDate date = LocalDate.now();
        System.out.println("TÊN KHÁCH HÀNG");
        sell.setNameCustomer(input());
        System.out.println("STĐ");
        sell.setNumberPhone(input());
        System.out.println("SỐ LƯỢNG");
        sell.setQuantityPay(Integer.parseInt(input()));
        return sell;

    }
    public String input(){
        String input = new Scanner(System.in).nextLine();
        return input;
    }
}
