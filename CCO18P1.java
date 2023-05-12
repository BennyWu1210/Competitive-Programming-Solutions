
import java.io.*;
import java.util.*;

public class CCO18P1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int[][] dp;
	
	static class Pair{
		char win;
		int score;
		
		public Pair(int score, char win) {
			this.win = win;
			this.score = score;
		}
	}
	
	static int solve(int gi, int hi, Pair[] geese, Pair[] hawks) {
		
		
		if (gi < 0 || hi < 0) return 0;
		if (dp[gi][hi] != -1) return dp[gi][hi];
			
		boolean gWin = geese[gi].win == 'W';
		boolean hWin = hawks[hi].win == 'W';
		
		int best = -1;
		
		int leave1 = solve(gi-1, hi, geese, hawks);
		int leave2 = solve(gi, hi-1, geese, hawks);
		int take = 0;
		
		if (gWin && !hWin && geese[gi].score > hawks[hi].score 
				|| !gWin && hWin && geese[gi].score < hawks[hi].score ) {
			take = solve(gi-1, hi-1, geese, hawks) + geese[gi].score + hawks[hi].score;
		}
		
		best = Math.max(take, Math.max(leave1, leave2));
		
		return dp[gi][hi] = best;
	}
	
	
	public static void main(String[] args) throws IOException {


		int N = readInt();
		Pair[] geese = new Pair[N], hawks = new Pair[N];
		dp = new int[N][N];
		
		char[] input = readLine().toCharArray();
		for (int i=0; i<N; i++) {
			char c = input[i];
			int score = readInt();
			
			geese[i] = new Pair(score, c);
		}
		
		input = readLine().toCharArray();
		for (int i=0; i<N; i++) {
			char c = input[i];
			int score = readInt();
			
			hawks[i] = new Pair(score, c);
		}
		
		for (int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		solve(N-1, N-1, geese, hawks);
		// System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[N-1][N-1]);
		
		
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


	
	
