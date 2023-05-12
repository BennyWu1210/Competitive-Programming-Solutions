
import java.io.*;
import java.util.*;


public class DP_practice032 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int r = 4, c = 4;
		
		int[][] dp = new int[r][c];
		
		for(int i=0; i<r; i++) dp[i][0] = 1;
		for(int i=0; i<c; i++) dp[0][i] = 1;
		
		for(int i=1; i<r; i++) {
			for(int j=1; j<c; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		
		for(int[] row: dp) System.out.println(Arrays.toString(row));
		
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


	
	
