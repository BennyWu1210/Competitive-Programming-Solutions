
import java.io.*;
import java.util.*;

public class Wac5p1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt();
		int[] arr = new int[N];
		int[] freq = new int[(int)(1e6)];
		int max = -1;
		
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
			freq[arr[i]] ++;
			max = Math.max(max, arr[i]);
		}
		
		int index = max;
		int subtracted = 0;
		int ans = 0;
		
		while (index >= 0) {
			if (freq[index] > subtracted) {
				ans += (index * (freq[index] - subtracted));
				subtracted += (freq[index] - subtracted);
			}
			index --;
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


	
	
