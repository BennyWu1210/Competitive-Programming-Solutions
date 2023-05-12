
import java.io.*;
import java.util.*;

public class dmopc21c8p6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		int[] a = new int[K + 1];
		long[] dp = new long[2 * N + 1];
		
		for (int i = 1; i <= K; i++) {
			a[i] = readInt();
		}
		
		// min. cost add up to 2 * N - 2
		
		Arrays.fill(dp, (int)1e17);
		dp[0] = 0;
		
		// state: minimum cost add up to i
		for (int i = 1; i <= 2 * N - 2; i++) {
			for (int j = 1; i - j >= 0 && j <= K; j++) {
				dp[i] = Math.min(dp[i], dp[i - j] + a[j]);
			}
		}
		
		// System.out.println(Arrays.toString(dp));
		
		System.out.println(dp[2 * N - 2]);
		
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


	
	
