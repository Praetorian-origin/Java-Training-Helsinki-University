package noticeboard;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

public class NoticeBoard implements Runnable {

    private JFrame frame;

    @Override
    public void run() {

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(500, 300));
        createComponents(frame.getContentPane());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container) {
        GridLayout layout = new GridLayout(3, 1);
        container.setLayout(layout);
        JTextField textarea = new JTextField();
        JButton button = new JButton("Copy!");

        JLabel text = new JLabel();
        container.add(textarea);
        container.add(button);
        container.add(text);

        ActionEventListener actionListener = new ActionEventListener(textarea, text);
        button.addActionListener(actionListener);
    }
}
