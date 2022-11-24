package sk.stuba.fei.uim.oop;


import javax.swing.*;

public abstract class Movement extends JPanel {

    public void left(Player player,Node node){

        if (!(node.isLeftWall())){
            player.setxPos(player.getxPos()-1);
        }
    }

    public void right(Player player,Node node){
        if (!(node.isRightWall())){
            player.setxPos(player.getxPos()+1);
        }
    }

    public void up(Player player,Node node){
        if (!(node.isTopWall())){
            player.setyPos(player.getyPos()-1);
        }
    }

    public void down(Player player,Node node){
        if (!(node.isBottomWall())){
            player.setyPos(player.getyPos()+1);
        }
    }


}
