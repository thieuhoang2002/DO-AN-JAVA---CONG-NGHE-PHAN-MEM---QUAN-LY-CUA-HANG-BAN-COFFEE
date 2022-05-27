package DTO;

public class ClassifyDTO {
    //attribute
    private String classifyId;
    private String classifyName;
    private boolean classifyBusiness;
    private String status;

    public String getStatus() {
        return String.valueOf(classifyBusiness);
    }
    
    //constructor
    public ClassifyDTO(String classifyId, String classifyName, boolean classifyBusiness) {
        this.classifyId = classifyId;
        this.classifyName = classifyName;
        this.classifyBusiness = classifyBusiness;
    }    
    
    //setter and getter
    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public boolean isClassifyBusiness() {
        return classifyBusiness;
    }

    public void setClassifyBusiness(boolean classifyBusiness) {
        this.classifyBusiness = classifyBusiness;
    }
}
