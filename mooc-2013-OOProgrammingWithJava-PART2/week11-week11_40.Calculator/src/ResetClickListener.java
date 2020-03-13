
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
public class ResetClickListener implements ActionListener {

    private JTextField inputField;
    private JTextField textField;
    private Calculator calculator;

    public ResetClickListener(JTextField inputField, JTextField textField, Calculator calculator) {
        this.inputField = inputField;
        this.textField = textField;
        this.calculator = calculator;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        calculator.reset();
        textField.setText(String.valueOf(calculator.getValue()));
          inputField.setText("");
    }

}
