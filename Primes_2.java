
import java.io.*;
import java.util.*;

public class Primes_2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static boolean[] prime;
	static boolean[] ans;
	static int l, r;
	
	public static void main(String[] args) throws IOException {

		l = readInt(); r = readInt();
		prime = new boolean[(int)Math.sqrt(r)+1];
		ans = new boolean[r-l+1];
		sieve(r);
		
		
		for (int i=0; i<r-l+1; i++) {
			if (ans[i] && i + l != 0 && i + l != 1) {
				System.out.println(i+l);
			}
		}
		
	}
	
	
	
	static void sieve(int N) {
		
		Arrays.fill(prime, true);
		
		
		prime[0] = false;
		prime[1] = false;
		
		for (int i=2; i*i<prime.length; i++) {
			if (prime[i]) {
				for (int j=i*i; j<prime.length; j += i) {
					prime[j] = false;
				}
			}
		}
		
		
		
		Arrays.fill(ans, true);
		

		for (int i=2; i<prime.length; i++) {
			if (prime[i]) {
				for (int j=i*i; j<=r; j+=i) {
					if (j >= l && j <= r) {
						ans[j - l] = false;
					}
				}
			}
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


	
	
