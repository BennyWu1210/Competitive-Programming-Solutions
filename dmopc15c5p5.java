
import java.io.*;
import java.util.*;

public class dmopc15c5p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = 2*(int)1e5 + 5, MOD = (int)1e9 + 7;;
	static long[] bit = new long[MM];
	static int[] ord = new int[MM], ans = new int[MM];
	static ArrayList<Integer>[] adj = new ArrayList[MM];
	
	static void dfs(int u) {
		
		long prev = query(ord[u]);
		
		for (int v: adj[u]) dfs(v);
		
		long cur = query(ord[u]);
		ans[u] = (int)((cur - prev + 1) % MOD);
		update(ord[u], cur - prev + 1);
		
	}
	
	static void update(int ind, long v) {
		for (int i=ind; i<MM; i+=i&-i) bit[i] = (long)((bit[i] + v) % MOD);
	}
	
	static long query(int ind) {
		long res = 0;
		
		for (int i=ind; i>0; i-=i&-i) res += bit[i];
		
		return res;
	}
	
	
	public static void main(String[] args) throws IOException {

		for (int i=0; i<MM; i++) adj[i] = new ArrayList();
		
		int N = readInt(), start = 0;
		
		for (int i=1; i<=N; i++) {
			int u = readInt();
			
			if (u == 0) start = i;
			else adj[u].add(i);
		}
		
		for (int i=1; i<=N; i++) ord[readInt()] = i;
		
		dfs(start);
		
		for (int i=1; i<=N; i++) System.out.print(ans[i] + " ");
		
		
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


	
	
