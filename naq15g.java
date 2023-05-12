import java.io.*;
import java.util.*;

public class naq15g {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N;
	static int[] t;
	static int[] dp;
	static boolean[] taken;
	public static void main(String[] args) throws IOException {

		N = readInt();
		
		t = new int[N + 1];
		dp = new int[(1 << N) + 1]; // 1: person already returned; 0: person still outside
		taken = new boolean[(1 << N) + 1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for (int i = 0; i < N; i++) t[i] = readInt();
		dp[0] = 0;
		
		Queue<Integer> q = new LinkedList();
		q.add(0);
		
		while (!q.isEmpty()) {

			int msk = q.poll();
			taken[msk] = false;
			// if it is not a valid state, skip
			if (dp[msk] == Integer.MAX_VALUE) continue;
			
			int minInd = -1, minTime = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				// if the i-th person is already back in the dorm, and if they are the fastest
				if ((msk & (1 << i)) != 0 && t[i] < minTime) {
					// this should be the person to bring the cloak back (is this assumption wrong?)
					minTime = t[i];
					minInd = i;
				}
			}
			
			int curMsk = msk ^ (1 << minInd);
			int val; // the time it takes for the person to come back
			if (msk == 0) {
				curMsk = 0;
				val = 0;
			} else {
				val = t[minInd];
			}
			
			
			
			for (int i = 0; i < N; i++) {
				if ((curMsk & (1 << i)) == 0) {
					for (int j = i + 1; j < N; j++) {
						if ((curMsk & (1 << j)) == 0) {
							// if both people are not back, bring them back
							int newMsk = curMsk | (1 << i) | (1 << j);
							if (dp[newMsk] > dp[msk] + val + Math.max(t[i], t[j])) {
								dp[newMsk] = dp[msk] + val + Math.max(t[i], t[j]);
								if (!taken[newMsk]) q.add(newMsk);
							}
							
						}
					}
				}
				
			}
			
			
		}
		
		System.out.println(dp[(1 << N) - 1]);
		
		
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