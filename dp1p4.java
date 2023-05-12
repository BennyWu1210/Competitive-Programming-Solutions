
import java.io.*;
import java.util.*;

public class dp1p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int MOD = (int)1e4 + 7;
	public static void main(String[] args) throws IOException {

		String str = readLine();
		long[] a = new long[26];
		long[] dp = new long[str.length() + 1];

		for (int i=1; i<=str.length(); i++) {
			dp[i] = (dp[i-1] * 2 + 1) % MOD;
			
			dp[i] = (dp[i] - a[str.charAt(i-1) - 'a'] + MOD) % MOD;
			
			a[str.charAt(i-1) - 'a'] = (a[str.charAt(i-1) - 'a'] + dp[i] - dp[i-1] + MOD) % MOD;
		}

		System.out.println(dp[str.length()] % MOD);
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




