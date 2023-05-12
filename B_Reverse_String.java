
import java.io.*;
import java.util.*;


public class B_Reverse_String {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static boolean find(String[] a, String[] b, int indexA, int indexB, boolean l) {
		if (indexB + 1 >= b.length) return true;
		boolean left = false;
		boolean right = false;
		if (!l && indexA + 1 < a.length && a[indexA+1].equals(b[indexB+1])) {
			right = find(a, b, indexA+1, indexB+1, l);
		}
		if (indexA > 0 && a[indexA-1].equals(b[indexB+1])) {
			left = find(a, b, indexA-1, indexB+1, true);
		}
		return left || right;
	}
	
	public static void main(String[] args) throws IOException {
		int q = readInt();
		outer: for(; q>0; q--) {
			String[] a = readLine().split("");
			String[] b = readLine().split("");
			
			int indexB = 0;
			int indexA = -1;
			for(int i=0; i<a.length; i++) {
				if (a[i].equals(b[0])) {
					indexA = i;
					boolean result = find(a, b, indexA, indexB, false);
					if (result) {System.out.println("YES"); continue outer;}
				}
			}
			
			System.out.println("NO");

			
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


	
	
