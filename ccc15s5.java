
import java.io.*;
import java.util.*;

public class ccc15s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[] A, B;
	static int[][][][] dp;
	static int N, M;
	
	static int solve(int i, boolean canTake, int l, int r) {

		int take = canTake ? 1 : 0;
		
		if (dp[i][take][l][r] != -1) return dp[i][take][l][r];
		
		int ans = 0;
		if (i == N + 1) {
			if (l <= r) {
				if (canTake) {
					ans = solve(i, false, l, r-1) + B[r];
				}
				else {
					ans = solve(i, true, l+1, r);
				}
			}
			
			return dp[i][take][l][r] = ans;
		}
		
		
		if (canTake) {
			ans = Math.max(solve(i+1, false, l, r) + A[i], solve(i, false, l, r));
			if (l <= r) {
				ans = Math.max(solve(i, false, l, r-1) + B[r], ans);
			}

		}
		
		else {
			ans = solve(i+1, true, l, r);
			if (l <= r) {
				ans = Math.max(solve(i, true, l+1, r), ans);
			}

		}
		
		return dp[i][take][l][r] = ans;
	
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt();
		A = new int[N+1];
		for (int i=1; i<=N; i++) A[i] = readInt();
		
		M = readInt();
		B = new int[M+1];
		for (int i=1; i<=M; i++) B[i] = readInt();
		
		Arrays.sort(B, 1, M+1);
		
		dp = new int[N+2][2][M+2][M+2];
		
		for (int i=0; i<=N+1; i++) {
			for (int j=0; j<=M+1; j++) {
				Arrays.fill(dp[i][0][j], -1);
				Arrays.fill(dp[i][1][j], -1);
			}
		}
		
		
		System.out.println(solve(1, true, 1, M));
		
		
		
		
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


	
	
