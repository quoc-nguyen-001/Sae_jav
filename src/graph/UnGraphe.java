package graph;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
/**
 * Classe qui implements l'interface Graphe 
 * Creer un graphe
 * Pour chaque sommet doit contenir une liste d'objet Arc<T> avec leur poids et leur destination, car un sommet peut avoir plusieurs destinations
 * On creer une map afin de retrouver plus facilement les sommets 
 * @param <T> Identifiant des sommets. Le type T doit être "hachable".
 */
public class UnGraphe<T> implements Graph<T> {

    public Map<T, List<Arc<T>>> graph;

    public UnGraphe() {
        graph = new HashMap<>();
    }
    
    @Override
    public List<Arc<T>> getSucc(T s) {
        return graph.getOrDefault(s, null); // Renvoie une nulle si le sommet n'existe pas
    }
}
