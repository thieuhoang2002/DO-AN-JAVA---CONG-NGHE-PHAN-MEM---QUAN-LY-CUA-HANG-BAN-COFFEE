package GUI;

import ApplicationHelper.MyDate;
import ApplicationHelper.StaffID;
import DTO.StaffDTO;
import BUS.StaffBUS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ThieuHoang
 */
public class StaffGUI extends JFrame {

    //khai bao cac bien 
    private JTable staffTable = new JTable();   //bang hien thi nhan vien
    private JLabel staffLabel, infoLabel, idLabel, nameLabel, birthdayLabel, addressLabel,
            phoneLabel, positionLabel;   //dung de hien thi cac chu nhu "STAFF", "INFOR",...
    private JTextField searchTextField, idTextField, nameTextField, birthdayTextField,
            addressTextField, phoneTextField, positionTextField; // cac o de nhap "Name", "id",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    DefaultTableModel model = new DefaultTableModel();
    private JPanel jpanel = new JPanel();
    private String staffID;

    public StaffGUI(String staffID) {
        this.staffID = staffID;
        MainDisplay();
        staffTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Birthday");
        model.addColumn("Address");
        model.addColumn("Phone");
        model.addColumn("Position");
        LoadDataFromDatabase();

    }

    public String getStaffID() {
        return staffID;
    }

    // ham nay de viet giao dien 
    public void MainDisplay() {
        //khởi tạo
        this.setTitle("Coffee Shop");
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));
        staffLabel = new JLabel("STAFF");
        infoLabel = new JLabel("INFO");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        birthdayLabel = new JLabel("Birthday:");
        addressLabel = new JLabel("Address:");
        phoneLabel = new JLabel("Phone:");
        positionLabel = new JLabel("Position:");
        searchTextField = new JTextField("ID,NAME,POSITION");
        idTextField = new JTextField();
        idTextField.setEditable(false);
        nameTextField = new JTextField();
        birthdayTextField = new JTextField();
        addressTextField = new JTextField();
        phoneTextField = new JTextField();
        positionTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        //setting
        staffLabel.setBounds(615, 30, 130, 30);
        staffLabel.setFont(new Font("Serif", Font.BOLD, 25));

        homeButton.setBounds(1230, 20, 50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBorder(null);
        homeButton.setBackground(new Color(202, 135, 96));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener((ActionEvent e) -> {
            ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(this.staffID);
            this.dispose();
        });

        saveButton.setBounds(1030, 560, 50, 50);
        saveButton.setIcon(new ImageIcon("Resource\\save-icon.png"));
        saveButton.setBackground(new Color(149, 231, 231));

        addButton.setBounds(960, 630, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149, 231, 231));

        editButton.setBounds(1030, 630, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149, 231, 231));

        deleteButton.setBounds(1100, 630, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149, 231, 231));

        logoutButton.setBounds(1100, 560, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149, 231, 231));

        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149, 231, 231));

//        staffTable.setBounds(110, 95, 615, 500);
        infoLabel.setBounds(1020, 120, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22));

        idLabel.setBounds(850, 170, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));

        nameLabel.setBounds(850, 220, 120, 25);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22));

        birthdayLabel.setBounds(850, 270, 120, 25);
        birthdayLabel.setFont(new Font("Serif", Font.BOLD, 22));

        addressLabel.setBounds(850, 320, 120, 25);
        addressLabel.setFont(new Font("Serif", Font.BOLD, 22));

        phoneLabel.setBounds(850, 370, 120, 25);
        phoneLabel.setFont(new Font("Serif", Font.BOLD, 22));

        positionLabel.setBounds(850, 420, 120, 25);
        positionLabel.setFont(new Font("Serif", Font.BOLD, 22));

        idTextField.setBounds(950, 170, 240, 25);
        nameTextField.setBounds(950, 220, 240, 25);
        birthdayTextField.setBounds(950, 270, 240, 25);
        addressTextField.setBounds(950, 320, 240, 25);
        phoneTextField.setBounds(950, 370, 240, 25);
        positionTextField.setBounds(950, 420, 240, 25);

        searchTextField.setBounds(110, 640, 545, 30);
        JScrollPane sp = new JScrollPane(staffTable);
        jpanel.setBounds(110, 95, 615, 500);
        jpanel.add(sp, BorderLayout.CENTER);
        jpanel.setLayout(new GridLayout(1, 1));
        this.add(staffLabel);
        this.add(homeButton);
//        this.add(saveButton);
        this.add(addButton);
        this.add(editButton);
        this.add(deleteButton);
