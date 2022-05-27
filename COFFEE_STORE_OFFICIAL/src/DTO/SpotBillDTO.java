package DTO;

public class SpotBillDTO {
    //attribute
    private String billId;
    private String tableId;
    
    //constructor
    public SpotBillDTO(String billId, String tableId) {
        this.billId = billId;
        this.tableId = tableId;
    }
    
    //setter and getter
    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }
    
}
