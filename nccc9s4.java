
import java.io.*;
import java.util.*;

public class nccc9s4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)1e5 + 5, sqrt = 316;
	static int[] arr = new int[MM], ans = new int[MM];
	static int N, Q;
	static List<Query> queries = new ArrayList();
	
	static class Query implements Comparable<Query>{
		int l, r, ind;
		
		public Query(int l, int r, int ind) {
			this.l = l;
			this.r = r;
			this.ind = ind;
		}

		@Override
		public int compareTo(Query o) {
			if (this.l / sqrt != o.l / sqrt) return this.l - o.l;
			return this.r - o.r;
		}
	}
	
	static class Pair implements Comparable<Pair>{
		int num, cnt;
		public Pair(int num) {
			this.num = num;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.cnt != o.cnt) return this.cnt - o.cnt;
			System.out.println("ihib");
			return o.num - this.num;
		}
		
		public String toString() {
			return "Pair: " + num + ", " + cnt;
			
		}
	}
	
	static class Comp implements Comparator<Pair>{

		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.cnt == o2.cnt) {
				return o2.num - o1.num;
			}
			return o2.num - o1.num;
			
		}
	}
	
	static void MO() {
		int L = 1, R = 0;
		Pair[] pairs = new Pair[N+2];
		PriorityQueue<Pair> pq = new PriorityQueue(new Comp());
		
		for (int i=1; i<=N; i++) {
			pairs[i] = new Pair(i);
			pq.add(pairs[i]);
		}
		
		System.out.println(pq);
		
		for (Query q: queries) {
			while (L < q.l) {
				System.out.println("increased L");
				pairs[arr[L]].cnt --;
				L ++;
			}
			
			while (L > q.l) {
				System.out.println("decreased L");
				L --;
				pairs[arr[L]].cnt ++;
			}
			
			while (R < q.r) {
				
				R ++;
				System.out.println("increased R" + " " + pairs[arr[R]].num);
				pairs[arr[R]].cnt ++;
			}
			
			while (R > q.r) {
				System.out.println("decreased R");
				pairs[arr[R]].cnt --;
				R --;
			}
			Pair p = new Pair(100000);
			p.cnt = 100000000;
			pq.add(p);
			pq.poll();
			
			System.out.println(L + " " + R);
			System.out.println(pq);
			
			ans[q.ind] = pq.peek().num;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); Q = readInt();
		
		for (int i=1; i<=N; i++) arr[i] = readInt();
		for (int i=0; i<Q; i++) {
			int l = readInt(), r = readInt();
			queries.add(new Query(l, r, i));
		}
		
		MO();
		
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


	
	
