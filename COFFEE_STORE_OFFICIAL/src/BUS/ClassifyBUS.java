package BUS;

import DAO.ClassifyDAO;
import DTO.ClassifyDTO;
import Interface.ICoffeeShop;
import java.util.Vector;

public class ClassifyBUS implements ICoffeeShop {

    //attribute
    private Vector<ClassifyDTO> classifyList;
    private ClassifyDAO classifyDAO;

    //constructor
    public ClassifyBUS() {
        this.classifyDAO = new ClassifyDAO();
        this.classifyList = classifyDAO.readClassifyListFromDatabase();
    }

    //setter and getter
    public Vector<ClassifyDTO> getClassifyList() {
        return classifyList;
    }

    public void setClassifyList(Vector<ClassifyDTO> classifyList) {
        this.classifyList = classifyList;
    }

    public ClassifyDAO getClassifyDAO() {
        return classifyDAO;
    }

    public void setClassifyDAO(ClassifyDAO classifyDAO) {
        this.classifyDAO = classifyDAO;
    }

    //method
    //process get classify list from ClassifyDAO class
    @Override
    public void resetList() {
        this.setClassifyList(this.getClassifyDAO().readClassifyListFromDatabase());
    }

    public ClassifyDTO getClassifyFromId(String id) {
        ClassifyDTO classify = null;
        for (ClassifyDTO o : this.getClassifyList()) {
            if (o.getClassifyId().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return classify;
    }

    //get classify name from id
    public String getClassifyName(String classifyId) {
        this.resetList();
        for (ClassifyDTO o : this.getClassifyList()) {
            if (o.getClassifyId().equalsIgnoreCase(classifyId)) {
                return o.getClassifyName();
            }
        }
        return null;
    }

    public String getClassifyId(String classifyName) {
        this.resetList();
        for (ClassifyDTO o : this.getClassifyList()) {
            if (o.getClassifyName().equalsIgnoreCase(classifyName)) {
                return o.getClassifyId();
            }
        }
        return null;
    }

    //ham cua Hoang
    public Vector<String> getClassifyID() {
        return classifyDAO.ClassifyID();
    }
    //doc du lieu tu database

    public Vector<ClassifyDTO> readClassifyListFromDatabase() {
        return classifyDAO.readClassifyListFromDatabase();
    }

    //ham luu du lieu vao database
    public void insert(ClassifyDTO classify) {
        classifyDAO.insert(classify);
    }
    //ham xoa loai san pham theo id

    public void delete(String id) {
        classifyDAO.delete(id);
    }

    //ham lay danh sach nhan vien (Tim kiem theo Keyword)
    public Vector<ClassifyDTO> getClassifyList(String keyWord) {
        this.setClassifyList(classifyList);
        Vector<ClassifyDTO> list = new Vector<>();
        ClassifyBUS classifyBUS = new ClassifyBUS();
        for (ClassifyDTO o : classifyBUS.getClassifyList()) {
            if (o.getClassifyName().contains(keyWord) || o.getClassifyName().toLowerCase().contains(keyWord)
                    || o.getClassifyName().toUpperCase().contains(keyWord) || o.getClassifyId().toLowerCase().contains(keyWord) || o.getClassifyId().contains(keyWord)
                    || o.getClassifyId().toUpperCase().contains(keyWord) || o.getStatus().contains(keyWord) || o.getStatus().toLowerCase().contains(keyWord)
                    || o.getStatus().toUpperCase().contains(keyWord)) {
                list.add(o);
            }
        }
        return list;
    }

    //ham lay so luong the loai dang kinh doanh
    public int count() {
        return classifyDAO.count();
    }

    //ham sua
    public void update(String id) {
        classifyDAO.update(id);
    }

    //ham sua
    public void update1(String id) {
        classifyDAO.update1(id);
    }
    //ham sua
    public void update2(String id, String name) {
        classifyDAO.update2(id, name);
    }

    //ham lay danh sach ten the loai 
    public Vector<String> ClassifyName() {
        return classifyDAO.ClassifyName();
    }
}
