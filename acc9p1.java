
import java.io.*;
import java.util.*;

public class acc9p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if (this.a != o.a) return this.a - o.a;
			return this.b - o.b;
		}
	}
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int sum = 0;
			int[] d = new int[5];
			for (int i = 1; i <= 4; i++) {
				d[i] = readInt();
				sum += d[i];
			}
			
			Arrays.sort(d, 1, 5);
			Set<Pair> ans = new TreeSet();
			
			for (int i = 1; i <= 4; i++) {
				for (int j = i + 1; j <= 4; j++) {
					ans.add(new Pair(d[i] + d[j], sum - (d[i] + d[j])));
				}
			}
			System.out.println(ans.size());
			for (Pair p: ans) {
				System.out.println(p.a + " " + p.b);
			}
			
			
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


	
	
