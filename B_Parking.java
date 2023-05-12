
import java.io.*;
import java.util.*;

public class B_Parking {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[] parent;

	static int find(int u) {
		if (parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}

	static void union(int u, int v) {
		// since the right slot always has a larger size
		u = find(u); v = find(v);
		parent[u] = v;
	}

	public static void main(String[] args) throws IOException {

		int n = readInt();

		parent = new int[n+1];

		for (int i=1; i<parent.length; i++) {
			parent[i] = i;
		}

		boolean last = false;

		for (int i=0; i<n; i++) {
			int u = readInt();
			int ans = find(u);

			if (ans == n) {
				if (last) ans = find(1);
				else last = true;
			}
			if (ans < n) {
				union(ans, ans+1);
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




