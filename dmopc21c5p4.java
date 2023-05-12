
import java.io.*;
import java.util.*;

public class dmopc21c5p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = (int)1e6 + 6;
	static boolean[] prime = new boolean[MN];

	static void Sieve() {
		Arrays.fill(prime, true);
		prime[0] = prime[1] = false;

		for (int i=2; i*i<MN; i++) {
			if (prime[i]) {
				for (int p=i*i; p<MN; p+=i) {
					prime[p] = false;
				}
			}
		}
	}


	public static void main(String[] args) throws IOException {

		int T = readInt();
		Sieve();

		outer: while (T --> 0) {
			int N = readInt();
			int x = 0;

			if (N == 1) {
				System.out.println(1);
				continue;
			}

			if (N <= 3) {
				System.out.println(-1);
				continue;
			}

			if (N == 4) {
				System.out.println("3 1 4 2");
				continue;
			}
			
			if (N == 5) {
				System.out.println("5 3 1 4 2");
				continue;
			}
			
			if (N == 6) {
				System.out.println("1 3 5 2 4 6");
				continue;
			}

			if (N == 7) {
				System.out.println("1 3 5 7 2 4 6");
				continue;
			}

			boolean odd = N % 2 == 1;
			if (N % 2 == 1) N--;

			for (int i=3; i<=N; i++) {
				if (prime[i] && prime[N-i]) {
					x = i;
					break;
				}
			}

			int cur = 0;

			if (odd) {
				System.out.print((N+1));
				for (int i=0; i<N; i++) {
					cur = (cur + x) % N;
					System.out.print(" " + (cur + 1));
				}
				System.out.println();
			} else {
				for (int i=1; i<N; i++) {
					cur = (cur + x) % N;
					System.out.print((cur + 1) + " ");
				}
				System.out.println((cur + x) % N + 1);
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