//        this.add(logoutButton);
        this.add(searchButton);
        this.add(jpanel);
        this.add(infoLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(idTextField);
        this.add(nameTextField);
        this.add(searchTextField);
        this.add(birthdayLabel);
        this.add(birthdayTextField);
        this.add(addressLabel);
        this.add(addressTextField);
        this.add(phoneLabel);
        this.add(phoneTextField);
        this.add(positionLabel);
        this.add(positionTextField);
        this.setSize(1300, 760);
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

        //them su kien
        staffTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                staffTableMouseClicked(evt);
            }

            private void staffTableMouseClicked(MouseEvent evt) {
                int i = staffTable.getSelectedRow();
                if (i >= 0) {
                    idTextField.setText(model.getValueAt(i, 0).toString());
                    nameTextField.setText(model.getValueAt(i, 1).toString());
                    birthdayTextField.setText(model.getValueAt(i, 2).toString());
                    addressTextField.setText(model.getValueAt(i, 3).toString());
                    phoneTextField.setText(model.getValueAt(i, 4).toString());
                    positionTextField.setText(model.getValueAt(i, 5).toString());
                }
            }
        });
        //su kien reset
        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                infoLabelClicked(evt);
            }

            private void infoLabelClicked(MouseEvent evt) {
                int i = staffTable.getSelectedRow();
                if (i >= 0) {
                    idTextField.setText("");
                    nameTextField.setText("");
                    birthdayTextField.setText("");
                    addressTextField.setText("");
                    phoneTextField.setText("");
                    positionTextField.setText("");
                }
            }
        });
        // nhan vao chu STAFF de reset
        staffLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                infoLabelClicked(evt);
            }

            private void infoLabelClicked(MouseEvent evt) {
                idTextField.setText("");
                nameTextField.setText("");
                birthdayTextField.setText("");
                addressTextField.setText("");
                phoneTextField.setText("");
                positionTextField.setText("");
                int a = model.getRowCount();
                while (a > 0) {
                    model.removeRow(a - 1);
                    a--;
                }
                LoadDataFromDatabase();
            }
        });
        //them
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                addButtonActionPerformed(evt);

            }

            private void addButtonActionPerformed(ActionEvent evt) {
                String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d){3}(\\s|\\.)?(\\d){3}$";

                if (nameTextField.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(rootPane, "Name cannot be left blank!");
                } else if (!phoneTextField.getText().matches(reg)) {
                    JOptionPane.showMessageDialog(rootPane, "Phone number format is not correct!");
                } else if (BirthdayCheck(birthdayTextField.getText()) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Please enter the correct format! For example: 09/03/2002");
                } else if (OldCheck(birthdayTextField.getText()) == false) {
                    JOptionPane.showMessageDialog(rootPane, "Employees under 18 years old!");
                } else {
                    StaffBUS o = new StaffBUS();
                    Vector<StaffDTO> list = new Vector<>();
                    String d = birthdayTextField.getText();//nhập "20/12/2002"
                    MyDate t = new MyDate();
                    String b = t.format(d);
                    MyDate mydate = new MyDate(b);
                    if (checkStaffID(idTextField.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "This employee already exists in the database!");
                    } else {
                        String id = StaffID.createStaffID();
                        list.add(new StaffDTO(id, nameTextField.getText(), mydate,
                                addressTextField.getText(), phoneTextField.getText(), positionTextField.getText()));
                        int i = list.size() - 1;
                        for (int a = 0; a <= i; a++) {
                            StaffDTO staff = list.get(a);
                            model.addRow(new Object[]{staff.getStaffId(), staff.getStaffName(), staff.getStaffBirthday(), staff.getStaffAddress(), staff.getNumberPhone(), staff.getPosition()});
                        }
                        int result = JOptionPane.showConfirmDialog(rootPane,
                                "Are you sure you want to save this employee?",
                                "Confirm",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            o.insert(list.get(list.size() - 1));
                            JOptionPane.showMessageDialog(rootPane, "Added!");
                        } else if (result == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(rootPane, "Not yet added!");
                            model.removeRow(model.getRowCount() - 1);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Not yet added!");
                            model.removeRow(model.getRowCount() - 1);
                        }
                    }
                }
            }

        });

        //xoa
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteButtonPeformed(e);
            }

            private void deleteButtonPeformed(ActionEvent e) {
                int i = staffTable.getSelectedRow();
                if (i >= 0) {
                    StaffBUS o = new StaffBUS();
                    int result = JOptionPane.showConfirmDialog(rootPane,
                            "Are you sure you want to delete this employee?" + model.getValueAt(i, 1).toString(),
                            "Confirm",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE);
                    if (result == JOptionPane.YES_OPTION) {
                        o.delete(model.getValueAt(i, 0).toString());
                        model.removeRow(i);
                        idTextField.setText("");
                        nameTextField.setText("");
                        birthdayTextField.setText("");
                        addressTextField.setText("");
                        phoneTextField.setText("");
                        positionTextField.setText("");
                        JOptionPane.showMessageDialog(rootPane, "Deleted!");
                    } else if (result == JOptionPane.NO_OPTION) {
                        JOptionPane.showMessageDialog(rootPane, "Not deleted yet!");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Not deleted yet!");
                    }

                }

            }
        });

        //sua
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonPeformed(e);
            }

            private void editButtonPeformed(ActionEvent e) {
                String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d){3}(\\s|\\.)?(\\d){3}$";
                int i = staffTable.getSelectedRow();
                if (i >= 0) {
                    if (nameTextField.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(rootPane, "Name cannot be left blank!");
                    } else if (!phoneTextField.getText().matches(reg)) {
                        JOptionPane.showMessageDialog(rootPane, "Phone number format is not correct!");
                    } else if (BirthdayCheck(birthdayTextField.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "Please enter the correct format! For example: 09/03/2002");
                    } else if (OldCheck(birthdayTextField.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "Employees under 18 years old!");
                    } else {
                        int result = JOptionPane.showConfirmDialog(rootPane,
                                "Are you sure you want to update this employee?" + model.getValueAt(i, 1).toString(),
                                "Confirm",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            StaffBUS o = new StaffBUS();
                            o.delete(model.getValueAt(i, 0).toString());
                            model.removeRow(i);
                            Vector<StaffDTO> list = new Vector<>();
                            String d = birthdayTextField.getText(); // nhập "20/12/2002"
                            MyDate t = new MyDate();
                            String aa = t.format(d);
                            MyDate mydate = new MyDate(aa);
                            String id = StaffID.createStaffID();
                            list.add(new StaffDTO(id, nameTextField.getText(), mydate,
                                    addressTextField.getText(), phoneTextField.getText(), positionTextField.getText()));
                            o.insert(list.get(list.size() - 1));
                            int k = list.size() - 1;
                            for (int a = 0; a <= k; a++) {
                                StaffDTO staff = list.get(a);
                                model.addRow(new Object[]{staff.getStaffId(), staff.getStaffName(), staff.getStaffBirthday(), staff.getStaffAddress(), staff.getNumberPhone(), staff.getPosition()});
                            }
                            JOptionPane.showMessageDialog(rootPane, "Updated!");
                        } else if (result == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(rootPane, "Not update!");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Not update!");
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "This employee does not exist in the database!");
                }
            }

        });
        //
        //show product list from keyWord on table

        //
        searchTextField.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTextField.setText("");
            }
        }
        );
        //tim kiem
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonPeformed(e);
            }

            private void showStaffListFromKeyWord(String keyWord) {
                StaffBUS o = new StaffBUS();
                o.resetList();
                model.setRowCount(0);
                for (StaffDTO staff : o.getStaffList(keyWord)) {
                    model.addRow(new Object[]{staff.getStaffId(), staff.getStaffName(), staff.getStaffBirthday(), staff.getStaffAddress(), staff.getNumberPhone(), staff.getPosition()});
                }
            }

            private void searchButtonPeformed(ActionEvent e) {
                if (searchTextField.getText().equalsIgnoreCase("") || searchTextField.getText().equalsIgnoreCase("search product here")) {
                    JOptionPane.showMessageDialog(rootPane, "Empty Search Box!", "Warning", JOptionPane.OK_OPTION);
                } else {
                    showStaffListFromKeyWord(searchTextField.getText());
                }
            }
        });
    }

    // xử lý sự kiện
    //load dữ liệu lên bảng
    public void LoadDataFromDatabase() {
        StaffBUS o = new StaffBUS();
        Vector<StaffDTO> list = o.readStaffListFromDatabase();
        int i = list.size() - 1;
        for (int a = 0; a <= i; a++) {
            StaffDTO staff = list.get(a);
            model.addRow(new Object[]{staff.getStaffId(), staff.getStaffName(), staff.getStaffBirthday(), staff.getStaffAddress(), staff.getNumberPhone(), staff.getPosition()});
        }
    }

    //ham check tuổi
    public boolean OldCheck(String year) {
        year = birthdayTextField.getText();
        String[] s = year.split("/");
        int i = 2022 - Integer.parseInt(s[2]);
        if (i >= 16) {
            return true;
        }
        return false;
    }

    //hàm check ngày tháng năm sinh
    public boolean BirthdayCheck(String ns) {
        ns = birthdayTextField.getText();
        if (ns.isEmpty()) {
            return false;
        } else {
            if (ns.codePointAt(2) != 47 || ns.codePointAt(5) != 47) {
                return false;
            } else {
                String[] s = ns.split("/");
                if (s[0].length() != 2 || s[1].length() != 2 || s[2].length() != 4) {
                    return false;
                } else {
                    return true;
                }
            }
        }
    }

    //ham check trung id
    public boolean checkStaffID(String id) {
        Vector<String> s = new StaffBUS().getStaffID();
        int a = s.size() - 1;
        for (int i = 0; i <= a; i++) {
            if (s.get(i).equals(id)) {
                return false;
            }
        }
        return true;
    }
}
