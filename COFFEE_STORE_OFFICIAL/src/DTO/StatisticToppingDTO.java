package DTO;

public class StatisticToppingDTO implements Comparable<StatisticToppingDTO>{
    //attribute
    private String toppingId;
    private int quantity;
    private Double sales;
    
    //constructor
    public StatisticToppingDTO() {
    }
    
    //setter and getter
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

    public Double getSales() {
        return sales;
    }

    public void setSales(Double sales) {
        this.sales = sales;
    }

    @Override
    public int compareTo(StatisticToppingDTO o) {
        if(getQuantity() < o.getQuantity())
            return 1;
        return -1;
    }
    
    
    
}
