
import java.io.*;
import java.util.*;

public class dmopc22c3p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		long N = readInt(), M = readInt();

		if (N * M % 2 == 0) {
			System.out.println(N * M / 2 + " " + N * M / 2);
		} else {
			System.out.println((Math.max(N, M) / 2 * Math.min(N, M) + Math.min(N, M)) + " " + (Math.max(N, M) / 2 * Math.min(N, M)));
		}

	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
