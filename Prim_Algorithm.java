import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Prim_Algorithm {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[] lowestCost;   // 
	static int[][] graph;  //Stores the cost from a vertex to another
	static boolean[] mstSet;
	static int[] parent;
	static int vertices;
	static int edges;


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		vertices = readInt();
		edges = readInt();
		graph = new int[vertices][vertices];
		parent = new int[vertices];
		lowestCost = new int[vertices];
		mstSet = new boolean[vertices];
		Arrays.fill(lowestCost, Integer.MAX_VALUE);
		Arrays.fill(parent, -1);
		
		for(int i=0; i<edges; i++){
			int bv = readInt();
			int ev = readInt();
			int cost = readInt();
			graph[bv-1][ev-1] = cost;
			graph[ev-1][bv-1] = cost;

		}

		lowestCost[0] = 0;

		while (true) {
			int currentVertex = findMinimum();

			if (currentVertex == -1) {
				break;
			}

			mstSet[currentVertex] = true;

			for (int target=0; target<vertices; target++) {
				if(!mstSet[target] && graph[currentVertex][target] != 0 && graph[currentVertex][target] < lowestCost[target]) {
					lowestCost[target] = graph[currentVertex][target];
					parent[target] = currentVertex;
				}
			}

		}
		
		for (int i=1; i<vertices; i++) {
			System.out.println(i+1 + ", " + (parent[i]+1) + ", " + lowestCost[i]);
		}




	}

	public static class Edge {
		int bv;
		int cost;
		public Edge(int bv, int cost){
			this.bv = bv;
			this.cost = cost;
		}

	}

	public static int findMinimum() {
		int minimum = Integer.MAX_VALUE;
		int index = -1;
		for (int i=0; i<lowestCost.length; i++) {
			if (!mstSet[i] && lowestCost[i] < minimum) {
				minimum = lowestCost[i];
				index = i;
			}
		}
		return index;

	}

	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}

}



