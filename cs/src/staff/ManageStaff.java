package staff;

import com.sun.jdi.event.StepEvent;
import create.Create;
import create.CreateFile;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageStaff implements Serializable {
    CreateFile createFile= new CreateFile();
    public ArrayList<Staff> list = (ArrayList<Staff>) createFile.readFile(fileStaff);
    ArrayList<String> listTimekeeping = new ArrayList<>();
    static final String fileStaff = "LISTSTAFF.txt";

    public void add(Staff staff){
        if (list==null){
            list=new ArrayList<>();
        }
        list.add(staff);
        createFile.writeFile(fileStaff,list);
    }
    public void read(){
        for (Staff s :list) {
            System.out.println(s.toString());
        }
    }
    public void update(Staff staff){
        for (Staff s :list) {
            if (s.getStaffID().equals(staff.getStaffID())){
                s.setFullName(staff.getFullName());
                s.setPosition(staff.getPosition());
                s.setRooms(staff.getRooms());
                s.setStaffID(staff.getStaffID());
                s.setAddress(staff.getAddress());
                s.setBirth(staff.getBirth());
            }
        }

    }
    public void delete(String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getStaffID().equals(id)){
                list.remove(i);
            }
        }
    }
    public void readInfor(){
        for (Staff s:list) {
            System.out.println(s.getStaffID()+" Infor :"+s.infor());
        }
    }
    public String choiceShift(){
        System.out.println("1 ca 1 ");
        System.out.println("2 ca 2 ");
        String shift ="";
        int choice = Integer.parseInt(new Scanner(System.in).nextLine());
        switch (choice){
            case 1:
                shift="ca 1 từ 8h AM đến 4h PM";
                break;
            case 2:
                shift="ca 2 từ 2h PM đến 10h PM";
            break;
        }
        return shift;
    }
    public String timekeeping(String id){
        String time = choiceShift();
        for (Staff s : list) {
            if (s.getStaffID().equals(id)){
                time=time+s.toString()+LocalDate.now();

            }
        }
        return time;
    }

public void addTimekeeping(String s){
        listTimekeeping.add(s);
}
public void readTimekeeping(){
        for (String s:listTimekeeping
             ) {
            System.out.println(s);

        }
    }
}
