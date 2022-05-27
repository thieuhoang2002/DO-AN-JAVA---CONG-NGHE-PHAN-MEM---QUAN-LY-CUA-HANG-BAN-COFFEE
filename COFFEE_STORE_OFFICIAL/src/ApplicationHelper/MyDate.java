package ApplicationHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class MyDate {
    //attribute
    private String day;
    private String month;
    private String year;

    public static int[][] arrDaysOfMonth = new int[][]{{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                                                       {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}};
    //constructor
    public MyDate() {
    }
    
    public MyDate(String date) {
        String[] temp = date.split("-");
        this.day = temp[2];
        this.month = temp[1];
        this.year = temp[0];
    }
    public MyDate(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public static int[][] getArrDaysOfMonth() {
        return arrDaysOfMonth;
    }

    public static void setArrDaysOfMonth(int[][] arrDaysOfMonth) {
        MyDate.arrDaysOfMonth = arrDaysOfMonth;
    }
    
    public void getDateNow() {
        LocalDate date = LocalDate.now(); //2021-12-11 LD
        String dateString = String.valueOf(date);  //2021-12-11 String
        String[] dateArray = dateString.split("-");
        this.day = dateArray[2];
        this.month = dateArray[1];
        this.year = dateArray[0];
    }
    
    
    @Override
    public String toString() {
        return this.day+"/"+this.month+"/"+this.year;
    }
    
    public String formatDB() {
        return this.year + "/" + this.month + "/" + this.day;
    }
    
    public static String format(String date) {
        String[] text = date.split("/");
        return text[2] + "-" + text[1] + "-" + text[0];
    }
    
    public static int checkLeapYear(int year) {
        if(year%400 == 0 || ((year%4 == 0) && (year%100) != 0)) {
            return 1;
        }
        return 0;
    }
    
}
