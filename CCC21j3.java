
import java.io.*;
import java.util.*;

public class CCC21j3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int[] freq = new int[5];
		
		int N = readInt();
		
		for (int i = 0; i < N; i++) {
			char[] C = readLine().toCharArray();
			
			for (int j = 0; j < 5; j++) {
				if (C[j] == 'Y') freq[j]++;
			}
		}
		
		int max = 0;
		for (int i = 0; i < 5; i++) {
			max = Math.max(max, freq[i]);
		}
		
		boolean printed = false;
		for (int i = 0; i < 5; i++) {
			if (freq[i] == max) {
				if (printed) {
					System.out.printf(",%d", i + 1);
				} else {
					System.out.print(i + 1);
				}
				printed = true;
				
			}
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


	
	
