
import java.io.*;
import java.util.*;

public class ccc09s4_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void dijkstra(int[][] dist, int[] step) {
		int N = step.length - 1;
		boolean[] checked = new boolean[N + 1];
		
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			int index = -1;
			
			for (int j = 1; j <= N; j++) {
				if (!checked[j] && step[j] < min) {
					min = step[j];
					index = j;
				}
			}
			
			if (index == -1) break;
			
			checked[index] = true;
			
			for (int j = 1; j <= N; j++) {
				if (!checked[j] && step[j] > step[index] + dist[index][j]) {
					step[j] = step[index] + dist[index][j];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), T = readInt();;
		int[][] dist = new int[N + 1][N + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = Integer.MAX_VALUE / 2;
			}
		}
		
		for (int i = 0; i < T; i++) { 
			int u = readInt(), v = readInt(), c = readInt();
			dist[u][v] = dist[v][u] = c;
		}
		
		int K = readInt();
		int[] pencilCost = new int[N + 1];
		Arrays.fill(pencilCost, Integer.MAX_VALUE / 2);
		
		for (int i = 0; i < K; i++) {
			int u = readInt(), c = readInt();
			pencilCost[u] = c;
		}
		
		int dest = readInt();
		int[] step = new int[N + 1];
		Arrays.fill(step, Integer.MAX_VALUE / 2);
		step[dest] = 0;
		
		dijkstra(dist, step);
		int ans = Integer.MAX_VALUE;
		
		for (int i = 1; i <= N; i++) {
			ans = Math.min(ans, step[i] + pencilCost[i]);
		}

		System.out.println(ans);
		
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


	
	
