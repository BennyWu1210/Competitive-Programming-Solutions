
import java.io.*;
import java.util.*;

public class aac4p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	
	static long lcm(long a, long b) {
		long ret = a * b / gcd(a, b);
		if (ret > 1e9) ret = (long)1e9 + 1;
		return ret;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		long[] a = new long[N+1], pa = new long[N+1];
		pa[0] = 1;
		
		for (int i=1; i<=N; i++) {
			a[i] = readLong();
			pa[i] = lcm(pa[i-1], a[i]);
		}
		
		for (int i=0; i<Q; i++) {
			int n = readInt();
			
			int l = 1, r = N, ans = -1;
			
			while (l <= r) {
				int mid = (l + r) / 2;
				if (n % pa[mid] != 0) {
					r = mid - 1;
					ans = mid;
					
				} else {
					l = mid + 1;
				}
			}
			
			System.out.println(ans);
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


	
	
