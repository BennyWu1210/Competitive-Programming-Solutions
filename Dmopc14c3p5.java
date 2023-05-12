
import java.io.*;
import java.util.*;


public class Dmopc14c3p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int INF = 0x3F3F3F3F;
	static int N, M;
	static String[] arr = new String[25];
	static int[][] dp = new int[55][(1 << 20) + 5];
	
	static int solve(int n, int b) {

		if (dp[n][b] == -1) {
			if (n == 0) {
				if (b == 0) {
					dp[n][b] = 0;
				}
				else {
					dp[n][b] = INF;
				}
			}
			else {
				int b0 = nxt(n, b);
				dp[n][b] = Math.min(solve(n-1, b), solve(n-1, b0) + 1);
			}
		}
		
		
		return dp[n][b];
	}
	
	static int nxt(int n, int b) {
		for(int i=0; i<N; i++) {
			if (arr[i].charAt(n-1) == 'X') {
				
				b &= ~(1 << i);
			}
		}
		
		return b;
	}
	public static void main(String[] args) throws IOException {
		N = readInt();
		M = readInt();
		int cnt = 0;
		
		for(int i=1; i<=N; i++) {
			String str = readLine();
			for(char c: str.toCharArray()) {
				if (c == 'X') {
					arr[cnt] = str;
					cnt ++;
					break;
				}
			}
		}
		
		N = cnt;
		
		for(int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		
		int ans = solve(M, (1 << N) - 1);
		if (ans == 0) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		
		System.out.println(ans);
		int b = (1 << N) - 1;
		
		for(int n=M; n>0; n--) {
			int b0 = nxt(n, b);
			if (dp[n][b] == dp[n-1][b0] + 1) {
				System.out.printf("%d ", n);
				b = b0;
			}
		}
		
		System.out.println();
		
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


	
	
