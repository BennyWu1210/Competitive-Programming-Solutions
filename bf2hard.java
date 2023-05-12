
import java.io.*;
import java.util.*;

public class bf2hard {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long getHash (int l, int r, long[] h, long[] p, int mod) {
		return (h[r] - (h[l-1] * p[r-l+1]) % mod + mod) % mod;
	}
	
	public static void main(String[] args) throws IOException {
		
		String s = readLine();
		int K = readInt();
		int len = s.length() + 1;
		
		long[] hash = new long[len];
		long[] pow = new long[len];
		
		int base = 13, mod = (int)1e9 + 9;
		
		pow[0] = 1;
		
		for (int i=1; i<pow.length; i++) {
			pow[i] = pow[i-1] * base % mod;
		}
		
		for (int i=1; i<hash.length; i++) {
			hash[i] = ((hash[i-1] * base + (s.charAt(i-1) - 'a')) % mod);
		}
		
		int lIndex = -1;
		int rIndex = -1;
		long least = (long)1e18;
		
		for (int i=K; i<hash.length; i++) {
			
			long val = getHash(i-K+1, i, hash, pow, mod);
			// System.out.println(val);
			if (val < least) {
				least = val;
				lIndex = i - K;
				rIndex = i;
			}
		}
		System.out.println(Arrays.toString(hash));
//		long test1 = getHash(lIndex, rIndex, hash, pow, mod);
//		long test2 = getHash(lIndex, rIndex, hash, pow, mod);
//
//		if (test1 > test2) {
//			System.out.println(s.substring(lIndex+1, rIndex+1));
//		}
//		else {
//			System.out.println(s.substring(lIndex, rIndex));
//		}
		System.out.println(s.substring(lIndex, rIndex));
		
		
		
		
		
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


	
	
