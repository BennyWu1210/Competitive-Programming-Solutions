
import java.io.*;
import java.util.*;

public class dmopc21c4p3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		System.out.println(0);
		System.out.println(10001);
		System.out.println(10101);
		System.out.println(10201);
		System.out.println(10301);
		System.out.println(11011);
		System.out.println(11111);
		System.out.println(12021);
		System.out.println(13031);
		System.out.println(11211);

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


	
	
