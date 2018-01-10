package application;

import java.util.List;


public class UnweightedGraph<V> extends AbstractGraph {
	public UnweightedGraph(int[][] edges, V[] vertices){
		super(edges, vertices);
	}
	public UnweightedGraph(List<Edge> edges, List<V> vertices){
		super(edges, vertices);
	}
	public UnweightedGraph(List<Edge> edges, int numberOfvertices){
		super(edges, numberOfvertices);
	}
	public UnweightedGraph(int[][] edges, int numberOfvertices){
		super(edges, numberOfvertices);
	}

	
}
