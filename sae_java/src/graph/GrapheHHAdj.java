package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrapheHHAdj implements VarGraph {
	private Map<String, List<Arc<String>>> graph;

    public GrapheHHAdj() {
        graph = new HashMap<>();
    }

	@Override
	public List<Arc<String>> getSucc(String s) {
		return graph.getOrDefault(s, null); // Renvoie une nulle si le sommet n'existe pas
	}

	@Override
	public void ajouterSommet(String noeud) {
		if(!graph.containsKey(noeud)) { // si le sommet n'existe alors on ajoute sinon rien faire
			graph.put(noeud, new ArrayList<>()); //creer une liste vide et enregistre le sommet et la liste dans la map
		}
	}

	@Override
	public void ajouterArc(String source, String destination, Integer valeur) {
		if(graph.containsKey(source) && graph.containsKey(destination) ) { //verifier si les sommets de la source et destination existent dans la map
			graph.get(source).add(new Arc<>(valeur,destination));
		}
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    for (Map.Entry<String, List<Arc<String>>> entry : graph.entrySet()) { // boucle pour chaque indice dans la map afin de voir tous les arcs de chaque sommet
	    	List<Arc<String>> arcs = entry.getValue();
	    	if(arcs == null || arcs.isEmpty() ) {
	    		sb.append(entry.getKey()).append(":").append(", ");
	    	}
	    	else {
	    		for(Arc<String> arc: arcs)
	    	        sb.append(entry.getKey()).append("-").append(arc.dst()).append("(").append(arc.val()).append(")").append(", ");
	    	}
	    	
	    }
	    
	    sb.setLength(sb.length() - 2); //supprime la virgule a la fin
	    return sb.toString();
	}
}
