
import java.io.*;
import java.util.*;
public class BobAndCanadaRedo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for(int t=0; t<T; t++) {
			
			int len = readInt();
			char[] input = readLine().toCharArray();
			
			long[] r = new long[len+1];
			long[] w = new long[len+1];
			
			for(int i=0; i<len; i++) {
				if (input[i] == 'R') {
					r[i] ++;
				}
				else {
					w[i] ++;
				}
			}
			
			for(int i=1; i<len; i++) {
				r[i] = r[i-1] + r[i];
				w[i] = w[i-1] + w[i];
			}
			
			// Loop b from 2 to n-1
			long minDiff = (r[0] == 1) ? -1:1;
			int aIndex = 0;
			int bIndex = 0;
			long result = 0;
			// (w[len-1] - w[bIndex]) + (r[bIndex] - r[aIndex]) + w[aIndex];
			
			for(int b=1; b<len-2; b++) {
				long curADiff = w[b] - r[b];
				long curBDiff = r[b] - w[b];
				if (curADiff< minDiff) {
					minDiff = curADiff + curBDiff;
				}
			}
			
			System.out.println(minDiff + );
//			long minBDiff = Integer.MAX_VALUE;
//			int bIndex = aIndex+1;
//			
//			for(int b=aIndex+1; b<len-1; b++) {
//				long curDiff = r[b] - w[b];
//				if (curDiff < minBDiff) {
//					minBDiff = curDiff;
//					bIndex = b;
//				}
//			}
			
			
			
//			System.out.println(aIndex + " " + bIndex);
//			System.out.println(Arrays.toString(w));
//			System.out.println(Arrays.toString(r));
//
//			System.out.println(result);
			
			
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
