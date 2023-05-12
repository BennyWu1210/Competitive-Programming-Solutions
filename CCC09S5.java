import java.io.*;
import java.util.*;
public class CCC09S5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static int M;
	public static int N;
	public static int K;
	public static int[][] arr;

	public static void query(int x1, int y1, int x2, int y2, int val) {

		arr[x1][y1] += val;
		arr[x1][y2+1] -= val;
		arr[x2+1][y1] -= val;
		arr[x2+1][y2+1] += val;


	}


	public static void main(String[] args) throws IOException{
		// Generate a 2D prefix sum array

		N = readInt();
		M = readInt();
		K = readInt();
		arr = new int[M+2][N+2];
		for(int i=0; i<K; i++) {
			int X = readInt()-1;
			int Y = readInt()-1;
			int R = readInt();
			int B = readInt();
			// Use the idea of integrals - Create rectangle sum queries
			int start = R;
			if (X-start < 0) {
				start = X+start;
			}

			for (int x=start; x>=-start; x--) {
				if (x == 0) continue;
				if (X-x < 0) continue;
				if (X-x >= M) break;

				int y = (int) (
						Math.floor(
						Math.sqrt(
						Math.pow(R, 2) - Math.pow(x, 2))
						+ 1));

				// Check if these values are within the range
				int xPos = X-x;
				int y1Pos = Y-y+1;
				int y2Pos = Y+y-1;

				if(X-x < 0) xPos = 0;
				if(X-x >= M) xPos = M-1;
				if(Y-y+1 < 0) y1Pos = 0;
				if(Y-y+1 >= N) y1Pos = N-1;
				if(Y+y-1 < 0) y2Pos = 0;
				if(Y+y-1 >= N) y2Pos = N-1;

				query(xPos, y1Pos, xPos, y2Pos, B);



			}


			// Update the middle column
			int xPos = X;
			int y1Pos = Y-R;
			int y2Pos = Y+R;
			if (y1Pos < 0)  y1Pos = 0;
			if (y1Pos >= N) y1Pos = N-1;
			if (y2Pos >= N)  y2Pos = N-1;
			if (y2Pos < 0) y2Pos = 0;
			query(xPos, y1Pos, xPos, y2Pos, B);

		}


		int highest = arr[0][0];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(arr[0][0], 1);


		for(int i=1; i<=M; i++) {
			arr[i][0] = arr[i-1][0] + arr[i][0];

			if (highest < arr[i][0]) highest = arr[i][0];
			if (map.containsKey(arr[i][0])) {
				map.put(arr[i][0], map.get(arr[i][0])+1);
			}
			else {
				map.put(arr[i][0], 1);
			}
		}
		for(int i=1; i<=N; i++) {
			arr[0][i] = arr[0][i-1] + arr[0][i];

			if (highest < arr[0][i]) highest = arr[0][i];
			if (map.containsKey(arr[0][i])) {
				map.put(arr[0][i], map.get(arr[0][i])+1);
			}
			else {
				map.put(arr[0][i], 1);
			}
		}

		for(int i=1; i<=M; i++) {
			for(int j=1; j<=N; j++) {
				arr[i][j] = arr[i][j] + arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
				if (highest < arr[i][j]) highest = arr[i][j];

				if (map.containsKey(arr[i][j])) {
					map.put(arr[i][j], map.get(arr[i][j])+1);
				}
				else {
					map.put(arr[i][j], 1);
				}
			}
		}

		System.out.println(highest);
		System.out.println(map.get(highest));




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