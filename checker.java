
import java.io.*;
import java.util.*;

public class checker {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int MM = 3005;
	static void update(int x, int y, long val, long[][] bit) {
		for (int i=x; i<MM; i+=i&-i) {
			for (int j=y; j<MM; j+=j&-j) {
				bit[i][j] += val;
			}
		}
	}

	static long getSum(int x, int y, long[][] bit) {
		long sum = 0;

		for (int i=x; i>0; i-=i&-i) {
			for (int j=y; j>0; j-=j&-j) {
				sum += bit[i][j];
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {

		int M = readInt(), N = readInt();

		long[][] bit = new long[MM][MM];
		long[][] mat = new long[MM][MM];


		while (true) {
			int cmd = readInt();

			if (cmd == 0) break;
			if (cmd == 1) {
				int r = readInt(), c = readInt(), x = readInt();

				if ((r + c) % 2 == 0) {
					update(r, c, - mat[r][c] + x, bit);
					mat[r][c] = x;
				}
				else {
					update(r, c, - mat[r][c] - x, bit);
					mat[r][c] = -x;
				}

			}
			else {
				int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();

				long res = getSum(r2, c2, bit) - getSum(r2, c1-1, bit) 
						- getSum(r1-1, c2, bit) + getSum(r1-1, c1-1, bit);
				
				if ((r1 + c1) % 2 == 0) {
					System.out.println(res);
				}
				else {
					System.out.println(-res);
				}
			}
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




