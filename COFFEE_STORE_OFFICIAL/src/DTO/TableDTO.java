package DTO;

public class TableDTO {
    //atribute
    private String tableId;
    private int tableType;
    private boolean tableStatus;
    
    //constructor
    public TableDTO(String tableId, int tableType, boolean tableStatus) {
        this.tableId = tableId;
        this.tableType = tableType;
        this.tableStatus = tableStatus;
    }
    
    //setter and getter
    public String getTableId() {
        return tableId;
    }

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public int getTableType() {
        return tableType;
    }

    public void setTableType(int tableType) {
        this.tableType = tableType;
    }

    public boolean isTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(boolean tableStatus) {
        this.tableStatus = tableStatus;
    }
    
    
}
