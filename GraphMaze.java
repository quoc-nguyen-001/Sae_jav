package adaptator;

import java.util.ArrayList;
import java.util.List;
import graph.Graph;
import maze.Maze;

public class GraphMaze<C> implements Graph<C> {

	private final Maze<C> maze;

	public GraphMaze(Maze<C> maze) {
		this.maze = maze;
	}

	@Override
	public List<Arc<C>> getSucc(C s) {
		List<Arc<C>> arcs = new ArrayList<>();
		for (C neighbor : maze.openedNeighbours(s)) {
			arcs.add(new Arc<>(1, neighbor)); 
		}
		return arcs;
	}
}
