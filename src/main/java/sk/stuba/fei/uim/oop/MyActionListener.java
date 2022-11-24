package sk.stuba.fei.uim.oop;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener extends Movement implements ActionListener {


    private final MyCanvas canvas;
    private final int direction;

    public MyActionListener(MyCanvas canvas, int direction) {

        this.canvas = canvas;
        this.direction = direction;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        switch (direction){

            case 1:
                this.up(canvas.getPlayer(),canvas.getMaze()[canvas.getPlayer().getxPos()][canvas.getPlayer().getyPos()]);
                break;
            case 2:
                this.down(canvas.getPlayer(),canvas.getMaze()[canvas.getPlayer().getxPos()][canvas.getPlayer().getyPos()]);
                break;
            case 3:
                this.left(canvas.getPlayer(),canvas.getMaze()[canvas.getPlayer().getxPos()][canvas.getPlayer().getyPos()]);
                break;
            case 4:
                this.right(canvas.getPlayer(),canvas.getMaze()[canvas.getPlayer().getxPos()][canvas.getPlayer().getyPos()]);
                break;
            case 5:
                canvas.finish(0);
                break;
        }


        canvas.removeAll();
        if(canvas.getPlayer().getxPos() == canvas.getMaze().length-1 && canvas.getPlayer().getyPos() == canvas.getMaze().length-1){
            canvas.finish(canvas.getComplete()+1);
        }
        else{
            canvas.printMaze(canvas, canvas.getPlayer().getxPos(), canvas.getPlayer().getyPos());
        }
        canvas.revalidate();

    }


}
