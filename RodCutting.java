
import java.io.*;
import java.util.*;

public class RodCutting {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int[] v = {1, 5, 8, 9, 10, 17, 17, 20};
		int n = v.length;
		int[] dp = new int[n+1];
		
		dp[0] = 0;
		
		for (int i = 1; i <= n; i++) {
			int val = -(int)1e9;
			for (int j = 0; j < i; j ++) {
				val = Math.max(val, v[j] + dp[i-j-1]);
			}
			dp[i] = val;
		}
		
		System.out.println(Arrays.toString(dp));
		
		
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


	
	
