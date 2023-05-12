
import java.io.*;
import java.util.*;

public class wc18c1s3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static final int MN = (int)1e6 + 4;
	static int H, J, N;
	static boolean[] a = new boolean[MN];
	static int[] steps = new int[MN];

	public static void main(String[] args) throws IOException {

		H = readInt(); J = readInt(); N = readInt();

		Arrays.fill(a, true); Arrays.fill(steps, (int)1e9);
		for (int i=1; i<=N; i++) {
			int l = readInt(), r = readInt();
			for (int j=l; j<=r; j++) a[j] = false;
		}

		steps[0] = 0;
		Queue<Integer> q = new LinkedList();
		q.add(0);

		int covered = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();

			if (cur + J >= H) {
				System.out.println(steps[cur] + 1);
				return;
			}

			if (steps[cur + J] > steps[cur] + 1 && a[cur + J]) {
				steps[cur + J] = steps[cur] + 1;
				q.add(cur + J);
			}

			for (int i=covered; i<cur; i++) {
				if (a[i] && steps[i] > steps[cur] + 1) {
					steps[i] = steps[cur] + 1;
					q.add(i);
				}
			}
			
			covered = Math.max(covered, cur);


		}
		System.out.println(-1);


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




