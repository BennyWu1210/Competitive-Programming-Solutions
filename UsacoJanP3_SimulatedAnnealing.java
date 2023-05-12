
import java.io.*;
import java.util.*;

public class UsacoJanP3_SimulatedAnnealing {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static Pair[] neighbor(Pair[] arr) {

		Pair[] res = new Pair[N+1];
		int a = (int)(Math.random() * N + 1), b = (int)(Math.random() * N + 1);
		
		System.arraycopy(arr, 1, res, 1, N);
		res[a] = new Pair(arr[b].a, arr[b].b, arr[b].id);
		res[b] = new Pair(arr[a].a, arr[a].b, arr[a].id);
		return res;
	}

	static int value(Pair[] arr) {
		boolean[] cereals = new boolean[M+1];
		int ans = 0;
		for (int i=1; i<=N; i++) {
			if (!cereals[arr[i].a]) {cereals[arr[i].a] = true; ans ++;}
			else if (!cereals[arr[i].b]) {cereals[arr[i].b] = true; ans ++;}
		}

		return ans;
	}

	static int N, M;

	static class Pair{
		int a, b, id;
		public Pair(int a, int b, int id){
			this.a = a; this.b = b; this.id = id;
		}
	}

	static double P (Pair[] prev, Pair[] next, double temp) {
		int p = value(prev), n = value(next);
		if (p > n) return 1.0;
		return Math.exp((n-p)/temp);
	}

	static Pair[] clone(Pair[] arr) {
		Pair[] res = new Pair[N+1];

		System.arraycopy(arr, 1, res, 1, N);
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int time_limit = 1000;
		long start = System.currentTimeMillis();
		N = readInt(); M = readInt();
		Pair[] arr = new Pair[N+1];
		for (int i=1; i<=N; i++) arr[i] = new Pair(readInt(), readInt(), i);

		Pair[] best = clone(arr);
		
		for (int i=0; i<10; i++) {
			if (System.currentTimeMillis() - start > 2700) break;
			double t = (int)1e5; double a = 0.99995;
			while (t > 1e-3) {
				t *= a;
				Pair[] next = neighbor(arr);
				if (value(arr) > value(best)) best = clone(arr);
				if (P(arr, next, t) >= Math.random()) arr = clone(next);
			}
		}
		
		


		System.out.println(N - value(best));
		for (int i=1; i<=N; i++) {
			System.out.println(best[i].id);
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




