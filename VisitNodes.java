package ad_a10_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Durchlaufen von Graphen, Algorithmus zu Skript S.95
 *
 * @author chh
 */
public class VisitNodes {

	// Adjacency matrix
	static boolean[][] graph = { { false, false, false, false, true, false, true, true, false },
			{ false, false, true, false, false, false, false, false, true },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, true, false, false, false },
			{ false, false, false, false, false, false, false, true, false },
			{ false, false, false, false, true, false, false, false, false },
			{ false, true, false, false, false, false, false, false, false },
			{ false, false, false, true, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false }, };

	// Init b and r
	static boolean[] b = new boolean[graph.length];
	static ArrayList<Integer> r = new ArrayList<Integer>();

	public static void main(String[] args) {
		// Hier den Algorithmus implementieren:
		// ...

		boolean[][] usedEdges = new boolean[graph.length][graph[0].length];

		b[0] = true;
		r.add(0);
		while (r.size() > 0) {
			int v = r.get(new Random().nextInt(r.size()));
			boolean hasEdges = false;
			for (int w = 0; w < graph[v].length; w++) {
				if (graph[v][w] && usedEdges[v][w]) {
					System.out.println("Removing vertex " + v);
					r.remove((Integer) v);
					hasEdges = true;
//					break;
				}
			}
				for (int w = 0; w < graph[v].length; w++) {
					if (graph[v][w] && !usedEdges[v][w]) {
						System.out.println("Mark edge (" + v + ", " + w + ") as true");
						usedEdges[v][w] = true;
						if (!b[w]) {
							System.out.println("Add " + w + " to data structures");
							b[w] = true;
							r.add(w);
						}
					}
				}
			
			boolean zusammenhaengend = true;
			for (int i = 0; i < b.length; i++) {
				if(!b[i]) zusammenhaengend = false;
			}
			if(zusammenhaengend) {
				System.out.println("Zusammen");
				break;
			} else {
				System.out.println("nicht");
				break;
			}
		}
	}
}