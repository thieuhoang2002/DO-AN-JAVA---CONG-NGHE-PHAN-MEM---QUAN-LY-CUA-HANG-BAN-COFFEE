package DAO;

import ApplicationHelper.DatabaseHelper;
import DTO.ClassifyDTO;
import java.util.Vector;
import java.sql.*;

public class ClassifyDAO {

    //constructor
    public ClassifyDAO() {
    }

    //method
    //get classify list from 'CLASSIFY' table on database
    public Vector<ClassifyDTO> readClassifyListFromDatabase() {
        Vector<ClassifyDTO> classifyList = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT * FROM CLASSIFY";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                ClassifyDTO classify = new ClassifyDTO(rs.getString("CLASSIFY_ID"), rs.getString("CLASSIFY_NAME"), rs.getBoolean("CLASSIFY_BUSINESS"));
                classifyList.add(classify);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error at readClassifyFromDatabase method from ClassifyDAO class!");
            System.err.println(e);
        }
        return classifyList;
    }

    // lay danh sach id
    public Vector<String> ClassifyID() {
        Vector<String> id = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT CLASSIFY_ID FROM CLASSIFY";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                id.add(rs.getString("CLASSIFY_ID"));
            }
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return id;
    }

    // lay danh sach status
    public Vector<String> ClassifyStatus() {
        Vector<String> status = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT CLASSIFY_BUSINESS FROM CLASSIFY";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                status.add(rs.getString("CLASSIFY_BUSINESS"));
            }
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return status;
    }

    //ham them
    public void insert(ClassifyDTO classify) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO CLASSIFY VALUES (?, ?, ?)");
            ps.setString(1, classify.getClassifyId());
            ps.setString(2, classify.getClassifyName());
            ps.setBoolean(3, classify.isClassifyBusiness());
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at insert method from ClassifyDAO class!");
            System.err.println(e);
        }

    }

    //ham sua
    public void update1(String id) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE CLASSIFY SET CLASSIFY_BUSINESS = 0 WHERE CLASSIFY_ID = ? ");
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at update method from ClassifyDAO class!");
            System.err.println(e);
        }
    }

    //update
    public void update(String id) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE CLASSIFY SET CLASSIFY_BUSINESS = 1 WHERE CLASSIFY_ID = ? ");
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at update method from ClassifyDAO class!");
            System.err.println(e);
        }
    }

    //update
    public void update2(String id, String name) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("UPDATE CLASSIFY SET CLASSIFY_NAME = ? WHERE CLASSIFY_ID = ? ");
            ps.setString(1, name);
            ps.setString(2, id);
            ps.executeUpdate();
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.err.println("Error at update method from ClassifyDAO class!");
            System.err.println(e);
        }
    }

    //ham xoa
    public void delete(String id) {
        try (Connection con = DatabaseHelper.openConnection()) {
            PreparedStatement ps = con.prepareStatement("DELETE FROM CLASSIFY WHERE CLASSIFY_ID = ?");
            ps.setString(1, id);
            ps.executeUpdate();
            System.out.println("Delete Sucess!");
        } catch (Exception ex) {
            System.out.println("Delete false!");
        }
    }

    //ham dem so luong the loai san pham dang kinh doanh
    public int count() {
        int i = 0;
        Vector<String> s = ClassifyStatus();
        for (int j = 0; j <= s.size() - 1; j++) {
            if ("1".equals(s.get(j))) {
                i++;
            }
        }
        return i;
    }

    //ham lay ra danh sach ten the loai san pham
    public Vector<String> ClassifyName() {
        Vector<String> name = new Vector<>();
        try (Connection con = DatabaseHelper.openConnection()) {
            String sql = "SELECT CLASSIFY_NAME FROM CLASSIFY";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                name.add(rs.getString("CLASSIFY_NAME"));
            }
            System.out.println("Success!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error");
        }
        return name;
    }
    //
    public static void main(String[] args) {
        ClassifyDAO a = new ClassifyDAO();
        System.out.println(a.ClassifyStatus());
        System.out.println(a.count());
    }

}
