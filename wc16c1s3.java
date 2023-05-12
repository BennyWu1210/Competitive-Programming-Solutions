
import java.io.*;
import java.util.*;

public class wc16c1s3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class pair implements Comparable<pair>{
		int p, c;
		
		public pair(int p, int c){
			this.c = c;
			this.p = p;
		}

		@Override
		public int compareTo(pair o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.p, o.p);
		}
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt(), m = readInt(), t = readInt();
		List<pair> a = new ArrayList<>();
		
		for (int i=0; i<n; i++) a.add(new pair(readInt(), readInt()));
		Collections.sort(a);
		
		PriorityQueue<Integer> q = new PriorityQueue();
		
		int best = 0, sum = 0;
		
		for (pair e: a) {
			if (e.p * 2 + t > m) break;
			sum += e.c;
			q.add(e.c);
			
			int limit = (m - e.p * 2) / t;
			
			while (q.size() > limit) {
				sum -= q.poll();
			}
			
			best = Math.max(best, sum);
		}
		
		System.out.println(best);
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


	
	
