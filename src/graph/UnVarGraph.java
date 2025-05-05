package graph;

import java.util.ArrayList;

public class UnVarGraph extends UnGraphe<String> implements VarGraph {
	public UnVarGraph() {
		super();
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
