
import java.io.*;
import java.util.*;

public class Abc231p6 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = 2*(int)1e5 + 5;
	static long[] bit = new long[MM];
	
	static void update(int ind, long v) {
		for (int i=ind; i<MM; i+=i&-i) bit[i] += v;
	}
	
	static long query(int ind) {
		int ret = 0;
		for (int i=ind; i>0; i-=i&-i) ret += bit[i];
		return ret;
	}
	
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.a == o.a) return this.b - o.b;
			return o.a - this.a;
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] a = new int[N], b = new int[N];
		Pair[] p = new Pair[N];
		
		for (int i=0; i<N; i++) a[i] = readInt();
		for (int i=0; i<N; i++) b[i] = readInt();
		for (int i=0; i<N; i++) {
			p[i] = new Pair(a[i], b[i]);
		}
		
		Arrays.sort(p); Arrays.sort(b);
		Map<Integer, Integer> map = new HashMap();
		int v = 1;
		map.put(b[0], v);
		for (int i=1; i<N; i++) {
			if (b[i] == b[i-1]) {
				continue;
			} else {
				map.put(b[i], ++v);
			}
		}
		
		long ans = 0, cont = 0;
		for (int i=0; i<N; i++) {
			// System.out.println(p[i].a + " " + p[i].b);
			if (i != 0 && p[i].a == p[i-1].a && p[i].b == p[i-1].b) cont ++;
			else cont = 0;
			ans += cont;
			update(map.get(p[i].b), 1);
			ans += query(map.get(p[i].b));
			
		}
		
		System.out.println(ans);
		
		
	
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
}


	
	
