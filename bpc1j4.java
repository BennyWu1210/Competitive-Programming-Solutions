
import java.io.*;
import java.util.*;

public class bpc1j4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, M;
	static Map<Long, Boolean> dp1 = new HashMap();
	static int[] numbers;
	static boolean[] val;
	
	static void solve(int sum, int ind) {
		// System.out.println(sum + " " + ind);
		long pair = sum > ind ? sum * sum + ind : ind * ind + sum;
		if (sum > M) return;
		if (ind == numbers.length - 1) {
			val[sum] = true;
			return;
		}
		if (dp1.containsKey(pair)) return;
		
		long cur = 0;
		int num = 0;
		for (int i = 1; i <= 4; i++) {
			if (ind + i >= numbers.length || num > M) break;
			num = num * 10 + numbers[i + ind];
			solve(sum + num, ind + i);
		}
		
		dp1.put(pair, true);
	}
	
	static void solveProblem(int n, int m, int[] nums) {
		N = n; M = m;
		numbers = nums;
		

		int num = 0;
		for (int i = 0; i <= 4; i++) {
			if (i >= numbers.length || num > M) break;
			
			num = num * 10 + numbers[i];
			solve(num, i);
			// System.out.println(num + " : " + ans);
		}
		
//		System.out.println(N + " " + M);
//		System.out.println(numbers);
//		System.out.println("res: ");
//		System.out.println(ans);
//		System.out.println();
		
	}
	
	public static void main(String[] args) throws IOException {
	
//		for (int i = 1; i <= 1; i++) {
//			int N = (int)(Math.random() * 10000), M = (int)(Math.random() * 10000);
//			char[] seq = new char[N + 1];
//			for (int j = 0; j < N; j++) seq[j] = (char)((int)(Math.random() * 10) + '0');
//			
//			solveProblem(N, M, seq);
//			
//		}
		
		int N = readInt(), M = readInt();
		char[] nums = readLine().toCharArray();
		numbers = new int[N];
		val = new boolean[M + 1];
		for (int i = 0; i < nums.length; i++) numbers[i] = nums[i] - '0';
		
		solveProblem(N, M, numbers);

		long ans = 0;
		for (int i = 0; i <= M; i++) {
			if (val[i]) ans ++;
		}
		
		System.out.println(ans);
		
		
				
		
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


	
	
