
import java.io.*;
import java.util.*;

public class CCC21j5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int R, C;
	static char[][] grid;
	static String flag;
	
	static int[] arr1 = {1, 0};
	static int[] arr2 = {0, 1};
	static int[] arr3 = {-1, 0};
	static int[] arr4 = {0, -1};
	static int[] arr5 = {1, 1};
	static int[] arr6 = {-1, -1};
	static int[] arr7 = {1, -1};
	static int[] arr8 = {-1, 1};
	static List<int[]> dir_arrays = new ArrayList();
	static Map<Integer, int[]> map = new HashMap();
	
	static boolean in_bounds(int i, int j) {
		return i >= 0 && i < R && j >= 0 && j < C;
	}
	
	static int solve(int i, int j, int count, int direction, boolean turned) {
		
		if (count == flag.length()) return 1;
		
		int ans = 0;
		
		int[] dir = dir_arrays.get(direction);
		
		int newI = i + dir[0], newJ = j + dir[1];
		if (in_bounds(newI, newJ) && grid[newI][newJ] == flag.charAt(count)) {
			ans += solve(newI, newJ, count + 1, direction, turned);
		}
		
		if (!turned && count > 1) {
			int[] ids = map.get(direction);
			
			for (int a = 0; a < 2; a++) {
				dir = dir_arrays.get(ids[a]);
				newI = i + dir[0]; newJ = j + dir[1];
				if (in_bounds(newI, newJ) && grid[newI][newJ] == flag.charAt(count)) {
					ans += solve(newI, newJ, count + 1, ids[a], true);
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		
		dir_arrays.add(arr1); dir_arrays.add(arr2); dir_arrays.add(arr3); dir_arrays.add(arr4);
		dir_arrays.add(arr5); dir_arrays.add(arr6); dir_arrays.add(arr7); dir_arrays.add(arr8);
		map.put(0, new int[] {1, 3}); map.put(1, new int[] {0, 2}); map.put(2, new int[] {1, 3}); map.put(3, new int[] {0, 2});
		map.put(4, new int[] {6, 7}); map.put(5, new int[] {6, 7}); map.put(6, new int[] {4, 5}); map.put(7, new int[] {4, 5});
		
		flag = readLine();
		
		R = readInt(); C = readInt();
		
		grid = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				grid[i][j] = readCharacter();
			}
		}
		
		int ans = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == flag.charAt(0)) {
					for (int z = 0; z < 8; z++) {
						ans += solve(i, j, 1, z, false);
					}
					
				}
			}
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


	
	
