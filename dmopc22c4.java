
import java.io.*;
import java.util.*;

public class dmopc22c4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(), K = readInt();
		
		int[] arr = new int[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = readInt();
			if (i != 0) {
				max = Math.max(max, arr[i] - arr[i - 1] - 1);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			int left = 0, right = M + 1;
			// what if I move A_i to the left?
			
			left = Math.max(left, arr[i] - K);
			
			if (i != 0) {
				left = Math.max(left, arr[i - 1]);
			}
			
			
			if (i != N - 1) {
				right = Math.min(right, arr[i + 1]);
			}
						
//			System.out.println(left + " " + right);
			max = Math.max(max, right - left - 1);
			
			// what if I move A_i to the right?
			left = 0; right = M + 1;
			right = Math.min(right, arr[i] + K);
			
			if (i != N - 1) {
				right = Math.min(right, arr[i + 1]);
			}
			
			if (i != 0) {
				left = Math.max(left, arr[i - 1]);
			}
			
			max = Math.max(max, right - left - 1);
		}
		
		System.out.println(max);
		
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


	
	
