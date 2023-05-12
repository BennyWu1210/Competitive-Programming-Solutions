
import java.io.*;
import java.util.*;

public class Matching {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N;
	static boolean[][] mat;
	static long[] dp;
	
	static int MOD = (int)1e9 + 7;
	
	static long solve(int mask, int level) {
		
		if (dp[mask] != -1) {
			return dp[mask];
		}
		
		if (level > N) {
			return 1;
		}
		
		long counter = 0;
		int index = 0;
		
		for (int i=N; i>0; i--) {
			boolean num = mat[level][i];
			if (num && ((1 << index) & mask) == 0) {
				int newMask = mask | (1 << index);
				counter = (counter + solve(newMask, level+1)) % MOD;
			}
			index ++;
		}
		
		return dp[mask] = counter % MOD;
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt();
		mat = new boolean[N+1][N+1];
		dp = new long[(1 << N) + 1]; 
		
		Arrays.fill(dp, -1);
		
		for (int i=1; i<=N; i++) {
			String[] input = readLine().split(" ");
			
			for (int j=1; j<=N; j++) {
				mat[i][j] = Integer.parseInt(input[j-1]) == 1;
			}
		}
		
		System.out.println(solve(0, 1));
	
		
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


	
	
