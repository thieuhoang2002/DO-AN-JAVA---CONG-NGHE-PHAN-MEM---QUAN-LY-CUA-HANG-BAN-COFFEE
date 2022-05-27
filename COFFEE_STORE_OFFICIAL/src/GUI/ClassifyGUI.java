package GUI;

import ApplicationHelper.ClassifyID;
import BUS.ClassifyBUS;
import DTO.ClassifyDTO;
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
public class ClassifyGUI extends JFrame {

    //khai bao cac bien 
    private JTable classifyTable;   //cai bang loai san pham
    private JLabel classifyLabel, infoLabel, idLabel, nameLabel, statusLabel;   //dung de hien thi cac chu nhu "CLASSIFY", "INFOR",...
    private JTextField searchTextField, idTextField, nameTextField; // cac o de nhap "Name", "id",...
    private JButton searchButton, saveButton, addButton, editButton, //cac nut chuc nang
            deleteButton, logoutButton, homeButton;
    private JRadioButton onRadioButton, offRadioButton;
    DefaultTableModel model = new DefaultTableModel();
    private JPanel jpanel = new JPanel();
    private ClassifyBUS classifyBUS = new ClassifyBUS();
    private String staffID;

    public ClassifyGUI(String staffId) {
        staffID = staffId;
        MainDisplay();
        classifyTable.setModel(model);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Status");
        LoadDataFromDatabase();
    }

    // ham nay de viet giao dien 
    public void MainDisplay() {
        //dat ten cho jframe, set icon va khoi tao cac doi tuong 
        this.setTitle("Coffee Shop");
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));
        classifyTable = new JTable();
        classifyLabel = new JLabel("CLASSIFY");
        infoLabel = new JLabel("INFO");
        idLabel = new JLabel("ID:");
        nameLabel = new JLabel("Name:");
        statusLabel = new JLabel("Status:");
        searchTextField = new JTextField("ID, NAME, STATUS");
        idTextField = new JTextField();
        idTextField.setEditable(false);
        nameTextField = new JTextField();
        searchButton = new JButton();
        saveButton = new JButton();
        addButton = new JButton();
        editButton = new JButton();
        deleteButton = new JButton();
        logoutButton = new JButton();
        homeButton = new JButton();
        onRadioButton = new JRadioButton("On");
        offRadioButton = new JRadioButton("Off");
        //setup cac doi tuong vua duoc khoi tao o tren
        //chu "CLASSIFY"
        classifyLabel.setBounds(615, 30, 130, 30);
        classifyLabel.setFont(new Font("Serif", Font.BOLD, 25));
        //nut Home
        homeButton.setBounds(1230, 20, 50, 50);
        homeButton.setIcon(new ImageIcon("Resource\\home-icon.png"));
        homeButton.setBorder(null);
        homeButton.setBackground(new Color(202, 135, 96));
        homeButton.setFocusPainted(false);
        homeButton.addActionListener((ActionEvent e) -> {
            ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(this.staffID);
            this.dispose();
        });
        //nut Save
        saveButton.setBounds(1030, 560, 50, 50);
        saveButton.setIcon(new ImageIcon("Resource\\save-icon.png"));
        saveButton.setBackground(new Color(149, 231, 231));
        //nut Them
        addButton.setBounds(1000, 630, 50, 50);
        addButton.setIcon(new ImageIcon("Resource\\add-1-icon.png"));
        addButton.setBackground(new Color(149, 231, 231));
        //nut Sua
        editButton.setBounds(1070, 630, 50, 50);
        editButton.setIcon(new ImageIcon("Resource\\edit-icon.png"));
        editButton.setBackground(new Color(149, 231, 231));
        //nut Xoa
        deleteButton.setBounds(1100, 630, 50, 50);
        deleteButton.setIcon(new ImageIcon("Resource\\trash-icon.png"));
        deleteButton.setBackground(new Color(149, 231, 231));
        //nut thoat
        logoutButton.setBounds(1100, 560, 50, 50);
        logoutButton.setIcon(new ImageIcon("Resource\\close-icon.png"));
        logoutButton.setBackground(new Color(149, 231, 231));
        //nut tim kiem
        searchButton.setBounds(675, 630, 50, 50);
        searchButton.setIcon(new ImageIcon("Resource\\search-icon.png"));
        searchButton.setBackground(new Color(149, 231, 231));
        //day la bang de hien thi danh sach classify
        classifyTable.setBounds(110, 95, 615, 500);
        // day la chu "INFO"
        infoLabel.setBounds(1020, 150, 120, 25);
        infoLabel.setFont(new Font("Serif", Font.BOLD, 22));
        // day la chu ID
        idLabel.setBounds(850, 220, 120, 25);
        idLabel.setFont(new Font("Serif", Font.BOLD, 22));
        // chu NAME
        nameLabel.setBounds(850, 270, 120, 25);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 22));
        // chu STATUS
        statusLabel.setBounds(850, 320, 120, 25);
        statusLabel.setFont(new Font("Serif", Font.BOLD, 22));
        // TextField la o de nhap
        idTextField.setBounds(950, 220, 240, 25);
        nameTextField.setBounds(950, 270, 240, 25);
        searchTextField.setBounds(110, 640, 545, 30);
        //nay la cac o de tich chon, chi chon duoc 1 trong 2, dung cai nay phai Group lai moi chuan
        onRadioButton.setBounds(950, 320, 50, 25);
        onRadioButton.setSelected(true);
        offRadioButton.setBounds(950, 370, 50, 25);
        ButtonGroup radiobuttongroup = new ButtonGroup();
        radiobuttongroup.add(onRadioButton);
        radiobuttongroup.add(offRadioButton);
        //add cai table vao thanh truot, them thanh truot vao cai JPanel
        JScrollPane sp = new JScrollPane(classifyTable);
        jpanel.setBounds(110, 95, 615, 500);
        jpanel.add(sp, BorderLayout.CENTER);
        jpanel.setLayout(new GridLayout(1, 1));
        //add tat ca vao JFrame
        this.add(classifyLabel);
        this.add(homeButton);
