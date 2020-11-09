package entity;

import java.io.Serializable;

public class Staff extends Person implements Serializable {
private String staffID;
private String rooms;
private String position;


    public Staff(String fullName, String personID, String birth, String address, String staffID, String rooms, String position) {
        super(fullName, personID, birth, address);
        this.staffID = staffID;
        this.rooms = rooms;
        this.position = position;
    }

    public Staff() {
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getRooms() {
        return rooms;
    }

    public void setRooms(String rooms) {
        this.rooms = rooms;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                "fullName='" + getFullName()+ '\'' +
                ", rooms='" + rooms + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
