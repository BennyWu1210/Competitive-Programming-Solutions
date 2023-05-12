
import java.io.*;
import java.util.*;

public class coci16c3p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean check(char c) {
		if (c == '.' || c == '?' || c == '!') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		String[] ipt = readLine().split(" ");
		
		
		int count = 0;
		for (String s: ipt) {
			boolean isName = false;
			
			char c = s.charAt(s.length()-1);
			
			if (Character.isUpperCase(s.charAt(0)) && s.length() == 1) isName = true;
			else if (Character.isUpperCase(s.charAt(0)) && (Character.isLowerCase(c) || check(c))) {
				isName = true;
				
				for (char cc: s.substring(1, s.length()-1).toCharArray()) {
					if (!Character.isLowerCase(cc)) {
						isName = false;
						break;
					}
				}
			}
			
			if (isName) count++;
			
			
			if (check(c)) {
				System.out.println(count);
				count = 0;
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


	
	
