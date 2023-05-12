
import java.io.*;
import java.util.*;
public class TSS_2017B {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static int binarySearch(int left, int right, double[] arr, double n) {
		if (right - left <= 1) {
			if (arr[left] < n) return right;
			if (arr[left] > n) return left;
		}
		
		int mid = (left+right)/2;
		double num = arr[mid];
		if (num < n) return binarySearch(mid+1, right, arr, n);
		if (num > n) return binarySearch(left, mid, arr, n);
		if (num == n) return mid+1;
		
		return -1;
				
				
	}
	
	
	public static void main(String[] args) throws IOException {
		// Sort the array first, then use binary search to find the number of houses
		int N = readInt();
		int Q = readInt();
		double[] dist = new double[N];
		
		for(int i=0; i<N; i++) {
			double x = readDouble();
			double y = readDouble();
			
			double d = Math.pow(x, 2) + Math.pow(y, 2);
			dist[i] = d;
		}
		
		Arrays.sort(dist);
		// System.out.println(Arrays.toString(dist));
		for(int i=0; i<Q; i++) {
			double r = Math.pow(readDouble(), 2);
			
			if (dist[N-1] < r) {
				System.out.println(N);
			}
			else {
				int index = binarySearch(0, dist.length-1, dist, r);
				System.out.println(index);
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
