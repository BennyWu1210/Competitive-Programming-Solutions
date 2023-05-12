
import java.io.*;
import java.util.*;

public class A_Get_together {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int n;
	static int[] x, v;

	static boolean solve(double t) {
		double left = -1e15, right = 1e15;
		
		for (int i=0; i<n; i++) {
			
			double curL = x[i] - t*v[i];
			double curR = x[i] + t*v[i];

			left = Math.max(left, curL);
			right = Math.min(right, curR);
			
			if (left > right) return false;
		}


		return true;
	}

	public static void main(String[] args) throws IOException {

		

		n = readInt();
		x = new int[n];
		v = new int[n];

		for (int i=0; i<n; i++) {
			x[i] = readInt();
			v[i] = readInt();
		}

		double l = 0, r = Long.MAX_VALUE;
		double res = 0;
		
		for (int i=0; i<120; i++) {
			
			double mid = (l + r) / 2.0;

			if (solve(mid)) {
				r = mid;
			}
			else {
				l = mid;
				res = mid;
			}
		}

		System.out.println(res);

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




