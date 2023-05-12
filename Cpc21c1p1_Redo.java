
import java.io.*;
import java.util.*;

public class Cpc21c1p1_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for(int t=0; t<T; t++) {
			long num = readLong(), denom = readLong();
			long d = gcd(num, denom);
			num /= d;
			denom /= d;

			int a = 0, b = 0;
			while(denom % 2 == 0 || denom % 5 == 0) {
				if (denom % 2 == 0) {
					denom /= 2;
					a ++;
				}
				else {
					denom /= 5;
					b ++;
				}
			}
			if (denom != 1) {
				System.out.println(-1);
				continue;
			}
			System.out.println(Math.max(a, b));
			
			
		}
	}

	static long gcd(long a, long b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
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


	
	
