package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.TableDTO;
import java.sql.*;
import java.util.Vector;

public class TableDAO {
    //constructor
    public TableDAO() {
    }
    
    //method
    public Vector<TableDTO> readTableListFromDatabase() {
        Vector<TableDTO> tableList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM TABLE_IN_STORE");
            while(rs.next()) {
                tableList.add(new TableDTO(rs.getString("TABLE_ID"), rs.getInt("TABLE_TYPE"), rs.getBoolean("TABLE_STATUS")));
            } 
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readTableListFromDatabase method from TableDAO class!");
            System.err.println(e);
        }
        return tableList;
    }
    
    //update status of a table
    public void updateStatustable(String tableId, boolean Status) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call UPDATE_TABLE_STATUS (?, ?)}");
                call.setString(1, tableId);
                call.setBoolean(2, Status);
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at updateStatustable method from TableDAO class!");
            System.err.println(e);
        }
    }
}
