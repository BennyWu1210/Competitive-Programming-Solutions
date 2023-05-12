
import java.io.*;
import java.util.*;

public class oly21practice77 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int N = readInt(),  X = readInt();

		long[][][] dp = new long[N][51][2502];
		long ans = 0;
		
		for (int i=0; i<N; i++) {
			int cur = readInt();

			dp[i][1][cur] ++;

			for (int j=0; j<i; j++) {
				for (int len=2; len<=50; len++) {
					for (int sum=cur; sum<=2500; sum++) {
						dp[i][len][sum] += dp[j][len-1][sum-cur];
						
					}
				}
			}
			
			for (int len=1; len<=50; len++) {
				for (int sum=cur; sum<=2500; sum++) {
					if (sum / 1.0 / len == X) ans += dp[i][len][sum];
					
				}
			}
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




