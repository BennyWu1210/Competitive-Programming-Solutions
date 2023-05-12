
import java.io.*;
import java.util.*;

public class cchange {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int x = readInt(), n = readInt();
		int[] a = new int[n], dp = new int[x+5];
		
		for (int i=0; i<n; i++) a[i] = readInt();
		Arrays.fill(dp, (int)1e9);
		
		dp[0] = 0;
		for (int i=0; i<=x; i++) {
			for (int j=0; j<n; j++) {
				if (i - a[j] >= 0) {
					dp[i] = Math.min(dp[i], dp[i-a[j]] + 1);
				}
			}
		}
		
		System.out.println(dp[x]);
		
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


	
	
