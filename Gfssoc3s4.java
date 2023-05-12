
import java.io.*;
import java.util.*;


public class Gfssoc3s4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		
		int r = readInt(), c = readInt();
		long mod = 1000000007;
		long[][] dp = new long[105][3000];
		ArrayList<Integer> list = new ArrayList<Integer>();
		long ans = 0;
		
		for(int mask=0; mask < (1 << c-2); mask++) {
			if ((mask & mask << 1) == 0 && (mask & mask << 2) == 0) {
				list.add(mask);
				dp[0][list.size()-1] = 1;
				ans ++;
			}
		}
		
		ans -= dp[0][0];
		
		ArrayList<Integer> adj[] = new ArrayList[list.size()];
		for(int i=0; i<list.size(); i++) {
			adj[i] = new ArrayList(); int mask = list.get(i);
			for(int j=0; j<list.size(); j++) {
				int mask2 = list.get(j), nmask = mask2 | mask2 << 1 | mask2 >> 1;
				if ((nmask & mask) == 0) adj[i].add(j);
			}
		}
		
		for(int i=1; i<r-1; i++) {
			for(int j=0; j<list.size(); j++) {
				for(int k: adj[j]) {
					dp[i][j] += dp[i-1][k]%mod;
				}
				dp[i][j] %= mod; ans = (ans + dp[i][j]) % mod;
			}
			ans = (ans - dp[i][0] + mod) % mod;
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


	
	
