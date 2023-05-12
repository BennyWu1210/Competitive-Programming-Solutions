
import java.io.*;
import java.util.*;

public class ccc18s3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 102;
	static char[][] mat = new char[MN][MN];
	static int N, M;
	static int[][] steps = new int[MN][MN];
	static boolean[][] checked = new boolean[MN][MN];
	
	static int[] getDir(char c) {
		if (c == 'U') return new int[] {-1, 0};
		if (c == 'D') return new int[] {1, 0};
		if (c == 'L') return new int[] {0, -1};
		if (c == 'R') return new int[] {0, 1};
		return new int[] {0, 0};
	}
	
	static int getNum(char c) {
		if (c == 'U') return 1;
		if (c == 'D') return 2;
		if (c == 'L') return 3;
		if (c == 'R') return 4;
		return -1;
	}

	static void dfs(int i, int j, char dir) {
		if (getNum(mat[i][j]) == -1) mat[i][j] = 'Z';
		
		int[] d = getDir(dir);
		i += d[0]; j += d[1];
		
		if (mat[i][j] == 'W' || checked[i][j]) return;
		dfs(i, j, dir);
	}
	
	static boolean notWall(int i, int j) {
		return mat[i][j] != 'W' && mat[i][j] != 'Z';
	}
	
	public static void main(String[] args) throws IOException {
		
		N = readInt(); M = readInt();
		List<int[]> cameras = new ArrayList();
		List<int[]> empty = new ArrayList();
		
		int[] start = new int[2];
		for (int i=1; i<=N; i++) {
			char[] ipt = readLine().toCharArray();
			for (int j=1; j<=M; j++) {
				mat[i][j] = ipt[j-1];
				if (mat[i][j] == 'C') cameras.add(new int[] {i, j});
				if (mat[i][j] == 'S') start = new int[] {i, j};
				if (mat[i][j] == '.') empty.add(new int[] {i, j});
			}
		}
		
		for (int[] pos: cameras) {
			int i = pos[0], j = pos[1];
			checked[i][j] = true;
			dfs(i, j, 'U');
			dfs(i, j, 'D');
			dfs(i, j, 'L');
			dfs(i, j, 'R');
			
		}
		
		if (mat[start[0]][start[1]] == 'Z') {
			for (int i=0; i<empty.size(); i++) System.out.println(-1);
			return;
		}
		
		Deque<int[]> queue = new LinkedList();
		queue.add(start);
		for (int i=1; i<=N; i++) Arrays.fill(steps[i], Integer.MAX_VALUE);
		steps[start[0]][start[1]] = 0;
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cur_i = cur[0], cur_j = cur[1];
			int nxt_i, nxt_j;
			
			if (mat[cur_i][cur_j] == '.' || mat[cur_i][cur_j] == 'S') {
				// Up
				int[] dir = getDir('U');
				nxt_i = cur[0] + dir[0]; nxt_j = cur[1] + dir[1];
				if (notWall(nxt_i, nxt_j) && steps[nxt_i][nxt_j] > steps[cur_i][cur_j] + 1) {
					steps[nxt_i][nxt_j] = steps[cur_i][cur_j] + 1;
					queue.add(new int[] {nxt_i, nxt_j});
				}
				
				// Down
				dir = getDir('D');
				nxt_i = cur[0] + dir[0]; nxt_j = cur[1] + dir[1];
				if (notWall(nxt_i, nxt_j) && steps[nxt_i][nxt_j] > steps[cur_i][cur_j] + 1) {
					steps[nxt_i][nxt_j] = steps[cur_i][cur_j] + 1;
					queue.add(new int[] {nxt_i, nxt_j});
				}
				
				// Left
				dir = getDir('L');
				nxt_i = cur[0] + dir[0]; nxt_j = cur[1] + dir[1];
				if (notWall(nxt_i, nxt_j) && steps[nxt_i][nxt_j] > steps[cur_i][cur_j] + 1) {
					steps[nxt_i][nxt_j] = steps[cur_i][cur_j] + 1;
					queue.add(new int[] {nxt_i, nxt_j});
				}
				
				// Right
				dir = getDir('R');
				nxt_i = cur[0] + dir[0]; nxt_j = cur[1] + dir[1];
				if (notWall(nxt_i, nxt_j) && steps[nxt_i][nxt_j] > steps[cur_i][cur_j] + 1) {
					steps[nxt_i][nxt_j] = steps[cur_i][cur_j] + 1;
					queue.add(new int[] {nxt_i, nxt_j});
				}
			}
			else if (getNum(mat[cur_i][cur_j]) != -1){
				int[] dir = getDir(mat[cur_i][cur_j]);
				nxt_i = cur[0] + dir[0]; nxt_j = cur[1] + dir[1];
				if (notWall(nxt_i, nxt_j) && steps[nxt_i][nxt_j] > steps[cur_i][cur_j]) {
					steps[nxt_i][nxt_j] = steps[cur_i][cur_j];
					queue.add(new int[] {nxt_i, nxt_j});
				}
			}
			
		}
		
		for (int[] pos: empty) {
			int ans;
			if (steps[pos[0]][pos[1]] == Integer.MAX_VALUE) ans = -1;
			else ans = steps[pos[0]][pos[1]];
			System.out.println(ans);
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


	
	
