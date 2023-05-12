
import java.io.*;
import java.util.*;
public class DP_Vacation {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		
		int[][] dp = new int[3][N];
		int max = -1;
		
		
		for(int i=0; i<N; i++) {
			
			dp[0][i] = readInt();
			dp[1][i] = readInt();
			dp[2][i] = readInt();
			
			if (i != 0) {
				dp[0][i] = dp[0][i] + Math.max(dp[1][i-1], dp[2][i-1]);
				dp[1][i] = dp[1][i] + Math.max(dp[0][i-1], dp[2][i-1]);
				dp[2][i] = dp[2][i] + Math.max(dp[1][i-1], dp[0][i-1]);
			}
			
			
		}
		
		max = Math.max(max, Math.max(Math.max(dp[0][N-1], dp[1][N-1]), dp[2][N-1]));
		System.out.println(max);
		
		
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
