package ad_a10_2;

import java.util.Arrays;

public class VisitNodes2 {

	static boolean[][] graph = { { false, false, false, false, true, false, true, true, false },
			{ false, false, true, false, false, false, false, false, true },
			{ false, false, false, false, false, false, false, false, false },
			{ false, false, false, false, false, true, false, false, false },
			{ false, false, false, false, false, false, false, true, false },
			{ false, false, false, false, true, false, false, false, false },
			{ false, true, false, false, false, false, false, false, false },
			{ false, false, false, true, false, false, false, false, false },
			{ false, false, false, false, false, false, false, false, false }, };

	static boolean[][] usedEdges = new boolean[graph.length][graph[0].length];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < usedEdges.length; i++) {
			Arrays.fill(usedEdges[i], false);
		}

		int v = 0;
		System.out.println("stating at node" + v);
		deepFirstSearch(v);

		boolean checkArrays = true;
		for (int i = 0; i < usedEdges.length - 1; i++) {
			for (int j = 0; j < usedEdges[i].length; j++) {
				if (graph[i][j] != usedEdges[i][j]) {
					checkArrays = false;
				}
			}
		}
		
		if(checkArrays){
			System.out.println("Zusammenhängend");
		}else{
			System.out.println("nicht zusammenhängend");
		}

	}

	private static void deepFirstSearch(int v) {
		// TODO Auto-generated method stub

		for (int i = 0; i < graph[v].length; i++) {
			if (graph[v][i]) {
				if (!usedEdges[v][i]) {
					usedEdges[v][i] = true;
					System.out.println("  marking edge (" + v + ", " + i +")");
					System.out.println("visting node " + i);
					deepFirstSearch(i);
				}
			}
		}

	}

}
