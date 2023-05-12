
import java.io.*;
import java.util.*;

public class test3015 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		boolean a = sc.nextBoolean();
		System.out.println(a);
		
		
//		int N = (int)(Math.random() * 10) + 3;
//		
//		System.out.println(N);
//		
//		for (int i=1; i<=N; i++) {
//			boolean[] taken = new boolean[N+1];
//			for (int j=1; j<=N; j++) {
//				int a = (int)(Math.random() * N) + 1;
//				while (taken[a]) a = (int)(Math.random() * N) + 1;
//				taken[a] = true;
//				System.out.print(a + " ");
//			}
//			System.out.println();
//		}
		
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


	
	
