import java.io.*;
import java.util.*;
public class Hardcore_Griding_Redo2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException{
		// Use diff array this time

		int N = readInt();
		int[] dif = new int[(int) Math.pow(10, 7)+1]; 
		int size = 0;
		// Perform the algorithm
		for(int i=0; i<N; i++) { 
			int start = readInt();
			int end = readInt();
			
			dif[start] ++;
			dif[end] --;
			
			if (end > size) {
				size = end;
			}
		}
		
		// Recover the array
		int[] arr = new int[size];
		int largest = Integer.MIN_VALUE;
		for(int i=1; i<arr.length; i++) {
			arr[i] = dif[i] + arr[i-1];
			if (arr[i] > largest) {
				largest = arr[i];
			}
		}
		//System.out.println(Arrays.toString(arr));
		System.out.println(largest);
		
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
