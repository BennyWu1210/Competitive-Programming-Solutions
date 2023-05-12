
import java.io.*;
import java.util.*;

public class dmopc22c4p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static long[][] rotate(long[][] arr, int N, int M) {

		long[][] temp_arr = new long[M][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_arr[j][N - i - 1] = arr[i][j];
			}
		}

		return temp_arr;
	}

	public static long[][] hFlip(long[][] arr, int N, int M) {
		long[][] temp_arr = new long[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_arr[i][j] = arr[N - i - 1][j];
			}
		}

		return temp_arr;
	}

	public static long[][] vFlip(long[][] arr, int N, int M) {
		long[][] temp_arr = new long[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				temp_arr[i][j] = arr[i][M - j - 1];
			}
		}

		return temp_arr;
	}

	public static boolean check(long[][] arr, int N, int M) {
		// doesn't need to check the entire array (TODO)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
//					System.out.println(
//							arr[i][j] + " " + 
//							arr[i][M - j - 1] + " " + 
//							arr[N - i - 1][M - j - 1] + " " + 
//							arr[N - i - 1][j]);

				if (i == N - i - 1 && j == M - j - 1) {
					if (arr[i][j] % 2 == 0) {
						continue;
					}
					return false;
				} else if (i == N - i - 1) {
					if ((arr[i][j] + arr[i][M - j - 1]) % 2 == 0) {
						continue;
					}
					return false;
				} else if (j == M - j - 1) {
					if ((arr[i][j] + arr[N - i - 1][j]) % 2 == 0) {
						continue;
					}
					return false;
				}

//					long diff = -arr[i][j];
//					
//					
//					arr[i][j] = 0;
//					arr[i][M - j - 1] += diff;
//					
//					
//					diff = -arr[i][M - j - 1];
//					arr[i][M - j - 1] = 0;
//					arr[N - i - 1][M - j - 1] += diff;
//					
//					
//					diff = -arr[N - i - 1][M - j - 1];
//					arr[N - i - 1][M - j - 1] = 0;
//					arr[N - i - 1][j] += diff;
//					
//					
//					if (arr[N - i - 1][j] != 0) {
//						return false;
//					}

				long upper = arr[i][j] + arr[N - i - 1][M - j - 1];
				long lower = arr[N - i - 1][j] + arr[i][M - j - 1];

				
				if (upper != lower) {
					return false;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {

		int N = readInt(), M = readInt();

		long[][] A = new long[N][M], T = new long[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				A[i][j] = readInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				T[i][j] = readInt();
			}
		}

//		for (int i = 0; i < 4; i++) {
//			
//			T = rotate(T, T.length, T[0].length);
//			
//			if (N != M && i % 2 == 0) continue;
//			
//			long[][] rotated = new long[N][M];
//			for (int x = 0; x < N; x++) {
//				for (int y = 0; y < M; y++) {
//					rotated[x][y] = T[x][y] - A[x][y];
//				}
//			}
//			
////			System.out.println(Arrays.deepToString(rotated));
//			
//			if (check(rotated, N, M)) {
//				System.out.println("YES");
//				return;
//			}
//			
//			long[][] flipped = new long[N][M];
//			flipped = hFlip(T, T.length, T[0].length);
//			for (int x = 0; x < N; x++) {
//				for (int y = 0; y < M; y++) {
//					flipped[x][y] -= A[x][y];
//				}
//			}
//			
//			if (check(flipped, N, M)) {
//				System.out.println("YES");
//				return;
//			}
//		}

		long[][] hFlipped = hFlip(T, N, M);
		long[][] vFlipped = vFlip(T, N, M);
		long[][] flipped2 = vFlip(hFlipped, N, M);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				T[i][j] = A[i][j] - T[i][j];
				hFlipped[i][j] = A[i][j] - hFlipped[i][j];
				vFlipped[i][j] = A[i][j] - vFlipped[i][j];
				flipped2[i][j] = A[i][j] - flipped2[i][j];
			}
		}
		if (check(T, N, M)) {
			System.out.println("YES");
			return;
		}

		if (check(hFlipped, N, M)) {
			System.out.println("YES");
			return;
		}

		if (check(vFlipped, N, M)) {
			System.out.println("YES");
			return;
		}

		if (check(flipped2, N, M)) {
			System.out.println("YES");
			return;
		}

//		System.out.println(Arrays.deepToString(T));
//		System.out.println(Arrays.deepToString(hFlipped));
//		System.out.println(Arrays.deepToString(vFlipped));
//		System.out.println(Arrays.deepToString(flipped2));
		System.out.println("NO");
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
