
import java.io.*;
import java.util.*;

public class bsspc21sp3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt(); long ans = 0;
		long[] psa = new long[N+1], a = new long[N+1], dp = new long[N+1];
		for (int i=1; i<=N; i++) a[i] = readInt();
		for (int i=1; i<=N; i++) {
			psa[i] = psa[i-1] + a[i];
			if (i < K) continue;
			int prev_ind = (i-K+1)-1;
			dp[i] = Math.max(0, psa[i] - psa[prev_ind] + dp[prev_ind]);
			ans = Math.max(ans, dp[i]);
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


	
	
