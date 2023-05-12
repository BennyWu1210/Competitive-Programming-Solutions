
import java.io.*;
import java.util.*;

public class usaco20febb3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		
		int a1 = readInt(), a2 = readInt();
		int b1 = readInt(), b2 = readInt();
		
		int[] arr = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = i;
		}
		
		
		int ans = 1;
		for (int i=0; i<K; i++) {
			
			int index = 0;
			
			while (index <= (a2 - a1)/2) {
				int a = arr[index+a1];
				arr[index+a1] = arr[a2-index];
				arr[a2-index] = a;
				index ++;
			}
			
			index = 0;
			
			
			while (index <= (b2 - b1)/2) {
				int b = arr[index+b1];
				arr[index+b1] = arr[b2-index];
				arr[b2-index] = b;
				index ++;
			}
			
			boolean same = true;
			
			for (int j=1; j<arr.length-1; j++) {
				if (arr[j+1] != arr[j] + 1) {
					same = false;
					break;
				}
			}
			
			if (same) {
				ans = i+1;
				break;
			}
			
		}
		
		
		
		for (int i=0; i<(K%ans); i++) {
			int index = 0;
			while (index <= (a2 - a1)/2) {
				int a = arr[index+a1];
				arr[index+a1] = arr[a2-index];
				arr[a2-index] = a;
				index ++;
			}
			
			
			index = 0;
			
			
			while (index <= (b2 - b1)/2) {
				int b = arr[index+b1];
				arr[index+b1] = arr[b2-index];
				arr[b2-index] = b;
				index ++;
			}
		}
		
		for (int i=1; i<arr.length; i++) {
			System.out.println(arr[i]);
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


	
	
