
import java.io.*;
import java.util.*;

public class Dp_Practice0139 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int N = 10;
		int[] S = {2, 5, 3, 6};
		int[] dp = new int[N+1];
		
		dp[0] = 1;
		for (int i=0; i<S.length; i++) {
			for (int s=0; s<dp.length; s++) {
				if (s - S[i] >= 0) {
					dp[s] += dp[s - S[i]];
				}
			}
		}
		
		System.out.println(dp[N]);
		
		
		
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


	
	
