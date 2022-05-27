package ApplicationHelper;

import java.sql.*;

public class DatabaseHelper {
    //resource
    private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String url = "jdbc:sqlserver://localhost:1433;database=MANAGE_COFFEE_STORE;integratedSecurity=false;trustServerCertificate=true";
    //encrypt = true;
    private static final String username = "sa";
    private static final String password = "09032002";
  
    //method
    public static Connection openConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
