import java.io.*;
import java.util.*;
public class Frog2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static int[] cost;
	public static int[] memo;
	public static int N;
	public static int K;

	public static int topdown(int n, int k) {
		if (n<=0) {
			return 0;
		} 
		else if (memo[n]!=Integer.MAX_VALUE) {
			return memo[n];
		} 
		else if (n == 1) {
			return memo[n] = Math.abs(cost[1]-cost[0]);
		} 
		else {
			for(int i=1; i<=k; i++) {
				if (n-i >= 0) {
					memo[n] = Math.min(memo[n], topdown(n-i, k) + Math.abs(cost[n]-cost[n-i]));
				}
				else {
					break;
				}
			}
			return memo[n];
		}

	}
	
	

	public static void main(String[] args) throws IOException{
		N = readInt();
		K = readInt();
		
		cost = new int[N+1];
		memo = new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		for(int i=0; i<N; i++) {
			cost[i] = readInt();
		}
		
		//System.out.println(Arrays.toString(memo));
		System.out.println(topdown(N-1, K));


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
