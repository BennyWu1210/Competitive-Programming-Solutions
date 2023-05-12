
import java.io.*;
import java.util.*;

public class ccoprep16c2q2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		int[] bits = new int[32];
		
		int res = 0;
		for (int i=0; i<N; i++){
			int cur = readInt();
			
			int max = 0;
			for (int j=0; j<bits.length; j++) {
				if (((1 << j) & cur) != 0) {
					max = Math.max(max, bits[j] + 1);
				}
			}
			
			for (int j=0; j<bits.length; j++) {
				if (((1 << j) & cur) != 0) {
					bits[j] = max;
				}
			}
			
			res = Math.max(res, max);
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


	
	
