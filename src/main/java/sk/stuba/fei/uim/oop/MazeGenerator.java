package sk.stuba.fei.uim.oop;

import java.util.Random;
import java.util.Stack;

public class MazeGenerator {

    public Node[][] mazeGen(int size) {

        Node[][] maze = new Node[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                maze[j][i] = new Node(j, i);
            }
        }
        Node node = maze[1][1];
        Stack<Node> stack = new Stack<>();
        mazeDFS(maze,node,size, stack);

        return maze;
    }



    public void mazeDFS(Node[][] maze,Node node,int size,Stack<Node> stack) {

        Random random = new Random();
        int rand;
        if(node.isVisited()){
            stack.push(node);
                }

        Node[] neighbors = new Node[4];
        node.setVisited(true);
        node.setNeighbors(neighbors,maze,size);
        Node[] unvisited = new Node[4];

        int i = 0;

        for (int k = 0; k < 4;k++){
            if (node.getNeighbors()[k] != null && node.getNeighbors()[k].isVisited()) {
                unvisited[k] = node.getNeighbors()[k] ;
                i++;
            }
        }

        if(i>0) {
            rand = random.nextInt(unvisited.length);
            while (unvisited[rand] == null) {
                rand = random.nextInt(unvisited.length);
            }

            node.removeWall(rand);
            node = unvisited[rand];
            node.removeWallOtherSide(rand);
            mazeDFS(maze, node,size,stack);
        }

        else if(stack.size()>1){
            stack.pop();
            mazeDFS(maze,stack.peek(),size,stack);
        }

    }

    public void newMaze(MyCanvas canvas){

        canvas.getPlayer().setyPos(0);
        canvas.getPlayer().setxPos(0);
        canvas.setMaze(mazeGen(canvas.getMaze().length));
    }



}


