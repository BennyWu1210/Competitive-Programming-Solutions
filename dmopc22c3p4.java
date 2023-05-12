
import java.io.*;
import java.util.*;

public class dmopc22c3p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), C = readInt(), K = readInt();
		
		long[][] dp = new long[N + 1][C + 1];
		
		dp[0][0] = 0;
		Set<Integer> exp = new HashSet();
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k <= K; k++) {
					
				}
			}
		}
		
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


	
	
