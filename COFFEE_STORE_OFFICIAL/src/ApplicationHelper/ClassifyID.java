package ApplicationHelper;

import BUS.ClassifyBUS;
import java.util.Vector;

/**
 *
 * @author ThieuHoang
 */
public class ClassifyID {

    public static int a = 0;

    public static String createClassifyID() {
        String id = null;
        String before = "CL";
        String num = null;
        ClassifyBUS d = new ClassifyBUS();
        Vector<String> s = new Vector<>();
        s = d.getClassifyID();
        try {
                for (int j = 1; j <= 99; j++) {
                    int k = j - 1;
                    num = String.format("%03d", j);//format j về kiểu 3 số như 001, 002
                    id = before + num;
                    if(id.compareTo(s.get(k)) != 0)
                        break;
                    else k++;   
                }
                System.out.println(id);
        } catch (Exception e) {
            System.out.println("Error!");
        }
        return id;
    }

    public static void main(String[] args) {
        ClassifyID c = new ClassifyID();
        System.out.println();
    }

}
