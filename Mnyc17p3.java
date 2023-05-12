
import java.io.*;
import java.util.*;

public class Mnyc17p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		String A = next();
		String B = next();
		int max = Math.max(A.length(), B.length());
		int base = 131;
		int mod = (int)1e9 + 7;
		
		long[] hashA = new long[A.length()+1], hashB = new long[B.length()+1], pw = new long[max+1];
		
		pw[0] = 1;
		
		for (int i=1; i<=max; i++) {
			pw[i] = pw[i-1] * base % mod;
		}
		
		for (int i=1; i<=A.length(); i++) {
			hashA[i] = (hashA[i-1] * base + (A.charAt(i-1) - 'A')) % mod;
		}
		
		for (int i=1; i<=B.length(); i++) {
			hashB[i] = (hashB[i-1] * base + (B.charAt(i-1) - 'A')) % mod;
		}
		
		
		int indexA = A.length();
		int indexB = 1;
		int indexAns = 0;
		
		while (indexA > 0 && indexB <= B.length()) {
			long aHash = (hashA[A.length()] - ((hashA[indexA-1]) * pw[A.length()-indexA+1] % mod) + mod) % mod;
			long bHash = hashB[indexB];
			
			if (aHash == bHash) {
				indexAns = indexB;
			}

			indexA --;
			indexB ++;
		}
		
		System.out.println(A + B.substring(indexAns));
		
		
		
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


	
	
