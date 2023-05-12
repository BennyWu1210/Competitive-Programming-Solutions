import java.io.*;
import java.util.*;

public class ccc23s1 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		boolean[][] arr = new boolean[2][N];
		
		int ans = 0;
		
		for (int i = 0; i < 2; i++)  {
			for (int j = 0; j < N; j++) {
				arr[i][j] = readInt() == 1 ? true : false;
				
				if (arr[i][j]) {
					ans += 3;
					
					if (j - 1 >= 0 && arr[i][j - 1]) {
						ans -= 2;
					}
					if (i == 1 && arr[i - 1][j]) {
						if (j % 2 == 0) {
							ans -= 2;
						}
					}
				
				}
				
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