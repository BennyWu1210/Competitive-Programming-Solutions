
import java.io.*;
import java.util.*;

public class dmopc16c1p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MAX = 500005;
	static int[] bit = new int[MAX];
	
	static void update(int index, int val){
		while (index <= MAX) {
			bit[index] += val;
			index += (index & -index);
		}
	}
	
	static int getSum(int index) {
		int sum = 0;
		
		while (index > 0) {
			sum += bit[index];
			index -= (index & -index);
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
				
		long ans = 0;
		for (int i=1; i<=N; i++) {
			int cur = readInt();
			
			// number smaller than cur
			int count = getSum(cur);
			
			update(cur, 1);
			
			ans += Math.min(count, i-count-1);
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


	
	
