
import java.io.*;
import java.util.*;

public class dmopc19c3p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static void update(int pos, int val, int[] bit) {
		pos += 150005;
		for (int i=pos; i<bit.length; i+=i&-i) {
			bit[i] += val;
		}
	}
	
	static int getSum(int pos, int[] bit) {
		int sum = 0;
		pos += 150005;
		for (int i=pos; i>0; i-=i&-i) {
			sum += bit[i];
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] psa = new int[N+5];
		int[] bit = new int[150000*2+5];
		
		int tot = 0;
		for (int i=1; i<=N; i++) {
			int cur = readInt() == 1 ? 1 : -1;
			psa[i+1] = cur + psa[i];
		}
		
		
		// count inversions
		
		long res = 0;
		for (int i=1; i<=N+1; i++) {
			int cur = psa[i];
			
			int ans = getSum(cur-1, bit);
			
			update(cur, 1, bit);
			res += ans;
			
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


	
	
