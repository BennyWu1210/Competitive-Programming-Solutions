
import java.io.*;
import java.util.*;

public class coci06c1p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static double solve(int level, int mask, double[] dp, double[][] mat) {
		
		if (dp[mask] != -1) {
			return dp[mask];
		}
		
		if (level == mat.length) {
			return 1;
		}
		
		double prob = 0;
		
		for (int i=0; i<mat[level].length; i++) {
			if (((1 << i) & mask) == 0) {
				int newMask = (1 << i) | mask;
				double res = solve(level + 1, newMask, dp, mat) * mat[level][i];
				prob = Math.max(prob, res);
			}
		}
		
		return dp[mask] = prob;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		
		double[] dp = new double[1 << N + 1];
		double[][] mat = new double[N][N];
		
		Arrays.fill(dp, -1);
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				mat[i][j] = readDouble() / 100;
			}
		}
		
		double res = solve(0, 0, dp, mat);
		
		System.out.println(res * 100);
		
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


	
	