//        this.add(saveButton);
        this.add(addButton);
        this.add(editButton);
//        this.add(deleteButton);
//        this.add(logoutButton);
        this.add(searchButton);
        this.add(jpanel);
        this.add(infoLabel);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(idTextField);
        this.add(nameTextField);
        this.add(searchTextField);
        this.add(onRadioButton);
        this.add(offRadioButton);
        this.add(statusLabel);
        this.setSize(1300, 760); //size cua JFrame
        this.setLocationRelativeTo(null); //set cai nay de khi chay thi chuong trinh hien ra giua man hinh ne
        this.getContentPane().setBackground(new Color(202, 135, 96)); //set mau cho JFrame bang bang mau RGB
        this.setLayout(null);// hong dung layout thi moi set vi tri thu cong duoc
        this.setVisible(true); // nay la bat buoc phai co de hien thi JFrame
        this.setResizable(false);// nay la hong cho phep phong to thu nho JFrame
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
                dispose();
            }
        });//nay la de khi an dau X tat chuong trinh thi chuong trinh tat han luon
        //xu ly su kien
        //day la xu ly su kien click chuot khi minh click vao 1 dong tren table
        classifyTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                staffTableMouseClicked(evt);
            }

            private void staffTableMouseClicked(MouseEvent evt) {
                int i = classifyTable.getSelectedRow(); //i nay la vi tri dong minh dang click, vidu click vao dong dau tien thi i = 0
                if (i >= 0) {
                    idTextField.setText(model.getValueAt(i, 0).toString());//(i, 0) thi i la dong, 0 la cot
                    nameTextField.setText(model.getValueAt(i, 1).toString());
                    if (model.getValueAt(i, 2).toString().equalsIgnoreCase("true")) { //equalsIg... la so sanh chuoi ki tu
                        onRadioButton.setSelected(true);
                    } else {
                        offRadioButton.setSelected(true);
                    }
                }
            }
        });

        //su kien reset de tra lai cac textfile trong, de thuc hien them moi, hong thi an vao CLASSIFY cung duoc
        infoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                infoLabelClicked(evt);
            }

            private void infoLabelClicked(MouseEvent evt) {
                int i = classifyTable.getSelectedRow();
                if (i >= 0) {
                    idTextField.setText("");
                    nameTextField.setText("");
                    onRadioButton.setSelected(false);
                    offRadioButton.setSelected(false);
                }
            }
        });
        // nhan vao chu CLASSIFY de reset
        classifyLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                infoLabelClicked(evt);
            }

            private void infoLabelClicked(MouseEvent evt) {
                idTextField.setText("");
                nameTextField.setText("");
                onRadioButton.setSelected(false);
                offRadioButton.setSelected(false);
                int a = model.getRowCount();
                while (a > 0) { //vong lap nay de xoa di het dong tren bang roi LoadData... de phuc hoi lai
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
                if (nameTextField.getText().equalsIgnoreCase("")) { //nay la o NAME khong duoc de trong
                    JOptionPane.showMessageDialog(rootPane, "Name cannot be left blank!");
                } else if (checkClassifyName(nameTextField.getText()) == false) {//nay la kiem tra NAME co bi trung hay khong
                    JOptionPane.showMessageDialog(rootPane, "ClassifyName cannot match!");
                } else {
                    //nay la them 1 dong moi vao table truoc roi moi them vao csdl
                    ClassifyBUS o = new ClassifyBUS();
                    Vector<ClassifyDTO> list = new Vector<>();
                    if (checkClassifyID(idTextField.getText()) == false) {
                        JOptionPane.showMessageDialog(rootPane, "This classify already exists in the database!");
                    } else {
                        String id = ClassifyID.createClassifyID();
                        boolean business = onRadioButton.isSelected();
                        list.add(new ClassifyDTO(id, nameTextField.getText(), business));
                        int i = list.size() - 1;
                        for (int a = 0; a <= i; a++) {
                            ClassifyDTO classify = list.get(a);
                            model.addRow(new Object[]{classify.getClassifyId(), classify.getClassifyName(), classify.isClassifyBusiness()});
                        }
                        //day la them vao csdl
                        int result = JOptionPane.showConfirmDialog(rootPane,
                                "Are you sure you want to save this classify?",
                                "Confirm",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            o.insert(list.get(list.size() - 1));
                            //vong lap if nay de kiem tra xem cac the loai o trang thai "true" co qua 10 hay khong, qua 10 la khong duoc
                            if (classifyBUS.count() > 10) {
                                JOptionPane.showMessageDialog(rootPane, "Do not trade more than 10 product classifies at the same time!");
                                o.update1(list.get(list.size() - 1).getClassifyId());
                                int a = model.getRowCount();
                                while (a > 0) {
                                    model.removeRow(a - 1);
                                    a--;
                                }
                                LoadDataFromDatabase();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Added!");
                            }
                        } else if (result == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(rootPane, "Not yet added!");
							int a = model.getRowCount();
                            while (a > 0) {
                                model.removeRow(a - 1);
                                a--;
                            }
                            LoadDataFromDatabase();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Not yet added!");
                        }
                    }
                }
            }

        });

        //sua -- ham nay phuc tap, can xu ly khi sua, neu trung id thi duoc phep trung ten, khac id thi khong duoc phep trung ten- giai 
        // phap thay the la them ki tu (2) vao sau ten the loai
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editButtonPeformed(e);
            }

            private void editButtonPeformed(ActionEvent e) {
                int i = classifyTable.getSelectedRow();
                if (i >= 0) {
                    if (nameTextField.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(rootPane, "Name cannot be left blank!");
                    } else if (checkClassifyName(nameTextField.getText()) == false) {
                        int result2 = JOptionPane.showConfirmDialog(rootPane, "Are you sure about this change?", "Confirm?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (result2 == JOptionPane.YES_OPTION) {
                            if (!nameTextField.getText().equals(model.getValueAt(i, 1).toString())) {
                                nameTextField.setText(nameTextField.getText() + "(2)");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Change business status only or change nothing!");
                            }
                            int result = JOptionPane.showConfirmDialog(rootPane,
                                    "Are you sure you want to update this classify '" + model.getValueAt(i, 1).toString() + "'?",
                                    "Confirm",
                                    JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE);
                            if (result == JOptionPane.YES_OPTION) {
                                ClassifyBUS o = new ClassifyBUS();
                                if (onRadioButton.isSelected()) {
                                    o.update(model.getValueAt(i, 0).toString());
                                }
                                if (offRadioButton.isSelected()) {
                                    o.update1(model.getValueAt(i, 0).toString());
                                }
                                int b = model.getRowCount();
                                while (b > 0) {
                                    model.removeRow(b - 1);
                                    b--;
                                }
                                LoadDataFromDatabase();
                                if (classifyBUS.count() > 10) {
                                    JOptionPane.showMessageDialog(rootPane, "Do not trade more than 10 product classifies at the same time!");
                                    o.update1(model.getValueAt(i, 0).toString());
                                    int a = model.getRowCount();
                                    while (a > 0) {
                                        model.removeRow(a - 1);
                                        a--;
                                    }
                                    LoadDataFromDatabase();
                                } else {
                                    JOptionPane.showMessageDialog(rootPane, "Updated!");
                                }
                            } else if (result == JOptionPane.NO_OPTION) {
                                JOptionPane.showMessageDialog(rootPane, "Not update!");
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Not update!");
                            }
                        } else if (result2 == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(rootPane, "Not update!");
                        }
                    } else {
                        int result = JOptionPane.showConfirmDialog(rootPane,
                                "Are you sure you want to update this classify '" + model.getValueAt(i, 1).toString() + "'?",
                                "Confirm",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE);
                        if (result == JOptionPane.YES_OPTION) {
                            ClassifyBUS o = new ClassifyBUS();
                            o.update2(model.getValueAt(i, 0).toString(), nameTextField.getText());
                            if (onRadioButton.isSelected()) {
                                o.update(model.getValueAt(i, 0).toString());
                            }
                            if (offRadioButton.isSelected()) {
                                o.update1(model.getValueAt(i, 0).toString());
                            }
                            int b = model.getRowCount();
                            while (b > 0) {
                                model.removeRow(b - 1);
                                b--;
                            }
                            LoadDataFromDatabase();
                            if (classifyBUS.count() > 10) {
                                JOptionPane.showMessageDialog(rootPane, "Do not trade more than 10 product classifies at the same time!");
                                o.update1(model.getValueAt(i, 0).toString());
                                int a = model.getRowCount();
                                while (a > 0) {
                                    model.removeRow(a - 1);
                                    a--;
                                }
                                LoadDataFromDatabase();

                            } else {
                                JOptionPane.showMessageDialog(rootPane, "Updated!");
                            }
                        } else if (result == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(rootPane, "Not update!");
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Not update!");
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "This classify does not exist in the database!");
                }
            }
        });

        //
        searchTextField.addMouseListener(
                new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                searchTextField.setText("");
            }
        }
        );
        //tim kiem theo Keyword
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButtonPeformed(e);
            }

            private void showStaffListFromKeyWord(String keyWord) {
                ClassifyBUS o = new ClassifyBUS();
                o.resetList();
                model.setRowCount(0);
                for (ClassifyDTO classify : o.getClassifyList(keyWord)) {
                    model.addRow(new Object[]{classify.getClassifyId(), classify.getClassifyName(), classify.isClassifyBusiness()});
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

    //load dữ liệu lên bảng
    public void LoadDataFromDatabase() {
        ClassifyBUS o = new ClassifyBUS();
        Vector<ClassifyDTO> list = o.readClassifyListFromDatabase();
        int i = list.size() - 1;
        for (int a = 0; a <= i; a++) {
            ClassifyDTO classify = list.get(a);
            model.addRow(new Object[]{classify.getClassifyId(), classify.getClassifyName(), classify.isClassifyBusiness()});
        }
    }

    //ham check trung ten the loai
    public boolean checkClassifyName(String name) {
        Vector<String> s = classifyBUS.ClassifyName();
        int a = s.size() - 1;
        for (int i = 0; i <= a; i++) {
            if (s.get(i).equals(name)) {
                return false;
            }
        }
        return true;
    }

    //ham check trung id
    public boolean checkClassifyID(String id) {
        Vector<String> s = new ClassifyBUS().getClassifyID();
        int a = s.size() - 1;
        for (int i = 0; i <= a; i++) {
            if (s.get(i).equals(id)) {
                return false;
            }
        }
        return true;
    }
}
