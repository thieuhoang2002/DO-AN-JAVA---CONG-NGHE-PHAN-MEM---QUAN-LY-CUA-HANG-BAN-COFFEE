package DAO;

import ApplicationHelper.DatabaseHelper;
import ApplicationHelper.MyDate;
import DTO.BillDTO;
import java.util.Vector;
import java.sql.*;

public class BillDAO {
    //constructor
    public BillDAO() {
    }
    
    //method
    //lay danh sach bill tu database
    public Vector<BillDTO> readBillListFromDatabase() {
        Vector<BillDTO> billList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM BILL";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
               String[] text = rs.getString("BILL_DATE").split("\\s");
               MyDate date = new MyDate(text[0]);
               BillDTO bill = new BillDTO(rs.getString("BILL_ID"), date, rs.getDouble("BILL_TOTAL"), rs.getDouble("RECEIVED_MONEY"), rs.getDouble("EXCESS_MONEY"), rs.getBoolean("BILL_STATUS"), rs.getString("STAFF_ID"), rs.getString("BILL_TYPE"));
               billList.add(bill);
            }

        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readBillListFromDatabase method from BillDAO class!");
            System.err.println(e);
        }
        return billList;
    }
    
    //Them mot bill vao csdl
    public void insertBill(BillDTO bill) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call INSERT_BILL(?, ?, ?, ?, ?, ?, ?, ?)}");
                call.setString(1, bill.getBillId());
                call.setString(2, bill.getDate().formatDB());
                call.setDouble(3, bill.getTotal());
                call.setDouble(4, bill.getReceivedMoney());
                call.setDouble(5, bill.getExcessMoney());
                call.setBoolean(6, bill.isBillStatus());
                call.setString(7, bill.getStaffId());
                call.setString(8, bill.getBillType());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insertBill method from BillDAO class!");
            System.err.println(e);
        }
    }
    
    //Xoa mot bill ra khoi csdl
    public void deleteBill(String billId) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call DELETE_BILL(?)}");
                call.setString(1, billId);
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at deleteBill method from BillDAO class!");
            System.err.println(e);
        }
    }
    
    //update bill
    public void updateBill(String billId, boolean status, Double receivedMoney, Double excessMoney) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                    CallableStatement call = con.prepareCall("{call UPDATE_BILL (?, ?, ?, ?)}");
                    call.setString(1, billId);
                    call.setBoolean(2, status);
                    call.setDouble(3, receivedMoney);
                    call.setDouble(4, excessMoney);
                    call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at updateBill method from BillDAO class!");
            System.err.println(e);
        }
        
    }
}
