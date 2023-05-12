
import java.io.*;
import java.util.*;

public class Gfssoc2j5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = 3628805;
	public static void main(String[] args) throws IOException {
		int N = readInt(), Q = readInt();
		int[] arr = new int[N];
		int[][] maxL = new int[N][2];
		int[][] maxR = new int[N][2];
		int[] freq = new int[MM];
		
		for (int i=0; i<N; i++) {
			arr[i] = readInt();
		}

		int leftMax = 0;
		for (int i=0; i<N; i++) {
			int num = arr[i];
			maxL[i][0] = leftMax;
			maxL[i][1] = freq[leftMax];
			
			if (num > leftMax) {
				leftMax = num;
			}
			
			freq[num] ++;
			
		}
		
		freq = new int[MM];
		int rightMax = 0;
		for (int i=N-1; i>=0; i--) {
			int num = arr[i];
			maxR[i][0] = rightMax;
			maxR[i][1] = freq[rightMax];
			
			if (num > rightMax) {
				rightMax = num;
			}
			
			freq[num] ++;
			
		}
		
		for (int i=0; i<Q; i++) {
			int a = readInt()-1, b = readInt()-1;
			if (maxL[a][0] == maxR[b][0]) {
				System.out.printf("%d %d", maxL[a][0], maxL[a][1] + maxR[b][1]);
			}
			else if (maxL[a][0] > maxR[b][0]){
				System.out.printf("%d %d", maxL[a][0], maxL[a][1]);
			}
			else if (maxL[a][0] < maxR[b][0]){
				System.out.printf("%d %d", maxR[b][0], maxR[b][1]);
			}
			
			System.out.println();
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


	
	
