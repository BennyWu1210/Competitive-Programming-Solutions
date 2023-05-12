
import java.io.*;
import java.util.*;


public class CCC12S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int R = readInt(), C = readInt(), K = readInt();
		int[][] dp = new int[R+1][C+1];
		int[][] mat = new int[R+1][C+1];
		
		for(int i=0; i<K; i++) {
			mat[readInt()][readInt()] = -1;
		}
		
		dp[1][1] = 1;
		for(int i=1; i<=R; i++) {
			for(int j=1; j<=C; j++) {
				if(mat[i][j] != -1) {
					dp[i][j] += dp[i-1][j] + dp[i][j-1];
				}
				else {
					dp[i][j] = 0;
				}
			}
		}
		
		
//		System.out.println(Arrays.deepToString(mat));
//		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[R][C]);
		
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


	
	
