
import java.io.*;
import java.util.*;

public class dmopc22c3p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		
		int[] A = new int[M], B = new int[M];
		
		for (int i = 0; i < M; i++) A[i] = readInt();
		for (int i = 0; i < M; i++) B[i] = readInt();
		
		long has = 0;
		for (int i = 0; i < M; i++) {
			if (A[i] < B[i] && A[i] != 0) {
				System.out.println("NO");
				return;
			}
			
			
			if (A[i] == 0) {
				
				if (B[i] != 1 || has == 0) {
					System.out.println("NO");
					return;
				}
				
				has -= 1;
				
				
			} else {
				has += A[i] - B[i];
			}
		}
		
		
		System.out.println("YES");
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


	
	
