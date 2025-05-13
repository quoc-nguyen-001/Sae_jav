package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graph.Graph;
import graph.Graph.Arc;
import graph.ShortestPath;
import graph.ShortestPath.Animator;
import graph.ShortestPath.Distances;

public class Dijkstra<T> implements ShortestPath<T> {
	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException{
		Map<T,Integer> dist = new HashMap<>();
		Map<T,T> pred = new HashMap<>();
		List<T> sommets_reconnus = new LinkedList<>();

		dist.put(src, 0);
        pred.put(src, null);
        animator.accept(src, 0);
        
		T sommetActuel = src;
		sommets_reconnus.add(sommetActuel);
		
		List<Arc<T>> arcs = g.getSucc(sommetActuel);
		if (arcs == null) {
			//END
		}
		
		T sommetDestination = null;
		T son_pred = null;
		
		while(true) {
			int poids_arc = Integer.MAX_VALUE;
			
			for(T sommet : sommets_reconnus) { //voir tous les arcs des sommets deja reconnus
				arcs = g.getSucc(sommet);
				if(arcs != null) {
					for(Arc<T> arc : arcs) { // voir tous ses arcs
						if(arc.val() < 0) {
							throw new IllegalArgumentException("Arc négatif détecté");
						}
						
						if(!sommets_reconnus.contains(arc.dst()) && poids_arc > arc.val() + dist.get(sommet) ) {// si le sommet est deja reconnu alors on sen fiche l'arc pour eviter des boucles
							poids_arc= arc.val() + dist.get(sommet);
							sommetDestination= arc.dst();
							son_pred = sommet ;
						}
					}
				}
				
			}
			if(sommetDestination == sommetActuel ) {
				return new Distances<>(dist,pred);
			}
			
			sommetActuel = sommetDestination;
			sommets_reconnus.add(sommetActuel);
			
			dist.put(sommetActuel, poids_arc);
	        pred.put(sommetActuel, son_pred);
	        animator.accept(sommetActuel, poids_arc);
			
		}
		
		
		
	}
}
