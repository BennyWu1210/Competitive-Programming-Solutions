import java.io.*;
import java.util.*;
public class Ccc03s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] parent;
	static int[] keys;
	static boolean[] mstSet;
	static ArrayList<Edge>[] adjList;
	static int V;
	static int E;
	static int D;
	
	public static class Edge{
		public int ev;
		public int cost;
		public boolean destination;
		public Edge(int ev, int cost) {
			this.ev = ev;
			this.cost = cost;
		}
		
	}
	
	public static int findNextKey() {
		int maximum = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i=0; i<keys.length; i++) {
			if (!mstSet[i] && keys[i]>maximum) {
				maximum = keys[i];
				maxIndex = i;
			}
		}
		//System.out.println(maxIndex);
		return maxIndex;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		V = readInt();
		E = readInt();
		D = readInt();
		
		adjList = new ArrayList[V];
		for(int i=0; i<adjList.length; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for(int i=0; i<E; i++) {
			int bv = readInt();
			int ev = readInt();
			int cost = readInt();
			adjList[bv-1].add(new Edge(ev-1, cost));
			adjList[ev-1].add(new Edge(bv-1, cost));
			
		}
		//boolean[] destinations = new boolean[V];
		int[] destinations = new int[D];
		for(int i=0; i<D; i++){
			int des = readInt();
//			destinations[des-1] = true;
			destinations[i] = des-1;
			
		}
		
		keys = new int[V];
		parent = new int[V];
		mstSet = new boolean[E];
		
		Arrays.fill(keys, Integer.MIN_VALUE);
		Arrays.fill(parent, -1);
		keys[0] = Integer.MAX_VALUE;
		
		while(true){
			int nextKey = findNextKey();
			//System.out.println(nextKey);
			if (nextKey == -1) {
				break;
			}

			mstSet[nextKey] = true;
			
			
			for(Edge e: adjList[nextKey]) {
//				System.out.println(keys[e.ev] + " " + e.cost);
//				System.out.println(mstSet[e.ev]);
//				System.out.println("e.ev:" + e.ev);
				if (!mstSet[e.ev] && keys[e.ev] < e.cost) {
					
					keys[e.ev] = e.cost; 
					parent[e.ev] = nextKey; 
//					System.out.println("next:" + nextKey);
					
				}
			}
		} 
		
//		for(int i=0; i<parent.length; i++) {
//			System.out.println(i+1 + " " + (parent[i]+1) + 
//						" " + keys[i]);
//		}
		
		boolean[] checked = new boolean[V];
		checked[0] = true;
		int smallest = Integer.MAX_VALUE;
		for (int d: destinations) {
			while(!checked[d]) {
				smallest = Math.min(smallest, keys[d]);
				checked[d] = true;
				d = parent[d];
			}
		}
		
		System.out.println(smallest);
		
		
		
		
		
		
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


