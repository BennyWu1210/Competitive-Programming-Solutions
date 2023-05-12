
import java.io.*;
import java.util.*;

public class aac5p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 2*(int)1e5 + 5;
	static int[] s, res;
	static List<Hill>[] adj;
	static int N, K;
	
	
	static class Hill implements Comparable<Hill>{
		int u, w;
		public Hill(int u, int w) {
			this.u = u; this.w = w;
		}
		@Override
		public int compareTo(Hill o) {
			return this.w - o.w;
		}
	}
	
	static void dfs(int u, int lef, int rit) {
		
		
		res[u] = rit - lef + 1;
		
		if (adj[u].size() == 0) return;
		
		int ind = lef;
		
		for (int i=0; i<adj[u].size()-1; i++) {
			int l = ind, r = rit, ans = l;
			
			Hill first = adj[u].get(i);
			Hill second = adj[u].get(i + 1); 
			
			if (Math.abs(s[l] - first.w) > Math.abs(s[l] - second.w)) continue;
			
			// find a bisector such that the left pandas will go through the first hill
			int target = (second.w + first.w) / 2;
			
			while (l <= r) {
				int mid = (l + r) / 2;
				
				if (s[mid] <= target) {
					l = mid + 1;
					ans = mid;
				} else {
					r = mid - 1;
				}
			}
			
			// continue to dfs
			dfs(first.u, ind, ans);
			ind = r + 1;
			if (ans == rit) break;
			
		}
		// System.out.println("out!");

		if (ind <= rit) {
			dfs(adj[u].get(adj[u].size()-1).u, ind, rit);
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		
		N = readInt(); K = readInt();
		
		adj = new ArrayList[N+1];
		s = new int[K+1];
		res = new int[N+1];
		
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
		
		for (int i=1; i<N; i++) {
			int u = readInt(), v = readInt(), w = readInt();
			adj[u].add(new Hill(v, w)); 
		}
		
		for (int i=1; i<=N; i++) {
			if (adj[i].size() == 0) continue;
			Collections.sort(adj[i]);
		}
		
		for (int i=1; i<=K; i++) s[i] = readInt();
		Arrays.sort(s, 1, K + 1);
		
		dfs(1, 1, K);
		
		for (int i=1; i<N; i++) System.out.print(res[i] + " ");
		System.out.println(res[N]);
		
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

/*
7 6
1 2 3
1 4 4
1 5 5 
2 3 1
2 6 3
4 7 6
1 2 3 4 5 6
 */
	
	
