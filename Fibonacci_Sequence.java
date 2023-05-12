import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Fibonacci_Sequence {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MOD = (int)1e9 + 7;
	static void multiply(long[][] a, long[][] b){
		long[][] res = new long[2][2];
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for (int k=0; k<2; k++) {
					res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % MOD;
				}
			}
		}
		
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				a[i][j] = res[i][j];
			}
		}
	}
	
	
	static long power (long[][] F, long n) {
		System.out.println(n);
		long[][] m = {{1, 1}, {1, 0}};
		
		if (n == 1) return F[0][0] + F[0][1];
		
		power(F, n / 2);
		multiply(F, F);
		
		if (n % 2 == 1) multiply(F, m);
		
		return F[0][0] + F[0][1];
		
	}

	public static void main(String[] args) throws IOException {

		long[][] m = {{1, 1}, {1, 0}};
		
		String ipt = readLine();
		BigInteger N = new BigInteger(ipt);
		
		N = N.mod(new BigInteger("2000000016")); // 2*MOD + 2
		
		long n = N.longValue();
		
		if (n <= 2) {System.out.println(1); return;}

		System.out.println(power(m, n-2) % MOD);
		
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