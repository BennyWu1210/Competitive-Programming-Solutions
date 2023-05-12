
import java.io.*;
import java.util.*;

public class Aac3p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int A = readInt(), B = readInt(), C = readInt(), D = readInt();
		
		boolean needSugar = B > A;
		boolean needToothPaste = D > C;
		
		if (needSugar && needToothPaste) {
			System.out.println("Go to the department store");
		}
		else if(needSugar) {
			System.out.println("Go to the grocery store");
		}
		else if(needToothPaste) {
			System.out.println("Go to the pharmacy");
		}
		else {
			System.out.println("Stay home");
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


	
	
