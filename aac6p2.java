
import java.io.*;
import java.util.*;

public class aac6p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;



	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt(), K = 1;

		int[] psa = new int[N+2];
		int[] ll = new int[N+2];
		
		for (int i=1; i<=Q; i++) {
			int l = readInt(), r = readInt();
			K = Math.max(K, r - l + 1);
			psa[l] ++; psa[r] --;
			ll[l] ++;
		}

		for (int i=1; i<=N; i++) psa[i] += psa[i-1];
		

		System.out.println(K);

		int cur = 1;
		for (int i=1; i<=N; i++) {
			if (psa[i-1] != 0) cur ++;
			System.out.print(cur % K + 1);

			if (i == N) System.out.println();
			else System.out.print(" ");

		}
		// System.out.println(ans[N]);

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
