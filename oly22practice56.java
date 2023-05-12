
import java.io.*;
import java.util.*;

public class oly22practice56 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Art implements Comparable<Art>{
		int a, b;
		public Art(int a, int b){
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Art o) {
			// TODO Auto-generated method stub
			
			return (this.a - this.b) - (o.a - o.b);
		}
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt();
		Art[] arts = new Art[n];
		
		int[] a = new int[n], b = new int[n];
		for (int i = 0; i < n; i++) a[i] = readInt();
		for (int i = 0; i < n; i++) b[i] = readInt();
		for (int i = 0; i < n; i++) arts[i] = new Art(a[i], b[i]);
		Arrays.sort(arts);
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i + 1 <= m) ans += arts[i].b;
			else ans += arts[i].a;
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


	
	
