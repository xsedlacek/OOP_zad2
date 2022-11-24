package sk.stuba.fei.uim.oop;


public class Game {
    public Game() {

        MazeGenerator mazeGenerator = new MazeGenerator();
        Node[][] maze = mazeGenerator.mazeGen(12);

        Player player = new Player(0, 0);
        MyCanvas canvas = new MyCanvas(player,maze);
        SidePanel sidePanel = new SidePanel(canvas,Integer.toString(canvas.getComplete()));
        canvas.setSidePanel(sidePanel);


        new MainFrame(canvas,sidePanel,0 ,0);


    }


}





