
import java.io.*;
import java.util.*;

public class CCC16S3_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MAX = 100005;
	static int N, M;
	static ArrayList<Integer>[] adj = new ArrayList[MAX];
	static boolean[] pho = new boolean[MAX], vis = new boolean[MAX], onPath = new boolean[MAX];
	static int[] dist = new int[MAX];
	
	static void dfs(int u) {
		for (int v: adj[u]) {
			if(!vis[v] && onPath[v]) {
				vis[v] = true;
				dist[v] = dist[u] + 1;
				dfs(v);
			}
		}
	}
	
	static boolean findPath(int u, int prev) {
		if (pho[u]) {
			onPath[u] = true;
		}
		
		for (int v: adj[u]) {
			if (v != prev) {
				onPath[u] |= findPath(v, u);
			}
		}
		return onPath[u];
	}
	
	public static void main(String[] args) throws IOException {
		
		N = readInt();
		M = readInt();
		
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		int n = 0;
		for(int i=0; i<M; i++) {
			n = readInt();
			pho[n] = true;
			
		}
		
		for(int i=0; i<N-1; i++) {
			int bv = readInt(), ev = readInt();
			adj[bv].add(ev);
			adj[ev].add(bv);
		}
		
		n = 0;
		for(int i=0; i<N; i++) {
			if (pho[i]) {
				findPath(i, -1);
				break;
			}
		}

		n = 0;
		for(int i=0; i<N; i++) {
			if (onPath[i]) {
				n = i;
				break;
			}
		}
		
		dist[n] = 0;
		vis[n] = true;
		dfs(n);
		
		for(int i=n; i<N; i++) {
			if (onPath[i] && dist[i] > dist[n]) {
				n = i;
			}
		}
		Arrays.fill(vis, false);
		dist[n] = 0;
		vis[n] = true;
		dfs(n);
		
		int diam = 0;
		int count = N;
		for (int i=0; i<N; i++) {
			if (onPath[i]) {
				diam = Math.max(diam, dist[i]);
			}
			else {
				count --;
			}
		}
		
		System.out.println(2 * (count - 1) - diam);
		
		
		
		
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


	
	
