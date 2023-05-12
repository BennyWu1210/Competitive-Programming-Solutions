
import java.io.*;
import java.util.*;

public class usaco19febs2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static long[][] arr = new long[1002][1002];
	
	static void update(int x1, int y1, int x2, int y2) {
		arr[x1][y1] ++;
		arr[x1][y2 + 1] --;
		arr[x2 + 1][y1] --;
		arr[x2 + 1][y2 + 1] ++;
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		
		for (int i=0; i<N; i++) {
			update(readInt()+1, readInt()+1, readInt(), readInt());
			
			
		}
		
		
		int ans = 0;
		for (int i=1; i<=1001; i++) {
			for (int j=1; j<=1001; j++) {
				arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];

				if (arr[i][j] == K) {
					ans++;
				}
				
				
			}
		}
		
//		for (int j=1; j<=10; j++) {
//			for (int k=1; k<=10; k++) {
//				System.out.print(arr[j][k] + " ");
//			}
//			System.out.println();
//		}
		
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


	
	
