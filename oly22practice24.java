
import java.io.*;
import java.util.*;

public class oly22practice24 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e6 + 5;
	static boolean[] prime = new boolean[MN];
	
	static void sieve() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int i=2; i*i<MN; i++) {
			if (prime[i]) {
				for (int j=i*i; j<MN; j+=i) {
					prime[j] = false;
				}
			}
		}
	}
	
	static void checker(int ind) {
		boolean[] ans = new boolean[ind+1];
		for (int i=1; i<=ind; i++) {
			for (int j=i; j<=ind; j+=i) {
				ans[j] = !ans[j];
			}
		}
		
		int cnt = 0;
		for (int i=1; i<=ind; i++) {
			if (ans[i]) cnt ++;
		}
		
		System.out.println(Arrays.toString(ans));
		
		System.out.println(cnt);
	}
	
	static boolean check(long x, long V) {
		return x * x <= V;
	}
	public static void main(String[] args) throws IOException {

		long N = readLong(), ans = 0;
		
		// number of perfect squares
		
		int l = 0, r = (int)1e9;
		
		while (l <= r) {
			int mid = (l + r) / 2;
			if (check(mid, N)) {
				l = mid + 1;
				ans = mid;
			} else {
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


	
	
