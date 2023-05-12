import java.io.*;
import java.util.*;
public class D_Police_Stations{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	// A BFS problem where the police stations are starting points
	// The idea is to traverse through all the nodes
	// If the steps there is lower or equal to prev.step + 1
	// Remove this edge
	
	public static class Node{
		int bv;
		int index;
		public Node(int bv, int index) {
			this.bv = bv;
			this.index = index;
		}
	}
	public static ArrayList<Node>[] adjList;
	public static int n;
	public static int k;
	public static int d; 
	public static int[] steps; 
	public static LinkedList<Integer> queue; 
	
	
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		k = readInt();
		d = readInt();
		
		adjList = new ArrayList[n];
		
		steps = new int[n]; // Keep track of distance to reach this city
		Arrays.fill(steps, Integer.MAX_VALUE);
		queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[n];

		for(int i=0; i<k; i++) {
			int city = readInt()-1;
			steps[city] = 0;
			queue.add(city); // Add the cities with a police station
			visited[city] = true;
		}
		
		// Read city input
		
		for(int i=0; i<n; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		
		// HashMap<int[], Integer> map = new HashMap<int[], Integer>();
		
		for(int i=0; i<n-1; i++) {
			int bv = readInt()-1;
			int ev = readInt()-1;
			adjList[bv].add(new Node(ev, i));
			adjList[ev].add(new Node(bv, i));
//			map.put(new int[] {bv, ev}, i+1);
//			map.put(new int[] {ev, bv}, i+1);
		}
		
		
		boolean[] ans = new boolean[n];
		int counter = 0;
		while(!queue.isEmpty()) {
			int city = queue.poll();
			// System.out.println(city);
			for(Node next: adjList[city]) {
//				System.out.println("neighbour: " + next.bv + " " + next.index);
//				System.out.println(Arrays.toString(steps));
				if (ans[next.index]) continue;
				if (steps[city]  <= steps[next.bv]) {
					if (visited[next.bv]) {
						ans[next.index] = true;
						counter ++;
					}
					steps[next.bv] = steps[city] + 1;
					queue.add(next.bv);
					visited[next.bv] = true;
				}
				
			}
		}
		
		
		System.out.println(counter);
		for(int i=0; i<ans.length; i++) {
			if(ans[i]) {
				System.out.print((i+1) + " ");
			}
		}
		
		
		
		
		
		

		
		
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
