
import java.io.*;
import java.util.*;

public class dmopc21c1_p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		
		int[] arr = new int[N];
		
		
		for (int i=0; i<N; i++) arr[i] = readInt();
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int index = 0;

		boolean sorted = false;
		
		while (!sorted) {
			
			boolean increasing = true;
			
			while (increasing && arr[index]) {
				
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


	
	
