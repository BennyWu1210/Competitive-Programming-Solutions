
import java.io.*;
import java.util.*;

public class CCC16S3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static int N, M;
	static ArrayList<Integer>[] adj;
	static int[] min;
	static int[] dest;
	static LinkedList<int[]> queue;
	static int ans;
	static boolean[] arrived;
	static int arrCount = 0;

	
	static void bfs(int start, int v, boolean[][] visited) {
		for(int next: adj[v]) {
			if (!visited[start][next] && min[next] != -1) {
				if (!arrived[start]) {
					arrived[start] = true;
					arrCount ++;
					ans += min[v];
					System.out.println("whooo " + (min[v]));
				}
				min[next] = Math.min(min[next], min[v]+1);
				visited[start][next] = true;
			}
			else if(!visited[start][next]) {
				min[next] = min[v] + 1;
				queue.add(new int[] {start, next});
				visited[start][next] = true;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println(false | false);
		N = readInt();
		M = readInt();
		ans = 0;
		adj = new ArrayList[N];
		min = new int[N];
		queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<Integer>();
		}
		Arrays.fill(min, -1);
		
		dest = new int[M];
		arrived = new boolean[N];
		
		for(int i=0; i<M; i++) {
			dest[i] = readInt();
			queue.add(new int[] {dest[i], dest[i]});
			visited[dest[i]][dest[i]] = true;
			min[dest[i]] = 0;
		}
		
		for(int i=0; i<N-1; i++) {
			int bv = readInt(), ev = readInt();
			adj[bv].add(ev);
			adj[ev].add(bv);
		}
		
		
		while(!queue.isEmpty()) {
			int[] next = queue.poll();
			System.out.println(next[1]);
			if(arrCount == M) break;
			
			bfs(next[0], next[1], visited);
		}
		
		System.out.println(Arrays.deepToString(visited));
		System.out.println(Arrays.toString(arrived));
		System.out.println(ans + (M-1));
		
		
		
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


	
	
