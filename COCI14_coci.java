
import java.io.*;
import java.util.*;
public class COCI14_coci {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	
	public static int query(int x1, int y1, int x2, int y2, int[][] arr) {
		return arr[x2][y2] - arr[x1-1][y2] - arr[x2][y1-1] + arr[x1-1][y1-1];
				
	}
	public static void main(String[] args) throws IOException{
		// Use a 2d matrix, pos (x, y) representing the scores of round 1 and 2 respectively
		// Count the number of contestants smaller than contestant(x, y), they are all ahead 
		// The rest is behind (x, y), other than [(x, 650), (x, 0)] and [(0, 650), (0, y)]
		// Calculate (x, y) place based on this information


		int[][] matrix = new int[650+2][650+2];
		int[][] diff = new int[650+3][650+3];

		int N = readInt();
		int[][] pos = new int[N][2];

		for(int i=0; i<N; i++) {
			int A = readInt();
			int B = readInt();
			pos[i] = new int[] {A+1, B+1};
			diff[A+1][B+1] ++;

		}


		for(int i=1; i<=651; i++) {
			for(int j=1; j<=651; j++) {
				matrix[i][j] = diff[i][j] + matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1];
			}
		}


		for(int[] p: pos) {
			int a = p[0];
			int b = p[1];
			

			
			int worst = N - matrix[a-1][b-1];
			int best = query(a+1, b+1, 651, 651, matrix)+1;
			if (a == 651) worst -= query(1, b, 1, b, matrix);
			if (b == 651) worst -= query(a, 1, a, 1, matrix);
			System.out.println(best + " " + worst);

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
