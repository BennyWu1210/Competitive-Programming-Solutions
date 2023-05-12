
import java.io.*;
import java.util.*;

public class AndMatching {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	

	static int[] solve(int n, int k) {
		int[] ans = new int[n/2+1];
		if (k <= n / 2 - 1) {
			for (int i=0; i<n/2; i++) ans[i] = (n - i - 1);
			ans[k] = n - 1;
			ans[0] = (n - k - 1);
			
		}
		else if (k >= n / 2 && k < Math.pow((1 << (n - 1)), 2)) {
			int ind = n / 2 - 1;
			int[] res = solve() 
	}
	public static void main(String[] args) throws IOException {

		// three cases?
		// k is 0 to n / 2 - 1 can be obtained through one change
		// k is n / 2 to n - 1 can be considered when n - 1, but instead of (i, j) do (i, j + (1 << (n - 1)) 
		// k is (1 << (p - 1)) ^ 2 to max[n] can be paired from (1 << (p - 1)) ^ 2 / 2 -> (0 to max[n-1] in the first half) and ((1 << (p - 1) ^ 2 / 2) to += 2*[n-2]))
		
		int t = readInt();
		int[] max = new int[17];
		
		for (int p=2; p<=16; p++) {
			max[p] = (1 << (p - 1)) * (1 << (p - 1)) / 2 + 2 * max[p-1];
		}
		
		while (t --> 0) {
			int n = readInt(), k = readInt();
			if (max[(31 - Integer.numberOfLeadingZeros(n))] < k) {
				System.out.println(-1);
				continue;
			}
			else {
				int[] ans = new int[n/2+1];
				if (k <= n / 2 - 1) {
					for (int i=0; i<n/2; i++) ans[i] = (n - i - 1);
					ans[k] = n - 1;
					ans[0] = (n - k - 1);
					
					for (int i=0; i<n/2; i++) System.out.println(i + " " + ans[i]);
				}
				
				if (k >= n / 2 && k < Math.pow((1 << (n - 1)), 2)) {
					int ind = n / 2 - 1;
					while (k > 0) {
						k -= ind;
						ans[ind] = 
					}
				}
			}
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


	
	
