
import java.io.*;
import java.util.*;

public class aac6p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] a = new int[N+2];
		
		// subtask 1:
		
		int consc = 1;
		long ans = 0;
		long[] dp = new long[N+2];
		
		for (int i=1; i<=N; i++) {
			a[i] = readInt();
			if (a[i] == a[i-1]) consc ++;
			else consc = 1;
			dp[i] = dp[i-1] + consc;
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


	
	
