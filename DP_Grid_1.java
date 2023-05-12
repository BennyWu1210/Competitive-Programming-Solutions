
import java.io.*;
import java.util.*;


public class DP_Grid_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int H, W;
	static long countWays(int r, int c, char[][] mat, long[][] dp) {
		if (r == H-1 && c == W-1) return 1;
		if (dp[r][c] != -1) return dp[r][c];
		
		long ways = 0;
		if (r + 1 < H && mat[r+1][c] != '#') {
			ways += countWays(r+1, c, mat, dp);
		}
		if (c + 1 < W && mat[r][c+1] != '#') {
			ways += countWays(r, c+1, mat, dp);
		}
		return dp[r][c] = (long) (ways%(Math.pow(10, 9)+7));
		
	}
	
	public static void main(String[] args) throws IOException {
		H = readInt();
		W = readInt();
		char[][] mat = new char[H][W];
		long[][] dp = new long[H][W];
		
		for(int i=0; i<H; i++) {
			mat[i] = readLine().toCharArray();
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println(countWays(0, 0, mat, dp));
		
		
		
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


	
	
