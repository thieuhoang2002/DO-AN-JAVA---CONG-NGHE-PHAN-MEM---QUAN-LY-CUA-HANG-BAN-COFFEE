package GUI;

import ApplicationHelper.ID;
import ApplicationHelper.PriceException;
import BUS.ClassifyBUS;
import BUS.ProductBUS;
import BUS.Product_SizeBUS;
import BUS.Product_ToppingBUS;
import BUS.StaffBUS;
import BUS.ToppingBUS;
import DTO.ClassifyDTO;
import DTO.ProductDTO;
import DTO.Product_SizeDTO;
import DTO.Product_ToppingDTO;
import DTO.ToppingDTO;
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

public final class ProductGUI extends JFrame{
    //attribute
    private JPanel pTop, pLeft, pRight, pLeftHeader, pLeftFooter, pRightHeader, pRightBody, pRightFooter;
    private JLabel lProduct, lInfo, lClassify, lProductID, lProductName, lProductNickName, lSizeS, lSizeM, lSizeL, lStatus, lBusiness;
    private JButton bHome, bTopping, bSearch, bAdd, bEdit, bReset, bClose, bOk;
    private JTextField tfProductID, tfProductName, tfNickName, tfSizeS, tfSizeM, tfSizeL, tfSearch;
    private JTable productTable;
    private JScrollPane sProductTable;
    private DefaultTableModel productModel;
    private JRadioButton rOn, rOff;
    private JCheckBox chHot, chCold;
    private ProductBUS productBUS;
    private ClassifyBUS classifyBUS;
    private ToppingBUS toppingBUS;
    private StaffBUS staffBUS;
    private Product_ToppingBUS productToppingBUS;
    private Product_SizeBUS productSizeBUS;
    private JComboBox cbClassify;
    private String staffID;
    private  Vector<Product_ToppingDTO> productToppingList;
    
    Color BACKGROUND_COLOR = new Color(202, 135, 96);
    
