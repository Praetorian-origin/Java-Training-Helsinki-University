package survey;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;

    @Override
    public void run() {
        // Create your app here
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(200, 300));
         frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
       
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        BoxLayout layout =  new BoxLayout(container, BoxLayout.Y_AXIS);
         container.setLayout(layout);
         
        container.add(new JLabel("Are you?"));
     
        JCheckBox checkboxYES = new JCheckBox("Yes!");
        JCheckBox checkboxNo = new JCheckBox("No!");

        container.add(checkboxYES);
        container.add(checkboxNo);
        container.add(new JLabel("Why?"));
        
        JRadioButton noreason = new JRadioButton("No reason.");
        JRadioButton becauseisfun = new JRadioButton("Because it is fun!");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(noreason);
        buttonGroup.add(becauseisfun);
        container.add(noreason);
        container.add(becauseisfun);
        container.add(new JButton("Done!"));
      

    }

    public JFrame getFrame() {
        return frame;
    }
}
