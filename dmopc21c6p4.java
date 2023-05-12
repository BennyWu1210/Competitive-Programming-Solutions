
import java.io.*;
import java.util.*;

public class dmopc21c6p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	// First subtask
	
	static final int MN = 2*(int)1e5 + 5;
	static List<Node>[] adj = new ArrayList[MN];
	static int[] ans = new int[MN];
	static int N, M, a, b, c, d;
	static boolean[] vis = new boolean[MN];
	
	static boolean dfs(int u, int dest, boolean hasc, boolean hasd) {
		vis[u] = true;
		if (u == c) hasc = true;
		if (u == d) hasd = true;
		// if (hasc && hasd) return false;
		if (u == dest) return true;
		
		for (Node v: adj[u]) {
			if (vis[v.u]) continue;
			
			boolean res = dfs(v.u, dest, hasc, hasd);
			if (res) {
				ans[v.id] = 1;
				return true;
			}
		}
		
		return false;
	}
	
	static LinkedList<Integer> dq = new LinkedList();
	static LinkedList<Integer> dq2 = new LinkedList();
	static boolean dfs2(int u, int dest, int steps, boolean allOne) {
		vis[u] = true;
		if (u == dest && steps > 1 && !allOne) return true;
		
		for (Node v: adj[u]) {
			if (vis[v.u]) continue;
			
			boolean allOneNew = !allOne || ans[v.id] != 1;
			boolean res = dfs2(v.u, dest, steps+1, allOneNew);
			if (res) {
				dq.addLast(v.id);
				dq2.addLast(v.id);
				return true;
			}
		}
		
		return false;
	}
	
	static class Node{
		int u, id;
		public Node(int u, int id) {
			this.u = u; this.id = id;
		}
	}
	
	static class Node2{
		int u, ones;
		public Node2(int u, int ones) {
			this.u = u; this.ones = ones;
		}
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		
		boolean isTree = M == N - 1;
		
		for (int i=1; i<=N; i++) adj[i] = new ArrayList();
		
		for (int i=1; i<=M; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(new Node(v, i));
			adj[v].add(new Node(u, i));
		}
		
		a = readInt(); b = readInt(); c = readInt(); d = readInt();
		boolean res = dfs(a, b, a==c, b==d);
		
		if (!res) {
			System.out.println(-1);
			return;
		}
		
		vis = new boolean[MN];
			
		boolean res2 = dfs2(c, d, 0, true);
		// int[] steps = new int[N]
		
		
		if (!res2) {
			System.out.println(-1);
			return;
		}
		
		int sz = dq.size();
		int ones = 0;
		while (!dq.isEmpty()) {
			int nxt = dq.pollLast();
			if (ans[nxt] == 0) {
				ans[nxt] = 2;
			} else {
				ones ++;
			}
		}
		
		if (ones == sz) {
			System.out.println(-1);
			return;
		}
		
		if (ones == 0) ans[dq2.get(0)] = 1;
		
		System.out.println(2);
		
		for (int i=1; i<=M; i++) {
			if (ans[i] == 0) System.out.println(2);
			else System.out.println(ans[i]);
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

/*
6 5
1 2
2 3
2 4
1 5
3 6
2 5 4 6
 */

	
	
