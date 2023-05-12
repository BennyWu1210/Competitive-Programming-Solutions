
import java.io.*;
import java.util.*;

public class ceoi17p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static final int MN = (int)1e5 + 5; static final long INF = Long.MAX_VALUE;
	static int N;
	static long[] dp = new long[MN], psa = new long[MN], h = new long[MN], w = new long[MN];;
	
	static double yInt(int x) {
		return dp[x] - psa[x] + h[x] * h[x];
	}
	
	static double slope(int x) {
		return -2 * h[x];
	}
	
	static double Intersect(int a, int b) {
		return (yInt(b) - yInt(a)) * 1.0 / (slope(a) - slope(b));
	}
	
	static double getVal(int line, long x) {
		return slope(line) * x + yInt(line);
	}

	static void solve(int l, int r) {
		if (l == r) return;
		int mid = (l + r) / 2;
		
		solve(l, mid);
		
		List<Integer> lst = new ArrayList(); 
		LinkedList<Integer> hull = new LinkedList();;
		
		for (int i=l; i<=mid; i++) lst.add(i);
		// I don't know why sorting the y-intercept in reverse order (compare(yInt(b), yInt(a)) made a 'TLE' become 'AC'
		Collections.sort(lst, (a, b) -> h[a] == h[b] ? Double.compare(yInt(b), yInt(a)) : Long.compare(h[a], h[b])); 		
		
		for (int v: lst) {
			while (hull.size() >= 2 && Intersect(hull.peekLast(), hull.get(hull.size()-2)) > Intersect(v, hull.get(hull.size()-2))) {
				hull.pollLast();
			}
			hull.addLast(v);
		}
		
		for (int i=mid+1; i<=r; i++) {
			int lft = 0, rit = hull.size() - 1;
			while (lft < rit) {
				int m = (lft + rit) / 2;
				if (getVal(hull.get(m), h[i]) > getVal(hull.get(m+1), h[i])) lft = m + 1;
				else rit = m;
			}
			
			int j = hull.get(lft);
			long dif = (h[i] - h[j]);
			dp[i] = Math.min(dp[i], dif * dif + psa[i-1] - psa[j] + dp[j]);
			
		}
		
		solve(mid + 1, r);

	}
	public static void main(String[] args) throws IOException {

		N = readInt();
		for (int i=1; i<=N; i++) h[i] = readLong();
		for (int i=1; i<=N; i++) {
			w[i] = readLong();
			psa[i] = psa[i-1] + w[i];
			dp[i] = Long.MAX_VALUE;
		}
		
		dp[1] = 0;
		solve(1, N);
		
		// System.out.println(Arrays.toString(dp));

		System.out.println(dp[N]);
		
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


	
	
