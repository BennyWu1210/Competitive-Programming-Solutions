
import java.io.*;
import java.util.*;

public class bdep {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long P, Y, T;
	
	
	static boolean solve(long N) {
		long tot = 0;
		for (int i = 0; i < Y; i++) {
			tot += N;
						
			tot = (long)(tot * (100 + P)) / 100;
			
			if (tot >= T) return true;	
		}
		
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		P = readLong(); Y = readLong(); T = readLong();
		
		long lo = 1, hi = T, ans = -1;
		
		while (lo <= hi) {
			long mid = (lo + hi) / 2;
			
			if (solve(mid)) {
				hi = mid - 1;
				ans = mid;
			} else {
				lo = mid + 1;
			}
		}
		
		if (!solve(ans) || ans == -1) throw new AssertionError();
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


	
	
