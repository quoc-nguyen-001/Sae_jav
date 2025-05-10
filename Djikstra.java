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
	

	// revoie un type Distances qui compose des plus courts chemins et leurs predecesseurs
	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException{
		
		
		Map<T,Integer> dist = new HashMap<>();
		Map<T,T> pred = new HashMap<>();
		
		List<T> sommets_reconnus = new LinkedList<>();

		
		dist.put(src, 0);
        	pred.put(src, null);
        
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
				
				for(Arc<T> arc : arcs) { // voir tous ses arcs
					if(arc.val() < 0) {
						throw new IllegalArgumentException("Arc négatif détecté");
					}
					
					if(!sommet_existant(sommets_reconnus, arc.dst())) {// si le sommet est deja reconnu alors on sen fiche l'arc pour eviter des boucles
						if(poids_arc > arc.val() + dist.get(sommet)) {
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
			
			
		}
		
		
		
	}
	
	private boolean sommet_existant(List<T> sommets_reconnus, T sommet) {
		for(T sommet_1 : sommets_reconnus) {
			if(sommet == sommet_1) {
				return true;
			}
		}
		return false;
	}
}
