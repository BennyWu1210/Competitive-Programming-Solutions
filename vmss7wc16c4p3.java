
import java.io.*;
import java.util.*;

public class vmss7wc16c4p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int D = readInt(), I = readInt(), R = readInt();
		
		String[] input = readLine().split(" ");
		String A = input[0], B = input[1];

		// state: the time it takes to transform the first i 
		// characters to first j characters
		int[][] dp = new int[A.length()+1][B.length()+1];
		
		
		for (int i=1; i<=A.length(); i++) dp[i][0] = D * i;
		for (int i=1; i<=B.length(); i++) dp[0][i] = I * i;
		
		for (int i=1; i<=A.length(); i++) {
			for (int j=1; j<=B.length(); j++) {
				if (A.charAt(i-1) == B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				}
				else if (A.charAt(i-1) != B.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + R;
				}
				dp[i][j] = Math.min(dp[i][j], Math.min(dp[i-1][j] + D, dp[i][j-1] + I));
			}
		}
		
		System.out.println(dp[A.length()][B.length()]);
		
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


	
	
