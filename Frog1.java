import java.io.*;
import java.util.*;
public class Frog1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static int[] cost;
	public static int[] memo;

	//	public static int dp(int i) {
	//		
	//		if (i <= 1) return 0;
	//		int first = 0;
	//		int second = 0;
	//		if (memo[i-1] != 0) {
	//			first = memo[i-1];
	//		}
	//		else {
	//			first = Math.abs(dp(i-1) - cost[i]);
	//		}
	//		
	//		if (memo[i-2] != 0) {
	//			second = memo[i-2];
	//		}
	//		else {
	//			second = Math.abs(dp(i-2) - cost[i]);
	//		}
	//		
	//		return memo[i] = Math.min(first, second);
	//				
	//		
	//	}
	//	public static int dp(int n) {
	//		if(n==0) return 0;
	//		if(n==1) return Math.abs(cost[i]);
	//		
	//	}

	public static int topdown(int n) {
		if (n==0) {
			return 0;
		} else if (n==1) {
			return Math.abs(cost[1]-cost[0]);
		} else if  (memo[n]!=0) {
			return memo[n];
		} else {
			memo[n] = Math.min(
					topdown(n-1)+Math.abs(cost[n]-cost[n-1]), 
					topdown(n-2)+Math.abs(cost[n]-cost[n-2]));             
			return memo[n];
		}

	}
	
	



	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int N = readInt();
		cost = new int[N+1];
		memo = new int[N+1];

		for(int i=0; i<N; i++) {
			cost[i] = readInt();
		}

		System.out.println(topdown(N-1));


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
