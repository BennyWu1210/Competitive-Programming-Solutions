
import java.io.*;
import java.util.*;

public class the_torture_chamber {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	

	static long n, m;
	static boolean[] prime;
	static boolean[] ans;
	
	public static void main(String[] args) throws IOException {
		
		n = readLong(); m = readLong();
		prime = new boolean[(int)Math.sqrt(m)+1];
		ans = new boolean[(int) (m-n)];

		sieve();
		
		long count = 0;
		for (int i=0; i<ans.length; i++) {
			if (ans[i] && i+n != 1 && i+n != 0) {
				count ++;
			}
		}
		
		System.out.println(count);
		
		
	}
	
	
	static void sieve() {
		
		Arrays.fill(prime, true);
		
		prime[0] = false;
		prime[1] = false;
		
		for (int i=2; i<prime.length; i++) {
			if (prime[i]) {
				for (int j=i*i; j<prime.length && j > 0; j+=i) {
					prime[j] = false;
				}
			}
		}
		
		Arrays.fill(ans, true);
		for (int i=0; i<prime.length; i++) {
			if (prime[i]) {
				int start = (int) (n-(n%i)-n);
				
				while (start < 0) {
					start += i;
				}
				
				for (int j=start; j<m - n; j+=i) {
					if (j >= 0 && j < m - n) ans[j] = false;					
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


	
	
