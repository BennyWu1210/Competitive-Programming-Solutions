
import java.io.*;
import java.util.*;

public class Two_Kangaroos {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int x1 = readInt(), y1 = readInt(), k = readInt();
		int x2 = readInt(), y2 = readInt(), l = readInt();
		
		int xDif = Math.abs(x2 - x1), yDif = Math.abs(y2 - y1);
		int ans = (int)(xDif/(Math.abs(k-l))) + (int)(Math.abs(yDif/(k-l)));
		System.out.println(ans);
		
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


	
	
