package BUS;

import DAO.ToppingDAO;
import DTO.ToppingDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class ToppingBUS implements ICoffeeShop{
    //attribue
    private ToppingDAO toppingDAO;
    private Vector<ToppingDTO> toppingList;
    
    //constructor
    public ToppingBUS() {
        this.toppingDAO = new ToppingDAO();
        this.toppingList = this.toppingDAO.readToppingListFromDatabase();
    }
    
    //setter and getter
    public ToppingDAO getToppingDAO() {
        return toppingDAO;
    }

    public void setToppingDAO(ToppingDAO toppingDAO) {
        this.toppingDAO = toppingDAO;
    }

    public Vector<ToppingDTO> getToppingList() {
        return toppingList;
    }

    public void setToppingList(Vector<ToppingDTO> toppingList) {
        this.toppingList = toppingList;
    }
    
    //method
    public ToppingDTO getToppingFromId (String toppingId) {
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(toppingId)) {
                return topping;
            }
        }
        return null;
    }
    
    //lay gia topping tu id
    public Double getPriceFromId(String toppingId) {
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(toppingId)) {
                return topping.getToppingPrice();
            }
        }
        return 0.0;
    }
    
    //them topping
    public String insert(ToppingDTO topping) {
        if(this.getToppingDAO().insert(topping)) {
           this.resetList();
           return "Successfully!"; 
        }
        return "Failure!"; 
    }
    
    //sua topping
    public String update(ToppingDTO topping) {
        if(this.getToppingDAO().update(topping)) {
           this.resetList();
           return "Successfully!"; 
        }
        return "Failure!"; 
    }

    //tim kiem topping from keyWord
    public Vector<ToppingDTO> search(String keyWord) {
        Vector<ToppingDTO> searchList = new Vector<>();
        this.resetList();
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(keyWord) || topping.getToppingName().toLowerCase().contains(keyWord.toLowerCase())
                    || topping.getToppingPrice().toString().contains(keyWord)) {
                searchList.add(topping);
            }
        }
        return searchList;
    }
    
    //kiem tra xem ten topping da ton tai trong he thong hay chua
    public boolean checkName(String name) {
        this.resetList();
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    
    //kiem tra ton tai
    public boolean checkExist(String toppingId) {
        this.resetList();
        for(ToppingDTO topping: this.getToppingList()) {
            if(topping.getToppingId().equalsIgnoreCase(toppingId)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void resetList() {
        this.setToppingList(this.getToppingDAO().readToppingListFromDatabase());
    }
    
}
