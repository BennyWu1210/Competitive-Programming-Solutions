
import java.io.*;
import java.util.*;

public class C_Restructuring_Company {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[] root;
	static int[] total;
	static int[] max;

	static int find(int u) {
		if (root[u] == u) return u;
		return root[u] = find(root[u]);
	}

	static void union(int u, int v) {
		u = find(u); v = find(v);

		if (u != v) {
			if (total[v] > total[u]) {
				root[u] = v;
				total[v] += total[u];
				max[v] = Math.max(max[u], max[v]);
			}
			else {
				root[v] = u;
				total[u] += total[v];
				max[u] = Math.max(max[u], max[v]);
			}
		}
	}

	static boolean check(int u, int v) {
		u = find(u); v = find(v);
		
		if (u == v) return true;
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), q = readInt();

		root = new int[n+1]; total = new int[n+1]; max = new int[n+1];

		for (int i=1; i<=n; i++) {
			root[i] = i;
			total[i] = 1;
			max[i] = i;
		}

		boolean allConnected = false;
		for (int i=0; i<q; i++) {
			int cmd = readInt();
			int a = readInt(), b = readInt();

			if (cmd == 1) {
				// union a and b
				union(a, b);
			}
			else if (cmd == 2 && !allConnected) {
				// union all teams between a and b
				int p = max[find(b)];
//				for (int j=a+1; j<=b; j++) {
//					union(a, j);
//					if (total[a] == n || total[j] == n) allConnected = true;
//				}
				
				while (p < b) {
					union(p, b);
					p = max[find(p + 1)];
				}

			}
			else if (cmd == 3){
				// query a and b
				boolean ans = check(a, b);
				String output = ans ? "YES" : "NO";
				
				System.out.println(output);
				
			}
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




