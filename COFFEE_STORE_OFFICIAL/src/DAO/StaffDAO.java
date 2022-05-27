package DAO;

import ApplicationHelper.DatabaseHelper;
import ApplicationHelper.MyDate;
import DTO.StaffDTO;
import java.util.Vector;
import java.sql.*;

public class StaffDAO {

    //constructor
    public StaffDAO() {
    }

    //method
    //get staff list from database
    public Vector<StaffDTO> readStaffListFromDatabase() {
        Vector<StaffDTO> staffList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT * FROM STAFF";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String text[] = rs.getString("STAFF_BIRTHDAY").split("\\s");
                MyDate date = new MyDate(text[0]);
                StaffDTO staff = new StaffDTO(rs.getString("STAFF_ID"), rs.getNString("STAFF_NAME"), date, rs.getNString("STAFF_ADDRESS"), rs.getString("STAFF_PHONE"), rs.getString("STAFF_POSITION"));
                staffList.add(staff);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error at readStaffListFromDatabase method from StaffDAO class!");
            System.err.println(e);
        }
        return staffList;
    }

    //lay id tu bang nv
    public Vector<String> StaffID() {
        Vector<String> id = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT STAFF_ID FROM STAFF";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id.add(rs.getString("STAFF_ID"));
            }
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return id;
    }

    public void insert(StaffDTO staff) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO STAFF VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, staff.getStaffId());
            ps.setNString(2, staff.getStaffName());
            ps.setNString(3, staff.getStaffAddress());
            ps.setString(4, staff.getStaffBirthday().formatDB());
            ps.setString(5, staff.getNumberPhone());
            ps.setString(6, staff.getPosition());
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at insert method from StaffDAO class!");
            System.err.println(e);
        }

    }

    //xoa tai khoan
    public void deleteAccount(String id) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM ACCOUNT WHERE STAFF_ID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Delete Sucess!");
        } catch (Exception ex) {
            System.out.println("Delete false!");
        }
    }

    public void delete(String id) {
        deleteAccount(id);
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE BILL SET STAFF_ID = NULL WHERE STAFF_ID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            ps = con.prepareStatement("DELETE FROM STAFF WHERE STAFF_ID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Delete Sucess!");
        } catch (Exception ex) {
            System.out.println("Delete false!");
        }
    }

    public static void main(String[] args) {
        StaffDAO o = new StaffDAO();
        Vector<StaffDTO> list = o.readStaffListFromDatabase();
//        for (StaffDTO x : list) {
//            System.out.println(x.getStaffId() + "---" + x.getStaffName() + "---" + x.getStaffAddress() + "---" + x.getStaffBirthday().toString() + "---" + x.getPosition());
//        }
//        MyDate ns = new MyDate("12","01","2002");
//        o.editngaysinh("SF003", ns);
//        o.editposition("SF003", "Seller");
        System.out.println(o.StaffID());
    }

    public void insert2(StaffDTO staff) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()) {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO STAFF VALUES (?,?,?,?,?,?)");
            pstm.setString(1, staff.getStaffId());
            pstm.setNString(2, staff.getStaffName());
            pstm.setNString(3, staff.getStaffAddress());
            pstm.setString(4, staff.getStaffBirthday().formatDB());
            pstm.setString(5, staff.getNumberPhone());
            pstm.setString(6, staff.getPosition());
            pstm.executeUpdate();
            System.out.println("Thành công!");
        } catch (Exception ex) {
            System.out.println("Lỗi!");
        }
    }
}
