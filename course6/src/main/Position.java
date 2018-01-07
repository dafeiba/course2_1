package main;




public class Position {
    private int x;//浣嶇疆鐨剎鍧愭爣
    private int y;//浣嶇疆鐨剏鍧愭爣
    private int attribute;
    private String direction;

    public static final String UP = "up";//涓� 寰�涓婄旱鍧愭爣y鍑�1
    public static final String DOWN = "down";//涓� 寰�涓嬬旱鍧愭爣鍔�1
    public static final String LEFT = "left";//宸� 寰�宸︽í鍧愭爣x鍑�1
    public static final String RIGHT = "right";//鍙� 寰�鍙虫í鍧愭爣x鍔�1
    public static final String END = "end";//鍙� 寰�鍙虫í鍧愭爣x鍔�1

    public Position(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position(int x, int y, int attribute) {
        this.x = x;
        this.y = y;
        this.attribute = attribute;
    }

    public Position() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getAttribute() {
        return attribute;
    }

    @Override
    public String toString() {
        return "(" +
                "x=" + x +
                ", y=" + y +
                ", direction='" + direction + '\'' +
                ')';
    }
}
