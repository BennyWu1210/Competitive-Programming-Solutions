
import java.io.*;
import java.util.*;

public class Cpc21c1p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int N, M;
	static int[] parent;
	static ArrayList<Integer>[] adjList;

	static void dfs(int v, boolean[] visited) {
		int max = v;
		parent[v] = Math.max(v, parent[v]);
		for(int next: adjList[v]) {
			if (!visited[next]) {
				visited[next] = true;
				parent[next] = parent[v];
				dfs(next, visited);

			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();
		parent = new int[N+1];
		adjList = new ArrayList[N+1];

		Arrays.fill(parent, -1);

		for(int i=0; i<=N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<M; i++) {
			int bv = readInt(), ev = readInt();
			adjList[ev].add(bv); // reverse graph
		}

		// System.out.println(Arrays.toString(adjList));
		boolean[] visited = new boolean[N+1];
		for(int i=N; i>0; i--) {
			if (!visited[i]) {
				dfs(i, visited);
			}
		}
		// System.out.println(Arrays.toString(parent));

		int maxX = -1;
		int maxY = -1;

		for(int i=1; i<parent.length; i++) {
			if (i > maxX && parent[i] > i) {
				maxX = i;
				maxY = parent[i];
			}
		}

		if (maxX == -1) {
			System.out.println(-1);
			return;
		}
		System.out.printf("%d %d", maxX, maxY);



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




