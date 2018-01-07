package application;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Scanner;  
import java.util.Stack;
import javafx.scene.layout.GridPane;

public class MazeController implements Initializable{
	   
    private Stack<MazeCell> pathStack = new Stack<>();  
    /** 
     * 保存迷宫 
     */  
    private int[][] maze; 
    GridPane pane = new GridPane();
  
    private boolean flag = false;  
    private MazeCell startCell;  
    private MazeCell endCell;  
  
	@FXML
	private AnchorPane p;
	@FXML
	private TextField value;
	@FXML
	private VBox vb;
	@FXML
	private TextField index;
	
	  @Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				// TODO Auto-generated method stub
		    	findPath();
		    	 for(int i = 0;i <maze[0].length - 2;i++ ) {
	        	 for(int j = 0; j <maze.length - 2;j++  ) {
		        		 
	        			System.out.println(maze[j][i]);
		    	System.out.println("sb");
		    	 p.getChildren().add(pane);
		    	
	        	 }}
//		    	  GridPane pane = new GridPane();
//		    	 for(int i = 0;i <maze[0].length - 2;i++ ) {
//		        	 for(int j = 0; j <maze.length - 2;j++  ) {
//		        		 TextField tf = new TextField(0 + "");
//	        	  pane.add(tf, j, i);
//		        		  
//		        		 
//		        	 }
//		         }
//		       p.getChildren().add(pane);
			}
	 

public MazeController() {
	 initialMaze();  
}



	
	
	  
	       
	    
	  
	    /** 
	     * 寻找路径 
	     */  
	    public void findPath() {  
	        assert flag;  
	        processCell(startCell.getX(), startCell.getY(), startCell.getStep());
	        
	    }  
	  
	    private void processCell(int x, int y, int step) {  
	        if (x == endCell.getX() && y == endCell.getY()) {  
	            pathStack.pop();  
	            printPath();  
	            System.out.println("("+endCell.getX()+","+endCell.getY()+")");  
	            
	         System.out.println("shabi");
	       
	        
	         
	            
	            return;  
	           
	        }  
	        test(x,y-1,step+1);  
	        test(x,y+1,step+1);  
	        test(x-1,y,step+1);  
	        test(x+1,y,step+1);  
	    }  
	  
	    private void test(int x, int y, int step) {  
	        if (canGo(x,y)){  
	            MazeCell mazeCell = new MazeCell(x,y,step);  
	            insertToPath(mazeCell);  
	           processCell(x,y,step);
	           
	        }  
	        
	    }  
	  
	    private void printPath(){  
	        for (int i = 0; i < pathStack.size(); i++) {  
	            MazeCell cell = pathStack.get(i);  
	            System.out.print("("+cell.getX()+","+cell.getY()+")->");
	            
	           
		    	
		        		 TextField tf = new TextField(0 + "");
	        	  pane.add(tf, cell.getY(), cell.getX());
	        		  
		        		 
		        
		       
	        }  
//	       
	    }  
	  
	    private void insertToPath(MazeCell mazeCell) {  
	        while (pathStack.peek().getStep() >= mazeCell.getStep()) {  
	            pathStack.pop();  
	        }  
	        for (int i = 0; i < pathStack.size(); i++) {  
	            MazeCell cell = pathStack.get(i);  
	            System.out.print("("+cell.getX()+","+cell.getY()+")->");
	    }  
	    }
	    private boolean canGo(int x, int y) {  
	        if (maze[x][y]==1) {  
	            return false;  
	        } 
	      
	        for (int i = 0; i < pathStack.size(); i++) {  
	            MazeCell mazeCell = pathStack.get(i);  
	            if (mazeCell.getX()==x && mazeCell.getY()==y) {  
	                return false;  
	            }  
	        }  
	        return true;  
	    }  
	    /* {
		-1 0 1 0 0 0 1 0
		0 0 1 0 0 0 1 0
		0 0 0 0 1 1 0 1
		0 1 1 1 0 0 1 0
		0 0 0 1 0 0 0 0
		0 1 0 0 0 1 0 1
		0 1 1 1 1 0 0 1
		1 1 0 0 0 1 0 1
		1 1 0 0 0 0 0 2*/
	    private void initialMaze() {  
	        int column;  
	        int row;  
	        Scanner scanner = new Scanner(System.in);  
	        int temp = 0;  
	        do {  
	            System.out.println("请输入迷宫行数(>0)：");  
	            temp = scanner.nextInt();  
	        } while (temp<=0);  
	        row = temp;  
	        do {  
	            System.out.println("请输入迷宫列数(>0)：");  
	            temp = scanner.nextInt();  
	        } while (temp<=0);  
	        column = temp;  
	        maze = new int[row+2][column+2];  
	        System.out.println("请输入迷宫（1为墙，0为路，-1为起点，2为终点）:");  
	        for (int i = 0; i < column+2; i++) {  
	            maze[0][i] = 1;  
	        }  
	        for (int i = 1; i < row+1; i++) {  
	            maze[i][0] = 1;  
	            for (int j = 1; j < column+1; j++) {  
	                temp = scanner.nextInt();  
	                switch (temp) {  
	                    case -1:  
	                        startCell = new MazeCell(i,j,0);  
	                        maze[i][j] = temp;  
	                        pathStack.push(startCell);  
	                        break;  
	                    case 2:endCell = new MazeCell(i,j,-1);  
	                    case 0:  
	                    case 1:maze[i][j] = temp;break;  
	                    default:  
	                        System.out.println("输入不符合要求T T");  
	                        return;  
	                }  
	            }  
	            maze[i][column+1] = 1;  
	        }  
	        for (int i = 0; i < column+2; i++) {  
	            maze[row+1][i] = 1;  
	        }  
	        if (startCell!=null && endCell!=null) {  
	            flag = true;  
	            System.out.println("输入成功:)");
	        } else {  
	            System.out.println("至少要有一个起点和终点:(");  
	        }  
	    }  
	  
	
}
