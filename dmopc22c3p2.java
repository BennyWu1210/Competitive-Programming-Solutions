
import java.io.*;
import java.util.*;

public class dmopc22c3p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static Map<Integer, List<Integer>> map = new HashMap();
	
	public static int countBlocks(int[] s) {
		int ans = 1;
		
		for (int j = 1; j < s.length; j++) {
			if (s[j] != s[j - 1] + 1) {
				ans++;
			}
		}
		return ans;
	}
	
	public static void dfs(int u, boolean[] vis, int[] group, int num) {
		group[u] = num;
		map.get(num).add(u);
		
	}
	
	public static void main(String[] args) throws IOException {

		
		// subtask 1
		int N = readInt(), Q = readInt();
		boolean[] vis = new boolean[N + 1];
		// count consecutive blocks?
		
		int[] p = new int[N + 1], group = new int[N + 1];
		
		for (int i = 1; i <= N; i++) p[i] = readInt();
		
		for (int i = 1; i <= N; i++) {
			if (!vis[i]) {
				dfs(i, vis, group, i);
				map.put(i, new ArrayList());
			}
			
		}
		
		for (int i = 0; i < Q; i++) {
			int S = readInt();
			
			int[] s = new int[S];
			for (int j = 0; j < S; j++) s[j] = readInt();
			Arrays.sort(s);
			
			int ans = countBlocks(s);
			if (s[0] == 1 && s[S - 1] == N) ans--;
			
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


	
	