    //constructor
    public ProductGUI(String staffID) {
        this.setStaffID(staffID);
        this.setStaffBUS(new StaffBUS());
        this.setProductToppingList(new Vector<>());
        this.setProductBUS(new ProductBUS());
        this.setClassifyBUS(new ClassifyBUS());
        this.setToppingBUS(new ToppingBUS());
        this.setProductSizeBUS(new Product_SizeBUS());
        this.setProductToppingBUS(new Product_ToppingBUS());
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    //setter and getter
    public void setProductBUS(ProductBUS productBUS) {
        this.productBUS = productBUS;
    }

    public ProductBUS getProductBUS() {
        return productBUS;
    }

    public JTextField getTfNickName() {
        return tfNickName;
    }

    public void setTfNickName(JTextField tfNickName) {
        this.tfNickName = tfNickName;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public StaffBUS getStaffBUS() {
        return staffBUS;
    }

    public void setStaffBUS(StaffBUS staffBUS) {
        this.staffBUS = staffBUS;
    }

    public JButton getbOk() {
        return bOk;
    }

    public Vector<Product_ToppingDTO> getProductToppingList() {
        return productToppingList;
    }

    public void setProductToppingList(Vector<Product_ToppingDTO> productToppingList) {
        this.productToppingList = productToppingList;
    }

    public void setbOk(JButton bOk) {
        this.bOk = bOk;
    }

    public JComboBox getCbClassify() {
        return cbClassify;
    }

    public void setCbClassify(JComboBox cbClassify) {
        this.cbClassify = cbClassify;
    }

    public ToppingBUS getToppingBUS() {
        return toppingBUS;
    }

    public void setToppingBUS(ToppingBUS toppingBUS) {
        this.toppingBUS = toppingBUS;
    }

    public JButton getbReset() {
        return bReset;
    }

    public void setbReset(JButton bReset) {
        this.bReset = bReset;
    }

    public Product_ToppingBUS getProductToppingBUS() {
        return productToppingBUS;
    }

    public void setProductToppingBUS(Product_ToppingBUS productToppingBUS) {
        this.productToppingBUS = productToppingBUS;
    }

    public Product_SizeBUS getProductSizeBUS() {
        return productSizeBUS;
    }

    public void setProductSizeBUS(Product_SizeBUS productSizeBUS) {
        this.productSizeBUS = productSizeBUS;
    }
    
    

    public ClassifyBUS getClassifyBUS() {
        return classifyBUS;
    }

    public void setClassifyBUS(ClassifyBUS classifyBUS) {
        this.classifyBUS = classifyBUS;
    }
    
    public JPanel getpTop() {
        return pTop;
    }

    public void setpTop(JPanel pTop) {
        this.pTop = pTop;
    }

    public JPanel getpLeft() {
        return pLeft;
    }

    public void setpLeft(JPanel pLeft) {
        this.pLeft = pLeft;
    }

    public JPanel getpRight() {
        return pRight;
    }

    public void setpRight(JPanel pRight) {
        this.pRight = pRight;
    }

    public JButton getbClose() {
        return bClose;
    }

    public void setbClose(JButton bClose) {
        this.bClose = bClose;
    }

    public JPanel getpLeftHeader() {
        return pLeftHeader;
    }

    public void setpLeftHeader(JPanel pLeftHeader) {
        this.pLeftHeader = pLeftHeader;
    }

    public JPanel getpLeftFooter() {
        return pLeftFooter;
    }

    public void setpLeftFooter(JPanel pLeftFooter) {
        this.pLeftFooter = pLeftFooter;
    }

    public JPanel getpRightHeader() {
        return pRightHeader;
    }

    public void setpRightHeader(JPanel pRightHeader) {
        this.pRightHeader = pRightHeader;
    }

    public JPanel getpRightBody() {
        return pRightBody;
    }

    public void setpRightBody(JPanel pRightBody) {
        this.pRightBody = pRightBody;
    }

    public JPanel getpRightFooter() {
        return pRightFooter;
    }

    public void setpRightFooter(JPanel pRightFooter) {
        this.pRightFooter = pRightFooter;
    }

    public JLabel getlProduct() {
        return lProduct;
    }

    public void setlProduct(JLabel lProduct) {
        this.lProduct = lProduct;
    }

    public JLabel getlInfo() {
        return lInfo;
    }

    public void setlInfo(JLabel lInfo) {
        this.lInfo = lInfo;
    }

    public JLabel getlClassify() {
        return lClassify;
    }

    public void setlClassify(JLabel lClassify) {
        this.lClassify = lClassify;
    }

    public JLabel getlProductID() {
        return lProductID;
    }

    public void setlProductID(JLabel lProductID) {
        this.lProductID = lProductID;
    }

    public JLabel getlProductName() {
        return lProductName;
    }

    public void setlProductName(JLabel lProductName) {
        this.lProductName = lProductName;
    }

    public JLabel getlSizeS() {
        return lSizeS;
    }

    public void setlSizeS(JLabel lSizeS) {
        this.lSizeS = lSizeS;
    }

    public JLabel getlSizeM() {
        return lSizeM;
    }

    public void setlSizeM(JLabel lSizeM) {
        this.lSizeM = lSizeM;
    }

    public JLabel getlSizeL() {
        return lSizeL;
    }

    public void setlSizeL(JLabel lSizeL) {
        this.lSizeL = lSizeL;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JButton getbTopping() {
        return bTopping;
    }

    public void setbTopping(JButton bTopping) {
        this.bTopping = bTopping;
    }

    public JButton getbSearch() {
        return bSearch;
    }

    public void setbSearch(JButton bSearch) {
        this.bSearch = bSearch;
    }

    public JButton getbAdd() {
        return bAdd;
    }

    public void setbAdd(JButton bAdd) {
        this.bAdd = bAdd;
    }

    public JButton getbEdit() {
        return bEdit;
    }

    public void setbEdit(JButton bEdit) {
        this.bEdit = bEdit;
    }

    public JTextField getTfProductID() {
        return tfProductID;
    }

    public void setTfProductID(JTextField tfProductID) {
        this.tfProductID = tfProductID;
    }

    public JTextField getTfProductName() {
        return tfProductName;
    }

    public void setTfProductName(JTextField tfProductName) {
        this.tfProductName = tfProductName;
    }

    public JTextField getTfSizeS() {
        return tfSizeS;
    }

    public void setTfSizeS(JTextField tfSizeS) {
        this.tfSizeS = tfSizeS;
    }

    public JTextField getTfSizeM() {
        return tfSizeM;
    }

    public void setTfSizeM(JTextField tfSizeM) {
        this.tfSizeM = tfSizeM;
    }

    public JTextField getTfSizeL() {
        return tfSizeL;
    }

    public void setTfSizeL(JTextField tfSizeL) {
        this.tfSizeL = tfSizeL;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public void setProductTable(JTable productTable) {
        this.productTable = productTable;
    }

    public JScrollPane getsProductTable() {
        return sProductTable;
    }

    public void setsProductTable(JScrollPane sProductTable) {
        this.sProductTable = sProductTable;
    }

    public DefaultTableModel getProductModel() {
        return productModel;
    }

    public void setProductModel(DefaultTableModel productModel) {
        this.productModel = productModel;
    }

    public JLabel getlProductNickName() {
        return lProductNickName;
    }

    public void setlProductNickName(JLabel lProductNickName) {
        this.lProductNickName = lProductNickName;
    }

    public JLabel getlStatus() {
        return lStatus;
    }

    public void setlStatus(JLabel lStatus) {
        this.lStatus = lStatus;
    }

    public JLabel getlBusiness() {
        return lBusiness;
    }

    public void setlBusiness(JLabel lBusiness) {
        this.lBusiness = lBusiness;
    }

    public JRadioButton getrOn() {
        return rOn;
    }

    public void setrOn(JRadioButton rOn) {
        this.rOn = rOn;
    }

    public JRadioButton getrOff() {
        return rOff;
    }

    public void setrOff(JRadioButton rOff) {
        this.rOff = rOff;
    }

    public JCheckBox getChHot() {
        return chHot;
    }

    public void setChHot(JCheckBox chHot) {
        this.chHot = chHot;
    }

    public JCheckBox getChCold() {
        return chCold;
    }

    public void setChCold(JCheckBox chCold) {
        this.chCold = chCold;
    }
    
    //method
    private void init() {
       //khung chua chung
       this.setTitle("Product Form");
       this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
       this.setSize(1300, 760);
       this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(getStaffID());
                dispose();
            }
       });
       this.setResizable(false);
       this.setLayout(new BorderLayout());
       
       //ptop
       this.createPTop();
       
       //pLeft
       this.createpLeft();
       
       //pRight
       this.createpRight();
       
       //add
       this.add(this.getpTop(), BorderLayout.NORTH);
       this.add(this.getpLeft(), BorderLayout.WEST);
       this.add(this.getpRight(), BorderLayout.EAST);
    }
    
    private void createPTop() {
        //Tao khung chua chung
        this.setpTop(new JPanel());
        this.getpTop().setPreferredSize(new Dimension(JFrame.WIDTH, 60));
        this.getpTop().setBackground(BACKGROUND_COLOR);
        this.getpTop().setLayout(new BorderLayout(0, 0));
        
        //pTop Right
        JPanel pHome = new JPanel();
        pHome.setPreferredSize(new Dimension(60, 60));
        pHome.setLayout(new FlowLayout(FlowLayout.CENTER));
        pHome.setBorder(new EmptyBorder(new Insets(-2, 0, 0, -10)));
        pHome.setBackground(BACKGROUND_COLOR);
        
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
            ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(this.getStaffID());
            this.dispose();
        });
        
