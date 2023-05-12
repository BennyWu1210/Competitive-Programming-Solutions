
import java.io.*;
import java.util.*;
public class CCC15J2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String input = readLine();
		int happyCounter = 0;
		int sadCounter = 0;
		
		
		for (int i=0; i<input.length()-3; i++) {
			//System.out.println(input.substring(i, i+3));
			if (input.substring(i, i+3).equals(":-)")) {
				happyCounter ++;
			}
			else if (input.substring(i, i+3).equals(":-(")) {
				sadCounter ++;
			}
		}
		if (happyCounter > sadCounter) System.out.println("happy");
		if (happyCounter < sadCounter) System.out.println("sad");
		if (happyCounter == sadCounter) {
			if (happyCounter == 0) {
				System.out.println("none");
			}
			else {
				System.out.println("unsure");
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
