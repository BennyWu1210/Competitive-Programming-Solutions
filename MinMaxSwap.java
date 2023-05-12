
import java.io.*;
import java.util.*;

public class MinMaxSwap {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt();
			int mx = 0; 
			int[] a = new int[n+1], b = new int[n+1];
			
			for (int i=0; i<n; i++) {
				a[i] = readInt();
				mx = Math.max(mx, a[i]);
			}
			
			for (int i=0; i<n; i++) {
				b[i] = readInt();
				mx = Math.max(mx, b[i]);
			}
			
			int snd = 0;
			for (int i=0; i<n; i++) {
				int x = a[i], y = b[i];
				if (x == mx) {
					snd = Math.max(snd, y);
				}
				else if (y == mx) {
					snd = Math.max(snd, x);
				}
				else{
					snd = Math.max(snd, Math.min(x, y));
				}
			}
			System.out.println(mx * snd);
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


	
	
