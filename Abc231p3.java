
import java.io.*;
import java.util.*;

public class Abc231p3 {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		int[] a = new int[N];
		
		for (int i=0; i<N; i++) {
			a[i] = readInt();
		}
		
		Arrays.sort(a);
		
		for (int i=0; i<Q; i++) {
			int n = readInt();
			int ans = Arrays.binarySearch(a, n);
			if (ans < 0) ans = - ans - 1;
			System.out.println(N - ans);
		}
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine().trim());
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
	
}


	
	
