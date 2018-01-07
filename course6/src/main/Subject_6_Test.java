package main;



import java.util.ArrayList;


public class Subject_6_Test {
    public static void main(String[] args) {
       Maze maze = new Maze(4, 4);
       byte[][] x = maze.getMazeData();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maze.findPath());
        System.out.println(maze.findPath());
    }
}
