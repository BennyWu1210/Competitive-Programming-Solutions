
import java.io.*;
import java.util.*;

public class DP_Frog3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 2*(int)1e5 + 5;
	static long[] h = new long[MN];
	static long[] dp = new long[MN];
	static int N;
	static long C;
	
	static double slope(int x) {
		return -2*h[x];
	}
	
	static double yInt(int x) {
		return h[x]*h[x]+dp[x];
	}
	
	static double Intersect(int a, int b) {
		return (yInt(b) - yInt(a)) * 1.0 / (slope(a) - slope(b));
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); C = readLong();
		
		for (int i=1; i<=N; i++) h[i] = readLong();
		
		LinkedList<Integer> dq = new LinkedList();
		dq.addFirst(1);

		for (int i=2; i<=N; i++) {
			while (dq.size() >= 2 && Intersect(dq.get(0), dq.get(1)) < h[i]) {
				dq.pollFirst();
			}
			
			long dif = h[i] - h[dq.peekFirst()];
			dp[i] = dif * dif + C + dp[dq.peekFirst()];
			
			while (dq.size() >= 2 && Intersect(dq.peekLast(), dq.get(dq.size()-2)) > Intersect(i, dq.get(dq.size()-2))) {
				dq.pollLast();
			}

			
			dq.addLast(i);
		}
		
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


	
	