        //pTop Left
        JPanel pTitle = new JPanel();
        pTitle.setPreferredSize(new Dimension(1200, 60));
        pTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        pTitle.setBackground(Color.RED);
        pTitle.setBorder(new EmptyBorder(new Insets(20, 0, 0, 100)));
        pTitle.setBackground(BACKGROUND_COLOR);
        
        
        //lProduct
        this.setlProduct(new JLabel("PRODUCT"));
        this.getlProduct().setFont(new Font("Arial", Font.BOLD, 27) {
        });
        
        //add
        pTitle.add(this.getlProduct());
        pHome.add(this.getbHome());
        this.getpTop().add(pTitle, BorderLayout.WEST);
        this.getpTop().add(pHome, BorderLayout.EAST);
    }
    
    private void createpLeft() {
        //Tao khung chua chung
        this.setpLeft(new JPanel());
        this.getpLeft().setPreferredSize(new Dimension(900, JPanel.HEIGHT));
        this.getpLeft().setLayout(new BorderLayout());
        this.getpLeft().setBackground(Color.GREEN);
        
        //pLeftHeader
        this.setpLeftHeader(new JPanel());
        this.getpLeftHeader().setLayout(new FlowLayout());
        this.getpLeftHeader().setPreferredSize(new Dimension(980, 600));
        this.getpLeftHeader().setBorder(new EmptyBorder(-5, 20, 0, 0));
        this.getpLeftHeader().setBackground(BACKGROUND_COLOR);
        
        this.setProductModel(new DefaultTableModel());
        this.setProductTable(new JTable(this.getProductModel()));
        this.setsProductTable(new JScrollPane(this.getProductTable()));
        this.getsProductTable().setPreferredSize(new Dimension(880, 600));
        this.getsProductTable().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder()));
        
        //set model
        this.getProductTable().getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        this.getsProductTable().getViewport().setBackground(new Color(230, 222, 178));
        this.getProductModel().addColumn("Classify");
        this.getProductModel().addColumn("Product_ID");
        this.getProductModel().addColumn("Name");
        this.getProductModel().addColumn("NickName");
        this.getProductModel().addColumn("Price/S");
        this.getProductModel().addColumn("Price/M");
        this.getProductModel().addColumn("Price/L");
        this.getProductModel().addColumn("Status");
        this.getProductModel().addColumn("Business");
        this.getProductTable().getColumnModel().getColumn(2).setPreferredWidth(170);
        this.getProductTable().getColumnModel().getColumn(3).setPreferredWidth(170);
        this.getProductTable().setBackground(new Color(234, 231, 214));
        this.getProductTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = getProductTable().getSelectedRow();
                if(i >= 0) {
                    getCbClassify().setSelectedItem(getProductModel().getValueAt(i, 0).toString());
                    getCbClassify().setEnabled(false);
                    getTfProductID().setText(getProductModel().getValueAt(i, 1).toString());
                    getTfProductName().setText(getProductModel().getValueAt(i, 2).toString());
                    getTfNickName().setText(getProductModel().getValueAt(i, 3).toString());
                    getTfSizeS().setText(getProductModel().getValueAt(i, 4).toString());
                    getTfSizeM().setText(getProductModel().getValueAt(i, 5).toString());
                    getTfSizeL().setText(getProductModel().getValueAt(i, 6).toString());
                    if(getProductModel().getValueAt(i, 7).toString().equalsIgnoreCase("BOTH")) {
                        getChHot().setSelected(true);
                        getChHot().setActionCommand("1");
                        getChCold().setSelected(true);
                        getChCold().setActionCommand("1");
                    } else if(getProductModel().getValueAt(i, 7).toString().equalsIgnoreCase("HOT")) {
                        getChHot().setSelected(true);
                        getChHot().setActionCommand("1");
                        getChCold().setSelected(false);
                        getChCold().setActionCommand("0");
                    } else {
                        getChCold().setSelected(true);
                        getChCold().setActionCommand("1");
                        getChHot().setSelected(false);
                        getChHot().setActionCommand("0");
                    }
                    if(getProductModel().getValueAt(i, 8).toString().equalsIgnoreCase("true")) {
                        getrOn().setSelected(true);
                    } else {
                        getrOff().setSelected(true);
                    }
                }
            }
        });
        
        this.showProductListOnTable();
        
        this.getpLeftHeader().add(this.getsProductTable());
        
        //pFooterHeader
        this.setpLeftFooter(new JPanel());
        this.getpLeftFooter().setPreferredSize(new Dimension(900, 100));
        this.getpLeftFooter().setBackground(BACKGROUND_COLOR);
        this.getpLeftFooter().setLayout(new FlowLayout(FlowLayout.CENTER));
        
        //bSearch anf tfSearch
        this.setTfSearch(this.createJTextField(40, 200, 40, "tfSearch"));
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 16));
        this.getTfSearch().setText("search product here");
        this.getTfSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                getTfSearch().setText("");
            }
        });
        
        this.setbSearch(this.createButton(new ImageIcon("Resource\\search-icon2.png"), 80, 50, "bSearch"));
        this.getbSearch().addActionListener((ActionEvent e) -> {
           if(this.getTfSearch().getText().equalsIgnoreCase("") || this.getTfSearch().getText().equalsIgnoreCase("search product here")) {
               JOptionPane.showMessageDialog(this, "Empty Search Box!", "Warning", JOptionPane.OK_OPTION);
           } else {
               this.showProductListFromKeyWord(this.getTfSearch().getText());
           }
        });
        
        //bReset
        this.setbReset(this.createButton(new ImageIcon("Resource\\reset-icon.png"), 80, 50, "bReset"));
        this.getbReset().addActionListener((ActionEvent e) -> {
           this.showProductListOnTable();
        });
        
        this.getpLeftFooter().add(this.getTfSearch());
        this.getpLeftFooter().add(this.getbSearch());
        this.getpLeftFooter().add(this.getbReset());
        
        //add
        this.getpLeft().add(this.getpLeftHeader(), BorderLayout.NORTH);
        this.getpLeft().add(this.getpLeftFooter(), BorderLayout.CENTER);
    }
    
    //pRight
    private void createpRight() {
        //Tao khung chua chung
        this.setpRight(new JPanel());
        this.getpRight().setPreferredSize(new Dimension(390, JPanel.HEIGHT));
        this.getpRight().setLayout(new BorderLayout());
        this.getpRight().setBackground(Color.BLUE);
        
        //Header
        this.setpRightHeader(new JPanel());
        this.getpRightHeader().setLayout(new FlowLayout(FlowLayout.CENTER));
        this.getpRightHeader().setPreferredSize(new Dimension(400, 40));
        this.getpRightHeader().setBackground(BACKGROUND_COLOR);
        
        this.setlInfo(new JLabel("Info"));
        this.getlInfo().setFont(new Font("Arial", Font.BOLD, 22));
        
        this.getpRightHeader().add(this.getlInfo());
        
        //Center
        this.setpRightBody(new JPanel(new GridLayout(10, 1, 0, 0)));
        this.getpRightBody().setBackground(BACKGROUND_COLOR);
        
        JPanel panelClassify = new JPanel();
        panelClassify.setBackground(BACKGROUND_COLOR);
        panelClassify.setLayout(new FlowLayout());
        panelClassify.setBorder(new EmptyBorder(0, 0, 0, 4));
        
        this.setlClassify(this.createJLabel("Classify:"));
        
        this.setCbClassify(new JComboBox());
        this.getCbClassify().setPreferredSize(new Dimension(239, 40));
        this.getCbClassify().setFont(new Font("Arial", Font.BOLD, 16));
        this.fillDataFromClassifyListToCB();
        
        panelClassify.add(this.getlClassify());
        panelClassify.add(this.getCbClassify());
        
        
        JPanel panelID = new JPanel();
        panelID.setBackground(BACKGROUND_COLOR);
        this.setTfProductID(createJTextField(18, 50, 40, "tfID"));
        this.setDetailInfo(panelID, "ID:", this.getTfProductID());
        this.getTfProductID().setEditable(false);
        this.getTfProductID().setBackground(new Color(223, 230, 241));
        this.getTfProductID().setText(ID.createProductId((String) this.getCbClassify().getSelectedItem()));
        
        //set su kien for CB
        this.getCbClassify().addActionListener((ActionEvent e) -> {
            String newProductId = ID.createProductId(String.valueOf(this.getCbClassify().getSelectedItem()));
            this.getTfProductID().setText(newProductId);
        });
        
        
        JPanel panelName = new JPanel();
        panelName.setBackground(BACKGROUND_COLOR);
        this.setTfProductName(this.createJTextField(18, 50, 40, "tfName"));
        this.setDetailInfo(panelName, "Name:", this.getTfProductName());
        
        JPanel panelNickName = new JPanel();
        panelNickName.setBackground(BACKGROUND_COLOR);
        this.setTfNickName(this.createJTextField(18, 50, 40, "tfNickName"));
        this.setDetailInfo(panelNickName, "NickName:", this.getTfNickName());
        
        JPanel panelSizeS = new JPanel();
        panelSizeS.setBackground(BACKGROUND_COLOR);
        this.setTfSizeS(this.createJTextField(18, 50, 40, "tfSizeS"));
        this.setDetailInfo(panelSizeS, "Price/S:", this.getTfSizeS());
        
        JPanel panelSizeM = new JPanel();
        panelSizeM.setBackground(BACKGROUND_COLOR);
        this.setTfSizeM(this.createJTextField(18, 50, 40, "tfSizeM"));
        this.setDetailInfo(panelSizeM, "Price/M:", this.getTfSizeM());
        
        JPanel panelSizeL = new JPanel();
        panelSizeL.setBackground(BACKGROUND_COLOR);
        this.setTfSizeL(this.createJTextField(18, 50, 40, "tfSizeL"));
        this.setDetailInfo(panelSizeL, "Price/L:", this.getTfSizeL());
        
        JPanel panelStatus = new JPanel();
        panelStatus.setBackground(BACKGROUND_COLOR);
        panelStatus.setLayout(new BorderLayout());
        panelStatus.setBorder(new EmptyBorder(0, 23, 0, 20));
        
        this.setlStatus(this.createJLabel("Status:"));
        
        this.setChHot(new JCheckBox("Hot"));
        this.getChHot().setBackground(BACKGROUND_COLOR);
        this.getChHot().setFocusPainted(false);
        this.getChHot().setFont(new Font("Arial", Font.BOLD, 18));
        this.getChHot().setSelected(true);
        this.getChHot().setCursor(new Cursor(HAND_CURSOR));
        this.getChHot().setActionCommand("1");
        this.getChHot().addActionListener((ActionEvent e) -> {
            if(getChHot().getActionCommand().equalsIgnoreCase("1")) {
                    getChHot().setActionCommand("0");
                    if(getChCold().getActionCommand().equalsIgnoreCase("0")) {
                        getChCold().setSelected(true);
                        getChCold().setActionCommand("1");
                    }
            } else if(getChHot().getActionCommand().equalsIgnoreCase("0")) {
                    getChHot().setActionCommand("1");
            }
        });
        
        this.setChCold(new JCheckBox("Cold"));
        this.getChCold().setBackground(BACKGROUND_COLOR);
        this.getChCold().setFocusPainted(false);
        this.getChCold().setCursor(new Cursor(HAND_CURSOR));
        this.getChCold().setFont(new Font("Arial", Font.BOLD, 18));
        this.getChCold().setPreferredSize(new Dimension(160, 40));
        this.getChCold().setActionCommand("0");
        this.getChCold().addActionListener((ActionEvent e) -> {
            if(getChCold().getActionCommand().equalsIgnoreCase("1")) {
                    getChCold().setActionCommand("0");
                    if(getChHot().getActionCommand().equalsIgnoreCase("0")) {
                        getChHot().setSelected(true);
                        getChHot().setActionCommand("1");
                    }
            } else if(getChCold().getActionCommand().equalsIgnoreCase("0")) {
                    getChCold().setActionCommand("1");
            }
        });
        
        panelStatus.add(this.getlStatus(), BorderLayout.WEST);
        panelStatus.add(this.getChHot(), BorderLayout.CENTER);
        panelStatus.add(this.getChCold(), BorderLayout.EAST);
        
        JPanel panelBusiness = new JPanel();
        panelBusiness.setBackground(Color.RED);
        panelBusiness.setBackground(BACKGROUND_COLOR);
        panelBusiness.setLayout(new BorderLayout());
        panelBusiness.setBorder(new EmptyBorder(0, 23, 0, 20));
        
        this.setlBusiness(this.createJLabel("Business:"));
        
        this.setrOn(new JRadioButton("On"));
        this.getrOn().setBackground(BACKGROUND_COLOR);
        this.getrOn().setFocusPainted(false);
        this.getrOn().setFont(new Font("Arial", Font.BOLD, 18));
        this.getrOn().setCursor(new Cursor(HAND_CURSOR));
        this.getrOn().setSelected(true);
        
        this.setrOff(new JRadioButton("Off"));
        this.getrOff().setBackground(BACKGROUND_COLOR);
        this.getrOff().setFocusPainted(false);
        this.getrOff().setFont(new Font("Arial", Font.BOLD, 18));
        this.getrOff().setPreferredSize(new Dimension(160, 40));
        this.getrOff().setCursor(new Cursor(HAND_CURSOR));
        
        
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(this.getrOn());
        bg.add(this.getrOff());
        
        panelBusiness.add(this.getlBusiness(), BorderLayout.WEST);
        panelBusiness.add(this.getrOn(), BorderLayout.CENTER);
        panelBusiness.add(this.getrOff(), BorderLayout.EAST);
        
        
        JPanel panelTopping = new JPanel();
        panelTopping.setBackground(Color.BLUE);
        panelTopping.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        panelTopping.setBackground(BACKGROUND_COLOR);
        
        this.setbTopping(new JButton("Topping"));
        this.getbTopping().setPreferredSize(new Dimension(100, 40));
        this.getbTopping().setActionCommand("bTopping");
        this.getbTopping().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getbTopping().setFocusPainted(false);
        this.getbTopping().setFont(new Font("Arial", Font.BOLD, 16));
        this.getbTopping().setBackground(Color.GREEN);
        this.getbTopping().setForeground(Color.WHITE);
        this.getbTopping().setCursor(new Cursor(HAND_CURSOR));
        this.getbTopping().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getbTopping().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getbTopping().setFont(new Font("Arial", Font.BOLD, 18));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbTopping().setFont(new Font("Arial", Font.BOLD, 16));
            }
        });
        this.getbTopping().addActionListener((ActionEvent e) -> {
            this.createJFrameContainTopping();
        });
        
        panelTopping.add(this.getbTopping());
        
        this.getpRightBody().add(panelClassify);
        this.getpRightBody().add(panelID);
        this.getpRightBody().add(panelName);
        this.getpRightBody().add(panelNickName);
        this.getpRightBody().add(panelSizeS);
        this.getpRightBody().add(panelSizeM);
        this.getpRightBody().add(panelSizeL);
        this.getpRightBody().add(panelStatus);
        this.getpRightBody().add(panelBusiness);
        this.getpRightBody().add(panelTopping);
        
        
        //Footer
        this.setpRightFooter(new JPanel());
        this.getpRightFooter().setPreferredSize(new Dimension(400, 100));
        this.getpRightFooter().setBackground(BACKGROUND_COLOR);
        this.getpRightFooter().setLayout(new FlowLayout(FlowLayout.CENTER, 20, 25));
        
        this.setbAdd(this.createButton(new ImageIcon("Resource\\add-1-icon2.png"), 55, 50, "bAdd"));
        this.getbAdd().addActionListener((ActionEvent e) -> {
            if(this.getProductBUS().checkId(this.getTfProductID().getText()) == false) {
                //check boxs
                int ok = 1;
                if(this.getTfProductName().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Product Name Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if(this.getProductBUS().checkName(this.getTfProductName().getText().trim())) {
                    JOptionPane.showMessageDialog(this, "This Product Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if (this.getTfNickName().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Display NickName Of Product Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                    ok= 0;
                } else if(this.getProductBUS().checkNickName(this.getTfNickName().getText().trim())) {
                    JOptionPane.showMessageDialog(this, "This Product Nick Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if (this.getTfSizeS().getText().equalsIgnoreCase("") && this.getTfSizeM().getText().equalsIgnoreCase("") && this.getTfSizeL().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Price For At Least One Size \"S, M or L\"!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                }
                
                //set product size list
                Vector<Product_SizeDTO> sizeList = new Vector<>();
                try {
                    sizeList = this.createProductSizeList();
                } catch (NumberFormatException|PriceException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Input Price!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                }
                
                //Them mot doi tuong san pham moi vao csdl thong qua lop BUS
                if(ok == 1) {
                    int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Add This Product To The Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(this, insertProduct(sizeList, this.getProductToppingList()), "Notification", JOptionPane.CLOSED_OPTION);
                        this.getProductSizeBUS().resetList();
                        this.getProductToppingBUS().resetList();
                        this.resetGUIAfterUpdate();
                    }
                } 
            }
        });
        this.setbEdit(this.createButton(new ImageIcon("Resource\\edit-validated-icon2.png"), 55, 50, "bEdit"));
        this.getbEdit().addActionListener((ActionEvent e) -> {
            String productId = this.getTfProductID().getText();
            if(this.getProductBUS().checkId(productId)) {
                int ok = 1;
                if(this.getTfProductName().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Product Name Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if(this.getProductBUS().checkName(this.getTfProductName().getText().trim()) && !this.getProductBUS().getProductFromId(productId).getProductName().equalsIgnoreCase(this.getTfProductName().getText().trim())) {
                    JOptionPane.showMessageDialog(this, "This Product Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if (this.getTfNickName().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Display NickName Of Product Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                    ok= 0;
                } else if(this.getProductBUS().checkNickName(this.getTfNickName().getText().trim()) && !this.getProductBUS().getProductFromId(productId).getProductNickName().equalsIgnoreCase(this.getTfNickName().getText().trim())) {
                    JOptionPane.showMessageDialog(this, "This Product Nick Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                } else if (this.getTfSizeS().getText().equalsIgnoreCase("") && this.getTfSizeM().getText().equalsIgnoreCase("") && this.getTfSizeL().getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Price For At Least One Size \"S, M or L\"!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                }
                
                //set product size list
                Vector<Product_SizeDTO> sizeList = new Vector<>();
                try {
                    sizeList = this.createProductSizeList();
                } catch (NumberFormatException|PriceException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid Input Price!", "Warning", JOptionPane.OK_OPTION);
                    ok = 0;
                }
                
                //Update san pham trong csdl thong qua lop BUS
                if(ok == 1) {
                    int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Update This Product In The Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(this, updateProduct(sizeList, this.getProductToppingList()), "Notification", JOptionPane.CLOSED_OPTION);
                        this.getProductSizeBUS().resetList();
                        this.getProductToppingBUS().resetList();
                        this.resetGUIAfterUpdate();
                    }
                } 
            }
        });
        
        this.setbClose(this.createButton(new ImageIcon("Resource\\close-icon2.png"), 55, 50, "bClose"));
        this.getbClose().addActionListener((ActionEvent e) -> {
            this.resetGUIAfterUpdate();
            this.getCbClassify().setEnabled(true);
        });
        
        
        this.getpRightFooter().add(this.getbAdd());
        this.getpRightFooter().add(this.getbEdit());
        this.getpRightFooter().add(this.getbClose());
        
        //add
        this.getpRight().add(this.getpRightHeader(), BorderLayout.NORTH);
        this.getpRight().add(this.getpRightBody(), BorderLayout.CENTER);
        this.getpRight().add(this.getpRightFooter(), BorderLayout.SOUTH);
    }
    
    private Vector<Product_SizeDTO> createProductSizeList() throws PriceException {
        Vector<Product_SizeDTO> productSizeList = new Vector<>();
            if(!this.getTfSizeS().getText().equalsIgnoreCase("") && !this.getTfSizeS().getText().equalsIgnoreCase("X")) {
                Double priceS = Double.parseDouble(this.getTfSizeS().getText().trim());
                productSizeList.add(new Product_SizeDTO(this.getTfProductID().getText().trim(), "S", priceS));
                if(priceS <= 0) {
                    throw new ApplicationHelper.PriceException();
                }
            }

            if(!this.getTfSizeM().getText().equalsIgnoreCase("") && !this.getTfSizeM().getText().equalsIgnoreCase("X")) {
                Double priceM = Double.parseDouble(this.getTfSizeM().getText().trim());
                productSizeList.add(new Product_SizeDTO(this.getTfProductID().getText().trim(), "M", priceM));
                if(priceM <= 0) {
                    throw new ApplicationHelper.PriceException();
                }
            }

            if(!this.getTfSizeL().getText().equalsIgnoreCase("") && !this.getTfSizeL().getText().equalsIgnoreCase("X")) {
                Double priceL = Double.parseDouble(this.getTfSizeL().getText().trim());
                productSizeList.add(new Product_SizeDTO(this.getTfProductID().getText().trim(), "L", priceL));
                if(priceL <= 0) {
                    throw new ApplicationHelper.PriceException();
                }
            }
        return productSizeList;
    }
    
    //insert a product
    public String insertProduct(Vector<Product_SizeDTO> productSize, Vector<Product_ToppingDTO> productTopping) {
        //set product
        String classifyId = this.getClassifyBUS().getClassifyId(String.valueOf(this.getCbClassify().getSelectedItem()));
        String productId = this.getTfProductID().getText().trim();
        String productName = this.getTfProductName().getText().trim();
        String productNickName = this.getTfNickName().getText().trim();
        String productStatus;
        if(this.getChHot().isSelected() && this.getChCold().isSelected()) {
            productStatus = "BOTH";
        } else if (this.getChHot().isSelected()) {
            productStatus = "HOT";
        } else {
            productStatus = "COLD";
        }
        boolean business = this.getrOn().isSelected();
        
        return this.getProductBUS().insert(new ProductDTO(classifyId, productId, productName, productNickName, productStatus, business), productSize, productTopping);
    }
    
    //update a product
    public String updateProduct(Vector<Product_SizeDTO> productSize, Vector<Product_ToppingDTO> productTopping) {
        //set product
        String classifyId = this.getClassifyBUS().getClassifyId(String.valueOf(this.getCbClassify().getSelectedItem()));
        String productId = this.getTfProductID().getText().trim();
        String productName = this.getTfProductName().getText().trim();
        String productNickName = this.getTfNickName().getText().trim();
        String productStatus;
        if(this.getChHot().isSelected() && this.getChCold().isSelected()) {
            productStatus = "BOTH";
        } else if (this.getChHot().isSelected()) {
            productStatus = "HOT";
        } else {
            productStatus = "COLD";
        }
        boolean business = this.getrOn().isSelected();
        
        return this.getProductBUS().update(new ProductDTO(classifyId, productId, productName, productNickName, productStatus, business), productSize, productTopping);
    }
    
    //reset gui
    private void resetGUIAfterUpdate() {
        this.getTfProductName().setText("");
        this.getTfNickName().setText("");
        this.getTfSizeS().setText("");
        this.getTfSizeM().setText("");
        this.getTfSizeL().setText("");
        this.getChHot().setSelected(true);
        this.getChCold().setSelected(false);
        this.getrOn().setSelected(true);
        this.getProductToppingList().clear();
        this.getCbClassify().setSelectedIndex(0);
        this.getTfProductID().setText(ID.createProductId((String) this.getCbClassify().getSelectedItem()));
        this.showProductListOnTable();
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
    
    private JButton createButton(String text, int width, int height, String actionCommand) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setActionCommand(actionCommand);
        button.setFont(new Font("Arial", Font.BOLD, 15));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
        button.setFocusPainted(false);
        button.setBackground(Color.LIGHT_GRAY);
        button.setCursor(new Cursor(HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(149, 231, 231));
                button.setFont(new Font("Arial", Font.BOLD, 17));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
                button.setFont(new Font("Arial", Font.BOLD, 15));
            }
        });
        
        return  button;
    }
    
    //create jtextfield
    private JTextField createJTextField(int x, int width, int height, String actionCommand) {
        JTextField tf = new JTextField(x);
        tf.setActionCommand(actionCommand);
        tf.setPreferredSize(new Dimension(width, height));
        tf.setBorder(new LineBorder(Color.BLACK, 2));
        tf.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16) {
        });
        return tf;
    }
    
    //set detail info
    private void setDetailInfo(JPanel panel,String text, JTextField tf) {
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(this.createJLabel(text));
        panel.add(tf);
        panel.setBorder(new EmptyBorder(new Insets(0, 0, 0, 20)));
    }
    
    //create JLabel
    private JLabel createJLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(100, 40));
        label.setFont(new Font("Arial", Font.BOLD, 18));
        return label;
    }
    
    //show product list on table
    private void showProductListOnTable() {
        this.getProductBUS().resetList();
        this.getProductModel().setRowCount(0);
        for(ProductDTO product: this.getProductBUS().getProductList()) {
            this.getProductModel().addRow(new Object[] {this.getClassifyBUS().getClassifyName(product.getClassifyId()), product.getProductId(), product.getProductName(), product.getProductNickName(), 
                                                        this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "S"), this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "M"), this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "L"),
                                                        product.getProductStatus().toLowerCase(), product.isProductBusiness()});
        }
    }
    
    //show product list from keyWord on table
    private void showProductListFromKeyWord(String keyWord) {
        this.getProductBUS().resetList();
        this.getProductModel().setRowCount(0);
        for(ProductDTO product: this.getProductBUS().getProductList(keyWord)) {
            this.getProductModel().addRow(new Object[] {this.getClassifyBUS().getClassifyName(product.getClassifyId()), product.getProductId(), product.getProductName(), product.getProductNickName(), 
                                                        this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "S"), this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "M"), this.getProductSizeBUS().getPriceToStatistic(product.getProductId(), "L"),
                                                        product.getProductStatus().toLowerCase(), product.isProductBusiness()});
        }
    }
    
    //fill date from classify list to cbClassify
    private void fillDataFromClassifyListToCB() {
        this.getClassifyBUS().resetList();
        for(ClassifyDTO o: this.getClassifyBUS().getClassifyList()) {
            this.getCbClassify().addItem(o.getClassifyName());
        }
    }
    
    //create jframe contain topping
    private JFrame createJFrameContainTopping() {
        JFrame frame = new JFrame();
        int height = this.getToppingBUS().getToppingList().size() * 52;
        frame.setSize(new Dimension(240, height));
        frame.setTitle("Topping");
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\Fruits-Strawberries-icon.png"));
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        Vector<JCheckBox> checkBoxToppingList = new Vector<>();
        this.getProductToppingList().clear();
        for(ToppingDTO topping: this.getToppingBUS().getToppingList()) {
            if(topping.isToppingStatus()) {
                JCheckBox cb = new JCheckBox(topping.getToppingName());
                cb.setPreferredSize(new Dimension(190, 30));
                cb.setFont(new Font("Arial", Font.BOLD, 15));
                cb.setFocusPainted(false);
                cb.setActionCommand(topping.getToppingId());
                cb.setBackground(new Color(175, 136, 110));
                frame.add(cb);
                checkBoxToppingList.add(cb);
                
                //Neu san pham da ton tai thi tim nhung topping cua san pham do de check vao
                if(this.getProductBUS().checkId(this.getTfProductID().getText())) {
                    for(String toppingId: this.getProductToppingBUS().getToppingIdList(this.getTfProductID().getText())) {
                        if(cb.getActionCommand().equalsIgnoreCase(toppingId)) {
                            cb.setSelected(true);
                            this.getProductToppingList().add(new Product_ToppingDTO(this.getTfProductID().getText(), toppingId));
                            break;
                        }
                    }
                }
            }
        }
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(190, 50));
        panel.setBackground(new Color(175, 136, 110));
        
        this.setbOk(this.createButton("Ok", 50, 30, "bOk"));
        this.getbOk().addActionListener((ActionEvent e) -> {
            this.getProductToppingList().clear();
            for(JCheckBox o: checkBoxToppingList) {
                if(o.isSelected()) {
                    this.getProductToppingList().add(new Product_ToppingDTO(this.getTfProductID().getText(), o.getActionCommand()));
                }
            }
            frame.dispose();
        });
        
        panel.add(this.getbOk());
        
        frame.add(panel);
        
        
        frame.getContentPane().setBackground(new Color(175, 136, 110));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(this);
        frame.setVisible(true);
        return frame;
    }
    
}
