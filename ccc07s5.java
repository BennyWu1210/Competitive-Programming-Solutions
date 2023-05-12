import java.io.*;
import java.util.*;

public class ccc07s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException{
		int t = readInt();
		
		while (t --> 0) {
			int n = readInt(), k = readInt(), w = readInt();
			
			int[] a = new int[n+1], psa = new int[n+1]; int[][] dp = new int[n+1][k+1];
			
			for (int i=1; i<=n; i++) {
				a[i] = readInt();
				psa[i] = psa[i-1] + a[i];
				for (int j=1; j<=k; j++) dp[i][j] = Integer.MIN_VALUE;
			}
			
			for (int i=w; i<=n; i++) {
				for (int j=1; j<=k; j++) {
					// System.out.println(dp[i][j]);
					dp[i][j] = Math.max(dp[i][j], dp[i-w][j-1] + psa[i] - psa[i-w]);
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
				}
			}
			
			int ans = Integer.MIN_VALUE;
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=k; j++) {
					ans = Math.max(ans, dp[i][j]);
				}
			}
			
			System.out.println(ans);
		}
	}
	
	static String next() throws IOException{
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
}
