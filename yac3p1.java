
import java.io.*;
import java.util.*;

public class yac3p1 {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(), A = readInt(), B = readInt();
		
		int[] u = new int[M + 1], v = new int[M + 1], goodPos = new int[M + 1];
		
		for (int i = 1; i <= M; i++) {
			u[i] = readInt();
			if (u[i] != -1) v[i] = readInt();
		}
		
		int pos = B;
		for (int i = M; i >= 1; i--) {
			if (u[i] != -1) {
				if (u[i] == pos) pos = v[i];
				else if (v[i] == pos) pos = u[i];
			}
			goodPos[i] = pos;
			
			// System.out.println(goodPos[i]);
		}
		
		int cur = A;
		boolean inPlace = false;
		
		
		for (int i = 1; i <= M; i++) {
			
			if (goodPos[i] == cur) inPlace = true;
			
			if (u[i] != -1) {
				if (cur == u[i]) cur = v[i];
				else if (cur == v[i]) cur = u[i];
				
				
				System.out.println(u[i] + " " + v[i]);
				continue;
			}
			
			if (inPlace) { 
				int a = 1, b = N;
				if (a == cur) a ++;
				if (b == cur) b --;
				
				System.out.println(a + " " + b);
			} else {
				
				System.out.println(cur + " " + goodPos[i]);
				cur = goodPos[i];
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


	
	
