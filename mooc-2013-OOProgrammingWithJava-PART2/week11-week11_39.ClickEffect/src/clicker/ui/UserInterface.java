package clicker.ui;

import clicker.applicationlogic.Calculator;
import clicker.applicationlogic.PersonalCalculator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator) {
        this.calculator = calculator;
    }
    
    
   

    @Override
    public void run() {
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BorderLayout borderLayout = new BorderLayout();
        container.setLayout(borderLayout);
        JLabel label = new JLabel("0");
        JButton button = new JButton("Click");
        container.add(label, BorderLayout.CENTER);
        container.add(button, BorderLayout.SOUTH);
        ClickListener cl = new ClickListener(this.calculator, label);
        button.addActionListener(cl);
        
        
    }

    public JFrame getFrame() {
        return frame;
    }
}
