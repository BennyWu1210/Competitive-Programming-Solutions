
import java.io.*;
import java.util.*;

public class dmopc14c2p6 {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long[] bit, ans;
	static Pair[] p;
	static Query[] q;
	
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
	
	static class Query implements Comparable<Query>{
		int l, r, k, id;

		public Query(int l, int r, int k, int id) {
			this.l = l;
			this.r = r;
			this.k = k;
			this.id = id;
		}
		
		@Override
		public int compareTo(Query o) {
			// TODO Auto-generated method stub
			return this.k - o.k;
		}
	}
	
	static void update(int pos, long l) {
		pos ++;
		for (int i=pos; i<bit.length; i+=(i&-i)) {
			bit[i] += l;
		}
	}
	
	static long getSum(int pos) {
		long res = 0;
		pos ++;
		for (int i=pos; i>0; i-=(i&-i)) {
			res += bit[i];
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		p = new Pair[N];
		bit = new long[30005];
		for (int i=0; i<N; i++) {
			p[i] = new Pair(readInt(), i);
			update(i, p[i].a);
		}
	
		
		int Q = readInt();
		
		ans = new long[Q];
		q = new Query[Q];
		
		for (int i=0; i<Q; i++) {
			q[i] = new Query(readInt(), readInt(), readInt(), i);
		}
		
		Arrays.sort(p); Arrays.sort(q);
		
		
		for (int i=0, j=0; i<Q; i++) {
			while (j < N && p[j].a < q[i].k) {
				update(p[j].b, -1L*p[j].a);
				j ++;
			}
			
			ans[q[i].id] = getSum(q[i].r) - getSum(q[i].l-1);
		}
		
		for (int i=0; i<Q; i++) System.out.println(ans[i]);
		
		
		
		
		
		
		
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


	
	
