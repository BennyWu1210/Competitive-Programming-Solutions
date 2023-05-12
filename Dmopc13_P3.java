import java.io.*;
import java.util.*;
public class Dmopc13_P3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ipt = readLine().split(" ");
		int N = Integer.parseInt(ipt[0]);
		int H = Integer.parseInt(ipt[1]);
		//System.out.println(N + " " + H);
		
		
		int[][] inputs = new int[N][N];
		LinkedList<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][N];
		long startTime = System.nanoTime();
		
		
		for (int i=0; i<N; i++) {  // Storing inputs
			String[] ipt1 = readLine().split(" ");
			for (int j=0; j<N; j++) {
				//System.out.println(Integer.parseInt(ipt1[j]));
				inputs[i][j] = Integer.parseInt(ipt1[j]);
			}
		}
		
		
		queue.add(new int[]{0,0});
		boolean reached = false;
		// Perform BFS
		visited[0][0] = true;
		
		
		while (!queue.isEmpty()) {
			//for(int[] a: queue) System.out.println(a[0] + " " + a[1]);
			//System.out.println("hi");
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			int num = inputs[x][y];
			
			//System.out.println(pos[0] + " " + pos[1]);
			
			
			if (x > 0) {
				if (Math.abs(inputs[x-1][y] - num) <= H && !visited[x-1][y]) {
					queue.add(new int[]{x-1,y});
					visited[x-1][y] = true;
				}
				
			}
			if (x < N-1) {
				if (Math.abs(inputs[x+1][y] - num) <= H && !visited[x+1][y]) {
					queue.add(new int[]{x+1,y});
					visited[x+1][y] = true;
				}
				
			}
			if (y > 0) {
				if (Math.abs(inputs[x][y-1] - num) <= H && !visited[x][y-1]) {
					queue.add(new int[]{x,y-1});
					visited[x][y-1] = true;
				}
				
			}
			if (y < N-1) {
				if (Math.abs(inputs[x][y+1] - num) <= H && !visited[x][y+1]) {
					queue.add(new int[]{x,y+1});
					visited[x][y+1] = true;
				}
				
			}
			
//			if ((System.nanoTime() - startTime)/1000000000 > 4) {
//				break;
//			}
			
			if (x==N-1 && y==N-1) {
				//System.out.println("reached");
				reached = true;
				queue.clear();
				break;
			}
			
			
		}
		
		if (reached) {
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
