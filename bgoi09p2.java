
import java.io.*;
import java.util.*;

public class bgoi09p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int TIME;
	
	static int[] graphNum;
	static int scc;
	
	static void dfs(int u, int[] low, int[] disc, boolean[] inStack, Stack<Integer> st, List<Integer>[] adj) {
		disc[u] = TIME;
		low[u] = TIME;
		TIME ++;
		
		inStack[u] = true;
		st.push(u);
		
		for (int v: adj[u]) {
			if (disc[v] == -1) {
				dfs(v, low, disc, inStack, st, adj);
				low[u] = Math.min(low[u], low[v]);
			}
			else if (inStack[v]) {
				low[u] = Math.min(low[u], disc[v]);
			}
		}
		
		int w = -1;
		
		if (low[u] == disc[u]) {
			scc ++;
			while (w != u) {
				w = st.pop();
				inStack[w] = false;
				graphNum[w] = scc;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		int T = 2;
		
		while (T --> 0) {
			int n = readInt();
			List<Integer>[] adj = new ArrayList[n+1];
			
			for (int i=0; i<=n; i++) adj[i] = new ArrayList();
			
			for (int i=1; i<=n; i++) {
				int u = readInt();
				adj[i].add(u);
			}
			
			int[] disc = new int[n+1];
			int[] low = new int[n+1];
			
			for (int i=1; i<=n; i++) {
				disc[i] = -1;
				low[i] = -1;
			}
			
			boolean[] inStack = new boolean[n+1];
			Stack<Integer> s = new Stack();
			graphNum = new int[n+1];
			scc = 0;
			TIME = 0;
			
			List<Integer>[] sccAdj = new ArrayList[n+1];
			for (int i=0; i<=n; i++) sccAdj[i] = new ArrayList();
			
			for (int i=1; i<=n; i++) {
				if (disc[i] == -1) {
					dfs(i, low, disc, inStack, s, adj);
				}
			}
			
			for (int i=1; i<=n; i++) {
				for (int j: adj[i]) {
					if (graphNum[i] != graphNum[j]) sccAdj[graphNum[i]].add(graphNum[j]);
				}
			}
			
			
			int ans = 0;
			
			for (int i=1; i<=scc; i++) {
				// System.out.println(sccAdj[i]);
				if (sccAdj[i].size() == 0) ans ++;
			}
			
			System.out.print(ans + " ");
		}
		
		System.out.println();
		
		
		
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


	
	
