
import java.io.*;
import java.util.*;

public class Aac3p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] inc = new int[N];
		char[] res = new char[N];
		int[] num = new int[N];
		
		for(int i=0; i<N; i++) {
			inc[i] = readInt();
		}
		
		Arrays.sort(inc);
		int index = 0;
		for(int i=0; i<Math.ceil(N/2.0); i++) {
			int front = inc[i];
			int back = inc[N-i-1];
			
			if (i != N-i-1) {
				num[index] = front;
				res[index] = 'B';
				index ++;
				num[index] = back;
				res[index] = 'S';
				index ++;
			}
			else {
				res[index] = 'E';
				num[index] = front;

			}
		}
		
		for(int i=0; i<N-1; i++) System.out.print(num[i] + " ");
		System.out.println(num[num.length-1]);
		for(char c: res) System.out.print(c);
		System.out.println();
		
		
		
//		Arrays.sort(arr);
//		int min = arr[0];
//		for(int i=0; i<arr.length-1; i++) System.out.print(arr[i] + " ");
//		System.out.print(arr[arr.length-1] + "\n");
//		
//		if (arr.length > 1 && arr[arr.length-1] > min) {
//			System.out.print("B");
//			for(int i=0; i<N-2; i++) System.out.print("E");
//			System.out.print("S");
//		}
//		else {
//			for(int i=0; i<N; i++) System.out.print("E");
//		}
//		
//		System.out.println();
		
		
		
		
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


	
	
