
import java.io.*;
import java.util.*;

public class Dmopc18c6p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static boolean[] visited;
	static ArrayList<Integer>[] adj;
	
	static void dfs(int node, boolean[] visited) {
		for(int next: adj[node]) {
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, visited);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();
		visited = new boolean[N];
		adj = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int bv = readInt()-1, ev = readInt()-1;
			adj[bv].add(ev);
			adj[ev].add(bv);
			
		}
		
		int counter = 0;
		for(int i=0; i<N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, visited);
				
				counter ++;
			}
		}
		
		if (M == N - counter || M == N - counter + 1) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
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


	
	
