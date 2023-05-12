
import java.io.*;
import java.util.*;

public class C_Numner_of_Equal {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		
		int[] a = new int[n], b = new int[m];
		
		for (int i=0; i<n; i++) a[i] = readInt();
		for (int i=0; i<m; i++) b[i] = readInt();
		
		int i = 0, j = 0;
		long res = 0;
		
		while (i < n && j < m) {
			int bCount = 1;
			
			while (j + 1 < m && b[j+1] == b[j]) {
				bCount ++;
				j ++;
			}
			
			while (i < n && a[i] < b[j]) {
				i ++;
			}
			
			while (i < n && a[i] == b[j]) {
				res += bCount;
				i ++;
			}
			
			j ++;
			

			
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


	
	
