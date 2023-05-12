
import java.io.*;
import java.util.*;


public class Cpc21c1p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
//		System.out.println(13810 ^ 13);
//		System.out.println(13811 ^ 13);
		
		int n = readInt();
		
		long[] a = new long[2*n+1];
		long[] b = new long[2*n+1];
		boolean[] ac = new boolean[2*n+1];
		boolean[] bc = new boolean[2*n+1];
		
		long smallA = Long.MAX_VALUE;
		long smallB = Long.MAX_VALUE;
		
		
		for(int i=0; i<=2*n; i++) {
			a[i] = readLong();
			if (smallA > a[i]) smallA = a[i];
		}
		for(int i=0; i<=2*n; i++) {
			b[i] = readLong();
			if (smallB > b[i]) smallB = b[i];
		}
//		Arrays.sort(a);
//		Arrays.sort(b);
		
		long result = smallA ^ smallB;
		
		// System.out.println(smallA + " " + smallB);
		for(int i=1; i<=2*n; i++) {
			boolean exist = false;
			for(int j=0; j<=2*n; j++) {
				// System.out.println(a[i] ^ b[j]);
				if (!bc[j] && (a[i] ^ b[j]) == result) {
					ac[i] = true;
					bc[j] = true;
					exist = true;
					break;
					
				}
			}
			if (!exist) {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(result);
		
		
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


	
	
