
import java.io.*;
import java.util.*;

public class C_Experience {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] root;
	static int[] points;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		
		root = new int[n+1]; points = new int[n+1]; rank = new int[n+1];
		
		for (int i=0; i<=n; i++) {
			root[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			String[] input = readLine().split(" ");
			
			if (input[0].equals("add")) {
				int u = Integer.parseInt(input[1]);
				int p = Integer.parseInt(input[2]);
				
				add(u, p);
			}
			else if (input[0].equals("join")) {
				int u = Integer.parseInt(input[1]);
				int v = Integer.parseInt(input[2]);
				
				union(u, v);
			}
			else {
				int u = Integer.parseInt(input[1]);
				int p = getPoint(u);
				
				System.out.println(p);
			}
		}
		
	}
	
	static int get(int u) {
		if (root[u] == u) {
			return u;
		}
		return root[u] = get(root[u]);
	}
	
	static int getPoint(int u) {
		if (u == root[u]) {
			return points[u];
		}
		return points[u] + get(root[u]);
	}
	
	static void add(int u, int p) {
		u = get(u);
		
		points[u] += p;
	}
	
	static void union(int a, int b) {
		a = get(a); b = get(b);
		
		if (a == b) return;
		if (rank[a] == rank[b]) {
			rank[a] ++;
		}
		
		if (rank[a] > rank[b]) {
			root[b] = a;
			points[b] -= points[a];
			
		}
		else {
			root[a] = b;
			points[a] -= points[b];
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


	
	
