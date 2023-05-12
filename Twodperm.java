
import java.io.*;
import java.util.*;

public class Twodperm {
	

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(), Q = readInt();
		
		int[] psa = new int[5001];
		for (int i=1; i<psa.length; i++) psa[i] = psa[i-1] + i;
		
		for (int i=0; i<Q; i++) {
			int n = readInt();
			int r1 = n, c1 = 1, r2 = 1, c2 = n;
	
			if (N < n) {
				c1 += (n - N);
				r1 = N;
			}
			if (M < n) {
				r2 += (n - M);
				c2 = M;
			}
			
			System.out.println(r1 + " " + c1);
			System.out.println(r2 + " " + c2);
			System.out.println();
			
			int a = (r2 - M + 1);
			int b =  (r1 - N + 1);
			int l = Math.max(a, b);
			int r = Math.min(a, b);
			
			
			System.out.println(psa[r] - psa[l-1]);

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


	
	
