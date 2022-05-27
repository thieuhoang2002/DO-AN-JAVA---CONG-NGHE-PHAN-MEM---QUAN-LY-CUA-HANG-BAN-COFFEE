package BUS;

import DTO.BillDTO;
import DTO.BillDetail_ToppingDTO;
import DTO.Detail_BillDTO;
import DTO.StatisticProductDTO;
import DTO.StatisticToppingDTO;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JTable;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StatisticBUS {
    //attribute
    private SellBUS sellBUS;
    
    //constructor
    public StatisticBUS() {
        this.sellBUS = new SellBUS();
    }
    
    //setter and getter
    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }
    
    //method
    //Tao danh sach StatisticProductDTO tu dateStart and dateEnd
    public Vector<StatisticProductDTO> getSatisticProductDTO(String dateStart, String dateEnd) {
        Vector<StatisticProductDTO> getStatisticProductDTOList = new Vector<>();
        int count = 0;
        for(Detail_BillDTO detail: this.getDetailBillListFromDate(dateStart, dateEnd)) {
            for(StatisticProductDTO statistic: getStatisticProductDTOList) {
                count = 0;
                if(detail.getProductId().equalsIgnoreCase(statistic.getProductId())) {
                    if(detail.getProductSize().equalsIgnoreCase("S")) {
                        statistic.getSalesOfSize()[0][0] = String.valueOf(Integer.parseInt(statistic.getSalesOfSize()[0][0]) + detail.getQuantity());
                        statistic.getSalesOfSize()[1][0] = String.valueOf(Double.parseDouble(statistic.getSalesOfSize()[1][0]) + (this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "S") * detail.getQuantity()));
                    } else if (detail.getProductSize().equalsIgnoreCase("M")) {
                        statistic.getSalesOfSize()[0][1] = String.valueOf(Integer.parseInt(statistic.getSalesOfSize()[0][1]) + detail.getQuantity());
                        statistic.getSalesOfSize()[1][1] = String.valueOf(Double.parseDouble(statistic.getSalesOfSize()[1][1]) + (this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "M") * detail.getQuantity()));
                    } else {
                        statistic.getSalesOfSize()[0][2] = String.valueOf(Integer.parseInt(statistic.getSalesOfSize()[0][2]) + detail.getQuantity());
                        statistic.getSalesOfSize()[1][2] = String.valueOf(Double.parseDouble(statistic.getSalesOfSize()[1][2]) + (this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "L") * detail.getQuantity()));
                    }
                    count++;
                    break;
                }
            }
            if(count == 0) {
                StatisticProductDTO statistic = new StatisticProductDTO();
                statistic.setProductId(detail.getProductId());
                String[][] temp = new String[][] {{"0", "0", "0", "0"}, {"0", "0", "0", "0"}};
                if(detail.getProductSize().equalsIgnoreCase("S")) {
                    temp[0][0] = String.valueOf(detail.getQuantity());
                    temp[1][0] = String.valueOf(this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "S") * detail.getQuantity());
                } else if(detail.getProductSize().equalsIgnoreCase("M")) {
                    temp[0][1] = String.valueOf(detail.getQuantity());
                    temp[1][1] = String.valueOf(this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "M") * detail.getQuantity());
                } else {
                    temp[0][2] = String.valueOf(detail.getQuantity());
                    temp[1][2] = String.valueOf(this.getSellBUS().getProductSizeBUS().getPrice(detail.getProductId(), "L") * detail.getQuantity());
                }
                statistic.setSalesOfSize(temp);
                getStatisticProductDTOList.add(statistic);
            }
        }
        this.setAndSortList(getStatisticProductDTOList);
        return getStatisticProductDTOList;
    }
    
    //Set and sort list
    private void setAndSortList(Vector<StatisticProductDTO> statisticList) {
        for(StatisticProductDTO statistic: statisticList) {
            //Nhung size nao khong ton tai thi danh dau X
            if(this.getSellBUS().getProductSizeBUS().checkSize(statistic.getProductId(), "S") == false) {
                statistic.getSalesOfSize()[0][0] = "X";
                statistic.getSalesOfSize()[1][0] = "X";
            }
            if (this.getSellBUS().getProductSizeBUS().checkSize(statistic.getProductId(), "M") == false) {
                statistic.getSalesOfSize()[0][1] = "X";
                statistic.getSalesOfSize()[1][1] = "X";
            }
            if(this.getSellBUS().getProductSizeBUS().checkSize(statistic.getProductId(), "L") == false) {
                statistic.getSalesOfSize()[0][2] = "X";
                statistic.getSalesOfSize()[1][2] = "X";
            }
            
            for(int i = 0; i < 3; i++) {
                if(!statistic.getSalesOfSize()[0][i].equalsIgnoreCase("X")) {
                    statistic.getSalesOfSize()[0][3] = String.valueOf(Integer.parseInt(statistic.getSalesOfSize()[0][3]) + Integer.parseInt(statistic.getSalesOfSize()[0][i]));
                    statistic.getSalesOfSize()[1][3] = String.valueOf(Double.parseDouble(statistic.getSalesOfSize()[1][3]) + Double.parseDouble(statistic.getSalesOfSize()[1][i]));
                }
            }
        }
        Collections.sort(statisticList);
    }
    
    //Tao danh sach detailBill from dateStart and dateEnd
    private Vector<Detail_BillDTO> getDetailBillListFromDate(String dateStart, String dateEnd) {
        this.getSellBUS().getDetailBillBUS().resetList();
        Vector<Detail_BillDTO> detailList = new Vector<>();
        try {
            for(BillDTO bill: this.getSellBUS().getBillBUS().getBillList(dateStart, dateEnd)) {
                for(Detail_BillDTO detail: this.getSellBUS().getDetailBillBUS().getDetailBillListFromBillId(bill.getBillId())) {
                    detailList.add(detail);
                }
            }
        } catch (ParseException e) {
            System.err.println("Error at getDetailBillListFromDate method of StatisticBUS class!");
            System.err.println(e);
        }
        return detailList;
    }
    
    //Tao danh sach detail_topping from dateStart and dateEnd
    private Vector<BillDetail_ToppingDTO> getDetailToppingFromDate(String dateStart, String dateEnd) {
        this.getSellBUS().getDetailBillToppingBUS().resetList();
        Vector<BillDetail_ToppingDTO> detailToppingList = new Vector<>();
        for(Detail_BillDTO detail: this.getDetailBillListFromDate(dateStart, dateEnd)) {
            for(BillDetail_ToppingDTO detailTopping: this.getSellBUS().getDetailBillToppingBUS().getDetailToppingList(detail.getDetailBillId().trim())) {
                detailToppingList.add(detailTopping);
            }
        }
        return detailToppingList;
    }
    
    //Tao danh sach thong ke topping from dateStart and dateEnd
    public Vector<StatisticToppingDTO> getStatisticToppingList(String dateStart, String dateEnd) {
        Vector<StatisticToppingDTO> statisticToppingList = new Vector<>();
        int count = 0;
        for(BillDetail_ToppingDTO detailTopping: this.getDetailToppingFromDate(dateStart, dateEnd)) {
            for(StatisticToppingDTO statisticTopping: statisticToppingList) {
                count = 0;
                if(detailTopping.getToppingId().equalsIgnoreCase(statisticTopping.getToppingId())) {
                    statisticTopping.setQuantity(statisticTopping.getQuantity() + detailTopping.getQuantity());
                    statisticTopping.setSales(statisticTopping.getSales() + detailTopping.getPrice());
                    count++;
                    break;
                }
            }
            if(count == 0) {
                    StatisticToppingDTO statistic = new StatisticToppingDTO();
                    statistic.setToppingId(detailTopping.getToppingId());
                    statistic.setQuantity(detailTopping.getQuantity());
                    statistic.setSales(detailTopping.getPrice());
                    statisticToppingList.add(statistic);
            }
        }
        Collections.sort(statisticToppingList);
        return statisticToppingList;
    }
    
    //get statistic topping list from key word and date
    public Vector<StatisticToppingDTO> getStatisticToppingList(String keyWord, String dateStart, String dateEnd) {
        Vector<StatisticToppingDTO> statisticToppingList = new Vector<>();
        for(StatisticToppingDTO statisticTopping: this.getStatisticToppingList(dateStart, dateEnd)) {
            if(statisticTopping.getToppingId().contains(keyWord) || statisticTopping.getToppingId().toLowerCase().contains(keyWord)
                || statisticTopping.getToppingId().toUpperCase().contains(keyWord)
                || this.getSellBUS().getToppingBUS().getToppingFromId(statisticTopping.getToppingId()).getToppingName().toLowerCase().contains(keyWord)
                || this.getSellBUS().getToppingBUS().getToppingFromId(statisticTopping.getToppingId()).getToppingName().toUpperCase().contains(keyWord)
                || this.getSellBUS().getToppingBUS().getToppingFromId(statisticTopping.getToppingId()).getToppingName().contains(keyWord) ) {
                statisticToppingList.add(statisticTopping);
            }
        }
        return statisticToppingList;
    }
    //get statistic product list from key word and date
    public Vector<StatisticProductDTO> getStatisticProductList(String keyWord, String dateStart, String dateEnd) {
        Vector<StatisticProductDTO> statisticProductList = new Vector<>();
        for(StatisticProductDTO statisticProduct: this.getSatisticProductDTO(dateStart, dateEnd)) {
            if(statisticProduct.getProductId().contains(keyWord) || statisticProduct.getProductId().toUpperCase().contains(keyWord)
                || statisticProduct.getProductId().toLowerCase().contains(keyWord) || this.getSellBUS().getProductBUS().getProductFromId(statisticProduct.getProductId()).getProductName().contains(keyWord)
                || this.getSellBUS().getProductBUS().getProductFromId(statisticProduct.getProductId()).getProductName().toLowerCase().contains(keyWord)
                || this.getSellBUS().getProductBUS().getProductFromId(statisticProduct.getProductId()).getProductName().toUpperCase().contains(keyWord)) {
                statisticProductList.add(statisticProduct);
            }
        }
        return statisticProductList;
    }
    
    //print statistic topping
    public void printToppingStatistic(JTable toppingTable, String dateStart, String dateFinish, String staffID) {
        try {
            //Tao khong gian lam viec trong excel
            XSSFWorkbook workBook = new XSSFWorkbook();
            
            //Tao sheet
            XSSFSheet sheet = workBook.createSheet();
            
            //set row and cell
            XSSFRow row = null;
            Cell cell = null;
            
            row = sheet.createRow(0);
            
            CellRangeAddress range = new CellRangeAddress(0, 0, 0, 8);
            sheet.addMergedRegion(range);
            
            CellStyle titleStyle = workBook.createCellStyle();
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font18Bold = workBook.createFont();
            font18Bold.setFontHeight(18);
            font18Bold.setBold(true);
            titleStyle.setFont(font18Bold);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Statistic Topping Coffee Shop");
            cell.setCellStyle(titleStyle);
            
            row = sheet.createRow(2);
            
            range = new CellRangeAddress(2, 2, 1, 7);
            sheet.addMergedRegion(range);
            
            CellStyle addressStyle = workBook.createCellStyle();
            addressStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Normal = workBook.createFont();
            font14Normal.setFontHeight(14);
            addressStyle.setFont(font14Normal);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("770 CMT8");
            cell.setCellStyle(addressStyle);
            
            row = sheet.createRow(3);
            
            range = new CellRangeAddress(3, 3, 0, 8);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("5 Ward, Tan Binh District, Ho Chi Minh City");
            cell.setCellStyle(addressStyle);
            
            row = sheet.createRow(5);
            
            range = new CellRangeAddress(5, 5, 0, 8);
            sheet.addMergedRegion(range);
            
            CellStyle fromToStyle = workBook.createCellStyle();
            fromToStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Italic = workBook.createFont();
            font14Italic.setFontHeight(14);
            font14Italic.setItalic(true);
            fromToStyle.setFont(font14Italic);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("From: " + dateStart + " To: " + dateFinish);
            cell.setCellStyle(fromToStyle);
            
            row = sheet.createRow(7);
            
            CellStyle staffStyle = workBook.createCellStyle();
            staffStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont font14Bold = workBook.createFont();
            font14Bold.setFontHeight(14);
            font14Bold.setBold(true);
            staffStyle.setFont(font14Bold);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Staff:");
            cell.setCellStyle(staffStyle);
            
            range = new CellRangeAddress(7, 7, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getSellBUS().getStaffBUS().getStaffFromId(staffID).getStaffName());
            cell.setCellStyle(addressStyle);
            
            row = sheet.createRow(9);
            
            range = new CellRangeAddress(9, 9, 0, 2);
            sheet.addMergedRegion(range);
            
            CellStyle menuStyle = workBook.createCellStyle();
            menuStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Menu = workBook.createFont();
            font14Menu.setFontHeight(14);
            font14Menu.setBold(true);
            menuStyle.setFont(font14Menu);
            
            CellStyle menuItemStyle = workBook.createCellStyle();
            menuItemStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont font14Item = workBook.createFont();
            font14Item.setFontHeight(14);
            menuItemStyle.setFont(font14Item);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Topping Name");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 3, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Price/Topping");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 5, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Quantity");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 7, 8);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Sales(VND)");
            cell.setCellStyle(menuStyle);
            
            int count = 10;
            for (int i = 0; i < toppingTable.getRowCount(); i++) {
                
                range = new CellRangeAddress(count, count, 0, 2);
                sheet.addMergedRegion(range);
                
                row = sheet.createRow(count);
                
                cell = row.createCell(0);
                cell.setCellValue((String) toppingTable.getValueAt(i, 1));
                cell.setCellStyle(menuItemStyle);
                
                range = new CellRangeAddress(count, count, 3, 4);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(3);
                cell.setCellValue((Double) toppingTable.getValueAt(i, 2));
                cell.setCellStyle(addressStyle);
                
                range = new CellRangeAddress(count, count, 5, 6);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(5);
                cell.setCellValue((Integer) toppingTable.getValueAt(i, 3));
                cell.setCellStyle(addressStyle);
                
                range = new CellRangeAddress(count, count, 7, 8);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(7);
                cell.setCellValue((Double) toppingTable.getValueAt(i, 4));
                cell.setCellStyle(addressStyle);  
                count++;
            }
            
            range = new CellRangeAddress(0, count, 0, 8);
            
            RegionUtil.setBorderBottom(BorderStyle.THIN, range, sheet);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, range, sheet);
            
            //Tao file, mo file va luu thay doi vao file
            String path = "./ExcelToppingStatistic/" + "StatisticToppingFrom" + dateStart.replace("/", "") + "To" + dateFinish.replace("/", "") + ".xlsx";
            File file = new File(path);
            try (FileOutputStream fis = new FileOutputStream(file)){
                workBook.write(fis);
            } catch (IOException e) {
                System.err.println("Error open file at print topping statistic method in StatisticBUS class");
                System.err.println(e);
            }
            
        } catch (Exception e) {
            System.err.println("Error at print topping statistic method in StatisticBUS class");
            System.err.println(e);
        }
    }
    
    //print products statistic from dateStart and dateEnd
    public void printProductStatistic(JTable productTable, String dateStart, String dateFinish, String staffID) {
        try {
            //Tao khong gian lam viec trong excel
            XSSFWorkbook workBook = new XSSFWorkbook();
            
            //Tao sheet
            XSSFSheet sheet = workBook.createSheet();
            
            //set row and cell
            XSSFRow row = null;
            Cell cell = null;
            
            //title
            row = sheet.createRow(0);
            
            CellRangeAddress range = new CellRangeAddress(0, 0, 0, 18);
            sheet.addMergedRegion(range);
            
            CellStyle titleStyle = workBook.createCellStyle();
            titleStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font18Bold = workBook.createFont();
            font18Bold.setFontHeight(18);
            font18Bold.setBold(true);
            titleStyle.setFont(font18Bold);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Statistic Product Coffee Shop");
            cell.setCellStyle(titleStyle);
            
            range = new CellRangeAddress(1, 1, 0, 18);
            sheet.addMergedRegion(range);
            
            //address
            row = sheet.createRow(2);
            
            range = new CellRangeAddress(2, 2, 1, 17);
            sheet.addMergedRegion(range);
            
            CellStyle addressStyle = workBook.createCellStyle();
            addressStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Normal = workBook.createFont();
            font14Normal.setFontHeight(14);
            addressStyle.setFont(font14Normal);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("770 CMT8");
            cell.setCellStyle(addressStyle);
            
            row = sheet.createRow(3);
            
            range = new CellRangeAddress(3, 3, 0, 18);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("5 Ward, Tan Binh District, Ho Chi Minh City");
            cell.setCellStyle(addressStyle);
            
            //From...To...
            row = sheet.createRow(5);
            
            range = new CellRangeAddress(5, 5, 0, 18);
            sheet.addMergedRegion(range);
            
            CellStyle fromToStyle = workBook.createCellStyle();
            fromToStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Italic = workBook.createFont();
            font14Italic.setFontHeight(14);
            font14Italic.setItalic(true);
            fromToStyle.setFont(font14Italic);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("From: " + dateStart + " To: " + dateFinish);
            cell.setCellStyle(fromToStyle);
            
            //Staff
            row = sheet.createRow(7);
            
            CellStyle staffStyle = workBook.createCellStyle();
            staffStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont font14Bold = workBook.createFont();
            font14Bold.setFontHeight(14);
            font14Bold.setBold(true);
            staffStyle.setFont(font14Bold);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Staff:");
            cell.setCellStyle(staffStyle);
            
            range = new CellRangeAddress(7, 7, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getSellBUS().getStaffBUS().getStaffFromId(staffID).getStaffName());
            cell.setCellStyle(addressStyle);
            
            //Menu title
            row = sheet.createRow(9);
            
            range = new CellRangeAddress(9, 9, 0, 2);
            sheet.addMergedRegion(range);
            
            CellStyle menuStyle = workBook.createCellStyle();
            menuStyle.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Menu = workBook.createFont();
            font14Menu.setFontHeight(13);
            font14Menu.setBold(true);
            menuStyle.setFont(font14Menu);
            
            CellStyle menuItemStyle = workBook.createCellStyle();
            menuItemStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont font14Item = workBook.createFont();
            font14Item.setFontHeight(13);
            menuItemStyle.setFont(font14Item);
            
            CellStyle menuItemStyle2 = workBook.createCellStyle();
            menuItemStyle2.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font14Item2 = workBook.createFont();
            font14Item2.setFontHeight(13);
            menuItemStyle2.setFont(font14Item2);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Product Name");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Price/S");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("QtyS");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 5, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("SalesS(VND)");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Price/M");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("QtyM");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 9, 10);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("SalesM(VND)");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue("Price/L");
            cell.setCellStyle(menuStyle);
            
            cell = row.createCell(12, CellType.STRING);
            cell.setCellValue("QtyL");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 13, 14);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(13, CellType.STRING);
            cell.setCellValue("SalesL(VND)");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 15, 16);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(15, CellType.STRING);
            cell.setCellValue("CountSum");
            cell.setCellStyle(menuStyle);
            
            range = new CellRangeAddress(9, 9, 17, 18);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(17, CellType.STRING);
            cell.setCellValue("SalesSum");
            cell.setCellStyle(menuStyle);
            
            int count = 10;
            for(int i = 0; i < productTable.getRowCount(); i++) {
                row = sheet.createRow(count);
                range = new CellRangeAddress(count, count, 0, 2);
                
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue((String) productTable.getValueAt(i, 0));
                cell.setCellStyle(menuItemStyle);

                //S
                
                cell = row.createCell(3);
                if(!productTable.getValueAt(i, 1).equals("X")) {
                    cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 1)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 1));
                }
                cell.setCellStyle(menuItemStyle2);

                cell = row.createCell(4, CellType.STRING);
                if(!productTable.getValueAt(i, 2).equals("X")) {
                    cell.setCellValue((Integer) Integer.parseInt((String) productTable.getValueAt(i, 2)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 2));
                }
                cell.setCellStyle(menuItemStyle2);

                range = new CellRangeAddress(count, count, 5, 6);
                sheet.addMergedRegion(range);

                cell = row.createCell(5, CellType.STRING);
                if(!productTable.getValueAt(i, 3).equals("X")) {
                    cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 3)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 3));
                }
                cell.setCellStyle(menuItemStyle2);
                
                //M
                
                cell = row.createCell(7);
                if(!productTable.getValueAt(i, 4).equals("X")) {
                    cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 4)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 4));
                }
                cell.setCellStyle(menuItemStyle2);

                cell = row.createCell(8, CellType.STRING);
                if(!productTable.getValueAt(i, 5).equals("X")) {
                    cell.setCellValue((Integer) Integer.parseInt((String) productTable.getValueAt(i, 5)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 5));
                }
                cell.setCellStyle(menuItemStyle2);

                range = new CellRangeAddress(count, count, 9, 10);
                sheet.addMergedRegion(range);

                cell = row.createCell(9, CellType.STRING);
                if(!productTable.getValueAt(i, 6).equals("X")) {
                    cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 6)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 6));
                }
                cell.setCellStyle(menuItemStyle2);
                
                //L
                
                cell = row.createCell(11);
                if(!productTable.getValueAt(i, 7).equals("X")) {
                    cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 7)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 7));
                }
                cell.setCellStyle(menuItemStyle2);

                cell = row.createCell(12, CellType.STRING);
                if(!productTable.getValueAt(i, 8).equals("X")) {
                    cell.setCellValue((Integer) Integer.parseInt((String) productTable.getValueAt(i, 8)));
                } else {
                    cell.setCellValue((String) productTable.getValueAt(i, 8));
                }
                cell.setCellStyle(menuItemStyle2);

                range = new CellRangeAddress(count, count, 13, 14);
                sheet.addMergedRegion(range);

                cell = row.createCell(13, CellType.STRING);
                if(!productTable.getValueAt(i, 9).equals("X")) {
                   cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 9))); 
                } else {
                   cell.setCellValue((String) productTable.getValueAt(i, 9));
                }
                cell.setCellStyle(menuItemStyle2);
                
                //Sum
                range = new CellRangeAddress(count, count, 15, 16);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(15, CellType.STRING);
                cell.setCellValue((Integer) Integer.parseInt((String) productTable.getValueAt(i, 10)));
                cell.setCellStyle(menuStyle);
                
                range = new CellRangeAddress(count, count, 17, 18);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(17, CellType.STRING);
                cell.setCellValue((Double) Double.parseDouble((String) productTable.getValueAt(i, 11)));
                cell.setCellStyle(menuItemStyle2);
            
                count++;
            }
            
            range = new CellRangeAddress(0, count, 0, 18);
            
            RegionUtil.setBorderBottom(BorderStyle.THIN, range, sheet);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, range, sheet); 
            
            //Tao file, mo file va luu thay doi vao file
            String path = "./ExcelProductStatistic/" + "StatisticProductFrom" + dateStart.replace("/", "") + "To" + dateFinish.replace("/", "") + ".xlsx";
            File file = new File(path);
            try (FileOutputStream fis = new FileOutputStream(file)){
                workBook.write(fis);
            } catch (IOException e) {
                System.err.println("Error open file at print product statistic method in StatisticBUS class");
                System.err.println(e);
            }
            
        } catch (Exception e) {
            System.err.println("Error at print product statistic method in StatisticBUS class");
            System.err.println(e);
        }
    }
}
