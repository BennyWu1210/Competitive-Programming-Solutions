
import java.io.*;
import java.util.*;

public class Aac3p2 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		int K = readInt(), D = readInt();
		
		boolean containsZero = false;
		int min = 10;
		for(int i=0; i<D; i++) {
			int num = readInt();
			if (num != 0 && num < min) {
				min = num;
			}
			if (num == 0) {
				containsZero = true;
			}
		}
		
		if (min == 10) {
			System.out.println(-1);
			return;
		}

		if (!containsZero) {
			for(int i=0; i<K; i++) System.out.print(min);
		}
		else if (containsZero && K > 2){
			System.out.print(min);
			for(int i=0; i<K-2; i++) System.out.print(0);
			System.out.print(min);
		}
		else {
			for(int i=0; i<K; i++) System.out.print(min);
		}
		
		
		System.out.println();
		
		
		
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


	
	
