
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class CCC05S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static long[] bit;

	static void update(int x, int val) {
		while (x < bit.length) {
			
			bit[x] += val;
			
			x += (x & - x);
		}
	}
	
	static long getSum(int idx) {
		long sum = 0;
		while (idx > 0) {
			sum += bit[idx];
			
			idx -= (idx & -idx);
		}
		
		return sum;
	}
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		int[] scores = new int[t];
		HashMap<Integer, Integer> map = new HashMap<>();


		for (int i=0; i<t; i++) {
			scores[i] = readInt();
		}

		int[] sorted = scores.clone();

		Arrays.sort(sorted);

		int rank = 1;

		map.put(sorted[0], rank);
		for (int i=1; i<t; i++) {
			if (sorted[i] != sorted[i-1]) {
				rank ++;
				map.put(sorted[i], rank);
			}
		}
		
		bit = new long[rank + 5];
		
		double ans = 0;
		for (int i=0; i<scores.length; i++) {
			int cur = map.get(scores[i]);
			long pos = getSum(rank+4) - getSum(cur); 
			
			update(cur, 1);
			ans += pos + 1;
			
			// System.out.println(cur + " " + (pos + 1));
		}
		
		DecimalFormat df = new DecimalFormat("0.00");
		ans /= t;
		System.out.println(df.format(ans));

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




