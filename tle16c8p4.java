
import java.io.*;
import java.util.*;

public class tle16c8p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MOD = (int)1e9 + 7, MM = (int)1e5 + 5;
	static int X, D, N, P, W, f[] = new int[MM], dp[] = new int[MM], dif[] = new int[MM];
	
	public static void main(String[] args) throws IOException {

		X = readInt();
		
		if (X == 1) {
			D = readInt(); N = readInt(); P = readInt();
			
			for (int i=1; i<=P; i++) {
				int q = readInt(), r = readInt();
				f[q] = r;
			}
			
			dp[0] = 1; dif[1] ++; dif[N+1] --;
			
			for (int i=1; i<=D; i++){
				dp[i] = dif[i] = (dif[i] + dif[i-1]) % MOD;
				if (f[i] != 0) {
					dif[i+1] = (dif[i+1] + dif[i]) % MOD;
					int t = Math.min(i + f[i] + 1, D + 1);
					dif[t] = (dif[t] - dif[i] + MOD) % MOD;
 				}
			}
			
			System.out.println(dp[D]);
		}
		else {
			W = readInt(); int size = 30, dst = size + 2;
			System.out.println(dst + " " + size + " " + size);
			
			for (int k=1; k<=size; k++) {
				if (((W & 1 << (k - 1))) != 0) System.out.println(k + " " + (dst - k));
				else System.out.println(k + " " + (dst - k - 1));
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


	
	
