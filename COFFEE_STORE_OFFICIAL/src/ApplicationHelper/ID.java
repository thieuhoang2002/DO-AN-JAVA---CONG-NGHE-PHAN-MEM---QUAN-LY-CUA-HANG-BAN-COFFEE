package ApplicationHelper;

import BUS.BillBUS;
import BUS.ClassifyBUS;
import BUS.Detail_BillBUS;
import BUS.ProductBUS;
import BUS.ToppingBUS;
import DTO.BillDTO;
import DTO.Detail_BillDTO;
import DTO.ProductDTO;
import DTO.ToppingDTO;

public class ID {
    //attribute
    private static final BillBUS billBUS = new BillBUS();
    private static final Detail_BillBUS detailBillBUS = new Detail_BillBUS();
    private static final ProductBUS productBUS = new ProductBUS();
    private static final ClassifyBUS classifyBUS = new ClassifyBUS();
    private static final ToppingBUS toppingBUS = new ToppingBUS();
    
    //getter
    public static BillBUS getBillBUS() {
        return billBUS;
    }

    public static Detail_BillBUS getDetailBillBUS() {
        return detailBillBUS;
    }

    public static ProductBUS getProductBUS() {
        return productBUS;
    }

    public static ClassifyBUS getClassifyBUS() {
        return classifyBUS;
    }

    public static ToppingBUS getToppingBUS() {
        return toppingBUS;
    }
    
    //method
    public static String createBillId() {
        getBillBUS().resetList();
        int Id = 1;
        String newBillId;
        for(BillDTO bill: getBillBUS().getBillList()) {
            newBillId = "BL" + String.format("%05d", Id);
            if(bill.getBillId().equalsIgnoreCase(newBillId)) {
                Id++;
            } else {
                break;
            }
        }
        newBillId = "BL" + String.format("%05d", Id);
        return newBillId;  
    }
    
    public static String createDetailBillId(String billId) {
        return billId + createOrdinalNumber(billId);
    }
    
    public static int createOrdinalNumber(String billId) {
        getDetailBillBUS().resetList();
        int num = 1;
        for(Detail_BillDTO detail: getDetailBillBUS().getDetailBillList()) {
            if(detail.getBillId().equalsIgnoreCase(billId) && detail.getOrdinalNumber() == num) {
                num++;
            } else if(!detail.getBillId().equalsIgnoreCase(billId)) {
            } else {
                break;
            }
        }
        return num;
    }
    
    //Cap id san pham
    public static String createProductId(String classify) {
        getProductBUS().resetList();
        String beforeId;
        
        if(classify.equalsIgnoreCase("Coffee")) {
            beforeId = "CF";
        } else if(classify.equalsIgnoreCase("Tea")) {
            beforeId = "TE";
        } else if(classify.equalsIgnoreCase("Fruit Juice")) {
            beforeId = "FJ";
        } else if(classify.equalsIgnoreCase("Yogurt")) {
            beforeId = "YG";
        } else if(classify.equalsIgnoreCase("Smoothie")) {
            beforeId = "SM";
        } else {
            if(classify.split("\\s").length == 1) {
                beforeId = String.valueOf(classify.split("\\s")[0].charAt(0)).toUpperCase() + String.valueOf(classify.split("\\s")[0].charAt(1)).toUpperCase() + "";
            } else {
                beforeId = String.valueOf(classify.split("\\s")[0].charAt(0)).toUpperCase() + String.valueOf(classify.split("\\s")[1].charAt(0)).toUpperCase() + "";
            }
        }
        int id = 1;
        String newProductId;
        for(ProductDTO product: getProductBUS().getProductList()) {
            newProductId = beforeId + String.format("%03d", id);
            if(getClassifyBUS().getClassifyName(product.getClassifyId()).equalsIgnoreCase(classify) && product.getProductId().equalsIgnoreCase(newProductId.trim())) {
                id++;
            } else if(!getClassifyBUS().getClassifyName(product.getClassifyId()).equalsIgnoreCase(classify)){
            } else {
                break;
            }
        }
        newProductId = beforeId + String.format("%03d", id);
        return newProductId;
    }
    
    public static String createToppingID() {
        String newId;
        int id = 1;
        getToppingBUS().resetList();
        for(ToppingDTO topping: getToppingBUS().getToppingList()) {
            newId = "TP" + String.format("%03d", id);
            if(topping.getToppingId().equalsIgnoreCase(newId)) {
                id++;
            } else {
                break;
            }
        }
        newId = "TP" + String.format("%03d", id);
        return newId;
    }
}
