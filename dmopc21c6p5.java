
import java.io.*;
import java.util.*;

public class dmopc21c6p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, M;
	static char[] c = new char[M+1];
	static long[][] dp = new long[M+1][M+1];
	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		c = readLine().toCharArray();
		
		for (int i=0; i<M; i++) {
			for (int j=1; j<=M-i; j++) {
				dp[i][j] += dp[i]
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


	
	
