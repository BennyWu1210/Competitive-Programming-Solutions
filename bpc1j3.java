
import java.io.*;
import java.util.*;

public class bpc1j3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] arr = new int[2 * N + 1];
		for (int i = 1; i <= 2 * N; i++) arr[i] = readInt();
		Arrays.sort(arr, 1, 2 * N + 1);
		
		long ans = 0;
		for (int i = 2; i <= 2 * N; i += 2) {
			ans += Math.abs(arr[i] - arr[i - 1]); 
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


	
	
