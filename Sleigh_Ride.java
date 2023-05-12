
import java.io.*;
import java.util.*;

public class Sleigh_Ride {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		
		
		int u, cost;
		
		public Node(int u, int cost) {
			this.u = u;
			this.cost = cost;
		}
	}
	static int MM = (int)1e5 + 5;
	static int deepest = 0;
	static ArrayList<Node>[] adj = new ArrayList[MM];

	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		for (int i=0; i<=N; i++) adj[i] = new ArrayList();
		
		int totDist = 0;
		
		for (int i=0; i<N; i++) {
			int u = readInt(), v = readInt(), c = readInt();
			adj[u].add(new Node(v, c));
			adj[v].add(new Node(u, c));
			totDist += c;
		}
		
		totDist *= 2;
		
		int[] step = new int[N+1];
		Arrays.fill(step, Integer.MAX_VALUE);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(0);
		step[0] = 0;
		
		
		while (!q.isEmpty()) {
			int nxt = q.poll();
			
			for (Node v: adj[nxt]) {
				if (step[v.u] > step[nxt] + v.cost) {
					step[v.u] = step[nxt] + v.cost;
					deepest = Math.max(deepest, step[v.u]);
					q.add(v.u);
				}
			}
		}
		
		
		System.out.println(totDist - deepest);
		
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


	
	
