package main;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Stack;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;



public class MazeController implements Initializable{
	
	int maze[][];
    private int row = 9;
    private int col = 8;
    Stack<Position> stack;
    boolean p[][] = null;
	
	 String resault[][]=new String[3][3];
	 Alert alert = new Alert(AlertType.INFORMATION);

	
	

@FXML
private AnchorPane ap;
@FXML
private Text t;

public MazeController(){
    maze = new int[15][15];
    stack = new Stack<Position>();
    p = new boolean[15][15];
}


    
public void init(){
	
	
    Scanner scanner = new Scanner(System.in);
    System.out.println("�������Թ�������");
    row = scanner.nextInt();
    System.out.println("�������Թ�������");
    col = scanner.nextInt();
    System.out.println("������" + row + "��" + col + "�е��Թ�");
    int temp = 0;
    for(int i = 0; i < row; ++i) {
        for(int j = 0; j < col; ++j) {
            temp = scanner.nextInt();
            maze[i][j] = temp;
            p[i][j] = false;
        }
    }
}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		GridPane  gp = new  GridPane();
		TextField tf = new TextField();
		
		 init();
		 int temp[][] = new int[row + 2][col + 2];
	        for(int i = 0; i < row + 2; ++i) {
	            for(int j = 0; j < col + 2; ++j) {
	                temp[0][j] = 1;
	                temp[row + 1][j] = 1;
	                temp[i][0] = temp[i][col + 1] = 1;
	            }
	        }
	        // ��ԭʼ�Թ����Ƶ��µ��Թ���
	        for(int i = 0; i < row; ++i) {
	            for(int j = 0; j < col; ++j) {
	                temp[i + 1][j + 1] = maze[i][j];
	            }
	        }
	        // �����Ͻǿ�ʼ����˳ʱ�뿪ʼ��ѯ
	 
	        int i = 1;
	        int j = 1;
	        p[i][j] = true;
	        stack.push(new Position(i, j));
	        while (!stack.empty() && (!(i == (row) && (j == col)))) {
	 
	            if ((temp[i][j + 1] == 0) && (p[i][j + 1] == false)) {
	                p[i][j + 1] = true;
	                stack.push(new Position(i, j + 1));
	                j++;
	            } else if ((temp[i + 1][j] == 0) && (p[i + 1][j] == false)) {
	                p[i + 1][j] = true;
	                stack.push(new Position(i + 1, j));
	                i++;
	            } else if ((temp[i][j - 1] == 0) && (p[i][j - 1] == false)) {
	                p[i][j - 1] = true;
	                stack.push(new Position(i, j - 1));
	                j--;
	            } else if ((temp[i - 1][j] == 0) && (p[i - 1][j] == false)) {
	                p[i - 1][j] = true;
	                stack.push(new Position(i - 1, j));
	                i--;
	            } else {
	                stack.pop();
	                if(stack.empty()){
	                    break;
	                }
	                i = stack.peek().row;
	                j = stack.peek().col;
	            }
	 
	        }
	    
	 
	        Stack<Position> newPos = new Stack<Position>();
	        if (stack.empty()) {
	            System.out.println("û��·��");
	            alert.setContentText("û��·��");
	            alert.show();
	        } else {
	        	
	            System.out.println("��·��");
	            alert.setContentText("��·��");
	            alert.show();
	            System.out.println("·�����£�");
	            t.setText("·�����£�");
	            while (!stack.empty()) {
	                Position pos = new Position();
	                pos = stack.pop();
	                newPos.push(pos);
	            }
	        }
	         
	        /*
	         * ͼ�λ����·��
0	0	1	0	0	0	1	0
1	1	1	0	0	0	1	0
0	0	1	0	1	1	0	1
0	1	1	1	0	0	1	0
0	0	0	1	0	0	0	0
0	1	0	0	0	1	0	1
0	1	1	1	1	0	0	1
1	1	0	0	0	1	0	1
1	1	0	0	0	0	0	0
	         * */
//	         
	        String resault[][]=new String[row+1][col+1];
	        System.out.println("row:"+row);
	        System.out.println("col:"+col);
	        for(int k=0;k<row;++k){
	            for(int t=0;t<col;++t){
	                resault[k][t]=(maze[k][t])+"";
	            }
	        }
	        while (!newPos.empty()) {
	            Position p1=newPos.pop();
	            resault[p1.row-1][p1.col-1]="#";
	         
	        }
	         
	        for(int k=0;k<row;++k){
	            for(int t=0;t<col;++t){
	            	TextField tf1 = new TextField();
	            	
	            	tf1.setText(resault[k][t]);
	            	
	            	   gp.add(tf1, t, k);
	            	   tf1.setPrefColumnCount(1);// ���Ϳ����
						tf1.setAlignment(Pos.CENTER);// �־���
	                
	            }
	           
	          
	        }
	        ap.getChildren().add(gp);
	      
	 
	    }
	 
	 
	    }
	
	 
	

