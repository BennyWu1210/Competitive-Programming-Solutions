
import java.io.*;
import java.util.*;

public class oly22practice74 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		char[] C = readLine().toCharArray();
		int[] arr = new int[C.length + 1];
		int K = readInt();
		int ans = 0;
		
		int cnt = 0;
		for (int i = 1; i <= C.length; i++) {
			if (C[i - 1] == '0') {
				cnt++;
				arr[cnt] = i;
			}
			
			if (cnt - K < 0) {
				ans = Math.max(ans, i);
			} else {
				ans = Math.max(ans, i - arr[cnt - K]);
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


	
	
