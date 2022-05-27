package ApplicationHelper;

import BUS.StaffBUS;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class StaffID {

    public static int a = 0;

    public static String createStaffID() {
        String id = null;
        String before = "SF";
        String num = null;
        StaffBUS d = new StaffBUS();
        Vector<String> s = new Vector<>();
        s = d.getStaffID();
        try {
                for (int j = 1; j <= 99; j++) {
                    int k = j - 1;
                    num = String.format("%03d", j);
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
        StaffID s = new StaffID();
        System.out.println(s.createStaffID());
    }

}
