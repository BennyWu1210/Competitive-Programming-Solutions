
import java.io.*;
import java.util.*;

public class Bobs_Knapsack {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), q = readInt();
		
		Long[] arr = new Long[n+1];
		arr[0] = 0L;
		
		for (int i=1; i<=n; i++) {
			long num = readLong();
			
			if (num < 0) {
				arr[i] = 0L;
			}
			else {
				arr[i] = num;
			}
			
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		for (int i=1; i<=n; i++) {
			arr[i] += arr[i-1];
		}
		
		for (int i=0; i<q; i++) {
			int index = readInt();
			
			System.out.println(arr[index-1]);
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


	
	
