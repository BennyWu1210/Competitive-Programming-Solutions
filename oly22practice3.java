
import java.io.*;
import java.util.*;

public class oly22practice3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long[] dp = new long[2*(int)1e5 + 3];
	static int[] a = new int[2*(int)1e5 + 3], freq = new int[5004];
	
	static long solve(int num) {
		if (dp[num] != -1) return dp[num];
		
		long ans = 0;
		
		for (int i=num*2; i<=5000; i+=num) {
			ans += solve(i);
		}
		
		return dp[num] = ans + freq[num];
	}
	public static void main(String[] args) throws IOException {

		int n = readInt(); long ans = 0;
		
		
		for (int i=1; i<=n; i++) {
			a[i] = readInt();
			freq[a[i]] ++;
		}
//		
//		for (int i=1; i<=n; i++) {
//			for (int j=1; j<=n; j++) {
//				if (i == j) continue;
//				if (a[i] % a[j] == 0) {
//					ans ++;
//				}
//			}
//		}
		
		Arrays.fill(dp, -1);
		solve(1);
		
		for (int i=1; i<=16; i++) {
			System.out.println(i + " " + dp[i]);
			ans = ans + dp[i];
		}
		
		System.out.println(ans);
		
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


	
	
