
import java.io.*;
import java.util.*;


public class Ctuopen2017a {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}

			// System.out.println(Arrays.toString(arr));

			int index = 1;
			int diff = (int)1e9+10;
			int ans = 1;
			while(index < N) {
				if (arr[index] - arr[index-1] != diff) {
					diff = arr[index] - arr[index-1];
					ans = index;
				}
				index ++;
			}
			
			System.out.println(ans);
			if (!sc.hasNextLine()) {
				break;
			}
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




