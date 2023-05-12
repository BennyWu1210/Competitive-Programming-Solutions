
import java.io.*;
import java.util.*;
public class DP_Knapsack_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int N = readInt();
		int W = readInt();

		long[] dp = new long[W+1]; // Optimized space complexity
		
		
		for(int i=0; i<N; i++) {
			int weight = readInt(), value = readInt();
			for(int w=W; w>=weight; w--) {
				dp[w] = Math.max(dp[w], dp[w-weight]+value); // Interesting concept
				
			}
		}

		System.out.println(dp[W]);
		
		
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
