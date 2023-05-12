
import java.io.*;
import java.util.*;

public class dmopc22c4p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int dist(int x, int y) {
		return Math.abs(y - x);
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), D = readInt();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) arr[i] = readInt();
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			int x = arr[i];
			
			int cur = arr[i];
			int ind = i;
			int ans = 0;
			
			// forward direction
			while (ind < N && dist(cur, arr[ind]) < D) {
				ans++;
				while (ind + 1 < N && dist(cur, arr[ind + 1]) < D) ind++;
				
				ind++;
				if (ind < N) {
					cur = arr[ind];
				}
				
			}
			
			if  (i == 0) {
				System.out.println("ans: " + ans);
				max = Math.max(max, ans);
				continue;
			}
			
			cur = arr[i - 1];
			ind = i - 1;
			
			// backward direction
			while (ind >= 0 && dist(cur, arr[ind]) < D) {
				ans++;
				while (ind - 1 >= 0 && dist(cur, arr[ind - 1]) < D) ind--;
				
				ind--;
				if (ind >= 0) {
					cur = arr[ind];
				}
			}
			
			System.out.println("ans: " + ans);
			max = Math.max(max, ans);
		}
		
		System.out.println(max);
		
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


	
	
