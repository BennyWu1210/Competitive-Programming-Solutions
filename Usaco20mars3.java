
import java.io.*;
import java.util.*;


public class Usaco20mars3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static class Pair implements Comparable<Pair>{
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.x != o.x ? this.x - o.x : this.y - o.y;
		}
		
	}
	public static void main(String[] args) throws IOException {

		int n = readInt(), x[] = new int[n], y[] = new int[n];
		Pair order[] = new Pair[n];
		
		
		for(int i=0; i<n; i++) {
			x[i] = readInt();
			y[i] = readInt();
			order[i] = new Pair(x[i], y[i]);
		}
		
		Arrays.sort(order);
		
		int[] leftMin = new int[n], rightMax = new int[n];
		
		leftMin[0] = order[0].y;
		for(int i=1; i<n; i++) {
			leftMin[i] = Math.min(leftMin[i-1], order[i].y);
		}
		
		rightMax[n-1] = order[n-1].y;
		for(int i=n-2; i>=0; i--) {
			rightMax[i] = Math.max(rightMax[i+1], order[i].y);
		}
		
		int ans = 1;
		for(int i=0; i<n-1; i++) {
			if (leftMin[i] > rightMax[i+1]) {
				ans ++;
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


	
	
