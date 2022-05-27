package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.SpotBillDTO;
import java.util.Vector;
import java.sql.*;

public class SpotBillDAO {
    //constructor
    public SpotBillDAO() {
    }
    
    //method
    //get spot bill list from database
    public Vector<SpotBillDTO> readSpotBillListFromDB() {
        Vector<SpotBillDTO> spotBillList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM SPOT_BILL";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                SpotBillDTO spotBill = new SpotBillDTO(rs.getString("BILL_ID"), rs.getString("TABLE_ID"));
                spotBillList.add(spotBill);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readBillListFromDatabase method from BillDAO class!");
            System.err.println(e);
        }
        return spotBillList;
    }
    
    //insert a spot bill
    public void insetSpotBill(SpotBillDTO spotBill) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call INSERT_SPOT_BILL (?, ?)}");
                call.setString(1, spotBill.getBillId());
                call.setString(2, spotBill.getTableId());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insetSpotBill method from BillDAO class!");
            System.err.println(e);
        }
    }
}
