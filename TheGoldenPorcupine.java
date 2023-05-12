
import java.io.*;
import java.util.*;
public class TheGoldenPorcupine {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int N = readInt(); // Number of quills
		int T = readInt(); // The time, starting from 1
		long[] total = new long[T];
		
		for(int t=0; t<N; t++) {
			int left = readInt();
			int right = readInt();
			int a = readInt();
			int b = readInt();
			int c = readInt();
			
			int x = 0;
			while(left <= right) {
				long result = (long)Math.pow(x, 2)*a + b*x + c;
				total[left-1] += result;
				left ++;
				x ++;
			}
			
		} 
		
		for(long num: total) System.out.print(num + " "); // Apparently brute force does not work. Created a redo file	
		
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
