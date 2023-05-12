
import java.io.*;
import java.util.*;

public class globexcup19j4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt(), K = readInt();
		
		// coordinate compression?
		
		int[] num = new int[N];
		int[] freq = new int[N];
		
		for (int i=0; i<N; i++) num[i] = readInt();
		
		Arrays.sort(num);
		
		
		int index = 0;
		freq[index] = 1;
		
		for (int i=1; i<N; i++) {
			if (num[i] != num[i-1]) {
				freq[++index] = 1;
			}
			else {
				freq[index] ++;
			}
		}
		
		
		Arrays.sort(freq);
		
		int rem = K;
		long ans = 0;
		index = freq.length - 1;
		while (rem > 0) {
			if (freq[index] <= 1) {
				break;
			}
			if (rem - freq[index] >= 0) {
				rem -= freq[index];
				ans += (long)(freq[index] - 1) * (freq[index]) / 2;
				index --;
			} else {
				ans += (long)(rem - 1) * (rem) / 2;
				break;
			}
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


	
	
