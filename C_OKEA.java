
import java.io.*;
import java.util.*;

public class C_OKEA {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int n = readInt(), k = readInt();
			
			if (k == 1) {
				System.out.println("YES");
				for (int i=1; i<=n; i++) {
					System.out.println(i);
				}
				continue;
			}

			
//			if (n == 2) {
//				System.out.println("YES");
//				int[][] ans = new int[3][k+1];
//				ans[1][1] = 1;
//				ans[2][1] = 2;
//				for (int i=1; i<=2; i++) {
//					for (int j=2; j<=k; j++) {
//						ans[i][j] = ans[i][j-1] + 2;
//					}
//				}
//				
//				for (int i=1; i<=2; i++) {
//					for (int j=1; j<=k; j++) {
//						System.out.print(ans[i][j] + " ");
//					}
//					System.out.println();
//				}
//				continue;
//			}
			if (n % 2 == 0) {
				System.out.println("YES");
				int[][] ans = new int[n+1][k+1];
				for (int i=1; i<=n; i+=2) {
					ans[i][1] = (i - 1) * k + 1;
					ans[i+1][1] = (i - 1) * k + 2; 
					for (int l=i; l<=i+1; l++) {
						for (int j=2; j<=k; j++) {
							ans[l][j] = ans[l][j-1] + 2;
						}
					}
				}
				for (int i=1; i<=n; i++) {
					for (int j=1; j<=k; j++) {
						System.out.print(ans[i][j] + " ");
					}
					System.out.println();
				}
				continue;
			}
			System.out.println("NO");
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


	
	
