
import java.io.*;
import java.util.*;


public class DP_Knapsack_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
//		int n = readInt();
//		int w = readInt();
//		long[][] dp = new long[n+1][(int)1e5+1];
//		
//		for(int i=0; i<=1e5; i++) {
//			dp[0][i] = (long)1e9+1;
//		}
//		
//		for(int i=0; i<=n; i++) {
//			dp[i][0] = 0;
//			
//		}
//		
//		for(int i=1; i<=n; i++) {
//			int weight = readInt(), value = readInt();
//			for(int j=1; j<=1e5; j++) {
//				if (value>j) {
//					dp[i][j] = dp[i-1][j];
//				}
//				else {
//					dp[i][j] = Math.min(dp[i-1][j], weight+dp[i-1][j-value]);
//					// System.out.println(dp[i][j]);
//				}
//				
//			}
//		}
//		int ans = 0;
//		for(int v=(int) 1e5; v>-0; v--) {
//			if (dp[n][v] <= w) {
//				System.out.println(v);
//				return;
//			}
//		}
		// System.out.println(ans);
		
		
		// Another approach
		int n = readInt();
		int w = readInt();
		long[] dp = new long[1000 * n + 1];
		Arrays.fill(dp, (long) 1e10);
		dp[0] = 0;
		
		for(int i=0; i<n; i++) {
			int weight = readInt();
			int value = readInt();
			for(int j=dp.length-value-1; j>=0; j--) {
				dp[j+value] = Math.min(dp[j+value], dp[j]+weight);
			}
		}
		
		
		for(int i=dp.length-1; i>=0; i--) {
			if (dp[i] <= w) {
				System.out.println(i);
				return;
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


	
	
