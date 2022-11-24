package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class Node extends JPanel {
    private final int x;
    private final int y;
    private boolean topWall = true;
    private boolean bottomWall = true;
    private boolean leftWall = true;
    private boolean rightWall = true;
    private boolean visited = false;
    private Node[] neighbors;//top,bot,left,right



    public Node(int x, int y) {
        this.x = x;
        this.y = y;
        setOpaque(true);
        setBackground(Color.BLACK);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    public boolean isTopWall() {
        return topWall;
    }


    public boolean isBottomWall() {
        return bottomWall;
    }


    public boolean isLeftWall() {
        return leftWall;
    }


    public boolean isRightWall() {
        return rightWall;
    }



    public boolean isVisited() {
        return !visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    public Node[] getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(Node[] neighbors,Node[][] maze,int mazeSize) {

        if (x>0){
            neighbors[2] = maze[x-1][y];
        }
        if (y>0){
            neighbors[0] = maze[x][y-1];
        }

        if (x<mazeSize-1){
            neighbors[3] = maze[x+1][y];
        }
        if (y<mazeSize-1){
            neighbors[1] = maze[x][y+1];
        }
        this.neighbors = neighbors;
    }



    public void removeWall(int wall){
        switch(wall){
            case 0:
                this.topWall = false;
                break;
            case 1:
                this.bottomWall = false;
                break;
            case 2:
                this.leftWall = false;
                break;
            case 3:
                this.rightWall = false;
                break;

        }
    }
    public void removeWallOtherSide(int wall){
        switch(wall){
            case 0:
                this.bottomWall = false;
                break;
            case 1:
                this.topWall = false;
                break;
            case 2:
                this.rightWall = false;
                break;
            case 3:
                this.leftWall = false;
                break;

        }
    }



    public int[] getPossibleMoves(MyCanvas canvas){

        int[] moves = new int[4]; moves[0] = 0;  moves[1] = 0;  moves[2] = 0;  moves[3] = 0;

        while(!canvas.getMaze()[canvas.getPlayer().getxPos()+ moves[0]] [canvas.getPlayer().getyPos()].isRightWall()){

            moves[0]++;
        }

        while(!canvas.getMaze()[canvas.getPlayer().getxPos()] [canvas.getPlayer().getyPos() - moves[1]].isTopWall()){

            moves[1]++;
        }

        while(!canvas.getMaze()[canvas.getPlayer().getxPos()] [canvas.getPlayer().getyPos()+ moves[2]].isBottomWall()){

            moves[2]++;
        }

        while(!canvas.getMaze()[canvas.getPlayer().getxPos()- moves[3]] [canvas.getPlayer().getyPos()].isLeftWall()){

            moves[3]++;
        }

        return moves;
    }
}
