package DTO;


public class AccountDTO {
    //attribute
    private String username;
    private String password;
    private String staffId;
    
    //constructor
    public AccountDTO(String username, String password, String staffId) {
        this.username = username;
        this.password = password;
        this.staffId = staffId;
    }
    
    //setter and getter
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
    
}
