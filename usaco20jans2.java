
import java.io.*;
import java.util.*;

public class usaco20jans2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(long X, long N, long M, long K) {
		long G = 0;
		long rem = N;
		
		if (rem - M * K <= 0) return true;
		
		while (rem > 0 && K >= 0) {
			long Y = (long)(Math.floor((N - G)*1.0/X));
			
			rem -= Y;
			G += Y;
			
			if (Y <= M) {
				return rem - M * (K - 1) <= 0;
			}
			
			K --;
			
		}
		return rem <= 0;
	}
	public static void main(String[] args) throws IOException {

		long N = readLong(), K = readLong(), M = readLong();
		
		long l = 1, r = (long)1e12 + 5, ans = l;
		
		
		while (l <= r) {
			long mid = (l + r) / 2;
			if (check(mid, N, M, K)) {
				l = mid + 1;
				ans = mid;
			}
			else {
				r = mid - 1;
			}
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


	
	
