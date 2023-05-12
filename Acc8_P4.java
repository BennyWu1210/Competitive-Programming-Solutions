
import java.io.*;
import java.util.*;

public class Acc8_P4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static ArrayList<Integer>[] adj;
	static int[] dist;
	static int[] ans;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		adj = new ArrayList[N];
		for (int i=0; i<N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<N-1; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		
		
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>();
		dist = new int[N];
		ans = new int[N];
		visited = new boolean[N];
		
		pq.add(new int[]{0, 0});
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		
		while(!pq.isEmpty()) {
			int[] next = pq.poll();
			
			if (dist[next[0]] != next[1]) continue;
			
			visited[next[0]] = true;
			
			for (int v: adj[next[0]]) {
				if (!visited[v] && dist[v] < dist[next[0]] + 1) {
					dist[v] = dist[next[0]] + 1;
					pq.add(new int[] {v, dist[v]});
				}
			}
			
			
		}
		
		for (int i=0; i<dist.length; i++) {
			ans[dist[i]] ++;
		}
		
		int Q = readInt();
		
		for (int q=0; q<Q; q++) {
			int ans = 0;
			for (int v=0; v<adj.length; v++) {
				if ()
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


	
	
