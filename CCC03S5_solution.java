import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CCC03S5_solution {
	public static boolean[] mstSet;  //if vertice in MST or not
	public static int[] maxCost;
	public static int[] parent;
	public static int V;
	public static class Edge {
		int ev;
		int cost;
		public Edge(int ev, int cost) {
				this.ev = ev;
				this.cost = cost;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		int d = sc.nextInt();
		int[] dest = new int[d];
		ArrayList<Edge>[] graph = new ArrayList[V];
		for (int i=0; i<V; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		for (int i=0; i<E; i++) {
			int bv = sc.nextInt()-1;
			int ev = sc.nextInt()-1;
			int cost = sc.nextInt();
			graph[bv].add(new Edge(ev, cost));
			graph[ev].add(new Edge(bv, cost));	
		}
		for (int i = 0 ; i < d ; i++)
			dest [i] = sc.nextInt()-1;
		
		parent = new int[V];
		mstSet = new boolean[V];
		maxCost = new int[V];
		Arrays.fill(parent,-1);
		Arrays.fill(maxCost, Integer.MIN_VALUE);
		maxCost[0] = Integer.MAX_VALUE;
		while (true) {
			int next = findNext();
			if (next==-1) {
				break;   //no next vertice
			}
			mstSet[next] = true;
			//find all neighbor edge update lowCost and parent table
			for (Edge e:graph[next]) {
				if (mstSet[e.ev]==false   //e.ev is neighbor vertice
						&& maxCost[e.ev]<e.cost) {
					maxCost[e.ev] = e.cost;
					parent[e.ev] = next;
				}
			}
		}
		int smallest = 100000;
		boolean vis[] = new boolean[V];
		vis[0] = true;
		for (int i = 0 ; i < d ; i++) {
			int crnt = dest[i];
			while(!vis[crnt]) {
				smallest = Math.min(smallest, maxCost[crnt]);
				vis[crnt] = true;
				crnt = parent[crnt];
			}
		}

		System.out.println(smallest);


	}

	public static int findNext() {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i=0; i<V; i++) {
			if (mstSet[i]==false && maxCost[i]>max) {
				max = maxCost[i];
				maxIndex = i;
			}
		}
		return maxIndex;
	}
}
