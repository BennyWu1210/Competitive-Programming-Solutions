
import java.io.*;
import java.util.*;

public class A_Binary_Search {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {

		int n = readInt(), k = readInt();

		int[] arr = new int[n];

		for (int i=0; i<arr.length; i++) arr[i] = readInt();

		for (int i=0; i<k; i++) {
			int val = readInt();
			boolean res = bSearch(val, arr);
			
			if (res) System.out.println("YES");
			else System.out.println("NO");
		}

	}

	static boolean bSearch(int num, int[] arr) {
		int l = 0, h = arr.length-1;
		
		while(l <= h) {
			int mid = (l+h)/2;
			if (arr[mid] < num) l = mid + 1;
			else if (arr[mid] > num) h = mid - 1;
			else return true;
		}
		
		return false;
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




