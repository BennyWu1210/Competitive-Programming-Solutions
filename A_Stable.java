
import java.io.*;
import java.util.*;

public class A_Stable {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int t = readInt();
		
		while (t --> 0) {
			int n = readInt(), k = readInt();
			char[][] mat = new char[n][n];
			
			if (Math.ceil(n / 2.0) < k) {
				System.out.println(-1);
				continue;
			}
			
			for (int r=0, c=0; r<n && k>0; r+=2, c+=2, k--) {
				mat[r][c] = 'R';
			}
			
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					if (mat[i][j] == 'R') System.out.print('R');
					else System.out.print('.');
				}
				System.out.println();
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


	
	
