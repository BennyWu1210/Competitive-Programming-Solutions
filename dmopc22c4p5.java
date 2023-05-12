
import java.io.*;
import java.util.*;

public class dmopc22c4p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MAX = (int)1e6 + 3;
	public static boolean[] prime = new boolean[MAX];
	public static List<Integer> primes = new ArrayList<>();
	
	public static void sieve() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;
		
		for (int i = 2; i < MAX; i++) {
			if (prime[i]) {
				primes.add(i);
				long cur = i;
				if (cur * cur > Integer.MAX_VALUE) break;
				for (int j = i * i; j < MAX; j += i) {
					prime[j] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		sieve();
		
		int N = readInt();
		
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			long num = readLong();
			
			int ind = 0;
			while (num > 1 && ind < primes.size()) {
				System.out.println(num + " " + ind);
				while (num % primes.get(ind) == 0) {
					num /= primes.get(ind);
					count++;
				}
				ind++;
				
			}
		}
		
		
		System.out.println(count);
		if (count % 2 == 1) {
			System.out.println("ALICE");
		}
		else {
			System.out.println("BOB");
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


	
	
