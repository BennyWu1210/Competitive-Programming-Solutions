
import java.io.*;
import java.util.*;

public class oly21practice79 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		

		int N = readInt();
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
		}
		
		Arrays.sort(arr);
		
		int max = 0;
		int ans = 0;
		
		int i = 0;
		while (i < N) {
			int ind = i;
			int count = 1;
			
			while (ind + 1 < N && arr[ind + 1] == arr[i]) {
				count ++;
				ind ++;
			}
			
			
			
			if (count > max) {
				max = count;
				ans = arr[i];
			}
			
			i = ind + 1;
		}
		
		System.out.println(ans);
		
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


	
	
