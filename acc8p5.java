
import java.io.*;
import java.util.*;

public class acc8p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e6 + 5, MOD = 998244353;
	static int T, N;
	static int[] a = new int[MN];  
	
	static void update(int ind, long v, long[] bit) {
		for (int i=ind; i<MN; i+=i&-i) bit[i] += v;
	}
	
	static long query(int ind, long[] bit) {
		long ans = 0;
		for (int i=ind; i>0; i-=i&-i) ans += bit[i];
		return ans;
	}
	
	public static void main(String[] args) throws IOException {

		T = readInt();
		
		while (T --> 0) {
			N = readInt();
			
			long[] bit1 = new long[MN], bit2 = new long[MN];
			for (int i=1; i<=N; i++) a[i] = readInt();
			
			long[] pref = new long[N+1], suf = new long[N+1];
			for (int i=1; i<=N; i++) {
				pref[i] = (query(a[i], bit1) + 1) % MOD;
				update(a[i], pref[i], bit1);
			}
			
			for (int i=N; i>=1; i--) {
				suf[i] = (query(a[i], bit2) + 1) % MOD;
				update(a[i], suf[i], bit2);
			}
			
			long res = 0;
			for (int i=1; i<=N; i++) {
				res = res + (pref[i] * suf[i]) % MOD;
			}
			System.out.println(res);
			
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


	
	
