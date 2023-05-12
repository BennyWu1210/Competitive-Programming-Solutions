
import java.io.*;
import java.util.*;

public class B_Ropes {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int check(double len, int[] arr)  {
		int total = 0;
		for (int i: arr) {
			total += Math.floor(i/len);
		}
		return total;
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), k = readInt();
		
		int[] len = new int[n];
		
		for (int i=0; i<n; i++) len[i] = readInt();
		
		double l = 0, r = 1e7;
		for (int i=0; i<=70; i++) {
			
			double mid = (l + r) / 2;
						
			if (check(mid, len) >= k) {
				l = mid;
			}
			else {
				r = mid;
			}
		}
		
		System.out.println(l);
		
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


	
	
