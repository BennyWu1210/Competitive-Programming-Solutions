
import java.io.*;
import java.util.*;

public class B_Number_of_smaller {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		
		int[] a = new int[n], b = new int[m];
		
		
		for (int i=0; i<n; i++) a[i] = readInt();
		for (int i=0; i<m; i++) b[i] = readInt();
		
		int i = 0, j = 0, k = 0;
		
		for (int index=0; index<m; index++) {
			while (i < n && a[i] < b[index]) {
				i ++;
			}
			System.out.print(i + " ");
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


	
	
