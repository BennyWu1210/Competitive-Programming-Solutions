
import java.io.*;
import java.util.*;
public class Dmopc_16_4p2_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// Try PSA (diff
		int B = readInt();
		int total = 0;
		int[] arr = new int[(int)Math.pow(10, 9)];
		for(int i=0; i<B; i++) {
			int start = readInt();
			int end = readInt();
			int value = readInt();
			
			for(int j=start; j<=end; j++) {
				arr[j] += value;
			}
			
			total += value;
		}
		
		int N = readInt();
		
		for(int i=0; i<N; i++) {
			int c = readInt();
			total -= arr[c];
		}
		
		System.out.println(total);
		
		
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
