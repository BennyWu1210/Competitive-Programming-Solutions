
import java.io.*;
import java.util.*;

public class Abc231p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static final int MM = 61;
	static int N;
	static long X;
	static long[] a = new long[MM];
	static Map<Long, Long> dp = new HashMap();

	static long solve(long v, int i) { 
		if (i == 0 || v == 0) return v;
		long key = v >= i ? v * v + i : i * i + v;
		if (dp.containsKey(key)) return dp.get(key);
		long ans;

		long ans1 = solve(v % a[i], i - 1) + v / a[i];
		long ans2 = solve((v / a[i] + 1) * a[i] - v, i - 1) + (v / a[i]) + 1;
		
		ans = Math.min(ans1, ans2);

		dp.put(key, ans);
		return ans;
	}


	public static void main(String[] args) throws IOException {

		N = readInt(); X = readLong();
		for (int i=0; i<N; i++) a[i] = readLong();

		long ans = solve(X, N - 1);
		System.out.println(ans);
	}

	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}

	static long readLong() throws NumberFormatException, IOException {
		return Long.parseLong(next());
	}

}




