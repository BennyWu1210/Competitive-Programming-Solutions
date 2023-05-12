
import java.io.*;
import java.util.*;

public class Aug28_Question {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int red = 2021;
	static int blue = 2020;
	
	static double[][] dp = new double[red+5][blue+5];
	
	static double solve(int r, int b) {
		if (b < 0 || r < 0) return 0;
		if (b == 0 && r > 0) return 1;
		if (b > 0 && r == 0) return 0;
		if (b > blue || r > red) return 0;
		
		if (dp[r][b] != -1) return dp[r][b];
		
		// Two red (R-1, B)
		double twoRed = solve(r-1, b) * ((double)r/(r+b)) * ((double)r-1/(r+b-1)) ;
		// Two blue (R+1, B-2)
		double twoBlue = solve(r+1, b-2) * ((double)b/(r+b)) * ((double)b-1/(r+b-1)) ;
		// One each (R-1, B)
		double oneEach = twoRed * 2 * ((double)r/(r+b)) * ((double)b/(r+b-1));
		
		// System.out.println(twoRed + " " + twoBlue + " " + oneEach);
		return dp[r][b] = twoRed + twoBlue + oneEach;
		
	}
	public static void main(String[] args) throws IOException {

		for (int i=0; i<dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		solve(2021, 2020);
		System.out.println(dp[2021][2020]);
		
		
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


	
	
