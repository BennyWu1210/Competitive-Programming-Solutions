
import java.io.*;
import java.util.*;

public class B_Closest_to_the_left {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), k = readInt();
		
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) arr[i] = readInt();
		
		for (int i=0; i<k; i++) {
			int q = readInt();
			
			int ans = bSearch(q, arr);
			System.out.println(ans+1);
		}
		
	}
	
	static int bSearch(int num, int[] arr) {
		int l = 0, h = arr.length-1;
		
		while (l <= h) {
			
			int mid = (l+h)/2;
			
			if (arr[mid] < num) {
				if (l == h) return mid;
				l = mid + 1;
			}
			else if (arr[mid] > num) {
				
				if (l == h) return mid - 1;
				h = mid;
			}
			else {
				while (mid + 1 < arr.length && arr[mid + 1] == arr[mid]) {
					mid ++;
				}
				return mid;
			}
		}

		return -1;
		
		
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


	
	
