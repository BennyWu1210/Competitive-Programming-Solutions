
import java.io.*;
import java.util.*;

public class UsacoJanP1 {

	static StringTokenizer stk;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static class Pair{
		long a, b;
		public Pair(long a, long b) {
			this.a = a; this.b = b;
		}
	}
	
	public static void main(String[] args) throws IOException{
		int T = readInt();
		
		long[] pow = new long[65];
		pow[0] = 1;
		for (int i=1; i<=64; i++) pow[i] = pow[i-1] * 2;
		
		while (T --> 0) {
			long a = readLong(), b = readLong();
			List<Pair> first = new ArrayList(), second = new ArrayList();
			long moves = Integer.MAX_VALUE;

			int cnt = 0;
			first.add(new Pair(a, 0));
			second.add(new Pair(b, 0));
			
			// log(a)
			while (a > 1) {
				if (a % 2 == 1) {
					a ++;
					cnt ++;
				}
				a /= 2;
				cnt ++;
				first.add(new Pair(a, cnt));
			}
			
			cnt = 0;
			// log(b)
			while (b > 1) {
				if (b % 2 == 1) {
					cnt ++;
				}
				b /= 2;
				cnt ++;
				second.add(new Pair(b, cnt));
			}
			
//			for (Pair p: first) System.out.println(p.a + " " + p.b);
//			System.out.println();
//			for (Pair p: second) System.out.println(p.a + " " + p.b);
			
			outer: for (Pair p1: first) {
				for (Pair p2: second) {
					if (p1.a > p2.a) continue outer;
					long ans = p1.b + p2.b + (p2.a - p1.a);
					moves = Math.min(moves, ans);
				}
			}
			
			System.out.println(moves);
		}
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreElements()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}


	
	
