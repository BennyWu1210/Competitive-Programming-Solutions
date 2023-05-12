
import java.io.*;
import java.util.*;


public class C_Penalty {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		outer: for(; t>0; t--) {
			char[] input = readLine().toCharArray();
			int k1 = 0, k2 = 0, p1 = 0, p2 = 0;
			int minimum = 10;
			for(int i=0; i<10; i++) {
				if (i % 2 == 0) {
					if (input[i] == '1' || input[i] == '?') {
						p1 ++;
					}
					k1 ++;
				}
				else {
					if (input[i] == '1') p2 ++;
					k2 ++;
				}
				
				if ((5 - k2) + p2 < p1) {
					minimum = i+1;
//					System.out.println(5 - k2);
//					System.out.println(p1);
					break;
				}
			}
			k1 = 0; k2 = 0; p1 = 0; p2 = 0;
			for(int i=0; i<10; i++) {
				if (i % 2 == 0) {
					if (input[i] == '1') {
						p1 ++;
					}
					k1 ++;
				}
				else {
					if (input[i] == '1' || input[i] == '?') {
						p2 ++;
					}
					k2 ++;
				}
				
				if ((5 - k1) + p1 < p2) {
					minimum = Math.min(i+1, minimum);
//					System.out.println(5 - k2);
//					System.out.println(p1);
					break;
				}
			}
			System.out.println(minimum);
		}
		
		
		
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


	
	
