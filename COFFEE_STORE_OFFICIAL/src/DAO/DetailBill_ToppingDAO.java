package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.BillDetail_ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class DetailBill_ToppingDAO {
    //constructor
    public DetailBill_ToppingDAO() {
    }
    
    //method
    //get detai_bill_topping list from database
    public Vector<BillDetail_ToppingDTO> readDetailBillToppingListFromDB() {
        Vector<BillDetail_ToppingDTO> detailBillToppingList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            try{
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_DETAILBILL_TOPPING_LIST()}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    BillDetail_ToppingDTO o = new BillDetail_ToppingDTO(rs.getString("DETAIL_BILL_ID"), rs.getString("TOPPING_ID"), rs.getInt("QUANTITY"), rs.getDouble("PRICE"));
                    detailBillToppingList.add(o);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readDetailBillToppingListFromDB method from DetailBill_ToppingDAO class!");
            System.err.println(e);
        }
        return detailBillToppingList;
    }
    
    //Them chi tiet bill _ topping vao csdl
    public void insertDetailBillTopping(BillDetail_ToppingDTO o) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call INSERT_DETAILBILL_TOPPING(?, ?, ?, ?)}");
                call.setString(1, o.getDetailBillId());
                call.setString(2, o.getToppingId());
                call.setInt(3, o.getQuantity());
                call.setDouble(4, o.getPrice());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insertDetailBillTopping method from DetailBill_ToppingDAO class!");
            System.err.println(e);
        }
    }
    
    //delete detail toppings from detailbill_id
    public void deleteDetailBillTopping(String detailBillId) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call DELTETE_DETAILBILL_TOPPING (?)}");
                call.setString(1, detailBillId);
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at delete DetailBillTopping method from DetailBill_ToppingDAO class!");
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at delete DetailBillTopping method from DetailBill_ToppingDAO class!");
            System.err.println(e);
        }
    }
}
