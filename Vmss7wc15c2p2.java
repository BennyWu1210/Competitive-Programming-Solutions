
import java.io.*;
import java.util.*;

public class Vmss7wc15c2p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int n = readInt();
		String str = readLine();

		String res = longestPalindrome(str);
		System.out.println(res);
		System.out.println(res.length());


	}

	static public String longestPalindrome(String s) {

		int len = s.length();
		int maxLength = 1;
		int start = 0;
		for (int i=1; i<len; i++){
			// find even palindrome
			int low = i-1, high = i;

			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
				low --;
				high ++;
			}

			low ++; high --;

			if (high - low + 1 > maxLength){
				start = low;
				maxLength = high - low + 1;
			}

			// find odd palindrome

			low = i-1;
			high = i+1;

			while (low >= 0 && high < len && s.charAt(low) == s.charAt(high)){
				low --;
				high ++;
			}

			low ++;
			high --;

			if (high - low + 1 > maxLength){
				start = low;
				maxLength = high - low + 1;
			}

		}

		String res = s.substring(start, start + maxLength);
		return res;
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




