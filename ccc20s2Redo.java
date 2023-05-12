import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class ccc20s2Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int M = readInt();
		int N = readInt();
		int[][] graph = new int[M][N];
		boolean[][] visited = new boolean[M][N];
		boolean[] boo = new boolean[1000001];
		
		for (int i=0; i<M; i++) {
			String[] str = readLine().split(" ");
			for (int j=0; j<N; j++) {
				graph[i][j] = Integer.parseInt(str[j]);
				//System.out.println(graph[i][j]);
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{0, 0});
		boolean gotcha = false;
		
		while (!queue.isEmpty() && !gotcha) {
			int[] coords = queue.poll();
			int x = coords[0];
			int y = coords[1];
			int num = graph[x][y];
			if (!boo[graph[x][y]]) {
				for (int i=1; i<=Math.sqrt(num); i++) {
					if (num % i==0) {
						int a = i-1;
						int b = num/i -1;
						
						if ((a == N-1 && b == M-1) || (a == M-1 && b == N-1)) {
							gotcha = true;
							break;
						}
						
						if (a != b) {
							if (a < M && b < N && !visited[a][b]){
								queue.add(new int[] {a, b});
								visited[a][b] = true;
							}
							if (a < N && b < M && !visited[b][a]){
								queue.add(new int[] {b, a});
								visited[b][a] = true;
							}
						}
						
						else {
							if (a < M && !visited[a][b]) {
								queue.add(new int[] {a, b});
								visited[a][b] = true;
							}
						}
					}
				}
			}
			if (x < M && y < N) {
				boo[graph[x][y]] = true;
			}
			else if (x < N && y < M) {
				boo[graph[y][x]] = true;
			}
		}
		
		
		if (gotcha) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
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
