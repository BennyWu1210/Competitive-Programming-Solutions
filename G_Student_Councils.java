
import java.io.*;
import java.util.*;

public class G_Student_Councils {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int k, n;
	static int[] val;
	
	static boolean check(long num) {
		long sum = num * k;
		
		for (int i=0; i<val.length; i++) {
			sum -= (long)((val[i] < num) ? val[i] : num);
			if (sum <= 0) return true;
			
		}
		
		return false;
		
	}
	public static void main(String[] args) throws IOException {

		k = readInt();
		n = readInt();
		val = new int[n];
		
		for (int i=0; i<n; i++) {
			val[i] = readInt();
		}
		
		long l = 0, r = (long)1e11;
		long res = 0;
		while (l <= r) {
			long mid = (l + r) / 2;
			
			if (check(mid)) {
				res = mid;
				l = mid + 1;
			}
			else {
				r = mid - 1;
			}
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


	
	
