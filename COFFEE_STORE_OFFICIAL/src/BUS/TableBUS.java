package BUS;

import DAO.TableDAO;
import DTO.TableDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class TableBUS implements ICoffeeShop{
    //attribute
    private TableDAO tableDAO;
    private Vector<TableDTO> tableList;
    
    //constructor
    public TableBUS() {
        this.tableDAO = new TableDAO();
        this.tableList = this.tableDAO.readTableListFromDatabase();
    }
    
    //setter and getter
    public TableDAO getTableDAO() {
        return tableDAO;
    }

    public void setTableDAO(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    public Vector<TableDTO> getTableList() {
        return tableList;
    }

    public void setTableList(Vector<TableDTO> tableList) {
        this.tableList = tableList;
    }
    
    //method
    @Override
    public void resetList() {
        this.setTableList(this.getTableDAO().readTableListFromDatabase());
    }
    
    //update status a table
    public void updateStatusTable(String tableId, boolean status) {
        this.getTableDAO().updateStatustable(tableId, status);
        this.resetList();
    }
    
    //get table from id
    public TableDTO getTableFromId(String tableId) {
        this.resetList();
        for(TableDTO table: this.getTableList()) {
            if(table.getTableId().equalsIgnoreCase(tableId)) {
                return table;
            }
        }
        return null;
    }
}
