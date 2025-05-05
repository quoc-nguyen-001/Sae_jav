package graph;

public class Appli extends UnVarGraph {
    public static void main(String[] args) {
        // Créer une instance de Appli
        Appli appli = new Appli();
        
        // Appeler la méthode peupler via l'instance
        appli.peupler("A-B(5), A-C(10), B-C(3), C-D(8), E:");
        
        // Affichage du contenu du graphe
        System.out.println("Graph: " + appli.graph);
    }
}
