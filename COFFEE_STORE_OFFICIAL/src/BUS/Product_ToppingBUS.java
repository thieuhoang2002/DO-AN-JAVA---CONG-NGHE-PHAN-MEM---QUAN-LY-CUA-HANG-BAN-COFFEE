package BUS;

import DAO.Product_ToppingDAO;
import DTO.Product_ToppingDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class Product_ToppingBUS implements ICoffeeShop{
    //attribute
    private Product_ToppingDAO productToppingDAO;
    private Vector<Product_ToppingDTO> productToppingList;
    
    //constructor
    public Product_ToppingBUS() {
        this.productToppingDAO = new Product_ToppingDAO();
        this.productToppingList = this.productToppingDAO.readProductToppingListFromDatabase();
    }
    
    //setter and getter
    public Product_ToppingDAO getProductToppingDAO() {
        return productToppingDAO;
    }

    public void setProductToppingDAO(Product_ToppingDAO productToppingDAO) {
        this.productToppingDAO = productToppingDAO;
    }

    public Vector<Product_ToppingDTO> getProductToppingList() {
        return productToppingList;
    }

    public void setProductToppingList(Vector<Product_ToppingDTO> productToppingList) {
        this.productToppingList = productToppingList;
    }
    
    //reset
    @Override
    public void resetList() {
        this.setProductToppingList(this.getProductToppingDAO().readProductToppingListFromDatabase());
    }
    
    //get topping list from product id
    public Vector<String> getToppingIdList(String productId) {
        Vector<String> toppingIdList  = new Vector<>();
        this.resetList();
        for(Product_ToppingDTO productTopping: this.getProductToppingList()) {
            if(productTopping.getProductId().equalsIgnoreCase(productId)) {
                toppingIdList.add(productTopping.getToppingId());
            }
        }
        return toppingIdList;
    }
}
