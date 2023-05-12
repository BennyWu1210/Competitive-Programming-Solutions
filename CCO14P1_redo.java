
import java.io.*;
import java.util.*;

public class CCO14P1_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int max = 2005;
	static char[][] mat = new char[max][max];
	static int[][] dp = new int[max][max];
	static int n;
	
	static int solve(int r, int c) {
		if (dp[r][c] != -1) return dp[r][c];
		if (mat[r][c] == '.') return dp[r][c] = 0;
		
		boolean isTri = true;
		int min = Integer.MAX_VALUE;
		for (int i=-1; i<=1; i++) {
			if (r + 1 >= n) {
				isTri = false;
				break;
			}
			if (c + i < 0 || c + i >= n) {
				isTri = false;
				continue;
			}
			
			min = Math.min(min, solve(r+1, c+i));
		}
		
		
		if (!isTri) {
			dp[r][c] = 1;
		}
		else {
			dp[r][c] = min + 1;
		}
		
		return dp[r][c];
	}
	public static void main(String[] args) throws IOException {

		n = readInt();
		
		for (int i=0; i<n; i++) {
			mat[i] = readLine().toCharArray();
			Arrays.fill(dp[i], -1);
		}
		
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				ans += solve(i, j);
			}
		}
		
		
		
		System.out.println(ans);
		
		
		
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


	
	
