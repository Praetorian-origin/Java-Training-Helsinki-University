
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author praetorian
 */
public class MinusClickListener implements ActionListener {

    private JTextField inputField;
    private JTextField textField;
    private Calculator calculator;

    public MinusClickListener(JTextField inputField, JTextField textField, Calculator calculator) {
        this.inputField = inputField;
        this.textField = textField;
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            calculator.decrease(Integer.parseInt(inputField.getText()));
        } catch (Exception e) {
              inputField.setText("");
        }
        textField.setText(String.valueOf(calculator.getValue()));
        inputField.setText("");
    }

}
