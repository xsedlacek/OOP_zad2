package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class MainFrame {
    public MainFrame(MyCanvas panel, SidePanel panel1,int x, int y) {

        JFrame window = new JFrame();
        window.setSize(750, 500);
        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("Pohyb: sipky ,tlacitka,mys \n "));

        panel.setFocusable(true);

        panel.printMaze(panel,x,y);

        JSplitPane splitPane1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT,panel2,panel1);
        splitPane1.setDividerLocation(350);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, splitPane1,panel);
        splitPane.setDividerLocation(250);

        window.add(splitPane);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
