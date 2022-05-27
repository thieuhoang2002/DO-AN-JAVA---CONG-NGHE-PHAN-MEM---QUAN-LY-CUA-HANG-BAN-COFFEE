package BUS;

import DAO.Product_SizeDAO;
import DTO.Product_SizeDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class Product_SizeBUS implements ICoffeeShop{
    //attribute
    private Product_SizeDAO productSizeDAO;
    private Vector<Product_SizeDTO> productSizeList;
    
    //construcotr
    public Product_SizeBUS() {
        this.productSizeDAO = new Product_SizeDAO();
        this.productSizeList = this.productSizeDAO.readProductAndSizeFromDatabase();
    }
    
    //setter and getter
    public Product_SizeDAO getProductSizeDAO() {
        return productSizeDAO;
    }

    public void setProductSizeDAO(Product_SizeDAO productSizeDAO) {
        this.productSizeDAO = productSizeDAO;
    }

    public Vector<Product_SizeDTO> getProductSizeList() {
        return productSizeList;
    }

    public void setProductSizeList(Vector<Product_SizeDTO> productSizeList) {
        this.productSizeList = productSizeList;
    }
    
    //method
    //reset list
    @Override
    public void resetList() {
        this.setProductSizeList(this.getProductSizeDAO().readProductAndSizeFromDatabase());
    }
    
    //Lay gia cua san pham khi truyen vao size va productId
    public Double getPrice(String productId, String size) {
        for(Product_SizeDTO o: this.getProductSizeList()) {
            if(o.getProductId().equalsIgnoreCase(productId) && o.getSize().equalsIgnoreCase(size)) {
                return o.getPrice();
            }
        }
        return 0.0;
    }
    
    //check exists of a size of a product
    public boolean checkSize(String productId, String size) {
        this.resetList();
        for(Product_SizeDTO o: this.getProductSizeList()) {
            if(o.getProductId().equalsIgnoreCase(productId) && o.getSize().equalsIgnoreCase(size)) {
                return true;
            }
        }
        return false;
    }
    
    public String getPriceToStatistic(String productId, String size) {
        for(Product_SizeDTO o: this.getProductSizeList()) {
            if(o.getProductId().equalsIgnoreCase(productId) && o.getSize().equalsIgnoreCase(size)) {
                return String.valueOf(o.getPrice());
            }
        }
        return "X";
    }
    
}
