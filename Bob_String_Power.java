import java.io.*;
import java.util.*;

public class Bob_String_Power {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int base = 131;
	static int MOD = (int)1e9 + 7;
	
	static long getHash(int l, int r, long[] hash, long[] pow) {
		return ((hash[r] - hash[l-1] * pow[r-l+1] % MOD) + MOD) % MOD;
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		long[] pow = new long[(int)1e6 + 5];
		pow[0] = 1;
		
		for (int i=1; i<pow.length; i++) {
			pow[i] = pow[i-1] * base % MOD;
			
		}
		
		for (int t=0; t<n; t++) {
			
			String str = readLine();
			
			long[] hash = new long[str.length()+1];
			
			for (int i=1; i<=str.length(); i++) {
				hash[i] = (hash[i-1] * base + (str.charAt(i-1))) % MOD;
			}
			
			boolean hasAns = false;
			
			for (int len=1; len<str.length(); len++) {
				
				int index = len;
				long prev = getHash(1, len, hash, pow);
				boolean repeat = true;
				

				
				if (str.length() % len != 0) continue;
				while (index <= str.length()) {
					long val = getHash(index-len+1, index, hash, pow);
					if (val != prev) {
						repeat = false;
						break;
					}
					index += len;
				}
				
				if (repeat) {
					System.out.println(str.length() / len);
					hasAns = true;
					break;
				}
			}
			
			
			if (!hasAns) System.out.println(1);
			
			
			
			
			
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