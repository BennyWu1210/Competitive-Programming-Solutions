
import java.io.*;
import java.util.*;

public class UsacoFebP3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			// System.out.println("====");
			int M = readInt(), N = readInt(), K = readInt();
			int[] a = new int[N+1], freq = new int[M+1];
			boolean[] taken = new boolean[N+1];
			
			for (int i=1; i<=N; i++) {
				a[i] = readInt();
				freq[a[i]] ++;
			}
			
			int lf = 1, ls = K, rf = 1, rs = K;
			
			int took = 0;
			boolean ok = true;
			outer: while (ok) {
				// System.out.println("OK");
				ok = false;
				
				int ind = rf;
				while (ind <= rs) {
					
					while (lf <= M && freq[lf] == 0) {
						lf ++; 
						if (ls != M) ls ++;
					}
					
//					System.out.println(lf + " " + ls + " : " + rf + " " + rs);
//					System.out.println(ind + " " + a[ind]);
					
					if (!taken[ind] && a[ind] >= lf && a[ind] <= ls) {
						if (rs == N) {
							while (rf > 1 && taken[rf - 1]) rf --;
							if (rf > 1) rf --;
						}
						else {
							rf ++;
							rs ++;
						}
						freq[a[ind]] --;
						took ++;
						// System.out.println("IND: " + ind);
						taken[ind] = true;
						ok = true;
					}
					ind ++;
					if (took == N) break outer;
				}
				
				if (!ok && rs != N) {
					//System.out.println("scroll");
					ok = true;
					rf ++;
					rs ++;
				}
			}

			

			boolean res = took == N;
			
			String ans = res ? "YES" : "NO";
			System.out.println(ans);
			
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


	
	
