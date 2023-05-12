
import java.io.*;
import java.util.*;

public class dmopc21c3p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MM = (int)1e6+1;
	public static void main(String[] args) throws IOException {

		Map<Long, Integer> map = new HashMap();
		long[] sum = new long[MM];

		for (int i=1; i<MM; i++) {
			sum[i] += sum[i-1] + i;
			map.put(sum[i], i);
		}
				
		long k = readLong();

		if (k == 0) {
			System.out.println(1);
			System.out.println(1);
			return;
		}
		
		if (k > sum[MM-1]) {
			System.out.println(-1);
			return;
		}
		

		
		if (map.containsKey(k) && map.get(k) < MM) {
			int i = map.get(k);
			
			System.out.println(i);
			
			for (int j=0; j<i-1; j++) {
				System.out.print(0 + " ");
			}
			
			System.out.println(0);
			return;
		}
		
		for (int i=0; i<MM; i++) {
			
			if (map.containsKey(k - sum[i])) {
				int otherInd = map.get(k - sum[i]);
				
				if (i + otherInd + 1 > MM) continue;
				
				System.out.println(i + otherInd + 1);
				
				for (int j=0; j<i; j++) {
					System.out.print(0 + " ");
				}
				
				System.out.print(1);
				
				for (int j=0; j<otherInd; j++) {
					System.out.print(" " + 0);
				}
				
				System.out.println();
				return;
			}
			
		}

		
		System.out.println(-1);



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




