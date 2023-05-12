
import java.io.*;
import java.util.*;

public class acc9p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final long MOD = 998244353;
	
	static long pow(long t, int n) {
		if (n == 0) return 1;
		long res = pow(t, n / 2) % MOD;
		res = res * res % MOD;
		if (n % 2 == 1) res = res * t % MOD;
		return res % MOD;
	}
	
	static boolean test() throws IOException {
		int n = 10;
		int[] arr = new int[n + 1];
		int[] tests = {-2, -1, 0, 1, 2};
		for (int i = 1; i <= n; i++) {
			arr[i] = tests[(int)(Math.random() * tests.length)];
		}
		
		long res = solve2(arr);
		int maxCount = 0; long max = 0;
		
		long res2 = -2;
		for (int i = 1; i <= n; i++) {
			res2 = Math.max(res2, arr[i]);
			int twoCount = 0, negCount = 0;
			for (int j = i; j <= n; j++) {
				if (arr[j] == 0) break;
				if (arr[j] < 0) negCount ++;
				if (Math.abs(arr[j]) == 2) twoCount ++;
				if (negCount % 2 == 0) maxCount = Math.max(maxCount, twoCount);
			}
		}
		
		if (maxCount != 0) res2 = pow(2, maxCount); 
		if (res != res2) {
			System.out.println(res + " " + res2);
			for (int i = 1; i < arr.length; i++) System.out.print(arr[i] + " ");
			System.out.println();
		} 
		return res == max;
		
	}
	
	static long solve2(int[] arr) {
		int n = arr.length - 1;
		int[] a = arr;
		int maxTwos = 0;
		long ans = -2;
		if (n == 1) return (a[1] + MOD) % MOD;
		
		int firstNeg = -1, lastNeg = -1, leftTwos = 0, rightTwos = 0, negCount = 0, twoCount = 0;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, a[i]);
			if (a[i] == 0) {
				if (negCount % 2 == 0) {
					maxTwos = Math.max(maxTwos, twoCount);
				}
				else {
					maxTwos = Math.max(maxTwos, Math.max(twoCount - leftTwos, twoCount - rightTwos));
				}
				firstNeg = -1; lastNeg = -1; leftTwos = 0; rightTwos = 0; negCount = 0; twoCount = 0;
				continue;
			}

			if (firstNeg == -1 && Math.abs(a[i]) == 2) leftTwos ++;

			if (a[i] < 0) {
				if (firstNeg == -1) firstNeg = i;
				lastNeg = i;
				rightTwos = 0;
				negCount ++;
			}
			if (Math.abs(a[i]) == 2) {
				twoCount ++;
				rightTwos ++;
			}
		}
		
		if (negCount % 2 == 0) {
			maxTwos = Math.max(maxTwos, twoCount);
		}
		else {
			maxTwos = Math.max(maxTwos, Math.max(twoCount - leftTwos, twoCount - rightTwos));
		}
		
		
		ans = (Math.max(ans, pow(2, maxTwos)) + MOD) % MOD;
		return ans;
	}
	
	static int[] input() throws IOException {
		int n = readInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) a[i] = readInt();
		return a;
	}
	
	static long solve(int[] arr) throws IOException {
		
		int n = arr.length - 1;
		int[] a = arr;
		int[][] dp = new int[n + 1][2];
		int ans = 0;
		boolean hasNeg = false;
		long max = -2, negCount = 0;
		
		if (n == 1) return (a[1] + MOD) % MOD;
		boolean same = true;
		
		for (int i = 2; i <= n; i++) {
			if (a[i] != a[i - 1]) same = false;
		}
		if (same && a[2] == -1) return 1;
		
//		if (same && (Math.abs(a[2]) == 1 || a[2] == 0)) {
//			return a[2];
//		}
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, a[i]);
			if (a[i] == 0) {
				negCount = 0;
				hasNeg = false;
				continue;
			}
			
			if (a[i] == -1) {
				dp[i][0] = dp[i - 1][1];
				dp[i][1] = dp[i - 1][0];
				hasNeg = true;
				negCount ++;
			}
			
			if (a[i] == 2) {
				dp[i][0] = dp[i - 1][0] + 1;
				if (dp[i - 1][1] != 0 || (dp[i - 1][1] == 0 && hasNeg)) dp[i][1] = dp[i - 1][1] + 1;
			}
			if (a[i] == -2) {
				if (dp[i - 1][1] != 0 || (dp[i - 1][1] == 0 && hasNeg)) dp[i][0] = dp[i - 1][1] + 1;
				dp[i][1] = dp[i - 1][0] + 1;
			}
			
			if (a[i] == 1) {
				dp[i][0] = dp[i - 1][0];
				dp[i][1] = dp[i - 1][1];
			}
			
			
			ans = Math.max(ans, dp[i][0]);
			if (negCount >= 2) max = 1;
		}
//		for (int i = 1; i <= n; i++) {
//			System.out.println(dp[i][0] + " " + dp[i][1]);
//		}
		
		// long m = -2;
		
//		for (int i = 1; i <= n; i++) {
//			long cur = arr[i];
//			m = Math.max(m, cur);
//			for (int j = i + 1; j <= n; j++) {
//				cur *= arr[j];
//				m = Math.max(m, cur);
//			}
//		}
		// System.out.println(m % MOD);
		
		// System.out.println(ans);
		if (ans > 0) return pow(2, ans) % MOD;
		else return (max + MOD) % MOD;
	
		
		
	}
	public static void main(String[] args) throws IOException {
//		for (int i = 0; i < 80000000; i++) {
//			boolean res = test();
//			if (!res) break;
//		}
//		
//		System.out.println("GOOD");
		int t = readInt();
		while (t --> 0) {
			System.out.println(solve2(input()));
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

// case 1: 2 -2 2 2 -1 -2 -1 2 -1 2 2 -2 -2 -2 2 -2 2 1 2 -2 -2 2 2 -2 -2 2 -2 2 1 1 2 1 -1 2 -1 2 2 1 2 2 
// case 2: 2 -2 -2 -2 -1 -2 -1 1 2 -2 2 1 -2 -2 1 -1 2 2 -1 1 -1 -1 2 -2 -1 -1 2 -2 2 2 -2 1 2 -1 2 2 -1 2 2 1 -2 2 -2 2 1 -2 -2 -1 -1 2 -2 -2 0 -1 -2 1 -1 0 -1 0 
	
	
