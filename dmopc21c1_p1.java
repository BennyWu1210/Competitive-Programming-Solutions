
import java.io.*;
import java.util.*;

public class dmopc21c1_p1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static HashMap<Long, Integer> dp; 
	static int even, odd;
	static long eSum, oSum;
	
	static int solve(long even, long odd, boolean turn) {
		// Duke wins when there odd = 0 
		
		long pair = (long) (((even + odd) * (even + odd + 1))/2.0 + odd);
		
		if (even > 0 && odd == 0) {
			return 1;
		}
		
		if (odd > 0 && even == 0) {
			return 0;
		}
		
		if (dp.containsKey(pair)) {
			return dp.get(pair);
		}
		
		
		int takeAll;
		int takeSome;
		
		if (turn) {
			takeAll = solve(even - 1, odd, !turn);
			takeSome = solve(even - 1, odd + 1, !turn);
		}
		else {
			takeAll = solve(even, odd - 1, !turn);
			takeSome = 0;

		}
			
		if (turn && (takeAll == 1 || takeSome == 1)) {
			dp.put(pair, 1);
			return 1;
		}
		
		if (!turn && (takeAll == 0)) {
			dp.put(pair, 0);
			return 0;
		}
		
		if (turn) {
			dp.put(pair, 0);
			return 0;
		}
		else {
			dp.put(pair, 1);
			return 1;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		long[] arr = new long[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = readLong();
			if (arr[i] % 2 == 0) {
				even ++;
				eSum += (arr[i])/2;
			}
			else {
				odd ++;
				oSum += (arr[i] + 1)/2;
			}
		}
		
		dp = new HashMap<>();
		
		// WTFFFFF
		if (eSum > oSum) {
			System.out.println("Duke");
		}
		else {
			System.out.println("Alice");
		}
		
//		if (solve(even, odd, true) == 1) {
//			System.out.println("Duke");
//		}
//		else {
//			System.out.println("Alice");
//		}
		
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


	
	
