import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class Dmopc20twoP2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Scanner sc = new Scanner(System.in);
		int N = readInt();
		int M = readInt();
		int[] colors = new int[N];
		for (int i=0; i<N; i++) {
			colors[i] = readInt();
		}
		
		int max = 0;
		for (int i=0; i<M; i++) {
			int a = readInt();
			int b = readInt();
			//System.out.println(a + " " + b);
			for (int j=0; j<N; j++) {
				boolean ended = false;
				if (a == colors[j]) {
					for (int k=j; k<N; k++) {
						if (colors[k] == b) {
							ended = true;
							if (k-j+1 > max) {
								max = k-j+1;
							}
								
							break;
						}
					}
				}
				if (ended) {
	
					
					break;
				}
			}
			
		}
//		for (int i=0; i<M; i++) {
//			int a = readInt();
//			int b = readInt();
//			if (b>=a && b<=N && b-a+1 > max) {
//				max = b-a+1;
//			}
//		}
		System.out.println(max);
		
		
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
