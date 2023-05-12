import java.io.*;
import java.util.*;

public class DP_Slimes {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		int[] arr = new int[N];
		long[][] dp = new long[N+1][N+1];
		long[] sum = new long[N+1];
		
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
			sum[i+1] = arr[i];
			sum[i+1] += sum[i];
		}
		for (int i=0; i<dp.length; i++){
			Arrays.fill(dp[i], (long)1e15);
			dp[i][i] = 0;
		}

		for (int i=2; i<=N; i++) {
			for (int j=1; j<=N-i+1; j++) {
				for (int z=1; z<i; z++) {

					long left = dp[j][j+i-1-z];
					long right = dp[j+i-z][j+i-1];

					dp[j][j+i-1] = Math.min(dp[j][j+i-1], left + right);
				}
				dp[j][j+i-1] += (sum[j+i-1] - sum[j-1]);
				
		
			}
		}
		
		System.out.println(dp[1][N]);
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