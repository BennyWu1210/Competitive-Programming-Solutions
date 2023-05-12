
import java.io.*;
import java.util.*;

public class dmopc21c5p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = (int)1e7+ 5;
	static boolean[] prime = new boolean[MN];
	static int[] win = new int[MN];

	static void sieve() {
		for (int i=2; i<MN; i++) prime[i] = true;
		for (int i=2; i*i<MN; i++) {
			if (prime[i]) {
				for (int j=i*i; j<MN; j+=i) prime[j] = false;
			}
		}

		int cnt = 0;
		int ind = -1;
		for (int i=3; i<MN; i++) {
			if (prime[i - 1] || prime[i - 2]) ind = i;
			win[i] = ind;
			if (ind != i) cnt ++;
		}
		
		System.out.println(cnt + " " + MN);
	}

	static boolean checker(int[] a) {
		int len = a.length - 1;
		if (prime[len - 1] || prime[len - 2]) return true;
		
		int p = len;
		while (!prime[--p]);
		
		if (a[len - p] == 1 || a[len - p] == 2) return true;
		return false;
		
	}
	public static void main(String[] args) throws IOException {

		int T = readInt();
		int t = 1;
		sieve();
		
		while (t ++< T) {
			int N = t;
			if (N == 1) {
				System.out.println(-1);
				continue;
			}
			if (N == 2) {
				System.out.println(-1);
				continue;
			}

			int[] a = new int[N+1];
			for (int i=1; i<=N; i++) a[i] = i;

			int ind = -1, v = -1;
			boolean hasAns = false;
			if (!prime[N - 1] && !prime[N - 2]) {
				int p = N;
				
				while (--p >= 2) {
					if (win[p] != p && prime[N - p]) {
						hasAns = true;
						break;
					}
				}
				
				p = N;
				while (!prime[--p]);
				
				if (!hasAns) {
					if (!prime[N - p - 1]) {
						ind = N - p;
						v = 2;
					}else {
						ind = N - p;
						v = 1;
					}
				}
				
			}
			
			int[] ans = new int[N+1];
			int idx = 1;
			
			for (int i=1; i<N; i++) {
				if (v == i) continue;
				System.out.print(a[i] + " ");
				ans[idx++] = a[i];
				if (ind == i) {
					System.out.print(v + " ");
					ans[idx++] = v;
				}
			}
			ans[idx] = a[N];
			System.out.println(a[N]);
			
			if (!checker(ans)) {
				System.out.println(false);
				return;
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




