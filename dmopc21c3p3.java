
import java.io.*;
import java.util.*;

public class dmopc21c3p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, M;
	static int[] pos;
	
	static boolean solve(int i, int satisfied) {
		if (i >= 2 && i < N+M+1-2) {
		}
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();
		pos = new int[N+M+1];
		
		for (int i=0; i<=N-1; i++) pos[i] = 1;
		for (int i=N+1; i<=N+M; i++) pos[i] = 2;
		
		
		
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


	
	
