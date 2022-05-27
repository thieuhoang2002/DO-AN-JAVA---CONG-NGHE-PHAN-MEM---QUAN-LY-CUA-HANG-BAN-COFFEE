package DTO;

public class ToppingDTO {
    //attribute
    private String toppingId;
    private String toppingName;
    private Double toppingPrice;
    private boolean toppingStatus;
    
    //constructor
    public ToppingDTO(String toppingId, String toppingName, Double toppingPrice, boolean toppingStatus) {
        this.toppingId = toppingId;
        this.toppingName = toppingName;
        this.toppingPrice = toppingPrice;
        this.toppingStatus = toppingStatus;
    }
    
    //setter and getter
    public String getToppingId() {
        return toppingId;
    }

    public void setToppingId(String toppingId) {
        this.toppingId = toppingId;
    }

    public String getToppingName() {
        return toppingName;
    }

    public void setToppingName(String toppingName) {
        this.toppingName = toppingName;
    }

    public Double getToppingPrice() {
        return toppingPrice;
    }

    public void setToppingPrice(Double toppingPrice) {
        this.toppingPrice = toppingPrice;
    }

    public boolean isToppingStatus() {
        return toppingStatus;
    }

    public void setToppingStatus(boolean toppingStatus) {
        this.toppingStatus = toppingStatus;
    }
    
}
