import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mccc4j5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = readInt();
		int[] dep = new int[N+1];
		ArrayList<Integer>[] adj = new ArrayList[N+1];
		ArrayList<Integer>[] depList = new ArrayList[N+1];
		for (int i=0; i<=N; i++) {
			adj[i] = new ArrayList<Integer>();
			depList[i] = new ArrayList<Integer>();
		}
		int[] w = new int[N+1];
		for (int i=0; i<N; i++) {
			int T = readInt();
			int R = readInt();
			w[i+1] = T;
			dep[i+1] = R;
			for (int j=0; j<R; j++) {
				int n = readInt();
				adj[n].add(i+1);
				depList[i+1].add(n);
			}
		}

		int answer = Integer.MIN_VALUE;
		int[] min = new int[N+1];
		Arrays.fill(min, 0);
		while (true) {
			boolean ok = false;
			for (int i=1; i<=N; i++) {
				if (dep[i]==0) {
					int max = 0;
					for (int j:depList[i]) {
						if (min[j]>max) {
							max = min[j];
						}
					}
					min[i]+=max+w[i];

					for (int j:adj[i]) {
						dep[j]--;
					}
					ok = true;
					dep[i] = -1;
					if (answer<min[i]) {
						answer = min[i];
					}
				}
			}
			if (ok==false) {
				break;
			}
		}

		System.out.println(answer);

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