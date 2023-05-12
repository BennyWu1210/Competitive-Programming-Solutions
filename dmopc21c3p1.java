
import java.io.*;
import java.util.*;

public class dmopc21c3p1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final long INF = Long.MAX_VALUE;
	public static void main(String[] args) throws IOException {

		int N = readInt();
		long[] org = new long[N+1];
		
		for (int i=1; i<=N/2*2; i+=2) {
			System.out.println("? " + i + " " + (i + 1));
			System.out.flush();
			long a = readLong();
			System.out.println("? " + i + " " + (i + 1));
			System.out.flush();
			long b = readLong();
			
			org[i+1] = b / 2;
			org[i] = a + org[i+1];
		}
		
		if (N % 2 == 1) {
			System.out.println("? " + 1 + " " + N);
			System.out.flush();
			org[N] = 2*org[1] - readLong();
		}
		
		System.out.print("!");
		
		for (int i=1; i<=N; i++) {
			System.out.print(" " + org[i]);
		}
		System.out.println();
		System.out.flush();
		
		
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


	
	
