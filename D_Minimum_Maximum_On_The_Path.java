
import java.io.*;
import java.util.*;

public class D_Minimum_Maximum_On_The_Path {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int n, m, d;
	static ArrayList<Node>[] adj;
	static Deque<Integer> ans;
	static Deque<Integer> temp;
	static int[] memo;
	static boolean[] stack;
	
	static class Node{
		int u, c;
		
		public Node(int u, int c) {
			this.u = u;
			this.c = c;
		}
	}

	static boolean findAns(int u, int x, int tot, Deque<Integer> temp) {
		
		if (u == n) {
			temp.push(u);
			return true;
		}
		if (d == tot) return false;
		if (memo[u] > x) return false;
		
		stack[u] = true;

		for (Node v: adj[u]) {
			if (v.c <= x && !stack[v.u]) {
				
				boolean res = findAns(v.u, x, tot+1, temp);
				if (res) {
					temp.push(u);
					return true;
				}
			}
		}
		memo[u] = x;
		stack[u] = false;
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		n = readInt(); m = readInt(); d = readInt();
		adj = new ArrayList[n+1];
		ans = new LinkedList<Integer>();
		memo = new int[n+1];
		
		int l = 0, r = 0;
		
		for (int i=0; i<=n; i++) {
			adj[i] = new ArrayList<Node>();
		}
		
		for (int i=0; i<m; i++) {
			int u = readInt(), v = readInt(), c = readInt();
			adj[u].add(new Node(v, c));
			
			l = Math.min(l, c - 1);
			r = Math.max(r, c + 1);
		}
		
		
		int res = -1;
		
		while (l <= r) {

			int mid = (l + r) / 2;

			stack = new boolean[n+1];
			Deque<Integer> temp = new LinkedList<Integer>();
			
			if (findAns(1, mid, 0, temp)) {
				r = mid - 1;
				res = mid;
				ans = temp;
			}
			else {
				l = mid + 1;
			}
		}
		
		if (res == -1) {
			System.out.println(-1);
			return;
		}

		System.out.println(ans.size() - 1);
		while (!ans.isEmpty()) System.out.print(ans.pollFirst() + " ");
		
		System.out.println();
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


	
	
