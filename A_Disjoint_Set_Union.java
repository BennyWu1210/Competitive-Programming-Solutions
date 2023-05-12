
import java.io.*;
import java.util.*;

public class A_Disjoint_Set_Union {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] root;
	static int[] rank;
	
	public static void main(String[] args) throws IOException {
		
		int n = readInt(), m = readInt();
		
		root = new int[n+1];
		rank = new int[n+1];
		
		for (int i=0; i<root.length; i++) {
			root[i] = i;
		}
		
		for (int i=0; i<m; i++) {
			String[] input = readLine().split(" ");
			String q = input[0];
			int a = Integer.parseInt(input[1]), b = Integer.parseInt(input[2]);
			
			if (q.equals("union")) {
				union(a, b);
			}
			else {
				a = get(a); b = get(b);
				
				if (a == b) {
					System.out.println("YES");
				}
				else {
					System.out.println("NO");
				}
			}
		}
		
		
	}
	
	static int get(int u) {
		return root[u] = (root[u] == u) ? u : get(root[u]);
	}
	
	static void union(int a, int b) {
		a = get(a);
		b = get(b);
		
		if (rank[a] == rank[b]) {
			rank[a] ++;
		}
		
		if (rank[a] > rank[b]) {
			root[b] = a;
		}
		else {
			root[a] = b;
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


	
	
