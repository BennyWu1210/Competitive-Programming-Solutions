
import java.io.*;
import java.util.*;

public class dmopc14c3p6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Problem{
		int p1, p2, p3, v1, v2, v3;
		public Problem(int p1, int v1, int p2, int v2, int p3, int v3) {
			this.p1 = p1; this.v1 = v1;
			this.p2 = p2; this.v2 = v2;
			this.p3 = p3; this.v3 = v3;
		}
	}
	
	static int n, t;
	static Problem[] problems = new Problem[2010];
	static long[][] dp;
	
	public static void main(String[] args) throws IOException {

		n = readInt(); t = readInt();
		dp = new long[2][t+1];
		long ans = -1;
		
//		for (int i=0; i<20; i++) {
//			for (int j=1; j<=3; j++) {
//				int a = (int)(Math.random() * 20), b = (int)(Math.random() * 50);
//				System.out.print(a + " " + b + " ");
//			}
//			System.out.println();
//		}
		
		for (int i=0; i<n; i++) problems[i] = new Problem(readInt(), readInt(), readInt(), readInt(), readInt(), readInt());
		// dp[i][t] state -> the maximum profit at the i-th customer when there is t time is used
		// transition dp[i][t] -> dp[i-1][t-cost] + val, dp[i][t-1]
		
		
		int ind = 0;
		for (int i=0; i<n; i++) {
			Problem p = problems[i];
			for (int j=1; j<=t; j++) {
				if (i == 0) {
					if (j >= p.p1) dp[ind][j] = Math.max(dp[ind][j], p.v1);
					if (j >= p.p2) dp[ind][j] = Math.max(dp[ind][j], p.v2);
					if (j >= p.p3) dp[ind][j] = Math.max(dp[ind][j], p.v3);
					ans = Math.max(ans, dp[ind][j]);
					continue;
				}
				
				dp[ind][j] = Math.max(dp[ind][j-1], dp[ind^1][j]);
				if (j - p.p1 >= 0) dp[ind][j] = Math.max(dp[ind][j], dp[ind^1][j-p.p1] + p.v1);
				if (j - p.p2 >= 0) dp[ind][j] = Math.max(dp[ind][j], dp[ind^1][j-p.p2] + p.v2);
				if (j - p.p3 >= 0) dp[ind][j] = Math.max(dp[ind][j], dp[ind^1][j-p.p3] + p.v3);
				
				ans = Math.max(ans, dp[ind][j]);
			}
			
			ind ^= 1;
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


	
	
