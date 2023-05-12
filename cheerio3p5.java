
import java.io.*;
import java.util.*;

public class cheerio3p5 {

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
		
		List<Integer>[] adj = new ArrayList[N];
		List<Integer>[] adj2 = new ArrayList[N];
		
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
		
		
		int[][] steps = new int[N][N];
		int[][] steps2 = new int[N][N];
		
		for (int node = 0; node < N; node++) {
			
			Queue<Integer> queue = new LinkedList<Integer>();
			Arrays.fill(steps[node], Integer.MAX_VALUE);
			
			steps[node][node] = 0;
			queue.add(node);
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				
				for (int next: adj[cur]) {
					if (steps[node][next] > steps[node][cur] + 1) {
						steps[node][next] = steps[node][cur] + 1;
						queue.add(next);
					}
				}
				
				if (depth[cur] == depth[node]) {
					for (int next: adj2[cur]) {
						if (steps[node][next] > steps[node][cur] + 1) {
							steps[node][next] = steps[node][cur] + 1;
							queue.add(next);
						}
					}
				}
			}
			
			queue = new LinkedList<Integer>();
			Arrays.fill(steps2[node], Integer.MAX_VALUE);
			steps2[node][node] = 0;
			queue.add(node);
			
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				
				for (int next: adj[cur]) {
					if (steps2[node][next] > steps2[node][cur] + 1) {
						steps2[node][next] = steps2[node][cur] + 1;
						queue.add(next);
					}
				}
			}
//			System.out.println(Arrays.toString(steps[node]));
		}
		
		for (int i = 0; i < Q; i++) {
			int a = readInt() - 1, b = readInt() - 1, d = readInt();
			
			long ans = Long.MAX_VALUE;
			if (d <= maxDepth) {
				
				for (int point: depthNodes[d]) {
					ans = Math.min(ans, steps[point][a] + steps[point][b]);
				}
//				int left = depthNodes[d].get(0);
//				int right = depthNodes[d].get(depthNodes[d].size() - 1);
////				System.out.println((left + 1)+ " " + (right + 1));
//				ans = Math.min(ans, steps[left][a] + steps[left][b]);
//				ans = Math.min(ans, steps[right][a] + steps[right][b]);
				ans = Math.min(ans, steps2[a][b]);
			}
			else {
				ans = steps2[a][b];
			}

			for (int j = 0; j < N; j++) {
				ans = Math.min(ans, steps2[a][j] + steps2[j][b]);
			}
			
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


	
	
