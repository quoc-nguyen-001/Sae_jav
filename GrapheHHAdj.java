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
}
