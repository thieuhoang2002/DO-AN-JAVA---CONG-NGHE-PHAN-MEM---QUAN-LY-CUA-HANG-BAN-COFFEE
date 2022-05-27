package GUI;

import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public final class ChoiceMenuOfToppingGUI extends JPanel {
    //attribute
    JPanel pCenter;
    JLabel toppingName;
    JButton btnAdd, btnSub;
    JTextField tfQuantity;
    String toppingId;
    
    Color BACKGROUND_COLOR = new Color(175, 136, 110);
    //constructor
    public ChoiceMenuOfToppingGUI(String toppingId, String actionCommand1, String actionCommand2, ChoiceMenuOfProductGUI choiceProduct) {
        this.toppingId = toppingId;
        //Tao khung chua chung
        this.setLayout(new GridLayout(1, 2));
        this.setBackground(BACKGROUND_COLOR);
        this.setBorder(new EmptyBorder(0, 5, 2, 5));
        
        //Them cac thanh phan vao panel topping
        this.toppingName = new JLabel(choiceProduct.getSellGUI().getSellBUS().getToppingBUS().getToppingFromId(toppingId).getToppingName());
        
        this.pCenter = new JPanel();
        this.pCenter.setBackground(BACKGROUND_COLOR);
        this.pCenter.setLayout(new GridLayout(1, 3, 5, 0));
        
        this.tfQuantity = new JTextField(choiceProduct.getSellGUI().getSellBUS().getDetailBillToppingBUS().getQuantity(choiceProduct.getDetailBillId(), toppingId)+"", 5);
        this.tfQuantity.setEditable(false);
        this.tfQuantity.setHorizontalAlignment((int) JTextField.CENTER_ALIGNMENT);
        
        this.btnAdd = this.createJButtonFromText("+", actionCommand1);
        this.btnAdd.addActionListener((ActionEvent e) -> {
            tfQuantity.setText(String.valueOf(Integer.parseInt(this.tfQuantity.getText()) + 1));
            choiceProduct.getTfPrice().setText(Double.parseDouble(choiceProduct.getTfPrice().getText()) + choiceProduct.getSellGUI().getSellBUS().getToppingBUS().getToppingFromId(toppingId).getToppingPrice() * Integer.parseInt(choiceProduct.getTfQuantity().getText()) + "");
        });
        
        this.btnSub = this.createJButtonFromText("−", actionCommand2);
        this.btnSub.addActionListener((ActionEvent e) -> {
            if(Integer.parseInt(this.tfQuantity.getText()) == 0) {
                this.tfQuantity.setText(0 + "");
            } else {
                this.tfQuantity.setText(String.valueOf(Integer.parseInt(this.tfQuantity.getText()) - 1));
                choiceProduct.getTfPrice().setText(Double.parseDouble(choiceProduct.getTfPrice().getText()) - choiceProduct.getSellGUI().getSellBUS().getToppingBUS().getToppingFromId(toppingId).getToppingPrice() * Integer.parseInt(choiceProduct.getTfQuantity().getText()) + "");
            }
        });
        
        this.pCenter.add(this.btnSub);
        this.pCenter.add(this.tfQuantity);
        this.pCenter.add(this.btnAdd);
        
        this.add(this.toppingName);
        this.add(this.pCenter);
    }
    
    private JButton createJButtonFromText (String text, String actionCommand) {
        JButton button = new JButton(text);
        button.setActionCommand(actionCommand);
        button.setFocusPainted(false);
        button.setCursor(new Cursor(HAND_CURSOR));
        button.setFont(new Font("Arial", Font.HANGING_BASELINE, 15));
        return button;
    }
}
