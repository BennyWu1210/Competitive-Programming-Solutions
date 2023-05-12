
import java.io.*;
import java.util.*;

public class Acc8_P2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		for (int t=readInt(); t>0; t--) {
			int n = readInt(), k = readInt();
			
			int ans = 0;
			int temp = 0;
			for (int i=0; i<n; i++) {
				temp += readInt();
				
				if (temp >= k) {
					ans ++;
					temp = 0;
				}
			}
			
			System.out.println(ans);
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


	
	
