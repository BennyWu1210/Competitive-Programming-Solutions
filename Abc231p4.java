
import java.io.*;
import java.util.*;

public class Abc231p4 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = (int)1e5 + 5;
	static int[] par = new int[MM], cnt = new int[MM];
	static List<Edge> edges = new ArrayList();

	static class Edge{
		int u, v;
		public Edge(int u, int v) {
			this.u = u; this.v = v;
		}
	}
	
	static int find(int u) {
		return par[u] = par[u] == u ? u: find(par[u]);
	}
	
	static void union(int u, int v) {
		u = find(u); v = find(v);
		par[u] = v; 
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		for (int i=1; i<=N; i++) par[i] = i;
		
		boolean hasAns = true;
		for (int i=0; i<M; i++) {
			int u = readInt(), v = readInt();
			if (find(u) != find(v) && cnt[u] < 2 && cnt[v] < 2) {
				union(u, v);
				cnt[u] ++; cnt[v] ++;
			} else {
				hasAns = false;
				break;
			}
		}
		
		String ans = hasAns ? "Yes" : "No";
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


	
	
