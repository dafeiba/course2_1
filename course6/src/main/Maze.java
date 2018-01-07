package main;



import java.io.Serializable;
import java.util.*;


public class Maze implements Serializable{
    private int rows = 10;//杩峰鐨勮鏁�
    private int columns = 10;//杩峰鐨勫垪鏁�
    private byte[][] mazeData;//瀛樺偍杩峰鐨勬暟鎹�0琛ㄧず閫氳矾锛�1琛ㄧず闃荤
    private int startPoint = 0;//杩峰璧风偣
    private int endPoint = rows * columns - 1;//杩峰缁堢偣
    private Position[][] labyrinth = new Position[rows][columns];

    public static final double PASS_PROBABILITY = 0.6;//鎺у埗閫氳繃鍑虹幇鐨勬鐜�
    public static final byte[] STATE = {0, 1};//鐐圭殑鐘舵�� 0琛ㄧず閫氳繃 1琛ㄧず闃荤

    private ArrayList<ArrayList<String>> route = new ArrayList<>();
    private ArrayList<String> temp = new ArrayList<String>();
    private boolean findWay;

    /**
     * 閫氳繃琛屽拰鍒楁潵鏋勯�犺糠瀹�
     * @param rows
     * @param columns
     */
    public Maze(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        initialMazeData();
    }

    public Maze(int rows) {
        this.rows = rows;
        initialMazeData();
    }

    public Maze(){
        initialMazeData();
    }


    //Get Set
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public byte[][] getMazeData() {
        return mazeData;
    }

    public void setMazeData(byte[][] mazeData) {
        this.mazeData = mazeData;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public ArrayList<ArrayList<String>> getRoute() {
        return route;
    }

    public Position[][] getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Position[][] labyrinth) {
        this.labyrinth = labyrinth;
    }

    /**
     * 闅忔満鐢熸垚杩峰
     */
    public void initialMazeData(){
        mazeData = new byte[rows][columns];
        labyrinth = new Position[rows][columns];
        endPoint = rows * columns - 1;//璁剧疆榛樿缁堢偣

        //闅忔満璁剧疆杩峰
        for (int i = 0; i < mazeData.length; i++) {
            for (int j = 0; j < mazeData[i].length; j++) {



                if(Math.random() > PASS_PROBABILITY){//鎺у埗閫氳繃鍑虹幇鐨勬鐜�
                    mazeData[i][j] = STATE[1];
                    labyrinth[i][j] = new Position(i, j, 1);
                }
                else {
                    mazeData[i][j] = STATE[0];
                    labyrinth[i][j] = new Position(i, j, 0);
                }
            }
        }

        //灏嗚捣鐐瑰拰缁堢偣璁句负閫氳繃
        mazeData[startPoint/this.columns][startPoint%this.columns] = STATE[0];
        mazeData[endPoint/this.columns][endPoint%this.columns] = STATE[0];
    }

    //鎵惧埌杩峰鍑哄彛璺嚎
    public boolean findPath(){
        findWay = false;
        byte[][] temp = mazeDataCopy();
        return findPath(temp, startPoint/this.rows, startPoint%this.rows);
    }


    public byte[][] mazeDataCopy(){
        byte[][] temp = new byte[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                temp[i][j] = mazeData[i][j];
            }
        }

        return temp;
    }


    /**
     * 浣跨敤閫掑綊鎵惧埌鍑哄彛
     * @param mazeData
     * @param x
     * @param y
     * @return 鏄惁鏈夊嚭鍙�
     */
    public boolean findPath(byte mazeData[][], int x, int y) {

        //鍒拌揪鍑哄彛鏃�
        if (x == endPoint/this.columns && y == endPoint%this.columns) {
            findWay = true;

            return true;
        }

        if (findWay) {
            return false;
        }

        //鍚戝彸鎼滃
        if (x + 1 < mazeData.length && y < mazeData[x + 1].length && (mazeData[x + 1][y] == STATE[0])) {
            mazeData[x + 1][y] = STATE[1];
            //route.add(new Position(x, y, Position.DOWN));
            findPath(mazeData, x + 1, y);
        }

        //鍚戜笅鎼滃
        if (y + 1 < mazeData[x].length && x < mazeData.length && (mazeData[x][y + 1] == STATE[0])) {
            mazeData[x][y + 1] = STATE[1];
            //route.add(new Position(x, y, Position.RIGHT));
            findPath(mazeData, x, y + 1);
        }

        //鍚戝乏鎼滃
        if (x - 1 < mazeData.length && x - 1 > 0 && y < mazeData[x - 1].length && (mazeData[x - 1][y] == STATE[0])) {
            mazeData[x - 1][y] = STATE[1];
            //route.add(new Position(x, y, Position.UP));
            findPath(mazeData, x - 1, y);
        }

        //鍚戜笂鎼滃
        if (y - 1 > 0 && y - 1 < mazeData[x].length && x < mazeData.length && (mazeData[x][y - 1] == STATE[0])) {
            mazeData[x][y - 1] = STATE[1];
           // route.add(new Position(x, y, Position.LEFT));
            findPath(mazeData, x, y - 1);
        }


        //娌℃湁鎵惧埌鍑哄彛
        if (x == 0 && y == 0 && !findWay) {
            //System.out.println("娌℃湁鍑哄彛");
            //route.clear();
            return false;
        }

        return true;
    }

    /**
     * 鎵惧埌鎵�鏈夎矾寰�
     */
    public void findAllWays(){
        findAllWays(labyrinth, startPoint/columns, startPoint%columns);
    }


    /**
     * 鎵惧埌鎵�鏈夎矾寰�
     * @param labyrinth
     * @param x
     * @param y
     */
    public void findAllWays(Position[][] labyrinth, int x, int y) {
        labyrinth[x][y].setAttribute(-1);
        if (x == labyrinth.length - 1 && y == labyrinth[labyrinth.length - 1].length - 1) {
            temp.add(labyrinth[x][y].toString());
            ArrayList<String> temp1 = (ArrayList<String>) temp.clone();
            route.add(temp1);
            temp.remove(temp.size() - 1);
            labyrinth[x][y].setAttribute(0);
            return;
        }

        if (y + 1 < labyrinth[x].length && x < labyrinth.length && labyrinth[x][y + 1].getAttribute() == 0) {
            labyrinth[x][y].setDirection(Position.RIGHT);
            temp.add(labyrinth[x][y].toString());
            findAllWays(labyrinth, x, y + 1);
        }
        if (x + 1 < labyrinth.length && y < labyrinth[x + 1].length && labyrinth[x + 1][y].getAttribute() == 0) {
            labyrinth[x][y].setDirection(Position.DOWN);
            temp.add(labyrinth[x][y].toString());
            findAllWays(labyrinth, x + 1, y);
        }
        if (y - 1 > 0 && y - 1 < labyrinth[x].length && x < labyrinth.length
                && labyrinth[x][y - 1].getAttribute() == 0) {
            labyrinth[x][y].setDirection(Position.LEFT);
            temp.add(labyrinth[x][y].toString());
            findAllWays(labyrinth, x, y - 1);
        }
        if (x - 1 < labyrinth.length && x - 1 > 0 && y < labyrinth[x - 1].length
                && labyrinth[x - 1][y].getAttribute() == 0) {
            labyrinth[x][y].setDirection(Position.UP);
            temp.add(labyrinth[x][y].toString());
            findAllWays(labyrinth, x - 1, y);
        }

        labyrinth[x][y].setAttribute(0);
    }




}
