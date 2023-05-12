
import java.io.*;
import java.util.*;

public class ccc19s4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e6 + 5;
	static int N, K; static long ans;
	static int[] a = new int[MN], day = new int[MN], pre = new int[MN];
	static long[] dp = new long[MN], dp1 = new long[MN], dp2 = new long[MN];
	
	
	public static void main(String[] args) throws IOException {
		
		N = readInt(); K = readInt();
		for (int i=1; i<=N; i++) {
			a[i] = readInt();
			day[i] = (i+K-1)/K;
		}
		
		for (int i=1; i<=K; i++) {
			dp[i] = pre[i] = Math.max(pre[i-1], a[i]);
		}
		
		for (int i=K+1; i<=N; i+=K) {
			int fst = (day[i]-2)*K, last = (day[i]-1)*K, suf = 0;
			for (int j=last; j>fst; j--) {
				dp1[j] = Math.max(dp1[j+1], dp[j]);
				dp2[j] = Math.max(dp2[j+1], dp[j] + suf);
				suf = Math.max(suf, a[j]);
				
			}
			for (int j=i; j<=Math.min(i+K, N); j++) {
				if (day[j] == day[j-1]) pre[j]  = Math.max(pre[j-1], a[j]);
				else pre[j] = a[j];
				dp[j] = Math.max(dp1[j-K] + pre[j], dp2[j-K]);
			}
		}
		
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


	
	
