package application;


import java.util.*;

public class FarmerCrossRiver {
  public final static int NUMBER_OF_NODES = 16;
  protected AbstractGraph<Integer>.Tree tree; // Define a tree

  /** Construct a model */
  public FarmerCrossRiver() {
    // Create edges
    List<AbstractGraph.Edge> edges = getEdges();
    
    // Create a graph
    UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(
      edges, NUMBER_OF_NODES); 

    // Obtain a BSF tree rooted at the target node
    tree = graph.bfs(15);
  }

  /** Create all edges for the graph */
  private List<AbstractGraph.Edge> getEdges() {
    List<AbstractGraph.Edge> edges =
      new ArrayList<AbstractGraph.Edge>(); // Store edges

    for (int u = 0; u < NUMBER_OF_NODES; u++) {
      for (int k = 0; k < 4; k++) {
        char[] node = getNode(u); // Get the node for vertex u
        if (node[k] == 'H') {
          int v = getFlippedNode(node, k);
          // Add edge (v, u) for a legal move from node u to node v
         if(node.toString().equals("HHTT") == false||node.toString().equals("TTHH") == false||
             node.toString().equals("THHT") == false||node.toString().equals("HTTH") == false||
             node.toString().equals("HTTT") == false||node.toString().equals("THHH") == false)
          edges.add(new AbstractGraph.Edge(v, u));
        }
      }
    }

    return edges;
  }

  public static int getFlippedNode(char[] node, int position) {
    int row = position / 2;
    int column = position % 2;
    flipACell(node, row, column);
    flipACell(node, row - 1, column);
    flipACell(node, row + 1, column);
    flipACell(node, row, column - 1);
    flipACell(node, row, column + 1);

    return getIndex(node);
  }
  
  

  public static void flipACell(char[] node, int row, int column) {
    if (row >= 0 && row <= 1 && column >= 0 && column <= 1) { 
      // Within the boundary
    	
      if (node[row * 2 + column] == 'H')
        node[row * 2 + column] = 'T'; // Flip from H to T
      else
        node[row * 2 + column] = 'H'; // Flip from T to H
    }
  }

  public static int getIndex(char[] node) {
    int result = 0;

    for (int i = 0; i < 4; i++)
      if (node[i] == 'T')
        result = result *2 + 1;
      else
        result = result *2 + 0;

    return result;
  }

  public static char[] getNode(int index) {
    char[] result = new char[4];

    for (int i = 0; i < 4; i++) {
      int digit = index % 2;
      if (digit == 0)
        result[3 - i] = 'H';
      else
        result[3 - i] = 'T';
      index = index / 2;
    }

    return result;
  }
  
  public List<Integer> getShortestPath(int nodeIndex) {
    return tree.getPath(nodeIndex);
  }

  public static void printNode(char[] node) {
    for (int i = 0; i < 4; i++)
     
        System.out.print(node[i]);
    
    System.out.println();

   
  }
}
