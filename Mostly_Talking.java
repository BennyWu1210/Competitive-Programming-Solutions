import java.io.*;
import java.util.*;

public class Mostly_Talking {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

//	static int N, M;
//	static ArrayList<Node>[] adj, revAdj;
//	static int[] dist, revDist;

	static class Node implements Comparable<Node>{
		int u, cost;

		public Node(int u, int cost) {
			this.u = u;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {

		int N = readInt(),  M = readInt();
		ArrayList<Node>[] adj = new ArrayList[N+1], revAdj = new ArrayList[N+1];;
		

		for (int i=0; i<=N; i++) {
			adj[i] = new ArrayList<Node>();
			revAdj[i] = new ArrayList<Node>();
		}

		for (int i=0; i<M; i++) {
			int bv = readInt(), ev = readInt(), cost= readInt();

			adj[bv].add(new Node(ev, cost));
			revAdj[ev].add(new Node(bv, cost));

		}
		
		

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		PriorityQueue<Node> revPq = new PriorityQueue<Node>();
		pq.add(new Node(1, 0));

		int[] dist = new int[N+1], revDist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE); Arrays.fill(revDist, Integer.MAX_VALUE);

		// run dijkstra from beginning

		dist[1] = 0;

 		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if (cur.cost != dist[cur.u]) continue;

			
			for (Node next: adj[cur.u]) {
				if (dist[cur.u] + next.cost < dist[next.u]) {
					dist[next.u] = dist[cur.u] + next.cost;
					pq.add(new Node(next.u, dist[next.u]));
				}
			}
		}


		// run dijkstra on reverse graph form Node N

		revDist[N] = 0;
		revPq.add(new Node(N, 0));

		while (!revPq.isEmpty()) {
			Node cur = revPq.poll();

			if (cur.cost != revDist[cur.u]) continue;
			
			for (Node next: revAdj[cur.u]) {
				if (revDist[cur.u] + next.cost < revDist[next.u]) {
					revDist[next.u] = revDist[cur.u] + next.cost;
					revPq.add(new Node(next.u, revDist[next.u]));
				}
			}
		}

		
		int D = readInt();
		int min = dist[N];
		for (int i=0; i<D; i++) {
			int u = readInt(), v = readInt(), cost = readInt();
			if (dist[u] != Integer.MAX_VALUE && revDist[v] != Integer.MAX_VALUE) {
				min = Math.min(min, dist[u] + cost + revDist[v]);
			}
		}
		
		if (min == dist[N] && dist[N] == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}

		System.out.println(min);
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