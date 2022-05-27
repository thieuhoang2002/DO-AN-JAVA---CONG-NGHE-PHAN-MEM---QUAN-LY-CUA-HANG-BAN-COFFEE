package GUI;

import BUS.AccountBUS;
import BUS.StaffBUS;
import DTO.AccountDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ThieuHoang
 */
public class AccountGUI extends JFrame {
    //khai bao cac bien 
    private JTable accountTable;   //bang account
    private JLabel accountLabel, infoLabel, usernameLabel, passwordLabel, staffidLabel;   //dung de hien thi cac chu nhu "ACCOUNT", "INFOR",...
    private JTextField searchTextField, usernameTextField, passwordTextField; // cac o de nhap "username", "password",...
    private JButton searchButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    private JComboBox cbStaffid;
    DefaultTableModel model = new DefaultTableModel();
    private JScrollPane sTable;
    private String staffID;
    private AccountBUS accountBUS;
    private StaffBUS staffBUS;

    public String getStaffID() {
        return staffID;
    }
    
     // ham nay de viet giao dien 
    private void MainDisplay(){
        this.setTitle("Coffee Shop");
        accountTable = new JTable();
        accountLabel = new JLabel("ACCOUNT");
        accountLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                loadAccountList();
            }
        });
        infoLabel = new JLabel("INFO");
        usernameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        staffidLabel = new JLabel("StaffID:");
        searchTextField = new JTextField();
        usernameTextField = new JTextField();
        passwordTextField = new JTextField();
        staffBUS = new StaffBUS();
        cbStaffid = new JComboBox(staffBUS.getStaffIdList());
        searchButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        accountBUS = new AccountBUS();
        
        accountLabel.setBounds(615, 30,  130, 30); 
        accountLabel.setFont(new Font("Serif", Font.BOLD, 25));
        
        homeButton.setBounds(1230,20,50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBorder(null);
        homeButton.setBackground(new Color(202, 135, 96));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener((ActionEvent e) -> {
           ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
           this.dispose();
        });
        
        logoutButton.setBounds(1030, 560, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149,231,231));
        logoutButton.addActionListener((ActionEvent e) -> {
            usernameTextField.setText("");
            passwordTextField.setText("");
            cbStaffid.setSelectedItem(staffBUS.getStaffIdList().get(0));
        });
        
        addButton.setBounds(960, 630, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149,231,231));
        addButton.addActionListener((ActionEvent e) -> {
            String username = usernameTextField.getText().trim();
            String password = passwordTextField.getText().trim();
            if(username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Full Information!", "Notification", JOptionPane.OK_OPTION);
            } else if (username.length() < 6 || username.length() > 20) {
                JOptionPane.showMessageDialog(this, "Username Must Be Between 6 And 20 Characters!", "Notification", JOptionPane.OK_OPTION);
            } else if (username.contains(" ")) {
                JOptionPane.showMessageDialog(this, "Username Can Not Contain Spaces!", "Notification", JOptionPane.OK_OPTION);
            } else if (password.length() < 7 || password.length() > 20) {
                JOptionPane.showMessageDialog(this, "Password Must Be Between 7 And 20 Characters!", "Notification", JOptionPane.OK_OPTION);
            } else if (password.contains(" ")) {
                JOptionPane.showMessageDialog(this, "Password Can Not Contain Spaces!", "Notification", JOptionPane.OK_OPTION);
            } else if (accountBUS.checkUsername(username)) {
                JOptionPane.showMessageDialog(this, "Username Already Exists!", "Notification", JOptionPane.OK_OPTION);
            } else {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Insert This Account To Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, accountBUS.insert(new AccountDTO(username, password, cbStaffid.getSelectedItem().toString())), "Notification", JOptionPane.OK_OPTION);
                    loadAccountList();
                }
            }
        });
        
        editButton.setBounds(1030, 630, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149,231,231));
        editButton.addActionListener((ActionEvent e) -> {
            int i = accountTable.getSelectedRow();
            if (i >= 0) {
                String oldUsername = model.getValueAt(i, 0).toString();
                String username = usernameTextField.getText().trim();
                String password = passwordTextField.getText().trim();
                if(username.equalsIgnoreCase("") || password.equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Please Enter Full Information!", "Notification", JOptionPane.OK_OPTION);
                } else if (username.length() < 6 || username.length() > 20) {
                    JOptionPane.showMessageDialog(this, "Username Must Be Between 6 And 20 Characters!", "Notification", JOptionPane.OK_OPTION);
                } else if (username.contains(" ")) {
                    JOptionPane.showMessageDialog(this, "Username Can Not Contain Spaces!", "Notification", JOptionPane.OK_OPTION);
                } else if (password.length() < 7 || password.length() > 20) {
                    JOptionPane.showMessageDialog(this, "Password Must Be Between 7 And 20 Characters!", "Notification", JOptionPane.OK_OPTION);
                } else if (password.contains(" ")) {
                    JOptionPane.showMessageDialog(this, "Password Can Not Contain Spaces!", "Notification", JOptionPane.OK_OPTION);
                } else {
                    int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Update This Account In Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                    if (result == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(this, accountBUS.update(new AccountDTO(username, password, cbStaffid.getSelectedItem().toString()), oldUsername), "Notification", JOptionPane.OK_OPTION);
                        loadAccountList();
                    }
                }
            }
        });
        
        deleteButton.setBounds(1100, 630, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149,231,231));
        deleteButton.addActionListener((ActionEvent e) -> {
            int i = accountTable.getSelectedRow();
            if (i >= 0) {
                int result = JOptionPane.showConfirmDialog(this, "Are You Sure You Want To Delete This Account In Database?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this, accountBUS.delete(model.getValueAt(i, 0).toString()), "Notification", JOptionPane.OK_OPTION);
                    loadAccountList();
                } 
            }
        });
        
        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149,231,231));
        searchButton.addActionListener((ActionEvent e) -> {
            if(searchTextField.getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Empty Search Box!", "Notification", JOptionPane.OK_OPTION);
            } else {
                loadAccountList(searchTextField.getText().trim());
            }
        });
        
        accountTable.setModel(model);
        sTable = new JScrollPane(accountTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sTable.setBounds(110,95,615,500);
        model.addColumn("Username");
        model.addColumn("Password");
        model.addColumn("StaffID");
        
        //dang ki su kien click chuot cho table
        accountTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int i = accountTable.getSelectedRow();
                if(i >= 0) {
                    usernameTextField.setText(model.getValueAt(i, 0).toString());
                    passwordTextField.setText(model.getValueAt(i, 1).toString());
                    cbStaffid.setSelectedItem(model.getValueAt(i, 2).toString());
                }
            }
        });
        
        loadAccountList();
        
        infoLabel.setBounds(1010, 150, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22)); 
        
        usernameLabel.setBounds(840, 220, 120, 25);
        usernameLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        passwordLabel.setBounds(840, 270, 120, 25);
        passwordLabel.setFont(new Font("Serif", Font.BOLD, 22));  
        
        staffidLabel.setBounds(840, 320, 120, 25);
        staffidLabel.setFont(new Font("Serif", Font.BOLD, 22));
        
        usernameTextField.setBounds(960, 220, 240, 25);
        passwordTextField.setBounds(960, 270, 240, 25);
        cbStaffid.setBounds(960, 320, 240, 25);
        searchTextField.setBounds(110, 640, 545, 30);
        
        this.add(accountLabel);
        this.add(homeButton);
        this.add(logoutButton);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
        this.add(searchButton);
        this.add(sTable);
        this.add(infoLabel);
        this.add(usernameLabel);
        this.add(passwordLabel);
        this.add(usernameTextField);
        this.add(passwordTextField);
        this.add(searchTextField);
        this.add(staffidLabel);
        this.add(cbStaffid);
        this.setSize(1300,760); 
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(202, 135, 96)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);
        this.setVisible(true);
        this.setResizable(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
                dispose();
            }
        });
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));

    }
    
    public AccountGUI(String staffID){
        this.staffID = staffID;
        MainDisplay();
    }
    
    //load account list to table
    public void loadAccountList() {
        model.setRowCount(0);
        accountBUS.resetList();
        for(AccountDTO account: accountBUS.getAccountList()) {
            model.addRow(new Object[] {account.getUsername(), account.getPassword(), account.getStaffId()});
        }
    }
    
    //load account list to table
    public void loadAccountList(String keyWord) {
        model.setRowCount(0);
        accountBUS.resetList();
        for(AccountDTO account: accountBUS.search(keyWord)) {
            model.addRow(new Object[] {account.getUsername(), account.getPassword(), account.getStaffId()});
        }
    }
    
    public static void main(String[] args) {
        AccountGUI o = new AccountGUI("SF001");
    }
}
