
import java.io.*;
import java.util.*;

public class B_Disjoint_Set_Union_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int root, rank, max, min, count;
	}
	
	static Node[] nodes;
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		nodes = new Node[n+1];
		
		for (int i=0; i<=n; i++) {
			Node u = nodes[i] = new Node();
			u.root = u.max = u.min = i;
			u.count = 1;
		}
		
		for (int i=0; i<m; i++) {
			String[] input = readLine().split(" ");
			
			if (input.length == 3) { // union
				int a = Integer.parseInt(input[1]), b = Integer.parseInt(input[2]);
				union(a, b);
			}
			else { // query
				int u = get(Integer.parseInt(input[1]));
				int min = nodes[u].min;
				int max = nodes[u].max;
				int count = nodes[u].count;
				System.out.printf("%d %d %d", min, max, count);
				System.out.println();
			}
		}
	}
	
	static int get(int u) {
		nodes[u].root = (nodes[u].root == u) ? u : get(nodes[u].root);
		return nodes[u].root;
	}
	
	static void union(int a, int b) {
		a = get(a);
		b = get(b);
		
		
		if (a == b) return;
		
		Node u = nodes[a];
		Node v = nodes[b];
		
		int min = Math.min(u.min, v.min);
		int max = Math.max(u.max, v.max);
		
		if (u.rank == v.rank) {
			u.rank ++;
		}
		
		if (u.rank > v.rank) {
			// u.rank += v.rank;
			
			v.root = a;
			u.min = min;
			u.max = max;
			u.count += v.count;
		}
		else {
			// v.rank += u.rank;
			
			u.root = b;
			v.min = min;
			v.max = max;
			v.count += u.count;
			
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


	
	
