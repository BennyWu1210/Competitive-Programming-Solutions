
import java.io.*;
import java.util.*;

public class dmopc21c2p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class pair{
		int a, b;
		
		public pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static void swap(int a, int b, int[] arr, int[] pos) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
		temp = pos[arr[a]];
		pos[arr[a]] = pos[arr[b]];
		pos[arr[b]] = temp;
	}
	
	static void swapB(int a, int b, int[] arr, int[] pos) {
		int temp = pos[arr[a]];
		pos[arr[a]] = pos[arr[b]];
		pos[arr[b]] = temp;
		
		
//		temp = pos[arr[a]];
//		pos[arr[a]] = pos[arr[b]];
//		pos[arr[b]] = temp;
	}
	
	static void solve(int a, int b, int N, int[] arr, int[] pos, LinkedList<pair> cmd) {
		
		int[] ans = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			ans[i] = i;
		}
		
		for (pair p: cmd) {
			swap(p.a, p.b, ans, pos);
		}
		
		for (int i=1; i<=N; i++) arr[i] = ans[i];
		
	}
	
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), Q = readInt();
		
		
		LinkedList<pair> commands = new LinkedList<pair>();
		int[] arr = new int[N+1], pos = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = i;
			pos[i] = i;
		}
		for (int i=0; i<Q; i++) {
			char c = readCharacter();
			
			if (c == 'B') {
				int a = readInt(), b = readInt();
				commands.addFirst(new pair(a, b));
				solve(a, b, N, arr, pos, commands);
				
			}
			else if (c == 'E') {
				int a = readInt(), b = readInt();
				commands.addLast(new pair(a, b));
				swap(a, b, arr, pos);
			}
			else {
				
				int[] ans = new int[N+1];
				for (int j=1; j<=N; j++) ans[pos[j]] = readInt();
				System.out.print(ans[1]);
				for (int j=2; j<=N; j++) System.out.print(" " + ans[j]);
				System.out.println();
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


	
	
