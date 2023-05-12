
import java.io.*;
import java.util.*;

public class bf2hard_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e6 + 5;
	static char[] s = new char[MM];
	static long[] hash = new long[MM];
	static long[] pw = new long[MM];
	static int K;
	static int base = 131;
	
	static long getHash (int L, int R) {
		return hash[R] - hash[L-1] * pw[R-L+1];
	}
	public static void main(String[] args) throws IOException {
		s = readLine().toCharArray();
		K = readInt();
		int n = s.length;
		
		pw[0] = 1;
		
		for (int i=1; i<=n; i++) {
			pw[i] = pw[i-1] * base;
			hash[i] = hash[i-1] * base + s[i-1];
		}
		
		int pos = 0;
		
		for (int i=1; i+K-1<n; i++) {
			if (s[i] < s[pos]) pos = i;
			else if (s[i] == s[pos]) {
				int lo = 0, hi = K - 1, dif = 0;
				while (lo <= hi) {
					int m = (lo + hi)/2;
					if (getHash(pos+1, pos+m+1) == getHash(i+1, i+m+1)) {
						lo = m+1;
					}
					else {
						dif = m;
						hi = m-1;
					}
				}
				if (s[pos+dif] > s[i+dif]) pos = i;
			}
		}
		
		for (int i=pos; i<pos+K; i++) {
			System.out.print(s[i]);
			
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


	
	
