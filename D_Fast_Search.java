
import java.io.*;
import java.util.*;

public class D_Fast_Search {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		int[] arr = new int[n];
		
		for (int i=0; i<n; i++) arr[i] = readInt();
		
		Arrays.sort(arr);
		
		int q = readInt();
		int[] ans = new int[q];
		
		HashMap<Integer, Integer> lmap = new HashMap<>();
		HashMap<Integer, Integer> rmap = new HashMap<>();
		
		for (int i=0; i<q; i++) {
			int l = readInt(), r = readInt();
			int rightAns;
			int leftAns;
			
			if (lmap.containsKey(l)) {
				leftAns = lmap.get(l);
			}
			else {
				leftAns = bSearchLeft(l, arr);
				lmap.put(l, leftAns);
			}
			
			if (rmap.containsKey(r)) {
				rightAns = rmap.get(r);
			}
			else {
				rightAns = bSearchRight(r, arr);
				rmap.put(r, rightAns);
			}

			ans[i] = rightAns - leftAns + 1;
		}
		
		for (int i: ans) System.out.print(i + " ");
		
	}
	

	static int bSearchRight(int num, int[] arr) {
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
	static int bSearchLeft(int num, int[] arr) {
		int l = 0, h = arr.length-1;
		
		while (l <= h) {
			
			int mid = (l+h)/2;
 
			
			if (arr[mid] < num) {
				if (l == h) return mid + 1;
				l = mid + 1;
			}
			else if (arr[mid] > num) {
				
				if (l == h) return mid ;
				h = mid;
			}
			else {
				while (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
					mid --;
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