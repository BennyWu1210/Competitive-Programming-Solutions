
import java.io.*;
import java.util.*;

public class aac4p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static class Pair{
		long x, y;
		public Pair(int x, int y) {
			this.x = x; this.y = y;
		}
	}

	static long gcd(long a, long b) {
		return b == 0 ? a : gcd(b, a%b);
	}
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(); long res = 0;
		Pair[] coord = new Pair[N];
		Pair[] slope = new Pair[M];
		for (int i=0; i<N; i++) coord[i] = new Pair(readInt(), readInt());
		
		for (int i=0; i<M; i++) {
			slope[i] = new Pair(readInt(), readInt());
			Map<Long, Integer> map = new HashMap();
			long f = gcd(slope[i].x, slope[i].y);
			slope[i].x /= f; slope[i].y /= f;
			
			boolean same = false;
			for (int j=0; j<i; j++) {
				if (slope[i].x == slope[j].x && slope[i].y == slope[j].y) {
					same = true;
					break;
				}
			}
			
			if (same) continue;
			
			for (Pair p: coord) {
				long b1 = (slope[i].y * p.y - slope[i].x * p.x);
				long b2 = slope[i].y;
				long ans = gcd(b1, b2);
				
				b1 /= ans; b2 /= ans;
				b1 += 1e9 + 1; b2 += 1e9 + 1;
				ans = b1 >= b2 ? b1 * b1 + b2 : b1 + b2 * b2;
				
				if (map.containsKey(ans)) {
					res += map.get(ans);
				}
				map.put(ans, map.getOrDefault(ans, 0) + 1);
			}
		}

		System.out.println(res);


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





