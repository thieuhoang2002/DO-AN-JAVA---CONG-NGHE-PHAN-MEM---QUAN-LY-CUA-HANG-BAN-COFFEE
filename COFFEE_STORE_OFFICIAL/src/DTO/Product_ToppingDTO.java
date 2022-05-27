package DTO;

public class Product_ToppingDTO {
    //attribute
    private String productId;
    private String toppingId;
    
    //constructor
    public Product_ToppingDTO(String productId, String toppingId) {
        this.productId = productId;
        this.toppingId = toppingId;
    }
    
    //setter and getter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getToppingId() {
        return toppingId;
    }

    public void setToppingId(String toppingId) {
        this.toppingId = toppingId;
    }
    
    
}
