
import java.io.*;
import java.util.*;

public class ccc14s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = 52;
	static int N, res;
	static int[][] pos = new int[MN][2];
	static double[][] dist = new double[MN][MN];
	static HashMap<Double, Integer> dp = new HashMap();
	
	static double getDist(int x1, int y1, int x2, int y2) {
		double xDif = x1 - x2, yDif = y1 - y2;
		return Math.sqrt(xDif * xDif + yDif * yDif);
	}
	
	static int solve(int x, int y, int ind, double max) {
		if (dp.containsKey(ind * 9 + max)) return dp.get(ind * 9 + max);
		int ans = 0;
		boolean hasAns = false;
		for (int i=1; i<=N; i++) {
			if (i == ind) continue;
			double dist = getDist(pos[ind][0], pos[ind][1], pos[i][0], pos[i][1]);
			if (dist < max) {
				ans = Math.max(ans, solve(pos[i][0], pos[i][1], i, dist));
				hasAns = true;
			}
		}
		
		if (!hasAns) return 0;
		else {
			dp.put(ind * 9 + max, ans + 1);
			return ans + 1;
		}
	}
	
	public static void main(String[] args) throws IOException {

		N = readInt();
		for (int i=1; i<=N; i++) {
			pos[i][0] = readInt(); pos[i][1] = readInt();
			dist[0][i] = getDist(0, 0, pos[i][0], pos[i][1]);
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (i == j) dist[i][j] = Integer.MAX_VALUE;
				else dist[i][j] = getDist(pos[i][0], pos[i][1], pos[j][0], pos[j][1]);
			}
		}
		
		res = solve(0, 0, 0, Integer.MAX_VALUE);
		System.out.println(res);
		
		
		
		
		
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


	
	
