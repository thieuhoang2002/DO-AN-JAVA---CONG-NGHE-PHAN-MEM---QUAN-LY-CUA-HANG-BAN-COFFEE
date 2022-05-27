package DTO;

public class BillDetail_ToppingDTO {
    //attribute
    private String detailBillId;
    private String toppingId;
    private int quantity;
    private double price;
    
    //constructor
    public BillDetail_ToppingDTO(String detailBillId, String toppingId, int quantity, double price) {    
        this.detailBillId = detailBillId;
        this.toppingId = toppingId;
        this.quantity = quantity;
        this.price = price;
    }

    //setter and getter
    public String getDetailBillId() {
        return detailBillId;
    }

    public void setDetailBillId(String detailBillId) {
        this.detailBillId = detailBillId;
    }

    public String getToppingId() {
        return toppingId;
    }

    public void setToppingId(String toppingId) {
        this.toppingId = toppingId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
