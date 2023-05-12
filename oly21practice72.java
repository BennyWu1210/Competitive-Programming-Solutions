
import java.io.*;
import java.util.*;

public class oly21practice72 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)1e5 * 2 + 5;
	static int[] arr = new int[MM];
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		for (int i=1; i<=N; i++) {
			arr[i] = readInt();
		}
		
		for (int i=0; i<Q; i++) {

			
			int c = readInt();
			
			if (c == 1) {
				int ind = readInt(), v = readInt();
				arr[ind] = v;
			}
			else {
				int l = readInt(), r = readInt();
				
				if ((r - l) % 2 == 1) {
					System.out.println(0);
				}
				else {
					int ans = 0;
					
					if (r - l == 0) {
						ans = arr[r];
					}
					else {
						while (l <= r) {
							ans ^= arr[l];
							l += 2;
						}
					}
					
					System.out.println(ans);
				}
			}
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


	
	
