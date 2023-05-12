
import java.io.*;
import java.util.*;

public class UsacoJanP3 {

	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	

	static class Pair{
		int cow, pref; // pref -> 1 is first choice, 2 is second choice
		public Pair(int a, int b) {
			this.cow = a; this.pref = b;
		}
	}
	
	static final int MN = (int)1e5+3;
	static int[][] dp = new int[MN][3];
	static boolean[] taken = new boolean[MN];
	static boolean[] end = new boolean[MN];
	static List<Pair>[] cereal = new ArrayList[MN];
	static int[] f = new int[MN], s = new int[MN];
	static int N, M;
	static boolean[] vis1 = new boolean[MN];
	static List<Integer>[] adj = new ArrayList[MN];
	static Deque<Integer> dq = new LinkedList();
	
	static void dfs(int u) {
		if (end[u]) return;
		vis1[u] = true;
		for (int v: adj[u]) {
			if (!vis1[v]) dfs(v);
		}
		dq.addFirst(u);
	}
	
	static void compute() {
		for (int i=1; i<=N; i++) {
			if (!vis1[i] && !end[i]) {
				vis1[i] = true;
				dfs(i);
			}
		}
		for (int i=1; i<=N; i++) {
			if (end[i]) {
				dq.addLast(i);
				//System.out.println("i: " + i);
			}
		}

	}
	
	static int solve(int i, int take, List<Integer>[] adj, boolean[] vis, boolean[] crl, boolean[] end) {

		vis[i] = true;
		if (take == 1) crl[f[i]] = true;
		if (take == 2) crl[s[i]] = true;
		
		int res = 0, ind = 0;
		boolean ff = false;
		for (int id=1; id<N; id++) {
			if (!vis[id]) {
				if (!crl[f[id]]) {
					int a = solve(id, 1, adj, vis, crl, end);
					if (a > res) {
						res = a;
						ind = id;
						ff = true;
					}
				} 
				if (!crl[s[id]] && crl[f[id]]) {
					int a = solve(id, 2, adj, vis, crl, end);
					if (a > res) {
						res = a;
						ind = id;
						ff = false;
					}
				}
			}
		}
		
		if (ind != 0) {
			if (ff = true) adj[i].add(ind);
			else adj[ind].add(i);
		}
		else if (!ff){
			end[i] = true;
		}
		
		return res + 1;
		
	}
	
	public static void main(String[] args) throws IOException{
		N = readInt(); M = readInt();
		
		
		for (int i=1; i<=M; i++) cereal[i] = new ArrayList();
		
		for (int i=1; i<=N; i++) {
			f[i] = readInt();  s[i] = readInt();
			cereal[f[i]].add(new Pair(i, 1));
			cereal[s[i]].add(new Pair(i, 2));
		}

		int ans = 0;
		
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
	
		
		for (int i=1; i<=N; i++) {
			List<Integer>[] temp = new ArrayList[N+1];
			for (int j=1; j<=N; j++) temp[j] = new ArrayList();
			boolean[] end_temp = new boolean[N+2];
			int a = solve(i, 1, temp, new boolean[N+1], new boolean[N+1], end_temp) + 1;
			if (a > ans) {
				ans = a;
				adj = temp;
				end = end_temp;
			}
		}

		for (int i=1; i<=N; i++) System.out.println(adj[i]);
		compute();
		System.out.println(N - ans);
		while(!dq.isEmpty()) {
			System.out.println(dq.pollFirst());
		}
		
		
		
		
		
		
	}
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreElements()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}


	
	
