
import java.io.*;
import java.util.*;

public class Wc07p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[][] dp;
	static final int mod = 13371337;

	static int solve(int i, int mask, int[][] mat, int N) {
		if (dp[i][mask] != -1) {
			return dp[i][mask];
		}
		
		if (((1 << i) & mask) == 0) {
			return dp[i][mask] = 0;
		}
		
		if (i == 0 && mask == 1) {
			return dp[i][mask] = 1;
		}
		
		dp[i][mask] = 0;
		
		for (int j=0; j<N; j++) {
			if (mat[j][i] != 0 && ((1 << j) & mask) != 0) {
				dp[i][mask] += solve(j, ~(1 << i) & mask, mat, N);
				dp[i][mask] %= mod;
			}
		}
		
		return dp[i][mask];
	}

	public static void main(String[] args) throws IOException {

		int T = readInt();

		while (T --> 0) {
			int N = readInt();
			int[][] mat = new int[N][N];
			dp = new int[N][1 << N];
			
			for (int i=0; i<dp.length; i++) {
				Arrays.fill(dp[i], -1);
			}

			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					mat[i][j] = readInt();
				}
			}
			
			long sum = 0;
			for (int i=(1<<(N-1)); i<(1<<N); i++) {
				sum += solve(N-1, i, mat, N);
				sum %= mod;
			}
			// System.out.println(Arrays.deepToString(dp));
			System.out.println(sum);

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




