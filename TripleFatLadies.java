
import java.io.*;
import java.util.*;

public class TripleFatLadies {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		for (int i=readInt(); i>0; i--) {
			int k = readInt();
			
			long ans = k;
			long num = ans/100*100+442;
			long num2 = ans/100*100+192;
			long num3 = ans/100*100+692;
			
			while(true) {
				if (num2 * num2 * num2 % 1000 != 888) {
					num2 += 192;
				}
				else {
					System.out.println(num2);
					break;
				}
				if (num * num * num % 1000 != 888) {
					num += 442;
				}
				else {
					System.out.println(num);
					break;
				}
				if (num3 * num3 * num3 % 1000 != 888) {
					num3 += 692;
				}
				else {
					System.out.println(num3);
					break;
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


	
	
