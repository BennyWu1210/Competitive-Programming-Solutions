
import java.io.*;
import java.util.*;

public class oly22practice25 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 5;
	static int N, M, X;
	static List<Node>[] adj = new ArrayList[MN], rAdj = new ArrayList[MN];
	static int[] cost1 = new int[MN], cost2 = new int[MN];
	
	static class Node implements Comparable<Node>{
		int u, w;
		public Node(int u, int w){
			this.u = u; this.w = w;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.w - o.w;
		}
	}
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt(); X = readInt();
		
		for (int i=1; i<=N; i++) {
			adj[i] = new ArrayList();
			rAdj[i] = new ArrayList();
		}
		
		for (int i=0; i<M; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Node(v, w));
			rAdj[v].add(new Node(u, w));
		}
		
		
		// Two dijkstras
		
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(X, 0));
		Arrays.fill(cost1, (int)1e9);
		cost1[X] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			// if (cur.w != cost1[X]) continue;
			
			for (Node nxt: adj[cur.u]) {
				if (cost1[cur.u] + nxt.w < cost1[nxt.u]) {
					cost1[nxt.u] = cost1[cur.u] + nxt.w;
					pq.add(new Node(nxt.u, cost1[nxt.u]));
				}
			}
		}
		
		pq = new PriorityQueue();
		pq.add(new Node(X, 0));
		Arrays.fill(cost2, (int)1e9);
		cost2[X] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			// if (cur.w != cost2[X]) continue;
			
			for (Node nxt: rAdj[cur.u]) {
				if (cost2[cur.u] + nxt.w < cost2[nxt.u]) {
					cost2[nxt.u] = cost2[cur.u] + nxt.w;
					pq.add(new Node(nxt.u, cost2[nxt.u]));
				}
			}
		}
		
		int ans = Integer.MIN_VALUE;
		for (int i=1; i<=N; i++) {
			if (i == X) continue;
			ans = Math.max(ans, cost1[i] + cost2[i]);
		}
			
		System.out.println(ans);
		
		
		
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


	
	
