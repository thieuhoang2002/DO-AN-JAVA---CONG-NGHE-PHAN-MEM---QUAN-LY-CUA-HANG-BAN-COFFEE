package BUS;

import DAO.StaffDAO;
import DTO.StaffDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class StaffBUS implements ICoffeeShop{

    //attribute
    private StaffDAO staffDAO;
    private Vector<StaffDTO> staffList;

    //constructor
    public StaffBUS() {
        this.staffDAO = new StaffDAO();
        this.staffList = this.staffDAO.readStaffListFromDatabase();
    }

    //setter and getter
    public StaffDAO getStaffDAO() {
        return staffDAO;
    }

    public void setStaffDAO(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    public Vector<StaffDTO> getStaffList() {
        return staffList;
    }

    public void setStaffList(Vector<StaffDTO> staffList) {
        this.staffList = staffList;
    }

    //method
    //reset lisst
    @Override
    public void resetList() {
        this.setStaffList(this.getStaffDAO().readStaffListFromDatabase());
    }

    //doc du lieu tu database
    public Vector<StaffDTO> readStaffListFromDatabase() {
        return staffDAO.readStaffListFromDatabase();
    }

    //ham luu du lieu vao database
    public void insert(StaffDTO staff) {
        staffDAO.insert(staff);
    }

    //ham lay danh sach ma nhan vien tu csdl
    public Vector<String> getStaffID() {
        return staffDAO.StaffID();
    }

    //ham xoa nhan vien theo id
    public void delete(String id) {
        staffDAO.delete(id);
    }

    //ham lay danh sach nhan vien (Tim kiem theo Keyword)
    public Vector<StaffDTO> getStaffList(String keyWord) {
        this.resetList();
        Vector<StaffDTO> list = new Vector<>();
        StaffBUS staffBUS = new StaffBUS();
        for (StaffDTO o : staffBUS.getStaffList()) {
            if (o.getStaffName().contains(keyWord) || o.getStaffName().toLowerCase().contains(keyWord)
                    || o.getStaffName().toUpperCase().contains(keyWord) || o.getStaffId().toLowerCase().contains(keyWord) || o.getStaffId().contains(keyWord)
                    || o.getStaffId().toUpperCase().contains(keyWord)
                    || o.getPosition().contains(keyWord) || o.getPosition().toLowerCase().contains(keyWord)
                    || o.getPosition().toUpperCase().contains(keyWord)) {
                list.add(o);
            }
        }
        return list;
    }

    //get staff from id
    public StaffDTO getStaffFromId(String staffId) {
        for (StaffDTO staff : this.getStaffList()) {
            if (staff.getStaffId().equalsIgnoreCase(staffId)) {
                return staff;
            }
        }
        return null;
    }


    //ham nay lay cua Hung
    public boolean checkPosition(String staffID) {
        this.resetList();
        for (StaffDTO staff : this.getStaffList()) {
            if (staff.getStaffId().equalsIgnoreCase(staffID) && staff.getPosition().equalsIgnoreCase("Manager")) {
                return true;
            }
        }
        return false;
    }
    
    public Vector<String> getStaffIdList() {
        this.resetList();
        Vector<String> idList = new Vector<>();
        for(StaffDTO o: this.getStaffList()) {
            idList.add(o.getStaffId());
        }
        return idList;
    }
}
