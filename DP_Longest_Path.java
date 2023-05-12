
import java.io.*;
import java.util.*;


public class DP_Longest_Path {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static void dfs(int node, int[] steps, boolean[] visited, ArrayList<Integer>[] adjList) {
		
		visited[node] = true;
		
		for(int next: adjList[node]) {
			if (!visited[next]) {
				dfs(next, steps, visited, adjList);
			}
			steps[node] = Math.max(steps[node], steps[next]+1);
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		
		int n = readInt(), m = readInt();
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for(int i=0; i<n; i++) adjList[i] = new ArrayList<Integer>();
		
		for(int i=0; i<m; i++) {
			int bv = readInt()-1, ev = readInt()-1;
			adjList[bv].add(ev);
		}
		
		boolean[] visited = new boolean[n];
		int[] steps = new int[n];
		
		for(int i=0; i<n; i++) {
			if (!visited[i]) {
				dfs(i, steps, visited, adjList);
			}
		}
		
		int ans = 0;
		
		for(int i: steps) {
			if (i > ans) ans = i;
		}
		
		System.out.println(ans);
		
		
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


	
	
