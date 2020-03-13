
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GraphicCalculator implements Runnable {

    private JFrame frame;
    private Calculator calculator;
    private JButton buttonReset;

    public GraphicCalculator(Calculator calculator) {
        this.calculator = calculator;

    }

    @Override
    public void run() {
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(450, 200));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        GridLayout gridLayout = new GridLayout(3, 1);
        container.setLayout(gridLayout);
        JTextField textField = new JTextField(String.valueOf(calculator.getValue()));
        textField.setEnabled(false);
        JTextField inputField = new JTextField();
        container.add(textField);
        container.add(inputField);
        JPanel panel = new JPanel(new GridLayout(1, 3));
        JButton buttonPlus = new JButton("+");
        panel.add(buttonPlus);
        JButton buttonMinus = new JButton("-");
        panel.add(buttonMinus);
        buttonReset = new JButton("Z");
        panel.add(buttonReset);
        container.add(panel);
        MinusClickListener minusCL = new MinusClickListener(inputField, textField, calculator);
        buttonMinus.addActionListener(minusCL);

        PlusClickListener plusCL = new PlusClickListener(inputField, textField, calculator);
        buttonPlus.addActionListener(plusCL);

        ResetClickListener resetCL = new ResetClickListener(inputField, textField, calculator);
        buttonReset.addActionListener(resetCL);
        calculator.setGraphicCalculator(this);
        
        buttonReset.setEnabled(false);

    }

    public void setButtonResetEnabled() {
        this.buttonReset.setEnabled(true);
    }

    public void setButtonResetDisabled() {
        this.buttonReset.setEnabled(false);
    }

//    private JPanel createBottomPanel() {
//        JPanel panel = new JPanel(new GridLayout(1, 3));
//        panel.add(new JButton("+"));
//        panel.add(new JButton("-"));
//        panel.add(new JButton("Z"));
//        return panel;
//    }
    public JFrame getFrame() {
        return frame;
    }
}
