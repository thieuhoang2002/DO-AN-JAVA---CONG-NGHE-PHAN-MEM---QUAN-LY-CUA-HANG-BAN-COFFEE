package DAO;

import DTO.AccountDTO;
import java.sql.*;
import java.util.Vector;

public class AccountDAO {
    //constructor
    public AccountDAO() {
    }
    
    //method
    //read account list from DB
    public Vector<AccountDTO> readAccountListFromDatabase() {
        Vector<AccountDTO> accountList = new Vector<>();
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                CallableStatement call = con.prepareCall("{call GET_ACCOUNT_LIST}");
                ResultSet rs = call.executeQuery();
                while(rs.next()) {
                    accountList.add(new AccountDTO(rs.getString("A_USERNAME"), rs.getString("A_PASSWORD"), rs.getString("STAFF_ID")));
                }
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at readAccountListFromDatabase method of AccountDAO class!");
                System.err.println(e);
            } finally {
                con.setAutoCommit(true);
            }
            
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at readAccountListFromDatabase method of AccountDAO class!");
            System.err.println(e);
        }
        return accountList;
    }
    
    //insert a new account
    public boolean insert(AccountDTO account) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                PreparedStatement stmt = con.prepareStatement("INSERT INTO ACCOUNT VALUES (?, ?, ?)");
                stmt.setString(1, account.getUsername());
                stmt.setString(2, account.getPassword());
                stmt.setString(3, account.getStaffId());
                stmt.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at insert method from AccountDAO class!");
                System.err.println(e);
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insert method from AccountDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    //update a account
    public boolean update(AccountDTO account, String oldUsername) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                PreparedStatement stmt = con.prepareStatement("UPDATE ACCOUNT SET A_USERNAME = ?, A_PASSWORD = ?, STAFF_ID = ? WHERE A_USERNAME = ?");
                stmt.setString(1, account.getUsername());
                stmt.setString(2, account.getPassword());
                stmt.setString(3, account.getStaffId());
                stmt.setString(4, oldUsername);
                stmt.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at update method from AccountDAO class!");
                System.err.println(e);
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at insert method from AccountDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    //delete a account
    public boolean delete(String username) {
        try (Connection con = ApplicationHelper.DatabaseHelper.openConnection()){
            try {
                con.setAutoCommit(false);
                PreparedStatement stmt = con.prepareStatement("DELETE FROM ACCOUNT WHERE A_USERNAME = ?");
                stmt.setString(1, username);
                stmt.executeUpdate();
                con.commit();
            } catch (SQLException e) {
                con.rollback();
                System.err.println("Error at delete method from AccountDAO class!");
                System.err.println(e);
                return false;
            } finally {
                con.setAutoCommit(true);
            }
        } catch (ClassNotFoundException|SQLException e) {
            System.err.println("Error at delete method from AccountDAO class!");
            System.err.println(e);
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        AccountDAO o = new AccountDAO();
        System.out.println(o.delete("seller3"));
    }
}
