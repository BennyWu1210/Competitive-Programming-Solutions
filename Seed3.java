
import java.io.*;
import java.util.*;

public class Seed3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int I = readInt(), N = readInt(), J = readInt();
		
		int[] psa = new int[I+1];
		
		for(int i=0; i<J; i++) {
			int a = readInt()-1, b = readInt()-1, k = readInt();
			psa[b+1] -= k;
			psa[a] += k;
		}
		
		int ans = 0;
		for(int i=1; i<=I; i++) {
			psa[i] += psa[i-1];
			if (psa[i] < N) {
				ans ++;
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


	
	
