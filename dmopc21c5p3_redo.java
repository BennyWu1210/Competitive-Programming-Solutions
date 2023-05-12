
import java.io.*;
import java.util.*;

public class dmopc21c5p3_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 5;
	static boolean[] prime = new boolean[MN];
	static int[] win = new int[MN];
	static int[] loss = new int[MN];

	static void init() {
		for (int i=2; i<MN; i++) prime[i] = true;
		for (int i=2; i*i<MN; i++) {
			if (prime[i]) {
				for (int j=i*i; j<MN; j+=i) prime[j] = false;
			}
		}

		int ind = -1;
		List<Integer> losses = new ArrayList();
		losses.add(1); losses.add(2);
		loss[1] = 1; loss[2] = 2;
		
		for (int i=3; i<MN; i++) {
			if (prime[i - 1] || prime[i - 2]) ind = i;
			boolean w = true;
			if (i != ind) {
				w = false;
				for (int j=losses.size()-1; j>=0; j--) {
					if (prime[i - losses.get(j)]) {
						w = true;
						break;
					}
				}
				if (w) ind = i;
			}
			
			win[i] = ind;
			loss[i] = losses.get(losses.size()-1);
			if (!w) losses.add(i);
			
		}
	}
	
	public static void main(String[] args) throws IOException {

		init();
		// System.out.println(Arrays.toString(win));
		// System.out.println(Arrays.toString(loss));
		
		int T = readInt();
		
		while (T --> 0) {
			int N = readInt();
			
			if (N == 1 || N == 2) {
				System.out.println(-1);
				continue;
			}

			int ind = N;
			
			while (win[ind] != ind) ind--;
				
			int i = 2, cnt = 1;
			System.out.print(1 + " ");
			while (cnt < N) {
				if (i == ind) {
					cnt ++;
					System.out.print(" " + N);
				}
				if (i != N) System.out.print(" " + i);
				i ++;
				cnt ++;
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


	
	
