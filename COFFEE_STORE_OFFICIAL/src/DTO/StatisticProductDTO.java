package DTO;

public class StatisticProductDTO implements Comparable<StatisticProductDTO>{
    //private
    private String productId;
    private String[][] salesOfSize;
    
    //constructor
    public StatisticProductDTO() {
        this.salesOfSize = new String[2][4];
    }
    
    //setter and getter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String[][] getSalesOfSize() {
        return salesOfSize;
    }

    public void setSalesOfSize(String[][] salesOfSize) {
        this.salesOfSize = salesOfSize;
    }
    
    @Override
    public int compareTo(StatisticProductDTO statistic) {
        if(Integer.parseInt(statistic.getSalesOfSize()[0][3]) > Integer.parseInt(getSalesOfSize()[0][3]))
            return 1;
        return -1;
    }
}
