
import java.io.*;
import java.util.*;


public class Usaco21febs3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[][] arr = new int[n+1][n+1], hundred = new int[n+1][n+1];
		long ans = 0;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int input = readInt();
				if (input >= 100) {
					arr[i][j] = 0;
				}
				else {
					arr[i][j] = 1;
				}
				if (input == 100) {
					hundred[i][j] = 1;
				}
				
				// 2d psa
				arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
				hundred[i][j] += hundred[i-1][j] + hundred[i][j-1] - hundred[i-1][j-1];
				if (hundred[i][j] == 0) continue;
				for(int r=1; r<=i; r++) {
					for(int c=1; c<=j; c++) {
						if (arr[i][j] - arr[r-1][j] - arr[i][c-1] + arr[r-1][c-1] == 0
					&& hundred[i][j] - hundred[r-1][j] - hundred[i][c-1] + hundred[r-1][c-1] >= 1) {
							// System.out.printf("%d %d %d %d, ", i, j, r, c);
							ans ++;
						}
					}
				}
			}
		}
		
		
		
//		System.out.println(Arrays.deepToString(arr));
//		System.out.println(Arrays.deepToString(hundred));
		
//		for(int i=1; i<=n; i++) {
//			for(int j=1; j<=n; j++) {
//				
//				
//			}
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


	
	
