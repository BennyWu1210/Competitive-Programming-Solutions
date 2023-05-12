
import java.io.*;
import java.util.*;

public class bpc1j2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] arr = new int[N + 1];
		
		arr[1] = readInt();
		int divisor = arr[1];
		
		for (int i = 2; i <= N; i++) {
			arr[i] = readInt();
			divisor = gcd(divisor, arr[i]);
		}
		
		if (N == 1) System.out.println(1);
		else {
			for (int i = 1; i <= N; i++) {
				System.out.print(arr[i] / divisor);
				if (i != N) System.out.print(" ");
				else System.out.println();
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


	
	
