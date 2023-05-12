
import java.io.*;
import java.util.*;

public class usaco19febs1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		int total = 0;
		int[] pos = new int[n];
		
		for (int i=0; i<n; i++) pos[i] = readInt();
		
		Arrays.sort(pos);
		
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		
		for (int i=1; i<n; i++) total += pos[i] - pos[i-1] - 1;
		
		if (pos[n-2] - pos[0] == n - 2 && pos[n-1] - pos[n-2] > 2 || pos[n-1] - pos[1] == n-2 && pos[1] - pos[0] > 2) {
			min = 2;
		}
		else {
			int j = 0;
			for (int i=0; i<n; i++) {
				while (j + 1 < n && pos[j+1] - pos[i] < n) j ++;
				min = Math.min(min, n-(j-i+1));
			}
		}
		
		max = Math.max(total - (pos[1] - pos[0] - 1), total - (pos[n-1] - pos[n-2] - 1));
		
		System.out.println(min);
		System.out.println(max);
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


	
	
