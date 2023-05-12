
import java.io.*;
import java.util.*;

public class vmss7wc15c4p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = (int)1e5 + 5;
	static int N, M, ans;
	static int[] dis = new int[MM], dis2 = new int[MM];
	static List<Node>[] adj = new ArrayList[MM];
	
	static class Node implements Comparable<Node>{
		int u, d;
		public Node(int u, int d) { this.u = u; this.d = d; }

		public int compareTo(Node o) { return this.d - o.d;}
	}
	
	static void dijkstra(int start, int[] res) {
		PriorityQueue<Node> pq = new PriorityQueue();
		pq.add(new Node(start, 0));
		
		Arrays.fill(res, Integer.MAX_VALUE); res[start] = 0;
		
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (res[cur.u] < cur.d) continue;
			
			for (Node nxt: adj[cur.u]) {
				if (res[nxt.u] > cur.d + nxt.d) {
					res[nxt.u] = cur.d + nxt.d;
					pq.add(new Node(nxt.u, res[nxt.u]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = readInt(); M = readInt();
		
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
		
		for (int i=0; i<M; i++) {
			int u = readInt() + 1, v = readInt() + 1, w = readInt();
			adj[u].add(new Node(v, w)); adj[v].add(new Node(u, w));
		}
		
		dijkstra(1, dis); dijkstra(N, dis2);
		
		for (int i=1; i<=N; i++) ans = Math.max(dis[i] + dis2[i], ans);
		
		System.out.println(ans);
		
		
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
}


	
	
