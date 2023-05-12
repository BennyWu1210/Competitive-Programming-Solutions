
import java.io.*;
import java.util.*;

public class C_Cows_in_Stalls {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int n, k;
	static int[] arr;
	
	static boolean check(int x) {
		int prev = arr[0];
		int rem = k;
		for (int i=1; i<arr.length; i++) {
			if (arr[i] - prev >= x) {
				prev = arr[i];
				rem --;
			}

			if (rem == 1) return true;
		}
		
		return rem <= 1;
	}
	public static void main(String[] args) throws IOException {

		n = readInt(); k = readInt();
		arr = new int[n];
		
		for (int i=0; i<n; i++) {
			arr[i] = readInt();
		}
		
		int l = 0, r = Integer.MAX_VALUE, res = 0;

		
		while (l <= r) {

			int mid = (l + r) / 2;
			
			if (check(mid)) {
				l = mid + 1;
				res = mid;
			}
			else {
				r = mid - 1;
				
			}
		}
		
		System.out.println(res);
		
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


	
	
