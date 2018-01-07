package test;

import java.util.Scanner;
import java.util.Stack;



class Maze{
	 int maze[][];
	    private int row = 9;
	    private int col = 8;
	    Stack<Position> stack;
	    boolean p[][] = null;
    public Maze(){
        maze = new int[15][15];
        stack = new Stack<Position>();
        p = new boolean[15][15];
    }
 
    /*
     * �����Թ�
     */
    
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
 
    /*
     * �����Թ����鿴�Ƿ��г�·
     */
    public void findPath(){
        // ��ԭʼ�Թ�����Χ��һȦΧǽ
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
        } else {
            System.out.println("��·��");
            System.out.println("·�����£�");
            while (!stack.empty()) {
                Position pos = new Position();
                pos = stack.pop();
                newPos.push(pos);
            }
        }
         
        /*
         * ͼ�λ����·��
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
            	   System.out.print("sb:");
                System.out.print(resault[k][t]+"\t");
            }
            System.out.println();
        }
     
 
    }
 
   
}