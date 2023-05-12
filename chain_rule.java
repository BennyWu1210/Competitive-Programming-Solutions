
import java.io.*;
import java.util.*;

public class chain_rule {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Node implements Comparable<Node> {
		int u, cost;
		
		public Node(int u, int cost) {
			this.u = u;
			this.cost = cost;
		}
		
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	
	public static void dijkstra(List<Node>[] graph, int[] step, int start) {
		int N = step.length;
		
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		Arrays.fill(step, Integer.MAX_VALUE);
		step[start] = 0;
		queue.add(new Node(start, 0));
		
		while(!queue.isEmpty()) {
			Node current = queue.poll();
			
			
			for (Node next: graph[current.u]) {
				if (step[next.u] > step[current.u] + next.cost) {
					step[next.u] = step[current.u] + next.cost;
					queue.add(new Node(next.u, step[next.u]));
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		List<Node>[] graph = new ArrayList[N];
		
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < M; i++) {
			int u = readInt(), v = readInt(), c = readInt();
			graph[u].add(new Node(v, c));
			graph[v].add(new Node(u, c));
		}
		
		int[] step1 = new int[N], step2 = new int[N];
		
		dijkstra(graph, step1, 0);
		dijkstra(graph, step2, N - 1);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, step1[i] + step2[i]);
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


	
	
