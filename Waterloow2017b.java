
import java.io.*;
import java.util.*;

public class Waterloow2017b {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		String str = readLine();
	
		int[] freq = new int[26];
		int min = Integer.MAX_VALUE;
		char c = ' ';
		
		if (k > n) {
			System.out.println("WRONGANSWER");
			return;
		}
		
		for (int i=0; i<str.length(); i++) {
			freq[str.charAt(i) - 'a'] ++;
		}
		
		
		for (int i=0; i<26; i++) {
			if (freq[i] < min) {
				min = freq[i];
				c = (char)(i + 'a');
			}
		}
		
		if (k < min) {
			System.out.println("WRONGANSWER");
			return;
		}
		
		int ai = 0;
		int left = k - min;
		char[] res = new char[n];
		
		for (int i=0; i<n; i++) {
			if (str.charAt(i) == c) {
				res[ai ++] = c;
			}
			else if (left > 0){
				res[ai ++] = str.charAt(i);
				left --;
			}
		}
		
		for (int i=ai; i<n; i++) {
			res[i] += c;
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


	
	
