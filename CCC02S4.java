// hint from: https://github.com/johnafish/CCC-Solutions/blob/master/2002/Senior/S4.java
import java.io.*;
import java.util.*;

public class CCC02S4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int M, Q;
	static int[] dp;
	static int[] t;
	static int[] group;
	static LinkedList<String> queue = new LinkedList<String>();
	
	public static void main(String[] args) throws IOException {
		M = readInt();
		Q = readInt();
		t = new int[Q];
		dp = new int[Q+1];
		group = new int[Q+1];
		
		
		for (int i=0; i<Q; i++) {
			String name = readLine();
			int time = readInt();
			queue.add(name);
			t[i] = time;
		}
		
		
		Arrays.fill(dp, (int)1e5);
		Arrays.fill(group, -1);
		
		dp[0] = 0;
		group[0] = 0;

		for (int i = 0; i <= Q; i++) {
			int cur = 0;
			for (int j = 1; j <= M && i + j - 1< Q; j++) {
				
				cur = Math.max(cur, t[i + j - 1]);
				
				if (dp[i] + cur < dp[i + j]) {
					dp[i + j] = dp[i] + cur;
					group[i + j] = j;
				}
			}
		}
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(group));
		System.out.println("Total Time: " + dp[Q]);
		int[] lines = new int[Q+1];
		int k = Q;
		int x = 0;
		
		while (group[k] != 0) {
			lines[x++] = group[k];
			k = k - group[k];
		}
		
		for(int i = x - 1; i >= 0; i--) {
			for (int j = 0; j < lines[i]; j++) {
				System.out.print(queue.pollFirst() + " ");
			}
			System.out.println();
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


	
	
