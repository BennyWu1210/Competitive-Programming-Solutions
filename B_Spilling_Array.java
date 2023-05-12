
import java.io.*;
import java.util.*;

public class B_Spilling_Array {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int n, k;
	static int[] num;
	
	static boolean solve(long sum) {
		long rem = k, temp = 0;
		
		for (int i=0; i<num.length; i++) {
			int next = num[i];
			
			if (next > sum) return false;
			
			if (temp + next > sum) {
				rem --;
				temp = 0;
			}
			
			temp += next;

			if (rem <= 0) return false;
		}
		
		
		return rem > 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		
		num = new int[n];
		input = br.readLine().split(" ");
		for (int i=0; i<n; i++) num[i] = Integer.parseInt(input[i]);
		
		long l = 0, r = (long)1e15, res = 0;


		while (l <= r) {
			long mid = (l + r) / 2;
			
			if (solve(mid)) {
				r = mid - 1;
				res = mid;
			}
			else {
				
				l = mid + 1;
			}
		}
		
		
		System.out.println(res);
		
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


	
	
