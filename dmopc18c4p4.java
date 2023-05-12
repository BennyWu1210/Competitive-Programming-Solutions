
import java.io.*;
import java.util.*;

public class dmopc18c4p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static class Pair implements Comparable<Pair>{
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}	
	}

	static class query implements Comparable<query>{
		int l, r, k, id;

		@Override
		public int compareTo(query o) {
			// TODO Auto-generated method stub
			return this.k - o.k;
		}
	}
	
	
	static int MM = 200005;
	static long[] bit = new long[MM], ans = new long[MM];
	static Pair[] a = new Pair[MM];
	static query[] q = new query[MM];

	static void update(int pos, long l) {
		for (int i=pos; i<MM; i+=(i&-i)) {
			bit[i] += l;
		}
	}

	static long getSum(int pos) {
		long res = 0;
		for (int i=pos; i>0; i-=(i&-i)) {
			res += bit[i];
		}

		return res;
	}

	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		for (int i=1; i<=N; i++) {
			a[i] = new Pair(readInt(), i);
			update(i, a[i].a);
		}
		
		for (int i=1; i<=Q; i++) {
			q[i] = new query();
			query cur = q[i];
			cur.l = readInt(); cur.r = readInt(); cur.k = readInt(); cur.id = i;
		}
		
		Arrays.sort(a, 1, N+1);
		Arrays.sort(q, 1, Q+1);
		
		for (int i=1, j=1; i<=Q; i++) {
			while (j <= N && a[j].a < q[i].k) {
				update(a[j].b, -2L*a[j].a);
				j ++;
			}
			
			ans[q[i].id] = getSum(q[i].r) - getSum(q[i].l-1);
		}
		
		for (int i=1; i<=Q; i++) System.out.println(ans[i]);

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




