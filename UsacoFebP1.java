import java.util.*;
import java.io.*;

public class UsacoFebP1{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static final int MN = 505;
	static int N;
	static int[][] cow = new int[MN][MN];
	static int[] pos = new int[MN], gift = new int[MN], ans = new int[MN];
	static boolean[] take = new boolean[MN], cont = new boolean[MN];

	static boolean solve(int c, int i, boolean[] inStack, boolean first) {
		// System.out.println(c + " " + i);
		if (!take[cow[c][i]]) {
			// System.out.println("Not taken!");
			take[cow[c][i]] = true;
			pos[c] = i;
			gift[cow[c][i]] = c;
			return true;
		}

		for (int j=i-1; j>=1; j--) {
			int new_ind = i - j;
			// System.out.println(new_ind);
			// System.out.println("cow: " + gift[cow[c][new_ind]]);
			if (inStack[gift[cow[c][new_ind]]]) continue;

			//			take[cow[c][i]] = false;
			//			pos[c] = new_ind;
			//			take[cow[c][new_ind]] = true;

			if (first) {
				take[cow[c][i]] = false;
				pos[c] = new_ind;
				gift[cow[c][i]] = 0;
			}
			else inStack[c] = true;
			// System.out.println(cow[c][new_ind]);

			if (gift[cow[c][new_ind]] == 0) {
				pos[c] = new_ind;
				gift[cow[c][new_ind]] = c;
				return true;
			}

			boolean res = solve(gift[cow[c][new_ind]], pos[gift[cow[c][new_ind]]], inStack, false);
			if (res) {
				pos[c] = new_ind; 
				gift[cow[c][new_ind]] = c;
				return true;
			}
			if (first) {
				take[cow[c][i]] = true;
				pos[c] = i;
				gift[cow[c][i]] = c;
			}
			inStack[c] = false;
			//			take[cow[c][i]] = true;
			//			pos[c] = i;
		}

		// System.out.println("No ans!");
		return false;

	}

	public static void main(String[] args) throws IOException{
		N = readInt();

		for (int i=1; i<=N; i++) {
			int ind = -1;
			for (int j=1; j<=N; j++) {
				cow[i][j] = readInt();
				if (cow[i][j] == i) ind = j;
			}
			pos[i] = ind;
			//			gift[i] = i;
			//			take[i] = true;
		}
		
		boolean ok = true;
		while (ok) {
			boolean[] taken = new boolean[N+1];
			for (int i=1; i<=N; i++) {
				for (int j=1; j<=pos[i]; j++) {
					if (!taken[cow[i][j]]) {
						ans[i] = cow[i][j];
						taken[cow[i][j]] = true;
						break;
					}
				}
				if (ans[i] == 0) ok = false;
			}
			
			
		}

		for (int i=1; i<=N; i++) System.out.println(ans[i]);



	}

	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}

	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}
/*
5
1 2 3 4 5
2 1 3 5 4
5 2 3 1 4
2 5 1 4 3
3 5 2 4 1

4
3 1 4 2
2 3 1 4
1 4 2 3
2 1 3 4

 */