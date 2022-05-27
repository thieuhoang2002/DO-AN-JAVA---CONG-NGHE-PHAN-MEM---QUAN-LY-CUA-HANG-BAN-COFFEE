package GUI;

import BUS.BillBUS;
import BUS.SellBUS;
import DTO.BillDTO;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class BillGUI extends JFrame{
    //attribute
    private JPanel pHeader, pBody, pFooter, pFooterTop, pFooterBottom;
    private JButton bHome, bSearch, bDelete, bPrint, bReset;
    private JTextField tfSearch;
    private JTable billTable;
    private DefaultTableModel model;
    private JLabel lBill;
    private JScrollPane sBillTable;
    private BillBUS billBUS;
    private SellBUS sellBUS;
    private String staffID;
    
    Color BACKGROUND_COLOR = new Color(202, 135, 96);
    Color HOVER_COLOR = new Color(149, 231, 231);
    
    //constructor
    public BillGUI(String staffId) {
        this.setStaffID(staffId);
        this.setSellBUS(new SellBUS());
        this.setBillBUS(new BillBUS());
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JPanel getpHeader() {
        return pHeader;
    }

    public void setpHeader(JPanel pHeader) {
        this.pHeader = pHeader;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public String getStaffID() {
        return staffID;
    }

    public final void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public final void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }

    public BillBUS getBillBUS() {
        return billBUS;
    }

    public final void setBillBUS(BillBUS billBUS) {
        this.billBUS = billBUS;
    }

    public JPanel getpBody() {
        return pBody;
    }

    public void setpBody(JPanel pBody) {
        this.pBody = pBody;
    }

    public JPanel getpFooter() {
        return pFooter;
    }

    public void setpFooter(JPanel pFooter) {
        this.pFooter = pFooter;
    }

    public JPanel getpFooterTop() {
        return pFooterTop;
    }

    public void setpFooterTop(JPanel pFooterTop) {
        this.pFooterTop = pFooterTop;
    }

    public JPanel getpFooterBottom() {
        return pFooterBottom;
    }

    public void setpFooterBottom(JPanel pFooterBottom) {
        this.pFooterBottom = pFooterBottom;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JButton getbSearch() {
        return bSearch;
    }

    public void setbSearch(JButton bSearch) {
        this.bSearch = bSearch;
    }

    public JButton getbDelete() {
        return bDelete;
    }

    public void setbDelete(JButton bDelete) {
        this.bDelete = bDelete;
    }

    public JButton getbPrint() {
        return bPrint;
    }

    public void setbPrint(JButton bPrint) {
        this.bPrint = bPrint;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }

    public JTable getBillTable() {
        return billTable;
    }

    public void setBillTable(JTable billTable) {
        this.billTable = billTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JLabel getlBill() {
        return lBill;
    }

    public void setlBill(JLabel lBill) {
        this.lBill = lBill;
    }

    public JScrollPane getsBillTable() {
        return sBillTable;
    }

    public void setsBillTable(JScrollPane sBillTable) {
        this.sBillTable = sBillTable;
    }

    public JButton getbReset() {
        return bReset;
    }

    public void setbReset(JButton bReset) {
        this.bReset = bReset;
    }
    
    //method
    public final  void init() {
        //set Frame
        super.setTitle("Bill Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
        this.setSize(new Dimension(900, 700));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(getStaffID());
                dispose();
            }
        });
        
        //pHeader
        this.setHeader();
        
        //pBody
        this.setBody();
        
        //pFooter
        this.setFooter();
        
        //add
        this.add(this.getpHeader(), BorderLayout.NORTH);
        this.add(this.getpBody(), BorderLayout.CENTER);
        this.add(this.getpFooter(), BorderLayout.SOUTH);
    }
    
    //pHeader
    private void setHeader() {
        //set khung chua chung
        this.setpHeader(new JPanel());
        this.getpHeader().setPreferredSize(new Dimension(900, 50));
        this.getpHeader().setBackground(BACKGROUND_COLOR);
        this.getpHeader().setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //pHome
        //bHome
        this.setbHome(new JButton(new ImageIcon("Resource\\iconHome.png")));
        this.getbHome().setActionCommand("Home");
        this.getbHome().setPreferredSize(new Dimension(40, 40));
        this.getbHome().setBorder(null);
        this.getbHome().setContentAreaFilled(false);
        this.getbHome().setCursor(new Cursor(HAND_CURSOR));
        this.getbHome().setFocusPainted(false);
        //su ly su kien chuot cho nut icon "Home" JButton
        this.getbHome().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHomeHover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHome.png"));
            }
        });
        this.getbHome().addActionListener((ActionEvent e) -> {
            ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(getStaffID());
            dispose();
        });
        
        //pHome
        JPanel pHome = new JPanel();
        pHome.setPreferredSize(new Dimension(40, 50));
        pHome.setBackground(BACKGROUND_COLOR);
        pHome.setBorder(new EmptyBorder(-7, 0, 0, 4));
        
        pHome.add(this.getbHome());
        
        //lBill
        this.setlBill(new JLabel("BILL", JLabel.CENTER));
        this.getlBill().setFont(new Font("Arial", Font.BOLD, 27));
        this.getlBill().setPreferredSize(new Dimension(800, 40));
        
        //add
        this.getpHeader().add(this.getlBill());
        this.getpHeader().add(pHome);
    }
    
    //set pBody
    private void setBody() {
        //Khung chua chung
        this.setpBody(new JPanel());
        this.getpBody().setBackground(BACKGROUND_COLOR);
        
        //set table
        this.setModel(new DefaultTableModel());
        this.setBillTable(new JTable(this.getModel()));
        this.setsBillTable(new JScrollPane(this.getBillTable()));
        this.getsBillTable().setPreferredSize(new Dimension(800, 470));
        this.getsBillTable().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        this.getModel().addColumn("Bill_ID");
        this.getModel().addColumn("Date");
        this.getModel().addColumn("Staff_ID");
        this.getModel().addColumn("Total");
        this.getModel().addColumn("Received Money");
        this.getModel().addColumn("Excess Cash");
        this.getModel().addColumn("Type");
        this.getModel().addColumn("Status_Payment");
        this.getBillTable().getColumnModel().getColumn(4).setPreferredWidth(100);
        this.getBillTable().getColumnModel().getColumn(7).setPreferredWidth(100);
        
        this.getBillTable().getTableHeader().setBackground(Color.LIGHT_GRAY);
        this.getBillTable().getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        this.getBillTable().setBackground(new Color(234, 231, 214));
        
        //fill data
        this.displayBillList(this.getBillBUS().getBillList());
        
        this.getsBillTable().getViewport().setBackground(new Color(230, 222, 178));
        
        //add
        this.getpBody().add(this.getsBillTable());
    }
    
    //set pFooter
    private void setFooter() {
        //Tao khung chua chung
        this.setpFooter(new JPanel());
        this.getpFooter().setPreferredSize(new Dimension(JFrame.WIDTH, 130));
        this.getpFooter().setBackground(Color.BLACK);
        this.getpFooter().setLayout(new BorderLayout());
        
        //pFooterTop
        this.setpFooterTop(new JPanel());
        this.getpFooterTop().setPreferredSize(new Dimension(JFrame.WIDTH, 60));
        this.getpFooterTop().setBackground(BACKGROUND_COLOR);
        this.getpFooterTop().setBorder(new EmptyBorder(4, 0, 0, 0));
        
        this.setTfSearch(new JTextField("search bill here",40));
        this.getTfSearch().setPreferredSize(new Dimension(10, 40));
        this.getTfSearch().setBorder(new LineBorder(Color.BLACK, 2));
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 16));
        this.getTfSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getTfSearch().setText("");
            }
        });
        this.setbSearch(this.createButton(new ImageIcon("Resource\\search-icon2.png"), 70, 40, "bSearch"));
        this.getbSearch().addActionListener((ActionEvent e) -> {
            if(this.getTfSearch().getText().equalsIgnoreCase("") || this.getTfSearch().getText().trim().equalsIgnoreCase("search bill here")) {
                JOptionPane.showMessageDialog(this, "Empty Search Box!", "Notification", JOptionPane.OK_OPTION);
            } else {
                this.displayBillList(this.getBillBUS().getBillList(this.getTfSearch().getText().trim()));
            }
        });
        
        this.getpFooterTop().add(this.getTfSearch());
        this.getpFooterTop().add(this.getbSearch());
        
        //pFooterBottom
        this.setpFooterBottom(new JPanel());
        this.getpFooterBottom().setBackground(BACKGROUND_COLOR);
        this.getpFooterBottom().setBorder(new EmptyBorder(5, 0, 0, 0));
        this.getpFooterBottom().setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        
        //create buttons
        this.setbReset(this.createButton(new ImageIcon("Resource\\reset-icon.png"), 80, 48, "bReset"));
        this.getbReset().addActionListener((ActionEvent e) -> {
            this.displayBillList(this.getBillBUS().getBillList());
        });
        this.setbDelete(this.createButton(new ImageIcon("Resource\\trash-icon2.png"), 80, 48, "bDelete"));
        this.getbDelete().addActionListener((ActionEvent e) -> {
            int i = this.getBillTable().getSelectedRow();
            if(i >= 0) {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete This Bill From Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    this.getBillBUS().deleteBill(this.getModel().getValueAt(i, 0).toString().trim());
                    this.displayBillList(this.getBillBUS().getBillList());
                    JOptionPane.showMessageDialog(this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
                }
            }
        });
        this.setbPrint(this.createButton(new ImageIcon("Resource\\print-icon2.png"), 80, 48, "bPrint"));
        this.getbPrint().addActionListener((ActionEvent e) -> {
            int i = this.getBillTable().getSelectedRow();
            if(i >= 0) {
                int result = JOptionPane.showConfirmDialog(this, "Do You Want To Print This Bill?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    this.getSellBUS().printBill(this.getModel().getValueAt(i, 0).toString().trim());
                    JOptionPane.showMessageDialog(this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
                }
            }

        });
        
        this.getpFooterBottom().add(this.getbReset());
        this.getpFooterBottom().add(this.getbDelete());
        this.getpFooterBottom().add(this.getbPrint());
        
        //add
        this.getpFooter().add(this.getpFooterTop(), BorderLayout.NORTH);
        this.getpFooter().add(this.getpFooterBottom(), BorderLayout.CENTER);
    }
    
    //create button
    private JButton createButton(Icon icon, int width, int height, String actionCommand) {
        JButton button = new JButton(icon);
        button.setPreferredSize(new Dimension(width, height));
        button.setActionCommand(actionCommand);
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFocusPainted(false);
        button.setBackground(Color.LIGHT_GRAY);
        button.setCursor(new Cursor(HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(149, 231, 231));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }
        });
        
        return  button;
    }
    
    //display bill list to table
    private void displayBillList(Vector<BillDTO> billList) {
        this.getModel().setRowCount(0);
        for(BillDTO bill: billList) {
            this.getModel().addRow(new Object[] {bill.getBillId(), bill.getDate(), bill.getStaffId(), bill.getTotal(), bill.getReceivedMoney(), bill.getExcessMoney(), bill.getBillType(), bill.isBillStatus()});
        }
    }
}
