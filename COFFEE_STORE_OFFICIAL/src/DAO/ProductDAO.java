package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.ProductDTO;
import DTO.Product_SizeDTO;
import DTO.Product_ToppingDTO;
import java.util.Vector;
import java.sql.*;

public class ProductDAO {
    //constructor
    public ProductDAO() {
    }
    
    //method  
    //get product list from database
    public Vector<ProductDTO> readProductListFromDatabase() {
        Vector<ProductDTO> productList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()){
            String sql = "SELECT * FROM PRODUCT";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                ProductDTO product = new ProductDTO(rs.getString("CLASSIFY_ID"), rs.getString("PRODUCT_ID"), rs.getString("PRODUCT_NAME"), rs.getString("PRODUCT_NICKNAME"), rs.getString("PRODUCT_STATUS"), rs.getBoolean("PRODUCT_BUSINESS"));
                productList.add(product);
            }

        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readProductListFromDatabase method from ProductDAO class!");
            System.err.println(e);
        }
        return productList;
    }
    
    //insert a product
    public boolean insert(ProductDTO product, Vector<Product_SizeDTO> productSizeList, Vector<Product_ToppingDTO> productToppingList) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                //insert product
                CallableStatement call = con.prepareCall("{call INSERT_PRODUCT (?, ?, ?, ?, ?, ?)}");
                call.setString(1, product.getClassifyId());
                call.setString(2, product.getProductId());
                call.setString(3, product.getProductName());
                call.setString(4, product.getProductNickName());
                call.setString(5, product.getProductStatus());
                call.setBoolean(6, product.isProductBusiness());
                call.executeUpdate();
                
                //insert product size
                call = con.prepareCall("{call INSERT_PRODUCT_SIZE (?, ?, ?)}");
                for(Product_SizeDTO productSize: productSizeList) {
                    call.setString(1, productSize.getProductId());
                    call.setString(2, productSize.getSize());
                    call.setDouble(3, productSize.getPrice());
                    call.executeUpdate();
                }
                
                //insert product topping
                if(!productToppingList.isEmpty()) {
                    call = con.prepareCall("{call INSERT_PRODUCT_TOPPING (?, ?)}");
                    for(Product_ToppingDTO productTopping: productToppingList) {
                        call.setString(1, productTopping.getProductId());
                        call.setString(2, productTopping.getToppingId());
                        call.executeUpdate();
                    }
                }
                con.commit();
            } catch (SQLException e) {
                System.err.println(e);
                con.rollback();
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insert method of ProductDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    //update a product
    public boolean update(ProductDTO product, Vector<Product_SizeDTO> productSizeList, Vector<Product_ToppingDTO> productToppingList) {
        try (Connection con = DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                //update a product
                CallableStatement call = con.prepareCall("{call UPDATE_PRODUCT (?, ?, ?, ?, ?)}");
                call.setString(1, product.getProductId());
                call.setString(2, product.getProductName());
                call.setString(3, product.getProductNickName());
                call.setString(4, product.getProductStatus());
                call.setBoolean(5, product.isProductBusiness());
                call.executeUpdate();
                
                //xoa nhung product size cua san pham nay sau do them lai nhung product size vua cap nhat vao
                call = con.prepareCall("{call DELETE_PRODUCT_SIZE_FROM_PRODUCT_ID (?)}");
                call.setString(1, product.getProductId());
                call.executeUpdate();
                
                call = con.prepareCall("{call INSERT_PRODUCT_SIZE (?, ?, ?)}");
                for(Product_SizeDTO productSize: productSizeList) {
                    call.setString(1, productSize.getProductId());
                    call.setString(2, productSize.getSize());
                    call.setDouble(3, productSize.getPrice());
                    call.executeUpdate();
                }
                
                //xoa nhung chi tiet product_topping cu sau do them lai nhung chi tiet product_topping vua cap nhap vao
                call = con.prepareCall("{call DELETE_PRODUCT_TOPPING_FROM_PRODUCT_ID (?)}");
                call.setString(1, product.getProductId());
                call.executeUpdate();
                        
                if(!productToppingList.isEmpty()) {
                    call = con.prepareCall("{call INSERT_PRODUCT_TOPPING (?, ?)}");
                    for(Product_ToppingDTO productTopping: productToppingList) {
                        call.setString(1, productTopping.getProductId());
                        call.setString(2, productTopping.getToppingId());
                        call.executeUpdate();
                    }
                }
                
                con.commit();
            } catch (SQLException e) {
                System.err.println(e);
                con.rollback();
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at update method of ProductDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
}
