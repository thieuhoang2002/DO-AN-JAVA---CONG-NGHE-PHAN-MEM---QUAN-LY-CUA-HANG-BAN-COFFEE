package DTO;

import ApplicationHelper.MyDate;

public class StaffDTO {
    //attribute
    private String staffId;
    private String staffName;
    private MyDate staffBirthday;
    private String staffAddress;
    private String numberPhone;
    private String position;
    
    //constructor
    public StaffDTO(String staffId, String staffName, MyDate staffBirthday, String staffAddress, String numberPhone, String position) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffBirthday = staffBirthday;
        this.staffAddress = staffAddress;
        this.numberPhone = numberPhone;
        this.position = position;
    }
    
    //setter and getter
    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public MyDate getStaffBirthday() {
        return staffBirthday;
    }

    public void setStaffBirthday(MyDate staffBirthday) {
        this.staffBirthday = staffBirthday;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    
}
