package version3;
import java.util.*;

public class SixteenTailModel{
  public final static int NUMBER_OF_NODES = 65536;
  protected AbstractGraph<Integer>.Tree tree; // Define a tree

  /** Construct a model */
  public SixteenTailModel() {
    // 创建边
    List<AbstractGraph.Edge> edges = getEdges();
    
    // 创建图
    UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(
      edges, NUMBER_OF_NODES); 

    // 获得一个扎根在目标节点BSF树
    tree = graph.bfs(65535);
  }

  /** 创建图的所有边*/
  private List<AbstractGraph.Edge> getEdges() {
    List<AbstractGraph.Edge> edges =
      new ArrayList<AbstractGraph.Edge>(); // Store edges

    for (int u = 0; u < NUMBER_OF_NODES; u++) {
      for (int k = 0; k < 16; k++) {
        char[] node = getNode(u); // Get the node for vertex u
        if (node[k] == 'H') {
          int v = getFlippedNode(node, k);
          // 为从节点U到节点v的合法移动添加边缘（V，U）
          edges.add(new AbstractGraph.Edge(v, u));
        }
      }
    }

    return edges;
  }

  public static int getFlippedNode(char[] node, int position) {
    int row = position / 4;
    int column = position % 4;

    flipACell(node, row, column);
    flipACell(node, row - 1, column - 1);
    flipACell(node, row + 1, column + 1);
    flipACell(node, row - 1, column + 1);
    flipACell(node, row + 1, column - 1);

    return getIndex(node);
  }

  public static void flipACell(char[] node, int row, int column) {
    if (row >= 0 && row <= 3 && column >= 0 && column <= 3) { 
      //在边界
      if (node[row * 4 + column] == 'H')
        node[row * 4 + column] = 'T'; // Flip from H to T
      else
        node[row * 4 + column] = 'H'; // Flip from T to H
    }
  }

  public static int getIndex(char[] node) {
    int result = 0;

    for (int i = 0; i < 16; i++)
      if (node[i] == 'T')
        result = result * 2 + 1;
      else
        result = result * 2 + 0;

    return result;
  }

  public static char[] getNode(int index) {
    char[] result = new char[16];

    for (int i = 0; i < 16; i++) {
      int digit = index % 2;
      if (digit == 0)
        result[15 - i] = 'H';
      else
        result[15 - i] = 'T';
      index = index / 2;
    }

    return result;
  }
  
  public List<Integer> getShortestPath(int nodeIndex) {
    return tree.getPath(nodeIndex);
  }

  public static void printNode(char[] node) {
    for (int i = 0; i < 16; i++)
      if (i % 4 != 3)
        System.out.print(node[i]);
      else
        System.out.println(node[i]);

    System.out.println();
  }
}
