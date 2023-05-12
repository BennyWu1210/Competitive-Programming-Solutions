import java.io.*;
import java.util.*;
public class MockCCC18_S5_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String[] input1 = readLine().split(" ");
		int N = Integer.parseInt(input1[0]);
		int M = Integer.parseInt(input1[1]);
		System.out.println(N + " " + M);
		parent = new int[N+1];
		Arrays.fill(parent, -1);
		
		original_arr = new Edge[M];
		edge = new Edge[M];
		mst = new LinkedList<Edge>();
		
		for(int i=0; i<M; i++) {
			String[] input2 = readLine().split(" ");
			int bv = Integer.parseInt(input2[0]);
			int ev = Integer.parseInt(input2[1]);
			int cost = Integer.parseInt(input2[2]);
			edge[i] = new Edge(bv, ev, cost, i+1);
			original_arr[i] = edge[i];
			System.out.println(bv + " " + ev + " " + cost);
		}
		//for(Edge e: edge) System.out.println(e);
		
		if (edge.length > 1) Arrays.sort(edge);
		for (Edge e: edge) {
			int broot = find(e.bv);
			int eroot = find(e.ev);
			if (broot != eroot) {
				union(broot, eroot);
				mst.add(e);
				
			}
		}
		
//		for (Edge e: mst) {
//			System.out.println(e);
//		}
		
		String[] input3 = readLine().split(" ");
		int Q = Integer.parseInt(input3[0]);
		//System.out.println("Q" + Q);
		for(int i=0; i<Q; i++) {
			String[] input2 = readLine().split(" ");
			int command = Integer.parseInt(input2[0]);
			if (command == 1) {  // Update
				int m_i = Integer.parseInt(input2[1]);
				int x_i = Integer.parseInt(input2[2]);
				System.out.println(Q + " " + m_i + " " + x_i);
				//System.out.println(edge[m_i-1]);
				original_arr[m_i-1].changeCost(x_i);
				//System.out.println(edge[m_i-1]);
				Arrays.sort(edge);
//				mst.clear();
//				Arrays.fill(parent, -1);
//				for (Edge e: edge) {
//					int broot = find(e.bv);
//					int eroot = find(e.ev);
//					if (broot != eroot) {
//						union(broot, eroot);
//						mst.add(e);
//					}
//				}
				
				
				
			}
			else if (command == 2) { // Query
				int a_i = Integer.parseInt(input2[1]);
				int b_i = Integer.parseInt(input2[2]);
				int w_i = Integer.parseInt(input2[3]);
				System.out.println(Q + " " + a_i + " " + b_i + " " + w_i);
				Arrays.sort(edge);
				Arrays.fill(parent, -1);
				//int split = Collections.binarySearch(edge, 1);
				// Splits the array into the cost higher
				//System.out.println("w: " + w_i);
				int split = binarySearch(0, edge.length-1, w_i);
				Edge[] temp = new Edge[split];
				//System.out.println(split);
				for(int j=0; j<split; j++) {
					temp[j] = edge[j];
					//System.out.println(edge[j]);
				}
				//for(Edge e: temp) System.out.println(e);
				//System.out.println("split " + split);
				for (Edge e: temp) {
					int broot = find(e.bv);
					int eroot = find(e.ev);
					if (broot != eroot) {
						union(broot, eroot);
						
						//mst.add(e);   Don't have to see what the tree looks like
					}
				}
				for(Edge e: edge) System.out.println(e);
				for(int a: parent) System.out.println(a);
				if (((parent[a_i] == -1 || parent[b_i] == -1) && 
						(parent[a_i] == b_i || parent[b_i] == a_i)) || 
						(parent[a_i] != -1 && parent[b_i] != -1 && parent[a_i] == parent[b_i])) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
/*
 	
3 2
1 2 5
2 3 10
3
2 1 2 5
1 1 4
2 1 2 5
 */
				
				//System.out.println(a_i + " " + b_i + " " + w_i);
						
			}
			
		}
	}
	
	static int[] parent;
	static Edge[] original_arr;
	static Edge[] edge;
	static LinkedList<Edge> mst;
	public static class Edge implements Comparable<Edge>{

		int bv;
		int ev;
		public int num;
		public int cost;
		public Edge(int bv, int ev, int cost, int num) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
			this.num = num;
		}
		
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return - this.cost + o.cost;
		}
		
		public void changeCost(int c) {
			this.cost = c;
		}
		
		public String toString() {
			return "Edge object: bv: " + this.bv  + " ev: " + ev + " cost: " + this.cost;
		}
		
	}
	
	public static int find(int x) {
		if (parent[x] == -1) return x;
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		parent[a] = b;
	}
	
	public static int binarySearch(int a, int b, int f) {
		while(a<=b) {
			int mid = (a+b)/2;
			//System.out.println(a + " " + b + " mid " + mid);
			if (edge[mid].cost > f) a = mid+1;
			else if (edge[mid].cost < f) b = mid-1;
			else {
				if (edge[mid].cost > f) b = mid+1;
				else if (edge[mid].cost < f) a = mid-1;
				return mid+1;
			}
		
		}
		return a;
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

