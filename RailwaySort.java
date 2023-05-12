
import java.io.*;
import java.util.*;


public class RailwaySort {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static int minMoves(int arr[], int n)
	{
		// Since we traverse array from end,
		// extected item is initially n
		int expectedItem = n;

		// Taverse array from end
		for (int i = n - 1; i >= 0; i--)
		{
			// If current item is at its correct position,
			// decrement the expectedItem (which also means
			// decrement in minimum number of moves)
			if (arr[i] == expectedItem)
				expectedItem--;
		}

		return expectedItem;
	}

	public static void main(String[] args) throws IOException {

		//		for(int t=0; t<10; t++) {
		//			int n = readInt();
		//			int[] arr = new int[n];
		//			boolean[] moved = new boolean[n];
		//			
		//			int largest = -1;
		//			for(int j=0; j<n; j++) {
		//				arr[j] = readInt();
		//				if (arr[j] > largest) {
		//					largest = arr[j];
		//				}
		//			}
		//			
		//			int solved = 0;
		//			int counter = 0;
		//			
		//			// System.out.println(Arrays.toString(arr));
		//			while(true) {
		//				int max = -1;
		//				int maxIndex = -1;
		//				for(int i=0; i<n; i++) {
		//					if (!moved[i] && arr[i] != largest && arr[i] > max) {
		//						max = arr[i];
		//						maxIndex = i;
		//					}
		//				}
		//				if (maxIndex == -1) {
		//					System.out.println(counter);
		//					break;
		//				}
		//				
		//				// System.out.println(arr[maxIndex]);
		//				moved[maxIndex] = true;
		//				int atFront = 0;
		//				
		//				for(int i=maxIndex+1; i<n; i++) {
		//					if (moved[i]) atFront ++;
		//				}
		//				counter += maxIndex + atFront;
		//				solved ++;
		//			}
		//			
		//		}



		




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




