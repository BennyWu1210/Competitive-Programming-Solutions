
import java.io.*;
import java.util.*;

public class cco17p5 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)2e5 + 5;
	static Pair[] arr = new Pair[MN];
	static int[] freq = new int[MN]; static long[] psa = new long[MN];
	static List<Integer>[] adj = new ArrayList[MN];
	static int N;
	
	static class Pair implements Comparable<Pair>{
		int a, b;
		public Pair(int a, int b) {
			this.a = a; this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.a - o.a;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		
		N = readInt();
		for (int i=0; i<=N; i++) adj[i] = new ArrayList();
		
		for (int i=1; i<=N; i++) {
			int a = readInt(), b = readInt();
			arr[i] = new Pair(a, b);
			freq[a] ++;
			adj[a].add(b);
		}
		
		for (int i=1; i<=N; i++) psa[i] = psa[i-1] + freq[i-1];
		
		Arrays.sort(arr, 1, N + 1);
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		long cost = 0; int taken = 0;
		for (int i=N; i>=1; i--) {
			for (int num: adj[i]) pq.add(num);
			
			long rem = i - psa[i] - taken;
						
			while (rem > 0) {
				cost += pq.poll();
				rem --;
				taken ++;
			}
		}
		
		System.out.println(cost);
		
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


	
	
