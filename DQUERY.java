
import java.io.*;
import java.util.*;

public class DQUERY {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int n, q, sqrt;
	static final int MM = 3*(int)1e4 + 4;
	static int[] arr = new int[MM], ans = new int[2*(int)1e5 + 5];
	static List<query> queries = new ArrayList();
	
	static class query implements Comparable<query>{
		int l, r, ind;
		
		public query(int l, int r, int ind) {
			this.l = l;
			this.r = r;
			this.ind = ind;
		}

		@Override
		public int compareTo(query o) {
			if (this.r / sqrt != o.r / sqrt) return this.r - o.r;
			return this.l - o.l;
		}
	}
	

	static void MO() {
		int curL = 1, curR = 0;
		int[] freq = new int[(int)1e6 + 5];
		int a = 0;
		
		for (query q: queries) {
			while (curR < q.r) {
				curR ++;
				if (freq[arr[curR]] == 0) a ++;
				freq[arr[curR]] ++;
			}
			
			while (curL > q.l) {
				curL --;
				if (freq[arr[curL]] == 0) a ++;
				freq[arr[curL]] ++;
			}
			
			while (curL < q.l) {
				freq[arr[curL]] --;
				if (freq[arr[curL]] == 0) a --;
				curL ++;
			}
			
			
			while (curR > q.r) {
				freq[arr[curR]] --;
				if (freq[arr[curR]] == 0) a --;
				curR --;
			}
			
			ans[q.ind] = a;
		}
		
	}
	
	public static void main(String[] args) throws IOException {

		n = readInt(); sqrt = (int)Math.sqrt(n);
		
		for (int i=0; i<n; i++) arr[i] = readInt();
		
		q = readInt();
		
		for (int i=0; i<q; i++) queries.add(new query(readInt() - 1, readInt() - 1, i));
		
		Collections.sort(queries);
		MO();
		
		for (int i=0; i<q; i++) {
			System.out.println(ans[i]);
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


	
	
