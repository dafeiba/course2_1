package application;
/* {
    		{0,0,1,0,0,0,1,0},
    		{0,0,1,0,0,0,1,0},
    		{0,0,0,0,1,1,0,1},
    		{0,1,1,1,0,0,1,0},
    		{0,1,1,1,0,0,1,0},
    		{0,0,0,1,0,0,0,0},
    		{0,1,1,1,1,0,0,1},
    		{1,1,0,0,0,1,0,1},
    		{1,1,0,0,0,0,0,0},};*/
import java.util.Stack;

public class Maze {

    // 栈
    private Stack<MazeNode> stack = new Stack<Maze.MazeNode>();
    // 迷宫
    private int[][] maze = {
        {1,1,1,1,1,1,1,1},
        {1,0,1,0,0,0,1,1},
        {1,0,0,0,0,1,1,0},
        {1,0,1,1,0,0,0,0},
        {1,1,1,0,0,0,1,1},
        {1,1,0,0,1,0,0,1},
        {1,0,0,1,1,1,0,1},
        {1,0,0,1,1,1,1,1},
        
    };
    // 标记路径是否已走过
    private int[][] mark = new int[MAZE_SIZE_X][MAZE_SIZE_Y];

    private static final int MAZE_SIZE_X = 8;
    private static final int MAZE_SIZE_Y = 8;
    private static final int END_X = 6;
    private static final int END_Y = 6;

    private void initMark() {
        for (int i = 0; i < MAZE_SIZE_X; i++) {
            for (int j = 0; j < MAZE_SIZE_Y; j++) {
                mark[i][j] = 0;
            }
        }
    }

    public void process() {
        initMark();
        Position curPos = new Position(1, 1);

        do {
            // 此路径可走
            if (maze[curPos.x][curPos.y] == 0 && mark[curPos.x][curPos.y] == 0) {
                mark[curPos.x][curPos.y] = 1;
                stack.push(new MazeNode(curPos, 1));
                // 已到终点
                if (curPos.x == END_X && curPos.y == END_Y) {
                    return;
                }
                curPos = nextPos(curPos, stack.peek().direction);
            }
            // 走不通
            else {
                if (!stack.isEmpty()) {
                    MazeNode curNode = stack.pop();
                    while (curNode.direction == 4 && !stack.isEmpty()) {
                        // 如果当前位置的4个方向都已试过，那么标记该位置不可走，并出栈
                        mark[curNode.position.x][curNode.position.y] = 1;
                        curNode = stack.pop();
                    }
                    if (curNode.direction < 4) {
                        curNode.direction++;// 方向+1
                        stack.push(curNode);// 重新入栈
                        curPos = nextPos(curNode.position, curNode.direction);// 获取下一个位置
                    }
                }
            }
        }
        while(!stack.isEmpty());
    }


    public void drawMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void drawResult() {
        initMark();
        MazeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            mark[node.position.x][node.position.y] = 1;
        }
        for (int i = 0; i < mark.length; i++) {
            for (int j = 0; j < mark[0].length; j++) {
                System.out.print(mark[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    // 记录迷宫中的点的位置
    class Position {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 栈中的结点
    class MazeNode {
        Position position;
        int direction;

        public MazeNode(Position pos) {
            this.position = pos;
        }
        public MazeNode(Position pos, int dir) {
            this.position = pos;
            this.direction = dir;
        }
    }

    // 下一个位置，从右开始，顺时针
    public Position nextPos(Position position, int direction) {
        Position newPosition = new Position(position.x, position.y);
        switch (direction) {
        case 1:
            newPosition.y += 1;
            break;
        case 2:
            newPosition.x += 1;
            break;
        case 3:
            newPosition.y -= 1;
            break;
        case 4:
            newPosition.x -= 1;
            break;
        default:
            break;
        }
        return newPosition;
    }

    public static void main(String[] args) {
        Maze maze = new Maze();
        maze.drawMaze();
        maze.process();
        maze.drawResult();
    }

}