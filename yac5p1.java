
import java.io.*;
import java.util.*;

public class yac5p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long N, K, X;
	static long pow(long x, long p) {
		if (p == 0) return 1;
		long res = pow(x, p/2);
		res = res * res % K;
		if (p % 2 == 1) {
			res = res * x % K;
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		N = readLong(); K = readLong(); X = readLong();
		
		long powN = (pow(2, N - 1) - 1 + K) % K;
		
		long res = (X - ((powN * (K - 1)) % K) + K) % K;
		
		for (int i = 0; i < N - 1; i++) System.out.print(K - 1 + " ");
		System.out.println(res);
		
		
		
		
		
		
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


	
	
