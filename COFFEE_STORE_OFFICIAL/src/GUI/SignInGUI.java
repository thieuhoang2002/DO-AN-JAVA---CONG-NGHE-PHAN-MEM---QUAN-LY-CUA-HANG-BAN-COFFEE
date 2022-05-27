package GUI;

import BUS.AccountBUS;
import BUS.StaffBUS;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class SignInGUI extends JFrame{
    //attribute
    private JLabel lUsername, lPassword;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JButton bSignIn;
    private AccountBUS accountBUS;
    private StaffBUS staffBUS;
    
    Color WORD_COLOR = new Color(7, 246, 224);
    
    //constructor
    public SignInGUI() {
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JLabel getlUsername() {
        return lUsername;
    }

    public void setlUsername(JLabel lUsername) {
        this.lUsername = lUsername;
    }

    public JLabel getlPassword() {
        return lPassword;
    }

    public void setlPassword(JLabel lPassword) {
        this.lPassword = lPassword;
    }

    public StaffBUS getStaffBUS() {
        return staffBUS;
    }

    public void setStaffBUS(StaffBUS staffBUS) {
        this.staffBUS = staffBUS;
    }

    public JTextField getTfUsername() {
        return tfUsername;
    }

    public void setTfUsername(JTextField tfUsername) {
        this.tfUsername = tfUsername;
    }

    public JTextField getTfPassword() {
        return tfPassword;
    }

    public void setTfPassword(JPasswordField tfPassword) {
        this.tfPassword = tfPassword;
    }

    public JButton getbSignIn() {
        return bSignIn;
    }

    public void setbSignIn(JButton signIn) {
        this.bSignIn = signIn;
    }

    public AccountBUS getAccountBUS() {
        return accountBUS;
    }

    public void setAccountBUS(AccountBUS accountBUS) {
        this.accountBUS = accountBUS;
    }
    
    //method
    private void init() {
        this.setStaffBUS(new StaffBUS());
        this.setAccountBUS(new AccountBUS());
        //Tao khung chua chung
        this.setTitle("Sign In Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
        this.setSize(new Dimension(700, 475));
        this.setLayout(null);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        //Tao background
        ImageIcon bg = new ImageIcon("Resource\\bg.png");
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg.getImage(), 0, 0, 700, 438, null);
            }

            @Override
            public void setLayout(LayoutManager mgr) {
                mgr = null;
                super.setLayout(mgr);
            }
        });
        
        //Set components
        //username
        this.setlUsername(new JLabel("username"));
        this.getlUsername().setForeground(WORD_COLOR);
        this.getlUsername().setFont(new Font("Arial", Font.BOLD, 18));
        this.getlUsername().setBounds(360, 90, 200, 30);
        
        this.setTfUsername(new JTextField(25));
        this.getTfUsername().setBounds(360, 125, 200, 30);
        this.getTfUsername().setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        this.getTfUsername().setBorder(BorderFactory.createLineBorder(new Color(246, 91, 7), 2));
        
        //password
        this.setlPassword(new JLabel("password"));
        this.getlPassword().setForeground(WORD_COLOR);
        this.getlPassword().setFont(new Font("Arial", Font.BOLD, 18));
        this.getlPassword().setBounds(360, 180, 200, 30);
        
        this.setTfPassword(new JPasswordField(10));
        this.getTfPassword().setBounds(360, 215, 200, 30);
        this.getTfPassword().setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 16));
        this.getTfPassword().setBorder(BorderFactory.createLineBorder(new Color(246, 91, 7), 2));
        
        this.setbSignIn(new JButton("Sign in"));
        this.getbSignIn().setBounds(410, 280, 80, 40);
        this.getbSignIn().setFocusPainted(false);
        this.getbSignIn().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getbSignIn().setBackground(WORD_COLOR);
        this.getbSignIn().setFont(new Font("Arial", Font.BOLD, 15));
        this.getbSignIn().setCursor(new Cursor(HAND_CURSOR));
        this.getbSignIn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getbSignIn().setFont(new Font("Arial", Font.BOLD, 17));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbSignIn().setFont(new Font("Arial", Font.BOLD, 15));
            }
        });
        this.getbSignIn().addActionListener((ActionEvent e) -> {
            if (this.getTfUsername().getText().equalsIgnoreCase("") || this.getTfPassword().getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(this, "Please Enter Full Information!", "Messege Sign In", JOptionPane.OK_OPTION);
            } else if (this.getTfUsername().getText().trim().length() < 6 || this.getTfUsername().getText().trim().length() > 20) {
                JOptionPane.showMessageDialog(this, "Username Must Be Between 6 And 20 Characters!", "Messege Sign In", JOptionPane.OK_OPTION);
            } else if (this.getTfUsername().getText().trim().contains(" ")) {
                JOptionPane.showMessageDialog(this, "Username Can Not Contain Spaces!", "Messege Sign In", JOptionPane.OK_OPTION);
            } else if (this.getTfPassword().getText().trim().length() < 7 || this.getTfPassword().getText().trim().length() > 20) {
                JOptionPane.showMessageDialog(this, "Password Must Be Between 7 And 20 Characters!", "Messege Sign In", JOptionPane.OK_OPTION);
            } else if (this.getTfPassword().getText().trim().contains(" ")) {
                JOptionPane.showMessageDialog(this, "Password Can Not Contain Spaces!", "Messege Sign In", JOptionPane.OK_OPTION);
            } else {
                if(this.getAccountBUS().checkAccount(this.getTfUsername().getText().trim(), this.getTfPassword().getText().trim())) {
                    String staffID = this.getAccountBUS().getStaffID(this.getTfUsername().getText().trim(), this.getTfPassword().getText().trim());
                    if(this.getStaffBUS().checkPosition(staffID)) {
                        this.dispose();
                        ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(staffID);
                    } else {
                        this.dispose();
                        SellMenuGUI sellMenuGUI = new SellMenuGUI(staffID);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Username Or Password Incorrect!", "Messege Sign In", JOptionPane.OK_OPTION);
                }
            }
        });
        
        //bSign in
        
        //add
        this.add(this.getlUsername());
        this.add(this.getTfUsername());
        this.add(this.getlPassword());
        this.add(this.getTfPassword());
        this.add(this.getbSignIn());
    }
    
    //main
    public static void main(String[] args) {
        SignInGUI signIn = new SignInGUI();
    }
}
