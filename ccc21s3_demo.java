
import java.io.*;
import java.util.*;

public class ccc21s3_demo {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static long distance(long p, long d, long c) {
		long left = p - d;
		long right = p + d;
		
		if (left <= c && c <= right) return 0;
		return Math.min(Math.abs(c - left), Math.abs(c - right));
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		long[] P = new long[N], W = new long[N], D = new long[N];
		
		for (int i = 0; i < N; i++) {
			P[i] = readInt();
			W[i] = readInt();
			D[i] = readInt();
		}
		
		long min = Long.MAX_VALUE;
		for (int c = 0; c <= 2000; c++) {
			int totalDistance = 0;
			for (int i = 0; i < N; i++) {
				totalDistance += distance(P[i], D[i], c) * W[i];
			}
			min = Math.min(min, totalDistance);
		}
		
		System.out.println(min);
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


	
	
