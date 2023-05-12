
import java.io.*;
import java.util.*;


public class DP_Coins {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static double dp1(int N, double[] p) {
		double[][] dp = new double[N+1][N+1];
		dp[0][0] = 1.0;
		
		for(int i=1; i<=N; i++) {
			for(int j=0; j<=i; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j] * (1.0 - p[i-1]);
				}
				else {
					dp[i][j] = dp[i-1][j] * (1.0 - p[i-1]) + dp[i-1][j-1] * p[i-1];
				}
			}
		}
		
		double ans = 0;
		
		for(int i=(N+1)/2; i<=N; i++) {
			ans += dp[N][i];
		}
		
		return ans;
	}
	
	static double dp2(int N, int[] p) {
		// with equal probability
		double ans = 0;
		int MAX = (int)1e6+1;
		double dp[] = new double[MAX];
		
		for(int i=2; i<N; i++) {
			dp[i] = (Math.log(i)/Math.log(2)) + dp[i-1];
		}
		
		for(int i=N/2; i<=N; i++) {
			double res = dp[N] - dp[i] - dp[N-1] - N;
			ans += Math.pow(2.0, res);
		}
		
		return ans;
	}
	public static void main(String[] args) throws IOException {

		int N = readInt();
		double[] p = new double[N];
		
		for(int i=0; i<N; i++) p[i] = readDouble();
	
		
		System.out.println(dp1(N, p));
		
		
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


	
	
