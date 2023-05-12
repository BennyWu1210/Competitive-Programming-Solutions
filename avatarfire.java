
import java.io.*;
import java.util.*;

public class avatarfire {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		int[] a = new int[N + 1];
		for (int i = 1; i <= N; i++) a[i] = readInt();
		Arrays.sort(a);
		
		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			if (i <= K) a[i] *= 2;
			ans = Math.min(ans, a[i]);
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


	
	
