
import java.io.*;
import java.util.*;

public class sac22cc3p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int M;
	
	static boolean check(double x) {
		return 12 * x * x - 5 * x + 1 <= M;
	}
	public static void main(String[] args) throws IOException {

		M = readInt();
		double lo = 0, hi = 1e4 + 3, ans = 0;
		
		for (int i=0; i<=75; i++) {
			double mid = (lo + hi) / 2;
			if (check(mid)) {
				lo = mid + 1;
				ans = mid;
			} else {
				hi = mid - 1;
			}
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


	
	
