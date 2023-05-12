
import java.io.*;
import java.util.*;

public class Bobs_Blocks {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int r = readInt(), c = readInt();
		
		int[][] mat = new int[r][c];
		int max = -1;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				mat[i][j] = readInt();
				max = Math.max(max, mat[i][j]);
			}
		}
		
		int ans = 0;
		
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				ans += (max - mat[i][j]);
			}
		}
		
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


	
	
