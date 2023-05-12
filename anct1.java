
import java.io.*;
import java.util.*;

public class anct1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int INF = (int)1e9 + 3;
	public static void main(String[] args) throws IOException {

		int N = readInt(), D = Math.abs(readInt());
		int[] a = new int[N + 1]; int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) a[i] = readInt();
		Arrays.sort(a);
		for (int i = 1; i <= N; i++) {
			if (D % a[i] == 0) ans = D / a[i];
		}
		String opt = ans == Integer.MAX_VALUE ? "This is not the best time for a trip." : String.valueOf(ans);
		System.out.println(opt);
	
		
		
		
		
		
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


	
	
