
import java.io.*;
import java.util.*;
public class TheCakeIsADessert {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// try 2D prefix sum

		int N = readInt();
		int M = readInt();
		int K = readInt();
		int[][] arr = new int[N][M];
		int[][] diff = new int[N+1][M+1];
		long[][] psa = new long[N][M];
		// 2D diff array 
		for(int i=0; i<K; i++) {
			int startX = readInt()-1;
			int startY = readInt()-1;
			int endX = readInt()-1;
			int endY = readInt()-1;
			
//			System.out.println(startX + " " + startY);
//			System.out.println(endX + " " + endY);
			diff[startX][startY] ++;
			diff[startX][endY+1] --;
			diff[endX+1][startY] --;
			diff[endX+1][endY+1] ++;
//			for(int[] a: diff) System.out.println(Arrays.toString(a));
//			System.out.println("-----");
		}
		
		// Recover array
		arr[0][0] = diff[0][0];
		for(int i=1; i<M; i++) arr[0][i] = arr[0][i-1] + diff[0][i];
		for(int i=1; i<N; i++) arr[i][0] = arr[i-1][0] + diff[i][0];
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				arr[i][j] = diff[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
			}
		}
//		for(int[] a: diff) System.out.println(Arrays.toString(a));
//		System.out.println("-----");
		// System.out.println("----");
		
		
		// Do PSA again
		psa[0][0] = arr[0][0];
		for(int i=1; i<M; i++) psa[0][i] = psa[0][i-1] + arr[0][i];
		for(int i=1; i<N; i++) psa[i][0] = psa[i-1][0] + arr[i][0];
		
		for(int i=1; i<N; i++) {
			for(int j=1; j<M; j++) {
				psa[i][j] = arr[i][j] + psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
			}
		}
//		for(int[] a: arr) System.out.println(Arrays.toString(a));
//		System.out.println("=====");
//		for(int[] a: psa) System.out.println(Arrays.toString(a));


		int Q = readInt();
		
		for(int i=0; i<Q; i++) {
			int startX = readInt()-1;
			int startY = readInt()-1;
			int endX = readInt()-1;
			int endY = readInt()-1;
			
			
			long allArea = psa[endX][endY];
			long leftArea = 0;
			long topArea = 0;
			long topLeftArea = 0;
			if(startY - 1 < 0) {
				leftArea = 0;
			}
			else {
				leftArea = psa[endX][startY-1];
			}
			
			if(startX - 1 < 0) {
				topArea = 0;
			}
			else {
				topArea = psa[startX-1][endY];
			}
			
			if(startX - 1 < 0 || startY - 1 < 0) {
				topLeftArea = 0;
			}
			else {
				topLeftArea = psa[startX-1][startY-1];
			}
			
			// System.out.println(allArea + " " + leftArea + " " + topArea + " " + topLeftArea);
			long result = allArea - leftArea - topArea + topLeftArea;
			System.out.println(result);
			
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
