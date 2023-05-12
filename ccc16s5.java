
import java.io.*;
import java.util.*;

public class ccc16s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		long T = readLong();
		char[] c = readLine().toCharArray();
		int[] arr = new int[N], ans = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = c[i] - '0';
		}
		
		for (int i=(int)(Math.log(T)/Math.log(2)); i>=0; i--) {
			if (((T >> i) & 1) != 0) {
				for (int j=0; j<N; j++) {

					ans[j] = arr[(int)((j+(long)(1L<<i))%N)] ^ arr[(int)(((j-(long)(1L<<i))%N+N)%N)];
				}
				for (int j=0; j<N; j++) {
					arr[j] = ans[j];
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(ans[i]);
		}
		
		System.out.println();
		
		
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


	
	
