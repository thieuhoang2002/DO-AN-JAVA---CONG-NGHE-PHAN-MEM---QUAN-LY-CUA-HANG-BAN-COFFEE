package GUI;

import BUS.ToppingBUS;
import DTO.ToppingDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public final class ToppingGUI extends JFrame {
    //khai bao cac bien 
    private JTable toppingTable;   //cai bang loai topping
    private JLabel toppingLabel, infoLabel, idLabel, nameLabel, priceLabel, statusLabel;   //dung de hien thi cac chu nhu "TOPPING", "INFOR",...
    private JTextField searchTextField, idTextField, nameTextField, priceTextField; // cac o de nhap "Name", "id",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    private JRadioButton onRadioButton, offRadioButton;
    DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sTable;
    private String staffID;
    private ToppingBUS toppingBUS;
    
    // ham nay de viet giao dien 
    public void MainDisplay(){
        toppingBUS = new ToppingBUS();
        this.setTitle("Coffee Shop"); //set tên cho frame
        //khởi tạo các đối tượng
        toppingTable = new JTable();
        toppingLabel = new JLabel("TOPPING");
        toppingLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                loadToppingList();
            }
        });
        infoLabel = new JLabel("INFO");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        priceLabel = new JLabel("Price:");
        statusLabel = new JLabel("Status:");
        searchTextField = new JTextField();
        idTextField = new JTextField();
        nameTextField = new JTextField();
        priceTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        onRadioButton = new JRadioButton("On");
        offRadioButton = new JRadioButton("Off");
        
        //cài đặt tọa độ, kích thước, icon, nền background cho button
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBorder(null);
        homeButton.setBackground(new Color(202, 135, 96));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener((ActionEvent e) -> {
           ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
           this.dispose();
        });
        
        addButton.setBounds(960, 630, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149,231,231));
        addButton.addActionListener((ActionEvent e) -> {
            if(!toppingBUS.checkExist(idTextField.getText().trim())) {
                if(nameTextField.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(this, "Topping Name Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                } else if (priceTextField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Topping Price Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                } else if (toppingBUS.checkName(nameTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Topping Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                } else if (!checkPrice(priceTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Invalid Price!", "Warning", JOptionPane.OK_OPTION);
                } else {
                    int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Insert This Topping To The Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                    Boolean business = onRadioButton.isSelected();
                    JOptionPane.showMessageDialog(this, toppingBUS.insert(new ToppingDTO(idTextField.getText().trim(), nameTextField.getText().trim(), 
                        Double.parseDouble(priceTextField.getText().trim()), business)), "Warning", JOptionPane.OK_OPTION);
                    loadToppingList();
                }
            }
            }
        });
        
        editButton.setBounds(1030, 630, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149,231,231));
        editButton.addActionListener((ActionEvent e) -> {
            if(toppingBUS.checkExist(idTextField.getText().trim())) {
                if(nameTextField.getText().equalsIgnoreCase("")){
                    JOptionPane.showMessageDialog(this, "Topping Name Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                } else if (priceTextField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Topping Price Can Not Be Empty!", "Warning", JOptionPane.OK_OPTION);
                } else if (toppingBUS.checkName(nameTextField.getText().trim()) && !toppingBUS.getToppingFromId(idTextField.getText().trim()).getToppingName().equalsIgnoreCase(nameTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Topping Name Already Exists!", "Warning", JOptionPane.OK_OPTION);
                } else if (!checkPrice(priceTextField.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Invalid Price!", "Warning", JOptionPane.OK_OPTION);
                } else {
                    int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Update This Topping In The Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if(result == JOptionPane.YES_OPTION) {
                    Boolean business = onRadioButton.isSelected();
                    JOptionPane.showMessageDialog(this, toppingBUS.update(new ToppingDTO(idTextField.getText().trim(), nameTextField.getText().trim(), 
                        Double.parseDouble(priceTextField.getText().trim()), business)), "Warning", JOptionPane.OK_OPTION);
                    loadToppingList();
                }
            }
            }
        });
        
        logoutButton.setBounds(1100, 630, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149,231,231));
        logoutButton.addActionListener((ActionEvent e) -> {
            resetInfo();
        });
        
        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149,231,231));
        searchButton.addActionListener((ActionEvent e) -> {
            if(searchTextField.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Empty Search Box!", "Notification", JOptionPane.OK_OPTION);
            } else {
                displayToppingList(searchTextField.getText());
            }
        });
        searchTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTextField.setText("");
            }
        });
        
        //set table
        toppingTable.setModel(model);
        toppingTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                displayInfo(e);
            }
        });
        
        sTable = new JScrollPane(toppingTable);
        sTable.setBounds(110,95,615,500);
       
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Business");
        
        //load danh sach topping
        loadToppingList();
        
        //set tọa độ, kích thước, font, cỡ chữ cho các Label
        toppingLabel.setBounds(615, 30,  130, 30);
        toppingLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        infoLabel.setBounds(1020, 150, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        idLabel.setBounds(850, 220, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        nameLabel.setBounds(850, 270, 120, 25);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        priceLabel.setBounds(850, 320, 120, 25);
        priceLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        statusLabel.setBounds(850, 370, 120, 25);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        idTextField.setBounds(950, 220, 240, 25);
        idTextField.setEditable(false);
        idTextField.setText(ApplicationHelper.ID.createToppingID());
        nameTextField.setBounds(950, 270, 240, 25);
        priceTextField.setBounds(950, 320, 240, 25);
        
        searchTextField.setBounds(110, 640, 545, 30);
        
        //2 ô on off, phải group lại để có thể chỉ chọn được 1 ô
        onRadioButton.setBounds(950, 370, 50, 25);
        onRadioButton.setSelected(true);
        offRadioButton.setBounds(950, 420, 50, 25);
        ButtonGroup radiobuttongroup = new ButtonGroup();
        radiobuttongroup.add(onRadioButton);
        radiobuttongroup.add(offRadioButton);
        
        //add tất cả vào frame
        this.add(toppingLabel);
        this.add(homeButton);
        this.add(addButton);
        this.add(editButton);
        this.add(logoutButton);
        this.add(searchButton);
        this.add(sTable);
        this.add(infoLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(idTextField);
        this.add(nameTextField);
        this.add(searchTextField);
        this.add(priceLabel);
        this.add(priceTextField);
        this.add(onRadioButton);
        this.add(offRadioButton);
        this.add(statusLabel);
        this.setSize(1300,760);  //kích thước của Frame
        this.setLocationRelativeTo(null); //set cái frame hiển thị ở giữa màn hình desktop
        this.getContentPane().setBackground(new Color(202, 135, 96)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null); //không set layout cho frame
        this.setVisible(true); //hiển thị frame
        this.setResizable(true); //cho phép kéo giãn frame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
                dispose();
            }
        });
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));
        
    }
    
    public String getStaffID() {
        return staffID;
    }
    
    public ToppingGUI(String staffID){
        this.staffID = staffID;
        this.MainDisplay();
    }
    
    //load danh sach topping len table
    public void loadToppingList() {
        model.setRowCount(0);
        toppingBUS.resetList();
        for(ToppingDTO topping: toppingBUS.getToppingList()) {
            model.addRow(new Object[] {topping.getToppingId(), topping.getToppingName(), topping.getToppingPrice(), topping.isToppingStatus()});
        }
    }
    
    //hien thi thong tin topping tren info khi click vao mot record
    public void displayInfo(MouseEvent e) {
        int i = toppingTable.getSelectedRow();
        if(i >= 0) {
            idTextField.setText(model.getValueAt(i, 0).toString());
            nameTextField.setText(model.getValueAt(i, 1).toString());
            priceTextField.setText(model.getValueAt(i, 2).toString());
            if(model.getValueAt(i, 3).toString().equalsIgnoreCase("true")) {
                onRadioButton.setSelected(true);
            } else {
                offRadioButton.setSelected(true);
            }
        }
    }
    
    //reset info
    public void resetInfo() {
        idTextField.setText(ApplicationHelper.ID.createToppingID());
        nameTextField.setText("");
        priceTextField.setText("");
        onRadioButton.setSelected(true);
    }
    
    //load danh sach topping from keyWord
    public void displayToppingList(String keyWord) {
        model.setRowCount(0);
        for(ToppingDTO topping: toppingBUS.search(keyWord)) {
            model.addRow(new Object[] {topping.getToppingId(), topping.getToppingName(), topping.getToppingPrice(), topping.isToppingStatus()});
        }
    }
    
    //check price
    public boolean checkPrice(String price) {
        Double priceTemp = 0.0;
        try {
            priceTemp = Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return false;
        }
        return priceTemp > 0;
    }
}
