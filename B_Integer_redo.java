
import java.io.*;
import java.util.*;

public class B_Integer_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int INF = (int)1e9 + 5;
	public static void main(String[] args) throws IOException {

		int T = readInt();


		while (T --> 0) {

			int lMin = Integer.MAX_VALUE, lCost = INF;
			int rMax = Integer.MIN_VALUE, rCost = INF;
			int lenMax = 0, costMax = INF;

			int n = readInt();

			for (int i=0; i<n; i++) {

				int l = readInt(), r = readInt(), c = readInt();

				if (l < lMin) {
					lMin = l; lCost = INF;
				}
				if (l == lMin) {
					lCost = Math.min(lCost, c);
				}

				if (r > rMax) {
					rMax = r; rCost = INF;
				}
				
				if (r == rMax) {
					rCost = Math.min(rCost, c);
				}

				if (r - l + 1 > lenMax) {
					lenMax = r - l + 1; costMax = INF;
				}
				if (r - l + 1 == lenMax) {
					costMax = Math.min(costMax, c);
				}

				int ans = lCost + rCost;
				if (lenMax == rMax - lMin + 1) {
					ans = Math.min(costMax, ans);
				}
				
				System.out.println(ans);
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




