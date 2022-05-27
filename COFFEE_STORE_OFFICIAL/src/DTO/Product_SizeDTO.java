package DTO;

public class Product_SizeDTO {
    //attribute
    private String productId;
    private String size;
    private Double price;
    
    //constructor
    public Product_SizeDTO(String productId, String size, Double price) {
        this.productId = productId;
        this.size = size;
        this.price = price;
    }
    
    //setter and getter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
}
