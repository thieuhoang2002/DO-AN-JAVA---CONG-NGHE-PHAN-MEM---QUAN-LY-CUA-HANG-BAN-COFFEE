package BUS;

import DTO.BillDTO;
import DTO.BillDetail_ToppingDTO;
import DTO.Detail_BillDTO;
import DTO.SpotBillDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class SellBUS{
   //attribute
   private ClassifyBUS classifyBUS;
   private ProductBUS productBUS;
   private TableBUS tableBUS;
   private Product_SizeBUS productSizeBUS;
   private ToppingBUS toppingBUS;
   private Product_ToppingBUS productToppingBUS;
   private StaffBUS staffBUS;
   private BillBUS billBUS;
   private Detail_BillBUS detailBillBUS;
   private DetailBillToppingBUS detailBillToppingBUS;
   private SpotBillBUS spotBillBUS;
   
   //constructor
   public SellBUS() {
       this.classifyBUS = new ClassifyBUS();
       this.productBUS = new ProductBUS();
       this.tableBUS = new TableBUS();
       this.productSizeBUS = new Product_SizeBUS();
       this.toppingBUS = new ToppingBUS();
       this.productToppingBUS = new Product_ToppingBUS();
       this.staffBUS = new StaffBUS();
       this.billBUS = new BillBUS();
       this.detailBillBUS = new Detail_BillBUS();
       this.detailBillToppingBUS = new DetailBillToppingBUS();
       this.spotBillBUS = new SpotBillBUS();
   }
   
   //setter and getter
    public ClassifyBUS getClassifyBUS() {
        return classifyBUS;
    }

    public void setClassifyBUS(ClassifyBUS classifyBUS) {
        this.classifyBUS = classifyBUS;
    }

    public ProductBUS getProductBUS() {
        return productBUS;
    }

    public void setProductBUS(ProductBUS productBUS) {
        this.productBUS = productBUS;
    }

    public TableBUS getTableBUS() {
        return tableBUS;
    }

    public void setTableBUS(TableBUS tableBUS) {
        this.tableBUS = tableBUS;
    }

    public Product_SizeBUS getProductSizeBUS() {
        return productSizeBUS;
    }

    public void setProductSizeBUS(Product_SizeBUS productSizeBUS) {
        this.productSizeBUS = productSizeBUS;
    }

    public ToppingBUS getToppingBUS() {
        return toppingBUS;
    }

    public void setToppingBUS(ToppingBUS toppingBUS) {
        this.toppingBUS = toppingBUS;
    }

    public Product_ToppingBUS getProductToppingBUS() {
        return productToppingBUS;
    }

    public void setProductToppingBUS(Product_ToppingBUS productToppingBUS) {
        this.productToppingBUS = productToppingBUS;
    }

    public StaffBUS getStaffBUS() {
        return staffBUS;
    }

    public void setStaffBUS(StaffBUS staffBUS) {
        this.staffBUS = staffBUS;
    }

    public BillBUS getBillBUS() {
        return billBUS;
    }

    public void setBillBUS(BillBUS billBUS) {
        this.billBUS = billBUS;
    }

    public Detail_BillBUS getDetailBillBUS() {
        return detailBillBUS;
    }

    public void setDetailBillBUS(Detail_BillBUS detailBillBUS) {
        this.detailBillBUS = detailBillBUS;
    }

    public DetailBillToppingBUS getDetailBillToppingBUS() {
        return detailBillToppingBUS;
    }

    public void setDetailBillToppingBUS(DetailBillToppingBUS detailBillToppingBUS) {
        this.detailBillToppingBUS = detailBillToppingBUS;
    }

    public SpotBillBUS getSpotBillBUS() {
        return spotBillBUS;
    }

    public void setSpotBillBUS(SpotBillBUS spotBillBUS) {
        this.spotBillBUS = spotBillBUS;
    }
    
       //Print Bill To Excel
    public void printBill(String billId) {
        try {
            //Tao khu vuc lam viec
            XSSFWorkbook workBook = new XSSFWorkbook();
            //Tao sheet co ten = billId
            XSSFSheet sheet = workBook.createSheet(billId);
            
            //Tao doi tuong hang
            XSSFRow row = null;
            //Tao doi tuong cot
            Cell cell = null;
            
            //Merge cell in excel
            CellRangeAddress range = new CellRangeAddress(0, 0, 0, 8);
            sheet.addMergedRegion(range);
            
            //Tao mot doi tuong cell style
            CellStyle styleId = workBook.createCellStyle();
            styleId.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont font1 = workBook.createFont();
            font1.setFontHeight(15);
            font1.setBold(true);
            font1.setColor(IndexedColors.BLACK1.getIndex());
            styleId.setFont(font1);
            
//            CellRangeAddress range2 = new CellRangeAddress(0, 9, 0, 7);
            
//            RegionUtil.setBorderBottom(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderTop(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, range2, sheet);
//            RegionUtil.setBorderRight(BorderStyle.DOUBLE, range2, sheet);
            
            //Tao tieu de
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Your Order Is " + billId);
            cell.setCellStyle(styleId);
            
            //Tao ten cua hang
            range = new CellRangeAddress(1, 2, 0, 8);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(1);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("COFFEE SHOP");
            
            CellStyle styleStoreName = workBook.createCellStyle();
            XSSFFont font2 = workBook.createFont();
            font2.setBold(true);
            font2.setFontHeight(18);
            styleStoreName.setFont(font2);
            styleStoreName.setAlignment(HorizontalAlignment.CENTER);
            
            cell.setCellStyle(styleStoreName);
            
            //Tao dia chi
            range = new CellRangeAddress(3, 3, 0, 8);
            sheet.addMergedRegion(range);
            
            CellStyle styleAddress = workBook.createCellStyle();
            XSSFFont font3 = workBook.createFont();
            font3.setFontHeight(13);
            styleAddress.setAlignment(HorizontalAlignment.CENTER);
            styleAddress.setFont(font3);
            
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("CMT8");
            cell.setCellStyle(styleAddress);
            
            range = new CellRangeAddress(4, 4, 0, 8);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(4);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("770 Cach Mang Thang Tam, 5 Ward, Tan Binh District");
            cell.setCellStyle(styleAddress);
            
            range = new CellRangeAddress(5, 5, 0, 8);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(5);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Ho Chi Minh City");
            cell.setCellStyle(styleAddress);
            
            //Tao ngay
            CellStyle styleBold = workBook.createCellStyle();
            XSSFFont font4 = workBook.createFont();
            font4.setFontHeight(13);
            font4.setBold(true);
            styleBold.setAlignment(HorizontalAlignment.LEFT);
            styleBold.setFont(font4);
            
            CellStyle styleNormal = workBook.createCellStyle();
            XSSFFont font5 = workBook.createFont();
            font5.setFontHeight(13);
            styleNormal.setAlignment(HorizontalAlignment.LEFT);
            styleNormal.setFont(font5);
            
            row = sheet.createRow(6);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Date:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(6, 6, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getBillBUS().getBillFromId(billId).getDate().toString());
            cell.setCellStyle(styleNormal);
            
            row = sheet.createRow(7);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Staff:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(7, 7, 1, 4);
            sheet.addMergedRegion(range);
           
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getStaffBUS().getStaffFromId(this.getBillBUS().getBillFromId(billId).getStaffId()).getStaffName());
            cell.setCellStyle(styleNormal);
            
            row = sheet.createRow(8);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Type:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(8, 8, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getBillBUS().getBillFromId(billId).getBillType());
            cell.setCellStyle(styleNormal);
            
            row = sheet.createRow(9);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Table:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(9, 9, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            if(this.getSpotBillBUS().getSpotBillFromId(billId) != null) {
                cell.setCellValue(this.getSpotBillBUS().getSpotBillFromId(billId).getTableId());
            } else {
                cell.setCellValue("");
            }
            cell.setCellStyle(styleNormal);
            
            //Tao menu item
            range = new CellRangeAddress(10, 10, 0, 8);
            sheet.addMergedRegion(range);
            
            CellStyle menuItemTitle = workBook.createCellStyle();
            XSSFFont menuItemTitleFont = workBook.createFont();
            menuItemTitleFont.setBold(true);
            menuItemTitleFont.setFontHeight(13);
            menuItemTitle.setAlignment(HorizontalAlignment.CENTER);
            menuItemTitle.setFont(menuItemTitleFont);
            
            row = sheet.createRow(11);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Num");
            cell.setCellStyle(menuItemTitle);
            
            range = new CellRangeAddress(11, 11, 1, 4);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("ItemName");
            cell.setCellStyle(menuItemTitle);
            
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Qty");
            cell.setCellStyle(menuItemTitle);
            
            range = new CellRangeAddress(11, 11, 6, 8);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Price(VND)");
            cell.setCellStyle(menuItemTitle);
            
            CellStyle productStyle = workBook.createCellStyle();
            XSSFFont productFont = workBook.createFont();
            productFont.setFontHeight(13);
            productStyle.setFont(productFont);
            
            CellStyle toppingStyle = workBook.createCellStyle();
            XSSFFont toppingFont = workBook.createFont();
            toppingFont.setItalic(true);
            toppingStyle.setFont(toppingFont);
            
            int i = 12;
            int num = 1;
            for(Detail_BillDTO detail: this.getDetailBillBUS().getDetailBillListFromBillId(billId)) {
                row = sheet.createRow(i);
                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue((num++) + ".");
                cell.setCellStyle(productStyle);
                
                range = new CellRangeAddress(i, i, 1, 4);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(this.getProductBUS().getProductFromId(detail.getProductId()).getProductName());
                cell.setCellStyle(productStyle);
                
                cell = row.createCell(5, CellType.NUMERIC);
                cell.setCellValue(detail.getQuantity());
                cell.setCellStyle(productStyle);
                
                range = new CellRangeAddress(i, i, 6, 8);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(6, CellType.NUMERIC);
                cell.setCellValue(detail.getUnitPrice());
                cell.setCellStyle(productStyle);
                
                row = sheet.createRow(++i);
                range = new CellRangeAddress(i, i, 1, 4);
                sheet.addMergedRegion(range);
                
                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(" - Size: " + detail.getProductSize() + " - Status: " + detail.getProducStatus());
                
                for(BillDetail_ToppingDTO detailTopping: this.getDetailBillToppingBUS().getDetailToppingList(detail.getDetailBillId().trim())) {
                    row = sheet.createRow(++i);
                    
                    range = new CellRangeAddress(i, i, 1, 4);
                    sheet.addMergedRegion(range);
                    
                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue(" - " + this.getToppingBUS().getToppingFromId(detailTopping.getToppingId()).getToppingName());
                    cell.setCellStyle(toppingStyle);
                    
                    cell = row.createCell(5, CellType.NUMERIC);
                    cell.setCellValue(detailTopping.getQuantity());
                    cell.setCellStyle(toppingStyle);
                    
                    range = new CellRangeAddress(i, i, 6, 8);
                    sheet.addMergedRegion(range);
                    
                    cell = row.createCell(6, CellType.NUMERIC);
                    cell.setCellValue(detailTopping.getPrice());
                    cell.setCellStyle(toppingStyle);
                }
                i++; 
            }
            
            range = new CellRangeAddress(i, i, 0, 8);
            sheet.addMergedRegion(range);
            
            //Phan tong gia footer
            row = sheet.createRow(++i);
            
            range = new CellRangeAddress(i, i, 5, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Total:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(i, i, 7, 8);
            sheet.addMergedRegion(range);
            
            CellStyle resultTotalStyle = workBook.createCellStyle();
            XSSFFont font6 = workBook.createFont();
            font6.setFontHeight(13);
            font6.setBold(true);
            resultTotalStyle.setFont(font6);
            resultTotalStyle.setAlignment(HorizontalAlignment.RIGHT);
            
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(this.getBillBUS().getBillFromId(billId).getTotal());
            cell.setCellStyle(resultTotalStyle);
            
            //Tao dong received money
            row = sheet.createRow(++i);
            
            range = new CellRangeAddress(i, i, 5, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Received:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(i, i, 7, 8);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(this.getBillBUS().getBillFromId(billId).getReceivedMoney());
            cell.setCellStyle(resultTotalStyle);
            
            //Tao dong excess money
            row = sheet.createRow(++i);
            
            range = new CellRangeAddress(i, i, 5, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Excess Cash:");
            cell.setCellStyle(styleBold);
            
            range = new CellRangeAddress(i, i, 7, 8);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue(this.getBillBUS().getBillFromId(billId).getExcessMoney());
            cell.setCellStyle(resultTotalStyle);
            
            //Tao dong hotline
            i++;
            
            range = new CellRangeAddress(i, i, 0, 8);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(++i);
            
            range = new CellRangeAddress(i, i, 2, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Hotline: 19002209");
            cell.setCellStyle(menuItemTitle);
            
            //Tao dong cam on quy khach
            row = sheet.createRow(++i);
            
            range = new CellRangeAddress(i, i, 2, 6);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Thank You Please Come Again!");
            cell.setCellStyle(menuItemTitle);
            
            CellRangeAddress rangeBig = new CellRangeAddress(0, ++i, 0, 8);
            RegionUtil.setBorderRight(BorderStyle.THIN, rangeBig, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, rangeBig, sheet);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, rangeBig, sheet);
            RegionUtil.setBorderBottom(BorderStyle.THIN, rangeBig, sheet);
            
            range = new CellRangeAddress(i, i, 0, 8);
            sheet.addMergedRegion(range);
            
            String path = "./ExcelBill/" + billId + ".xlsx";
            //Tao mot doi tuong file tren dia
            File f = new File(path);
            //Mo file
            try (FileOutputStream fis = new FileOutputStream(f)){
                //Ghi khu vuc lam viec len file
                workBook.write(fis);
                
            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.err.println("Error at prinBill method of BillBUS class");
            }  
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Error at prinBill method of SellBUS class");
        }
    }
    
    //print sales
    public void printSales(String staffID, String dateStart, String dateFinish, int qtySpot, int qtyTakeAWay, int Both, Double sales) {
        try {
            //Tao khong gian lam viec trong excel
            XSSFWorkbook workBook = new XSSFWorkbook();
            
            //Tao mot sheet moi
            XSSFSheet sheet = workBook.createSheet();
            
            //Khoi tao row and cell la null
            XSSFRow row = null;
            Cell cell = null;
            
            CellRangeAddress range = new CellRangeAddress(0, 0, 0, 5);
            sheet.addMergedRegion(range);
            
            CellStyle row0 = workBook.createCellStyle();
            row0.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont title = workBook.createFont();
            title.setFontHeight(18);
            title.setBold(true);
            row0.setFont(title);
            
            row = sheet.createRow(0);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Sales Coffee Shop");
            cell.setCellStyle(row0);
            
            range = new CellRangeAddress(1, 1, 0, 5);
            sheet.addMergedRegion(range);
            
            range = new CellRangeAddress(2, 2, 1, 4);
            sheet.addMergedRegion(range);
            
            CellStyle address = workBook.createCellStyle();
            address.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont addressFont =  workBook.createFont();
            addressFont.setFontHeight(14);
            address.setFont(addressFont);
            
            row = sheet.createRow(2);
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("770 CMT8");
            cell.setCellStyle(address);
            
            range = new CellRangeAddress(3, 3, 0, 5);
            sheet.addMergedRegion(range);
            
            row = sheet.createRow(3);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("5 Ward, Tan Binh District, Ho Chi Minh City");
            cell.setCellStyle(address);
            
            range = new CellRangeAddress(4, 4, 1, 4);
            sheet.addMergedRegion(range);
            
            range = new CellRangeAddress(5, 5, 0, 5);
            sheet.addMergedRegion(range);
            
            CellStyle styleFromTo = workBook.createCellStyle();
            styleFromTo.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont fontFromTo = workBook.createFont();
            fontFromTo.setFontHeight(14);
            fontFromTo.setItalic(true);
            
            styleFromTo.setFont(fontFromTo);
            
            row = sheet.createRow(5);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("From: " + dateStart + " To: " + dateFinish);
            cell.setCellStyle(styleFromTo);
            
            CellStyle boldStyle = workBook.createCellStyle();
            boldStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont boldFont =  workBook.createFont();
            boldFont.setFontHeight(14);
            boldFont.setBold(true);
            boldStyle.setFont(boldFont);
            
            CellStyle normalStyle = workBook.createCellStyle();
            normalStyle.setAlignment(HorizontalAlignment.LEFT);
            
            XSSFFont normalFont =  workBook.createFont();
            normalFont.setFontHeight(14);
            normalStyle.setFont(normalFont);
            
            row = sheet.createRow(7);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Staff: ");
            cell.setCellStyle(boldStyle);
            
            range = new CellRangeAddress(7, 7, 1, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(this.getStaffBUS().getStaffFromId(staffID).getStaffName());
            cell.setCellStyle(normalStyle);
            
            range = new CellRangeAddress(9, 9, 0, 2);
            sheet.addMergedRegion(range);
            
            CellStyle boldStyle2 = workBook.createCellStyle();
            boldStyle2.setAlignment(HorizontalAlignment.CENTER);
            
            XSSFFont boldFont2 =  workBook.createFont();
            boldFont2.setFontHeight(14);
            boldFont2.setBold(true);
            boldStyle2.setFont(boldFont2);
            
            row = sheet.createRow(9);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Type");
            cell.setCellStyle(boldStyle2);
            
            range = new CellRangeAddress(9, 9, 3, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Quantity");
            cell.setCellStyle(boldStyle2);
            
            row = sheet.createRow(10);
            
            range = new CellRangeAddress(10, 10, 0, 2);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Spot Bill");
            cell.setCellStyle(normalStyle);
            
            range = new CellRangeAddress(10, 10, 3, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(qtySpot);
            cell.setCellStyle(normalStyle);
            
            row = sheet.createRow(11);
            
            range = new CellRangeAddress(11, 11, 0, 2);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Take Away Bill");
            cell.setCellStyle(normalStyle);
            
            range = new CellRangeAddress(11, 11, 3, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(qtyTakeAWay);
            cell.setCellStyle(normalStyle);
            
            row = sheet.createRow(12);
            
            range = new CellRangeAddress(12, 12, 0, 2);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Both");
            cell.setCellStyle(normalStyle);
            
            range = new CellRangeAddress(12, 12, 3, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(Both);
            cell.setCellStyle(normalStyle);
            
            row = sheet.createRow(13);
            
            range = new CellRangeAddress(13, 13, 0, 5);
            sheet.addMergedRegion(range);
            
            range = new CellRangeAddress(13, 13, 0, 4);
            
            RegionUtil.setBorderBottom(BorderStyle.DASHED, range, sheet);
            
            row = sheet.createRow(15);
            
            range = new CellRangeAddress(15, 15, 0, 5);
            sheet.addMergedRegion(range);
            
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Sales(VND): " + sales);
            cell.setCellStyle(boldStyle);
            
            range = new CellRangeAddress(0, 16, 0, 5);
            
            RegionUtil.setBorderBottom(BorderStyle.THIN, range, sheet);
            RegionUtil.setBorderTop(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderLeft(BorderStyle.DOUBLE, range, sheet);
            RegionUtil.setBorderRight(BorderStyle.THIN, range, sheet);
            
            
            
            String path = "./ExcelSales/" + "SalesFrom" + dateStart.replace("/", "") + "To" + dateFinish.replace("/", "") + ".xlsx";
            //Tao mot doi tuong file tren disk
            File file = new File(path);
            //Mo file
            try (FileOutputStream fis = new FileOutputStream(file)){
                workBook.write(fis);
            } catch (FileNotFoundException e) {
                System.err.println(e);
                System.err.println("Error at printSales method of SellBUS class");
            }
            
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("Error at printSales method of SellBUS class");
        }
    }
    
    //find bill doesn't payment of a table
    public BillDTO getBillDoesNotPaymentOfATable(String tableId) {
        for(SpotBillDTO spotBill: this.getSpotBillBUS().getSpotBillList()) {
            if(spotBill.getTableId().equalsIgnoreCase(tableId) && !this.getBillBUS().getBillFromId(spotBill.getBillId()).isBillStatus()) {
                return this.getBillBUS().getBillFromId(spotBill.getBillId());
            }
        }
        return null;
    }
}
