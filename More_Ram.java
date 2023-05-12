
import java.io.*;
import java.util.*;

public class More_Ram {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Ram implements Comparable<Ram>{
		int a, b;
		
		public Ram(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Ram o) {
			return (o.b - this.b);
		}
	}
	

	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int n = readInt(), k = readInt();
			Ram[] rams = new Ram[n];
			boolean[] vis = new boolean[n];
			
			for (int i=0; i<n; i++) rams[i] = new Ram(readInt(), 0);
			for (int i=0; i<n; i++) rams[i].b = readInt();
			
			Arrays.sort(rams);
			
			boolean canTake = true;
			while (canTake) {
				canTake = false;
				for (int i=0; i<n; i++) {
					if (!vis[i] && rams[i].a <= k) {
						vis[i] = true;
						canTake = true;
						k += rams[i].b;
						break;
					}
				}
			}
			
			System.out.println(k);
			
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


	
	
