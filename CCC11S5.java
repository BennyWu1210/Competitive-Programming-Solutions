
import java.io.*;
import java.util.*;


public class CCC11S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int k;
	
	public static long countWays(int i, int mask, long[] dp) {
		// System.out.println(Integer.toBinaryString(mask));
		if (i == 0 || i > k) {
			if (mask == 0) return dp[i] = 1;
			else return dp[i] = 1;
		}
		if (mask == 0) return dp[i] = 1;
		if (dp[i] != -1) return dp[i];
		
		
		long ways = 0;
		
		long way1 = countWays(i-1, mask, dp);
		
		int consec = 1;
		int idx = i;
		int start = -1, end = -1;
		int m = 0;
		while(idx <= k) {
			if ((mask & (1 << idx)) != 0) {
				consec ++;
				m = 1 << idx;
				idx ++;
			}
			else {
				break;
			}
		}
		
		idx = i-1;
		while(idx >= 0) {
			if ((mask & (1 << idx)) != 0) {
				consec ++;
				m = 1 << idx;
				idx --;
			}
			else {
				start = idx;
				break;
			}
		}
		if (consec >= 4) {
			mask ^= m;
		}
		// System.out.println(consec);
		long way2 = countWays(i-1, mask, dp) + 1;
		
	
		// System.out.println(way1 + " " + way2);
		return dp[i] = Math.min(way1, way2);
		
		
		
		
	}
	public static void main(String[] args) throws IOException {
		
		k = readInt();
		long[] dp = new long[k+1];
		Arrays.fill(dp, -1);
		int mask = 0;
		for(int i=0; i<k; i++) {
			int input = readInt();
			mask = mask | input << i;
		}
		
		System.out.println(countWays(k, mask, dp));
		// System.out.println(Arrays.toString(dp));
		
		
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


	
	
