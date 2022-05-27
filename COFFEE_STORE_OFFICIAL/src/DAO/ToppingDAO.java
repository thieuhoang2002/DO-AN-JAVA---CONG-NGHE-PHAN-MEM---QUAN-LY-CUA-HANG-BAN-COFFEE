package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class ToppingDAO {

    //construtor
    public ToppingDAO() {
    }
    
    //method
    public Vector<ToppingDTO> readToppingListFromDatabase() {
        Vector<ToppingDTO> toppingList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try (Statement stmt = con.createStatement()){
                con.setAutoCommit(false);
                ResultSet rs = stmt.executeQuery("SELECT * FROM TOPPING");
                while(rs.next()) {
                    ToppingDTO topping = new ToppingDTO(rs.getString("TOPPING_ID"), rs.getString("TOPPING_NAME"), rs.getDouble("TOPPING_PRICE"), rs.getBoolean("TOPPING_BUSINESS"));
                    toppingList.add(topping);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readToppingListFromDatabase method from ToppingDAO class!");
            System.err.println(e);
        }
        return toppingList;
    }
    
    //insert a new topping
    public boolean insert(ToppingDTO topping) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                PreparedStatement stmt = con.prepareStatement("INSERT INTO TOPPING VALUES (?, ?, ?, ?)");
                stmt.setString(1, topping.getToppingId());
                stmt.setString(2, topping.getToppingName());
                stmt.setDouble(3, topping.getToppingPrice());
                stmt.setBoolean(4, topping.isToppingStatus());
                stmt.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at insert method from ToppingDAO class!");
                System.err.println(e);
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insert method from ToppingDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    //update a topping
    public boolean update(ToppingDTO topping) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                PreparedStatement stmt = con.prepareStatement("UPDATE TOPPING SET TOPPING_NAME = ?, TOPPING_PRICE = ?, TOPPING_BUSINESS = ? WHERE TOPPING_ID = ?");
                stmt.setString(1, topping.getToppingName());
                stmt.setDouble(2, topping.getToppingPrice());
                stmt.setBoolean(3, topping.isToppingStatus());
                stmt.setString(4, topping.getToppingId());
                stmt.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at update method from ToppingDAO class!");
                System.err.println(e);
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (SQLException|ClassNotFoundException e) {
            System.err.println("Error at update method from ToppingDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        ToppingDAO toppingDAO = new ToppingDAO();
        System.out.println(toppingDAO.update(new ToppingDTO("TP010", "Black Beans 2", 8000.0, false)));
    }
    
    
}
