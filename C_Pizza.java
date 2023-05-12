
import java.io.*;
import java.util.*;

public class C_Pizza {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int) 1e5 + 5, MOD = (int)1e9 + 7;
	static List<Integer>[] adj = new ArrayList[MN + 1];
	static boolean[] vis;
	
	static boolean dfs(int u, int[] d) {
		vis[u] = true;
		if (d[u] != 0) return false;
		
		for (int v: adj[u]) {
			if (!vis[v]) {
				boolean res = dfs(v, d);
				if (!res) return false;
			}
		}
		return true;
	}
	
	static void reset(int u) {
		vis[u] = true;
		
		for (int v: adj[u]) {
			if (!vis[v]) reset(v);
		}
	}
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			int[] a = new int[n + 1], b = new int[n + 1], d = new int[n + 1];
			int[] aInd = new int[n + 1], bInd = new int[n + 1];
	
			
			for (int i = 1; i <= n; i++) {
				a[i] = readInt();
				aInd[a[i]] = i;
				adj[i] = new ArrayList();
			}
			
			for (int i = 1; i <= n; i++) {
				b[i] = readInt();
				bInd[b[i]] = i;
			}
			for (int i = 1; i <= n; i++) {
				d[i] = readInt();
				adj[aInd[i]].add(bInd[i]);
				adj[bInd[i]].add(aInd[i]);
				if (a[i] == b[i]) d[i] = a[i];
			}
			
			vis = new boolean[n + 1];
			
			long ans = 1;
			for (int i = 1; i <= n; i++) {
				if (!vis[i] && d[i] == 0) {
					
					boolean res = dfs(i, d);
					if (res) {
						
						ans = (ans * 2) % MOD;
					}
					reset(i);
				}
			}
			
			System.out.println(ans);
			
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


	
	
