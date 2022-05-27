package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.Product_SizeDTO;
import java.sql.*;
import java.util.Vector;

public class Product_SizeDAO {
    //constructor
    public Product_SizeDAO() {
    }
    
    //method
    //read product_size list from database
    public Vector<Product_SizeDTO> readProductAndSizeFromDatabase() {
        Vector<Product_SizeDTO> productSizeList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM PRODUCT_SIZE");
                while(rs.next()) {
                    Product_SizeDTO o = new Product_SizeDTO(rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_SIZE"), rs.getDouble("PRODUCT_PRICE"));
                    productSizeList.add(o);
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
           System.err.println("Error at readProductAndSizeFromDatabase method from Product_SizeDAO class!");
           System.err.println(e);
        } 
        return productSizeList;
    }
    
    //insert a product_size
    public boolean insert(Product_SizeDTO productSize) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call INSERT_PRODUCT_SIZE (?, ?, ?)}");
                call.setString(1, productSize.getProductId());
                call.setString(2, productSize.getSize());
                call.setDouble(3, productSize.getPrice());
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                System.err.println(e);
                con.rollback();
                return false;
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
           System.err.println("Error at insert method from Product_SizeDAO class!");
           System.err.println(e);
           return false;
        }
        return true;
    }
    
    //delete product_size
    public boolean delete(String productId, String size) {
       try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call DELETE_PRODUCT_SIZE (?, ?)}");
                call.setString(1, productId);
                call.setString(2, size);
                call.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                System.err.println(e);
                con.rollback();
                return false;
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
           System.err.println("Error at delete method from Product_SizeDAO class!");
           System.err.println(e);
           return false;
        }
        return true; 
    }
}
