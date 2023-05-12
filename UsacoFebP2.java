
import java.io.*;
import java.util.*;

public class UsacoFebP2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static Map<Long, Integer>[] map = new HashMap[42];
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] ans = new int[41];
		int[] x = new int[N+1], y = new int[N+1];
		
		int x_flag = readInt(), y_flag = readInt();
		
		for (int i=1; i<=N; i++) {
			x[i] = readInt(); y[i] = readInt();
		}
		
		for (int i=1; i<(1<<N); i++) {
			int len = Integer.bitCount(i);
//			System.out.println(Integer.toBinaryString(i));
//			System.out.println(len);
			
			long x_tot = 0, y_tot = 0;
			
			for (int j=1; j<=N; j++) {
				if (((1 << (j-1)) & i) != 0) {
					x_tot += x[j]; y_tot += y[j];
				}
			}
			
			if (x_flag == x_tot && y_flag == y_tot) {
				ans[len] ++;
				// System.out.println("ANS!");
			}
			long key = x_tot >= y_tot ? x_tot * x_tot + y_tot : y_tot * y_tot + x_tot;
			map[len].put(key, map[len].getOrDefault(key, 0) + 1);
		}
		
		for (int i=)
		
		
		
		for (int i=1; i<=N; i++) {
			System.out.println(ans[i]);
		}
		
	}
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}


	
	
