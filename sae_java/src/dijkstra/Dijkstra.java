package dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import graph.Graph;
import graph.Graph.Arc;
import graph.ShortestPath;

public class Dijkstra<T> implements ShortestPath<T> {
	@Override
	public Distances<T> compute(Graph<T> g, T src, Animator<T> animator) throws IllegalArgumentException {
		Map<T, Integer> dist = new HashMap<>();
		Map<T, T> pred = new HashMap<>();
		List<T> sommetsReconnus = new LinkedList<>();

		dist.put(src, 0);
		pred.put(src, null);
		sommetsReconnus.add(src);
		animator.accept(src, 0);

		while (true) {
			int minPoids = Integer.MAX_VALUE;
			T prochainSommet = null;
			T sonPredecesseur = null;

			for (T sommet : sommetsReconnus) {
				for (Arc<T> arc : g.getSucc(sommet)) {
					T successeur = arc.dst();
					int poids = arc.val();

					if (poids < 0) {
						throw new IllegalArgumentException("Arc négatif détecté");
					}

					if (!sommetsReconnus.contains(successeur)) {
						int newDist = dist.get(sommet) + poids;
						if (newDist < minPoids) {
							minPoids = newDist;
							prochainSommet = successeur;
							sonPredecesseur = sommet;
						}
					}
				}
			}

			if (prochainSommet == null) {
				break;
			}

			dist.put(prochainSommet, minPoids);
			pred.put(prochainSommet, sonPredecesseur);
			sommetsReconnus.add(prochainSommet);
			animator.accept(prochainSommet, minPoids);
		}

		return new Distances<>(dist, pred);
	}

}
