import java.io.*;
import java.util.*;

public class DP_Stones {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	static int N, K;
	static int[] heights;
	static int[][] dp;
	
	static int solve(int h, boolean turn) {

		int turnNum = turn? 1 : 0;

		if (h > K) {
			return turnNum;
		}

		if (dp[h][turnNum] != -1) return dp[h][turnNum];

		for (int a: heights) {
			
			if (solve(h + a, !turn) == 1) {
				if (turn) return dp[h][turnNum] = 1;
			}
			else {
				if (!turn) return dp[h][turnNum] = 0;
			}
		}

		if (turn) return dp[h][turnNum] = 0;
		else return dp[h][turnNum] = 1;


	}


	public static void main(String[] args) throws IOException {

		N = readInt();
		K = readInt();

		heights = new int[N];

		for (int i=0; i<N; i++) {
			heights[i] = readInt();
		}


		// 0 -> false, 1 -> true, -1 -> unknown
		dp = new int[K+1][2];

		for (int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		int res = solve(0, true);


		if (res == 1) System.out.println("First");
		else System.out.println("Second");

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