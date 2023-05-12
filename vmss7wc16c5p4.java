
import java.io.*;
import java.util.*;

public class vmss7wc16c5p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), x = readInt(), y = readInt(), z = readInt();
		int[] dp = new int[N+1];

		dp[x] = dp[y] = dp[z] = 1;
		for (int i=1; i<=N; i++) {
			if (i - x >= 0 && dp[i-x] > 0) dp[i] = Math.max(dp[i], dp[i-x] + 1);
			if (i - y >= 0 && dp[i-y] > 0) dp[i] = Math.max(dp[i], dp[i-y] + 1);
			if (i - z >= 0 && dp[i-z] > 0) dp[i] = Math.max(dp[i], dp[i-z] + 1);
		}
		
		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
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


	
	
