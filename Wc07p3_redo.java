
import java.io.*;
import java.util.*;

public class Wc07p3_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		int T = readInt();

		while (T-->0) {
			int N = readInt();
			int[][] mat = new int[N][N];
			int[] dp = new int[1 << N];

			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					mat[i][j] = readInt();
				}
			}
			dp[0] = 1;
			for (int m=1; m<(1<<N); m++) {
				for (int u=0; u<N; u++) {
					if (((1 << u) & m) != 0) {
						for (int v=0; v<N; v++) {
							if (mat[v][u] == 1) {
								dp[m] += dp[(~(1 << u) & m)];
							}
						}
					}
				}
			}

			System.out.println(Arrays.toString(dp));
			long ans = 0;
			for (int i=(1<<N-1); i<(1<<N); i++) {
				ans += dp[i];
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




