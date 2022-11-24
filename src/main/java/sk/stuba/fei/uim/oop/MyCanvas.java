package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyCanvas extends Movement implements KeyListener , MouseListener {

    private final Player player;
    private Node[][] maze;
    private int complete;

    public void setSidePanel(SidePanel sidePanel) {
        this.sidePanel = sidePanel;
    }

    private SidePanel sidePanel;

    public MyCanvas(Player player,Node[][] maze) {

        this.setLayout(new GridLayout(maze.length,maze.length,-1,-1));
        addKeyListener(this);
        addMouseListener(this);
        this.player = player;
        this.maze = maze;
    }

    public Player getPlayer() {
        return player;
    }

    public Node[][] getMaze() {
        return maze;
    }

    public void setMaze(Node[][] maze) {
        this.maze = maze;
    }

    public int getComplete() {
        return complete;
    }

    public void setComplete(int complete) {
        this.complete = complete;
    }



    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {
            case 37:
                this.left(player, maze[player.getxPos()][player.getyPos()]);
                break;
            case 38:
                this.up(player, maze[player.getxPos()][player.getyPos()]);
                break;
            case 39:
                this.right(player, maze[player.getxPos()][player.getyPos()]);
                break;
            case 40:
                this.down(player, maze[player.getxPos()][player.getyPos()]);
                break;

        }

        removeAll();
        if (this.getPlayer().getxPos() == this.getMaze().length - 1 && this.getPlayer().getyPos() == this.getMaze().length - 1) {
            this.finish(this.getComplete()+1);
        } else {
            this.printMaze(this, player.getxPos(), player.getyPos());
        }
        this.revalidate();


    }



    @Override
    public void mouseClicked(MouseEvent e) {

    }



    public void printMaze(MyCanvas panel,int x,int y) {

        //kreslenie bludiska
        int size = panel.getMaze().length;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int top = 0;
                int bot = 0;
                int left = 0;
                int right = 0;

                JLabel label = new JLabel();

                if (panel.getMaze()[j][i].isBottomWall()) {
                    bot = 1;
                }

                if (panel.getMaze()[j][i].isTopWall()) {
                    top = 1;
                }

                if (panel.getMaze()[j][i].isLeftWall()) {
                    left = 1;
                }

                if (panel.getMaze()[j][i].isRightWall()) {
                    right = 1;

                }

                label.setBorder(BorderFactory.createMatteBorder(top, left, bot, right, Color.BLACK));
                label.setOpaque(true);

                if (i == y && j == x){
                    label.setText("★");
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                }

                if (i == 0 && j == 0) {
                    label.setBackground(Color.green);
                }

                if (i == size - 1 && j == size - 1) {
                    label.setBackground(Color.red);
                }

                panel.add(label);

            }
        }


    }

    public void finish(int value){
        MazeGenerator mazeGenerator = new MazeGenerator();
        mazeGenerator.newMaze(this);
        printMaze(this, 0, 0);
        this.setComplete(value);
        this.sidePanel.getComplete().setText(Integer.toString(this.getComplete()));
        sidePanel.revalidate();
    }




    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getX()/40 == player.getxPos() && e.getY()/40 == player.getyPos()) {

            int[] moves = maze[player.getxPos()][player.getyPos()].getPossibleMoves(this);

            for (int i = 1; i <= moves[0]; i++) {
                getComponentAt((e.getX() + i * 40), e.getY()).setBackground(Color.lightGray);

            }

            for (int i = 1; i <= moves[1]; i++) {
                getComponentAt((e.getX()), e.getY() - i * 40).setBackground(Color.lightGray);

            }

            for (int i = 1; i <= moves[2]; i++) {
                getComponentAt(e.getX(), e.getY() + i * 40).setBackground(Color.lightGray);

            }

            for (int i = 1; i <= moves[3]; i++) {
                getComponentAt((e.getX() - i * 40), e.getY()).setBackground(Color.lightGray);
            }

        }

        if (getComponentAt(e.getPoint()).getBackground() == Color.LIGHT_GRAY) {


            player.setxPos(e.getX() / 40);
            player.setyPos(e.getY() / 40);
            removeAll();

            if (this.getPlayer().getxPos() == this.getMaze().length - 1 && this.getPlayer().getyPos() == this.getMaze().length - 1) {
                this.finish(this.getComplete()+1);
            } else {
                this.printMaze(this, this.getPlayer().getxPos(), this.getPlayer().getyPos());
            }
            this.revalidate();
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
