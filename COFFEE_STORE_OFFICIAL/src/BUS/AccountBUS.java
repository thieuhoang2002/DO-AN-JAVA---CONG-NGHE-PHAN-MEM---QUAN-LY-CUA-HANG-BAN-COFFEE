package BUS;

import DAO.AccountDAO;
import DTO.AccountDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class AccountBUS implements ICoffeeShop{
    //attribute
    private AccountDAO accountDAO;
    private Vector<AccountDTO> accountList;
    private StaffBUS staffBUS;
    
    //constructor
    public AccountBUS() {
        this.accountDAO = new AccountDAO();
        this.accountList = this.accountDAO.readAccountListFromDatabase();
        this.staffBUS = new StaffBUS();
    }
    
    //setter and getter
    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Vector<AccountDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(Vector<AccountDTO> accountList) {
        this.accountList = accountList;
    }

    public StaffBUS getStaffBUS() {
        return staffBUS;
    }

    public void setStaffBUS(StaffBUS staffBUS) {
        this.staffBUS = staffBUS;
    }
    
    //method
    //reset account list
    @Override
    public void resetList(){
        this.setAccountList(this.getAccountDAO().readAccountListFromDatabase());
    }
    
    //check account
    public boolean checkAccount(String username, String password) {
        this.resetList();
        for(AccountDTO account: this.getAccountList()) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    //getStaffID from unsername and password
    public String getStaffID(String username, String password) {
        this.resetList();
        for(AccountDTO account: this.getAccountList()) {
            if(account.getUsername().equals(username) 
               && account.getPassword().equals(password)) {
                return account.getStaffId();
            }
        }
        return null;
    }
    
    //insert
    public String insert(AccountDTO account) {
        if(this.getAccountDAO().insert(account)) {
            this.resetList();
            return "Successfully!";
        }
        return "Failed!";
    }
    
    //update
    public String update(AccountDTO account, String oldUsername) {
        if(this.getAccountDAO().update(account, oldUsername)) {
            this.resetList();
            return "Successfully!";
        }
        return "Failed!";
    }
    
    //delete
    public String delete(String username) {
        if(this.getAccountDAO().delete(username)) {
            this.resetList();
            return "Successfully!";
        }
        return "Failed!";
    }
    
    //get account list from keyWord (search)
    public Vector<AccountDTO> search(String keyWord) {
        this.resetList();
        Vector<AccountDTO> searchList = new Vector<>();
        for(AccountDTO account: this.getAccountList()) {
            if(account.getUsername().toLowerCase().equalsIgnoreCase(keyWord.toLowerCase()) 
                    || account.getStaffId().toLowerCase().contains(keyWord.toLowerCase())) {
                searchList.add(account);
            }
        }
        return searchList;
    }
    
    //check username exist
    public boolean checkUsername(String username) {
        this.resetList();
        for(AccountDTO account: this.getAccountList()) {
            if(account.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
    
} 
