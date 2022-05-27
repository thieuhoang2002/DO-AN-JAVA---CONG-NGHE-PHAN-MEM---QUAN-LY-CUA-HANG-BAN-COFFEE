package BUS;

import DAO.ProductDAO;
import DTO.ProductDTO;
import DTO.Product_SizeDTO;
import DTO.Product_ToppingDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class ProductBUS implements ICoffeeShop{
    //attribute
    private ProductDAO productDAO;
    private Vector<ProductDTO> productList;
    
    //constructor
    public ProductBUS() {
        this.productDAO = new ProductDAO();
        this.productList = productDAO.readProductListFromDatabase();
    }
    
    //setter and getter
    public ProductDAO getProductDAO() {
        return productDAO;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public Vector<ProductDTO> getProductList() {
        return productList;
    }

    public void setProductList(Vector<ProductDTO> productList) {
        this.productList = productList;
    }
    
    //method
    //reset list when update database
    @Override
    public void resetList() {
        this.setProductList(this.getProductDAO().readProductListFromDatabase());
    }
    
    //lay san pham tu id cua san pham
    public ProductDTO getProductFromId (String productId) {
        for(ProductDTO o: this.getProductList()) {
            if(o.getProductId().equalsIgnoreCase(productId)) {
                return o;
            }
        }
        return null;
    }
    
    //get product list from keyWord
    public Vector<ProductDTO> getProductList(String keyWord) {
        this.resetList();
        Vector<ProductDTO> list = new Vector<>();
        ClassifyBUS classifyBUS = new ClassifyBUS();
        for(ProductDTO o: this.getProductList()) {
            if(o.isProductBusiness() && (classifyBUS.getClassifyName(o.getClassifyId()).toLowerCase().contains(keyWord.toLowerCase()) ||o.getProductName().toLowerCase().contains(keyWord.toLowerCase())
                || o.getProductId().toLowerCase().contains(keyWord.toLowerCase())|| o.getClassifyId().toLowerCase().contains(keyWord.toLowerCase()))) {
                list.add(o);
            }
        }
        return list;
    }
    
    //check product id
    public boolean checkId(String productId) {
        this.resetList();
        for(ProductDTO product: this.getProductList()) {
            if(product.getProductId().equalsIgnoreCase(productId)) {
                return true;
            }
        }
        return false;
    }
    //check product name
    public boolean checkName(String productName) {
        this.resetList();
        for(ProductDTO product: this.getProductList()) {
            if(product.getProductName().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }
    
    //check product nick name
    public boolean checkNickName(String productNickName) {
        this.resetList();
        for(ProductDTO product: this.getProductList()) {
            if(product.getProductNickName().equalsIgnoreCase(productNickName)) {
                return true;
            }
        }
        return false;
    }
    
    //insert a product
    public String insert(ProductDTO product, Vector<Product_SizeDTO> productSizeList, Vector<Product_ToppingDTO> productTopping) {
        if(this.getProductDAO().insert(product, productSizeList, productTopping))
            return "Successfully!";
        return "Failure!";  
    }
    
    //update a product
    public String update(ProductDTO product, Vector<Product_SizeDTO> productSizeList, Vector<Product_ToppingDTO> productTopping) {
        if(this.getProductDAO().update(product, productSizeList, productTopping))
            return "Successfully!";
        return "Failure!";  
    }
}
