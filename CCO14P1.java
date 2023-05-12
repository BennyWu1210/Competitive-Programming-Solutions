
import java.io.*;
import java.util.*;

public class CCO14P1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int[][] mat;
	static int[][] dp;
	static int ans;
	static void solve(int r, int c) {

		if (mat[r][c] - mat[r][c-1] != 1) return;


		ans ++;
		int x = r, yl = c, yr = c;
		while (x < dp.length - 1 && yl > 1 && yr < dp.length - 1) {
			if (mat[x+1][yr+1] - mat[x+1][yl-1-1] == yr - yl + 3) {
				ans ++;
				x ++;
				yl --;
				yr ++;
			}
			else {
				break;
			}
		}

	}
	public static void main(String[] args) throws IOException {

		for (int t=0; t<5; t++) {
			int N = readInt();
			mat = new int[N+1][N+1];
			dp = new int[N+1][N+1];
			ans = 0;

			for (int i=1; i<=N; i++) {
				char[] c = readLine().toCharArray();
				for (int j=1; j<=N; j++) {
					mat[i][j] = c[j-1] == '#' ? 1 : 0;
					mat[i][j] += mat[i][j-1];
					dp[i][j] = -1;
				}
			}


			for (int i=1; i<=N; i++) {
				for (int j=1; j<=N; j++) {
					solve(i, j);
				}
			}

			System.out.println(ans);
		}

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




