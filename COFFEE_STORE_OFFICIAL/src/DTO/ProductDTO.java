package DTO;

public class ProductDTO {
    //attribute
    private String classifyId;
    private String productId;
    private String productName;
    private String productNickName;
    private String productStatus;
    private boolean productBusiness;
    
    //constructor
    public ProductDTO (String classifyId, String productId, String productName, String productNickName, String productStatus, boolean productBusiness) {
        this.classifyId = classifyId;
        this.productId = productId;
        this.productName = productName;
        this.productNickName = productNickName;
        this.productStatus = productStatus;
        this.productBusiness = productBusiness;
    }
    
    //setter and getter
    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductNickName() {
        return productNickName;
    }

    public void setProductNickName(String productNickName) {
        this.productNickName = productNickName;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public boolean isProductBusiness() {
        return productBusiness;
    }

    public void setProductBusiness(boolean productBusiness) {
        this.productBusiness = productBusiness;
    }
    
    
    
}
