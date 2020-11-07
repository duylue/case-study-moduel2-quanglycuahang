package staff;

import java.io.Serializable;

public class Person implements Serializable {
    private String fullName;
    private  String personID;
    private String Birth;
    private String address;

    public Person() {
    }

    public Person(String fullName, String personID, String birth, String address) {
        this.fullName = fullName;
        this.personID = personID;
        Birth = birth;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPersonID() {
        return personID;
    }

    public void setPersonID(String personID) {
        this.personID = personID;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        this.Birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String infor() {
        return "Person{" +
                ", personID='" + personID + '\'' +
                "fullName='" + fullName + '\'' +
                ", Birth='" + Birth + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
