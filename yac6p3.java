
import java.io.*;
import java.util.*;

public class yac6p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static void guess(int X, int Y) {
		System.out.println("? " + X + " " + Y);
		System.out.flush();
	}
	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();
		int[] ans1 = {-1, 1}, ans2 = {-1, 1};
		
		if (M != 1) throw new AssertionError();
		
		int guess1 = N / 2;
		guess(guess1, M);
		int res1 = readInt();
		
		int guess2 = N / 2 + 1;
		guess(guess2, M);
		int res2 = readInt();
		
		
		if (res1 > res2) {
			ans1[0] = guess1 + res1;
		} else if (res1 < res2){
			ans1[0] = guess1 - res1;
		} else {
			ans1[0] = guess1 - res1;
			ans2[0] = guess2 + res2;
			System.out.println("! " + ans1[0] + " " + ans1[1] + " " + ans2[0] + " " + ans2[1]);
			return;
		}
		
		int guess3 = 1;
		guess(guess3, M);
		int res3 = readInt();
		if (guess3 + res3 != ans1[0]) {
			ans2[0] = guess3 + res3;
		} else {
			int guess4 = N;
			guess(guess4, M);
			int res4 = readInt();
			ans2[0] = guess4 - res4;
		}
		
		System.out.println("! " + ans1[0] + " " + ans1[1] + " " + ans2[0] + " " + ans2[1]);
		
		
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


	
	
