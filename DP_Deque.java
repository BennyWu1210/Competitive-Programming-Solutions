
import java.io.*;
import java.util.*;

public class DP_Deque {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long[][] dp;
	static int[] arr;
	static long sum;
	
	static long solve(int l, int r, boolean turn) {
		if (l == r) {
			if (turn) return dp[l][r] = arr[l];
			else return dp[l][r] = -arr[l];
		}
		
		if (dp[l][r] != -1) return dp[l][r];
		
		long left = solve(l+1, r, !turn);
		long right = solve(l, r-1, !turn);
		
		if (turn) {
			return dp[l][r] = Math.max(left+arr[l], right+arr[r]);
		}
		else {
			return dp[l][r] = Math.min(left-arr[l], right-arr[r]);
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		dp = new long[N][N];
		arr = new int[N];
		sum = 0;
		
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
			sum += arr[i];
			Arrays.fill(dp[i], -1);

		}
		
		solve(0, N-1, true);
		
		System.out.println(dp[0][N-1]);
		
		
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


	
	
