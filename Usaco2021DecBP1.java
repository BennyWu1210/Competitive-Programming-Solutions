
import java.io.*;
import java.util.*;

public class Usaco2021DecBP1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(); long ans = 0;
		char[] c = readLine().toCharArray();
		
		long[] GFront = new long[N+1], HFront = new long[N+1];
		long[] GBack = new long[N+1], HBack = new long[N+1];
		
		for (int i=1; i<N; i++) {
			if (c[i-1] == 'G') GFront[i] = GFront[i-1] + 1;
			else HFront[i] = HFront[i-1] + 1;
		}
		
		for (int i=N-2; i>=0; i--) {
			if (c[i+1] == 'G') GBack[i] = GBack[i+1] + 1;
			else HBack[i] = HBack[i+1] + 1;
		}
		
		
		for (int i=0; i<N; i++) {
			if (c[i] == 'H') {
				if (GFront[i] + GBack[i] < 2) continue;
				ans += GFront[i] + GBack[i] - 2 + (GFront[i] * GBack[i]);
				if (GFront[i] == 0 || GBack[i] == 0) ans ++;
			} else {
				
				if (HFront[i] + HBack[i] < 2) continue;
				ans += HFront[i] + HBack[i] - 2 + (HFront[i] * HBack[i]);
				if (HFront[i] == 0 || HBack[i] == 0) ans ++;
			}
		}
		
		System.out.println(ans);
		
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
	
}


	
	
