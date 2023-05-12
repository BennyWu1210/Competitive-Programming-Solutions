
import java.io.*;
import java.util.*;

public class Bobs_Temple {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		int[] arr = new int[N], freq = new int[(int)1e6+1];
		
		int max = 0;
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
			freq[arr[i]] ++;
			max = Math.max(max, arr[i]);
		}
		
		
		// increasing
		for (int i=0; i<=max; i++) {
			if (freq[i] != 0) {
				System.out.print(i + " ");
				freq[i] --;
			}
			
		}
		
		// decreasing
		for (int i=max; i>=0; i--) {
			while (freq[i] != 0) {
				System.out.print(i + " ");
				freq[i] --;
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


	
	
