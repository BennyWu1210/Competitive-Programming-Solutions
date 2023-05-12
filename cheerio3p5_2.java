
import java.io.*;
import java.util.*;

public class cheerio3p5_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static int maxDepth = 0;
	public static void dfs(int cur, int depth, List<Integer>[] adj, 
							int[] res, List<Integer>[] depthNodes) {
		res[cur] = depth;
		depthNodes[depth].add(cur);
		maxDepth = Math.max(maxDepth, depth);
		for (int v: adj[cur]) {
			if (res[v] != Integer.MAX_VALUE) continue;
			dfs(v, depth + 1, adj, res, depthNodes);
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();

		List<Integer>[] adj = new ArrayList[N], adj2 = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<Integer>();
			adj2[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			int u = readInt() - 1, v = readInt() - 1;
			adj[u].add(v);
			adj[v].add(u);
		}
		
		List<Integer>[] depthNodes = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			depthNodes[i] = new ArrayList<Integer>();
		}
		
		int[] depth = new int[N];
		Arrays.fill(depth, Integer.MAX_VALUE);
		dfs(0, 0, adj, depth, depthNodes);
		
		for (int i = 0; i < N; i++) {
			for (int j = 1; j < depthNodes[i].size(); j++) {
				int u = depthNodes[i].get(j);
				int v = depthNodes[i].get(j - 1);
				adj2[u].add(v);
				adj2[v].add(u);
			}
		}
		
		for (int i = 0; i < Q; i++) {
			int u = readInt() - 1, v = readInt() - 1, d = readInt();
			
			Queue<Integer> queue = new LinkedList<>();
			int[] ans = new int[N];
			Arrays.fill(ans, Integer.MAX_VALUE);
			ans[u] = 0;
			queue.add(u);
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				
				for (int next: adj[cur]) {
					if (ans[next] > ans[cur] + 1) {
						ans[next] = ans[cur] + 1;
						queue.add(next);
					}
				}
				
				if (depth[cur] == d) {
					for (int next: adj2[cur]) {
						if (ans[next] > ans[cur] + 1) {
							ans[next] = ans[cur] + 1;
							queue.add(next);
						}
					}
				}
			}
			
			System.out.println(ans[v]);
		}

	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
