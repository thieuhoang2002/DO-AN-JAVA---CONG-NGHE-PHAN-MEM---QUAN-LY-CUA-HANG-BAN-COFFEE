package DTO;

public class Detail_BillDTO {
    //atribute
    private String detailBillId;
    private String billId;
    private String productId;
    private int ordinalNumber;
    private String productSize;
    private String producStatus;
    private int quantity;
    private Double unitPrice;
    
    //constructor
    public Detail_BillDTO(String detailBillId, String billId, String productId, int ordinalNumber, String productSize, String producStatus, int quantity, Double unitPrice) {
        this.detailBillId = detailBillId;
        this.billId = billId;
        this.productId = productId;
        this.ordinalNumber = ordinalNumber;
        this.productSize = productSize;
        this.producStatus = producStatus;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Detail_BillDTO() {
    }
    
    //setter and getter
    public String getDetailBillId() {
        return detailBillId;
    }

    public void setDetailBillId(String detailBillId) {
        this.detailBillId = detailBillId;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getOrdinalNumber() {
        return ordinalNumber;
    }

    public void setOrdinalNumber(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getProductSize() {
        return productSize;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public String getProducStatus() {
        return producStatus;
    }

    public void setProducStatus(String producStatus) {
        this.producStatus = producStatus;
    }
}
