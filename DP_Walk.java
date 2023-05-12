
import java.io.*;
import java.util.*;

public class DP_Walk {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MOD = (int)1e9 + 7;
	static int[][] ans;
	static int n;
	
	static int[][] multiply(int[][] a, int[][] b) {
		int[][] m = new int[n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<n; k++) {
					m[i][k] = (int)((m[i][k] + (long)a[i][j] * b[j][k]) % MOD);
				}
			}
		}

		return m;


	}
	public static void main(String[] args) throws IOException {

		n = readInt();
		long k = readLong();

		int[][] grid = new int[n][n];
		ans = new int[n][n];

		
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grid[i][j] = readInt();
			}
		}
		
		for (int i=0; i<n; i++) {
			ans[i][i] = 1;
		}

		
		while (k > 0) {
			if (k % 2 != 0) {
				ans = multiply(ans, grid);
			}
			grid = multiply(grid, grid);

			k /= 2;
		}

		
		int total = 0;
		for (int a=0; a<n; a++) {
			for (int b=0; b<n; b++) {
				total = (total + ans[a][b]) % MOD;
				
			}
		}

		System.out.println(total);



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




