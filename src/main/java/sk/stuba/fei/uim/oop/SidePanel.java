package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class SidePanel extends JPanel {
    private final JLabel complete;


    public SidePanel(MyCanvas panel, String string){

        setLayout(new GridLayout(2,3,-1,-1));

        JButton upButton = new JButton("\u25b2");
        upButton.setFocusable(false);
        upButton.addActionListener(new MyActionListener(panel,1));

        JButton downButton = new JButton("\u25bc");
        downButton.setFocusable(false);
        downButton.addActionListener(new MyActionListener(panel,2));

        JButton leftButton = new JButton("\u25c0");
        leftButton.setFocusable(false);
        leftButton.addActionListener(new MyActionListener(panel,3));

        JButton rightButton = new JButton("\u25b6");
        rightButton.setFocusable(false);
        rightButton.addActionListener(new MyActionListener(panel,4));

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new MyActionListener(panel,5));
        resetButton.setFocusable(false);

        complete = new JLabel(string);

        this.add(complete);
        this.add(upButton);
        this.add(resetButton);
        this.add(leftButton);
        this.add(downButton);
        this.add(rightButton);
    }

    public JLabel getComplete() {

        return this.complete;
    }
}
