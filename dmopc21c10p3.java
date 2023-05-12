import java.io.*;
import java.util.*;

public class dmopc21c10p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static class Node{
		int u, w;
		
		public Node(int u, int w){
			this.u = u; this.w = w;
		}
	}
	
	static int N, M;
	static List<Node>[] adj;
	static Deque<Node> dq = new LinkedList();
	static int[] cost;

	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		
		if (N != M - 1) {
			if (N == 1 || M == 1) {
				System.out.println(-1);
				return;
			}
			int dif = Math.abs((M - 1) - N);
			if (dif % 2 == 1) {
				System.out.println(-1);
				return;
			}
		}
		
		int MAX = N * (2 * M + 1) + M + 2;
		
		adj = new ArrayList[MAX];
		cost = new int[MAX];
		
		
		for (int i = 0; i < adj.length; i++) {
			adj[i] = new ArrayList();
			cost[i] = Integer.MAX_VALUE;
		}
		
		
		for (int i = 1; i <= N; i++) {
			char[] c = readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				
				// set a value for each edges
				int up = (i - 1) * (2 * M + 1) + j;
				int down = i * (2 * M + 1) + j;
				int left = i * (2 * M + 1) - (M + 1) + j;
				int right = i * (2 * M + 1) - (M + 1) + j + 1;
				
				if (c[j - 1] == '\\') { // up right & left down
					
					if (j != M) {
						adj[up].add(new Node(right, 0));
						adj[down].add(new Node(right, 1));
					}
					if (i != 1) {
						adj[right].add(new Node(up, 0));
						adj[left].add(new Node(up, 1));
					}
					if (i != N || (i == N && j == M)) {
						adj[left].add(new Node(down, 0));
						adj[right].add(new Node(down, 1));
					}
					if (j != 1) {
						adj[down].add(new Node(left, 0));
						adj[up].add(new Node(left, 1));
					}
					
					
				} else {
					if (j != M) {
						adj[up].add(new Node(right, 1));
						adj[down].add(new Node(right, 0));
					}
					if (i != 1) {
						adj[right].add(new Node(up, 1));
						adj[left].add(new Node(up, 0));
					}
					if (i != N || (i == N && j == M)) {
						adj[left].add(new Node(down, 1));
						adj[right].add(new Node(down, 0));
					}
					
					if (j != 1) {
						adj[down].add(new Node(left, 1));
						adj[up].add(new Node(left, 0));
					}
				}
			}
		}
				
		// check path from 1 to N * (2 * M + 1) + M
		// do bfs/dijkstra
		
		
		
		cost[1] = 0;
		
		int[] arr = new int[4 * N * M + 2];
		int[] arrC = new int[4 * N * M + 2];
		int lft = arr.length / 2, rit = arr.length / 2 + 1;
		arr[lft] = 1;
		arrC[lft] = 0;
		
		boolean reached = false;
		while (lft < rit) {
			int curU = arr[lft];	
			int curW = arrC[lft];
			lft ++;

			if (curW != cost[curU]) continue;
			if (curU == N * (2 * M + 1) + M) reached = true;
			if (reached && curW != 0) break;
			
			
			for (Node nxt: adj[curU]) {
				
				if (cost[nxt.u] > cost[curU] + nxt.w) {
					
					cost[nxt.u] = cost[curU] + nxt.w;
					
					if (nxt.w == 0) {
						lft--; arr[lft] = nxt.u; arrC[lft] = cost[nxt.u];
					}
					else {
						arr[rit] = nxt.u; arrC[rit] = cost[nxt.u]; rit++;
					}
				}
			}
		}
		
		
		if (cost[N * (2 * M + 1) + M] == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(cost[N * (2 * M + 1) + M]);
		
		
		
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