package dijkstra;

import java.util.HashMap;
import java.util.Map;

import graph.Graph;
import graph.ShortestPath;
import graph.ShortestPath.Animator;
import graph.ShortestPath.Distances;

public class Dijkstra<T> implements ShortestPath<T> {
	
	private Distances<T> dst; // besoin cela pour afin de le renvoyer dans la methode compute
	private Map<T,Integer> dist;
	private Map<T,T> pred;
	
	public Dijkstra(){
		dist = new HashMap<>();
		pred = new HashMap<>();
		dst = new Distances<T>(dist,pred);
	}
	// revoie un type Distances qui compose des plus courts chemins et leurs predecesseurs
	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException{
		
		
		return dst;
	}
	

}
