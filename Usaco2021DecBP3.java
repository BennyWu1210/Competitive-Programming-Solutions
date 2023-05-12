
import java.io.*;
import java.util.*;

public class Usaco2021DecBP3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static char[][] mat;
	static long solve(int r, int c, int k, boolean dir, int max, long[][][][] dp) {
		if (r >= dp.length || c >= dp.length) return 0;
		int s = dir ? 1 : 0;
		if (mat[r][c] == 'H') return dp[r][c][k][s] = 0;
		if (r == dp.length - 1 && c == dp.length - 1) return dp[r][c][k][s] = 1;
		if (dp[r][c][k][s] != -1) return dp[r][c][k][s];
		
		dp[r][c][k][s] = 0;
		if (k == max) {
			if (dir) dp[r][c][k][s] = solve(r+1, c, k, dir, max, dp);
			else dp[r][c][k][s] = solve(r, c+1, k, dir, max, dp);
			return dp[r][c][k][s];
		}
		
		if (dir) dp[r][c][k][s] += solve(r+1, c, k, dir, max, dp) + solve(r, c+1, k+1, !dir, max, dp);
		else dp[r][c][k][s] += solve(r, c+1, k, dir, max, dp) + solve(r+1, c, k+1, !dir, max, dp);
		return dp[r][c][k][s];
	}
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		while (T --> 0) {
			int N = readInt(), K = readInt();
			long[][][][] dp = new long[N][N][K+1][2];
			mat = new char[N][N];
			for (int i=0; i<N; i++) {
				mat[i] = readLine().toCharArray();
				for (int j=0; j<N; j++) {
					for (int k=0; k<=K; k++) Arrays.fill(dp[i][j][k], -1);
				}
			}
			long ans = solve(1, 0, 0, true, K, dp) + solve(0, 1, 0, false, K, dp);
			System.out.println(ans);
			
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




