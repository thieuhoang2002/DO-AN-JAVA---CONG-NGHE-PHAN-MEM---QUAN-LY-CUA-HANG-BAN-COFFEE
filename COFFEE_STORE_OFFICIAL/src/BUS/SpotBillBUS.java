package BUS;

import DAO.SpotBillDAO;
import DTO.SpotBillDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class SpotBillBUS implements ICoffeeShop{
    //attribute
    private SpotBillDAO spotBillDAO;
    private Vector<SpotBillDTO> spotBillList;
    
    //constructor
    public SpotBillBUS() {
        this.spotBillDAO = new SpotBillDAO();
        this.spotBillList = this.spotBillDAO.readSpotBillListFromDB();
    }
    
    //setter and getter
    public SpotBillDAO getSpotBillDAO() {
        return spotBillDAO;
    }

    public void setSpotBillDAO(SpotBillDAO spotBillDAO) {
        this.spotBillDAO = spotBillDAO;
    }

    public Vector<SpotBillDTO> getSpotBillList() {
        return spotBillList;
    }

    public void setSpotBillList(Vector<SpotBillDTO> spotBillList) {
        this.spotBillList = spotBillList;
    }
    
    //method
    //reset

    /**
     *
     */
    @Override
    public void resetList() {
        this.setSpotBillList(this.getSpotBillDAO().readSpotBillListFromDB());
    }
    
    //insert a spot bill
    public void insertSpotBill(SpotBillDTO spotBill) {
        this.getSpotBillDAO().insetSpotBill(spotBill);
        this.resetList();
    }
    
    //get spot bill from id
    public SpotBillDTO getSpotBillFromId(String billId) {
        this.resetList();
        for(SpotBillDTO spotBill: this.getSpotBillList()) {
            if(spotBill.getBillId().equalsIgnoreCase(billId)) {
                return spotBill;
            }
        }
        return null;
    }
    
    //xem mot ban da co bill chua thanh toan hay chua
    public boolean checkSpotBill(String tableId, String billId) {
        this.resetList();
        BillBUS billTemp = new BillBUS();
        for(SpotBillDTO o: this.getSpotBillList()) {
            if(o.getTableId().equalsIgnoreCase(tableId) && !billTemp.getBillFromId(billId).isBillStatus()) {
                return true;
            }
        }
        return false;
    }
}
