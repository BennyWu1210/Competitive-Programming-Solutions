
import java.io.*;
import java.util.*;
public class DMPG_15S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		// Use 2D prefix sum array (diff)
		
		int N = readInt();
		int M = readInt();
		boolean[][] diff = new boolean[N+1][N+1];
		
		
		for(int i=0; i<M; i++) {
			int x = readInt();
			int y = readInt();
			int w = readInt();
			int h = readInt();
			
			int x2 = x+w-1;
			int y2 = y+h-1;
			
			diff[x][y] = !diff[x][y];
			diff[x][y2+1] = !diff[x][y2+1];
			diff[x2+1][y] = !diff[x2+1][y];
			diff[x2+1][y2+1] = !diff[x2+1][y2+1];

		}

		
		// Recover
		
		boolean[][] arr = new boolean[N][N];
		int counter = 0;
		
		
		arr[0][0] = diff[0][0];
		
		if (arr[0][0]) {
			counter ++;
		}
		
		for(int i=1; i<N; i++) { // First row and column
			arr[0][i] = arr[0][i-1] ^ diff[0][i];
			arr[i][0] = arr[i-1][0] ^ diff[i][0];
			if (arr[0][i]) {
				counter ++;
			}
			
			if (arr[i][0]) {
				counter ++;
			}
		}
		
		
		for(int r=1; r<N; r++) {
			for(int c=1; c<N; c++) {
				arr[r][c] = diff[r][c] ^ arr[r-1][c] ^ arr[r][c-1]  ^ arr[r-1][c-1];
				if (arr[r][c]) {
					counter ++;
				}
			}
		}
		// for(int[] d: arr) System.out.println(Arrays.toString(d));
		System.out.println(counter);
		
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
