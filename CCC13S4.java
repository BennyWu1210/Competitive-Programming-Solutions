import java.io.*;
import java.util.*;

public class CCC13S4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static boolean bfs(int u, int v, ArrayList<Integer>[] adj, int N) {
		boolean[] visited = new boolean[N+1];
		LinkedList<Integer> q = new LinkedList<>();

		visited[u] = true;
		q.add(u);

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next: adj[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}

		return visited[v];
	}

	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		ArrayList<Integer>[] adj = new ArrayList[N+1];

		for (int i=0; i<=N; i++) adj[i] = new ArrayList<Integer>();

		for (int i=0; i<M; i++) {
			adj[readInt()].add(readInt());
		}

		int u = readInt(), v = readInt();


		if (bfs(u, v, adj, N)) System.out.println("yes");
		else if (bfs(v, u, adj, N)) System.out.println("no");
		else System.out.println("unknown");

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
