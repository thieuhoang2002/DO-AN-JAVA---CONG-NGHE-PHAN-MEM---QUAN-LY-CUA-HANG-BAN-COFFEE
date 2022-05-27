package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.Detail_BillDTO;
import java.sql.*;
import java.util.Vector;

public class Detail_BillDAO {
    //constructor
    public Detail_BillDAO() {
    }
    
    //method
    //lay danh sach detail_bill tu database
    public Vector<Detail_BillDTO> readDetailBillListFromDatabase() {
        Vector<Detail_BillDTO> detailBillList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_DETAIL_BILL_LIST()}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    Detail_BillDTO detail = new Detail_BillDTO(rs.getString("DETAIL_BILL_ID"), rs.getString("BILL_ID"), rs.getString("PRODUCT_ID"), rs.getInt("ORDINAL_NUMBER"), rs.getString("PRODUCT_SIZE"), rs.getString("PRODUCT_STATUS"), rs.getInt("QUANTITY"), rs.getDouble("UNIT_PRICE"));
                    detailBillList.add(detail);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readDetailBillListFromDatabase method from Detail_BillDAO class!");
            System.err.println(e);
        }
        return detailBillList;
    }
    //Them mot chi tiet bill vao csdl
    public void insertDetailBill(Detail_BillDTO detailBill) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call INSERT_DETAIL_BILL(?, ?, ?, ?, ?, ?, ?, ?)}");
                call.setString(1, detailBill.getDetailBillId());
                call.setString(2, detailBill.getBillId());
                call.setString(3, detailBill.getProductId());
                call.setInt(4, detailBill.getOrdinalNumber());
                call.setDouble(5, detailBill.getUnitPrice());
                call.setString(6, detailBill.getProductSize());
                call.setString(7, detailBill.getProducStatus());
                call.setInt(8, detailBill.getQuantity());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insertDetailBill method from Detail_BillDAO class!");
            System.err.println(e);
        }
    }
    
    //Xoa mot chi tiet bill ra khoi database
    public void deleteDetailBill(String detailBillId) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call DELETE_DETAIL_BILL(?)}");
                call.setString(1, detailBillId);
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at deleteDetailBill method from Detail_BillDAO class!");
            System.err.println(e);
        }
    }
    
    //update a detailBill
    public void updateDetailBill(Detail_BillDTO detailBill) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call UPDATE_DETAIL_BILL(?, ?, ?, ?, ?)}");
                call.setString(1, detailBill.getDetailBillId());
                call.setDouble(2, detailBill.getUnitPrice());
                call.setString(3, detailBill.getProductSize());
                call.setString(4, detailBill.getProducStatus());
                call.setInt(5, detailBill.getQuantity());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at updateDetailBill method from Detail_BillDAO class!");
            System.err.println(e);
        }
    }
    
    public static void main(String[] args) {
        Detail_BillDAO o = new Detail_BillDAO();
        o.updateDetailBill(new Detail_BillDTO("BL000011", "BL00001", "TE003", 1, "L", "BOTH", 10, 230000.0));
    }
}
