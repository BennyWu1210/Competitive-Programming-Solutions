
import java.io.*;
import java.util.*;

public class CCC11S3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static boolean solve (int m, int x, int y) {
		if (m == 0) {
			return false;
		}
		
		int zone = (int)Math.pow(5, m-1);
		int newX = (int)(x / zone), newY = (int)(y / zone);
		
		if (newX == 0 || newX == 4) return false;
		if (newX == 1 || newX == 3) {
			if (newY ==  0) {
				return true;
			}
			else if (newY > 1) {
				return false;
			}
		}
		if (newX == 2) {
			if (newY < 2 ) return true;
			else if (newY > 2) return false;
			
		}

		return solve(m-1, (int)(x%zone), (int)(y%zone));
		
	}
	public static void main(String[] args) throws IOException {

		for (int t=readInt(); t>0; t--) {
			int l = readInt(), x = readInt(), y = readInt();
						
			boolean res = solve(l, x, y);
			
			String s = res ? "crystal" : "empty";
			
			System.out.println(s);
			
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


	
	
