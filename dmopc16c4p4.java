
import java.io.*;
import java.util.*;

public class dmopc16c4p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = (int)1e5 + 5, sqrt = 317; 
	static int[] arr = new int[MM], freq = new int[MM], res = new int[MM];
	static List<Query> queries = new ArrayList();
	
	static class Query implements Comparable<Query>{
		int l, r, ind;
		public Query(int l0, int r0, int ind0) {l=l0; r=r0; ind=ind0;}
		@Override
		public int compareTo(Query o) {
			if (l / sqrt != o.l / sqrt) return l - o.l;
			return (l / sqrt) % 2 == 0 ? r - o.r : o.r - r;
		};
	}
	
	static void MO() {
		int l = 1, r = 0, ans = 0;
		
		for (Query q: queries) {
			while (r < q.r) {
				r ++;
				freq[arr[r]] ++;
				if (freq[arr[r]] % 2 == 0) ans ++; 
				else if (freq[arr[r]] != 1) ans --;
			}
			while (l > q.l) {
				l --;
				freq[arr[l]] ++;
				if (freq[arr[l]] % 2 == 0) ans ++;
				else if (freq[arr[l]] != 1) ans --;
			}
			while (r > q.r) {
				if (freq[arr[r]] % 2 == 0) ans --;
				else if (freq[arr[r]] != 1) ans ++;
				freq[arr[r]] --;
				r --;
			}
			while (l < q.l) {
				if (freq[arr[l]] % 2 == 0) ans --;
				else if (freq[arr[l]] != 1) ans ++;
				freq[arr[l]] --;
				l ++;
			}
			
			res[q.ind] = ans;
		}
		
	}
	public static void main(String[] args) throws IOException {

		int N = readInt();
		for (int i=1; i<=N; i++) arr[i] = readInt();
		
		int Q = readInt();
		for (int i=1; i<=Q; i++) {
			int l = readInt(), r = readInt();
			queries.add(new Query(l, r, i));
		}
		
		Collections.sort(queries);
		MO();
		
		for (int i=1; i<=Q; i++) System.out.println(res[i]);
		
		
	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) {
			stk = new StringTokenizer(br.readLine());
		}
		return stk.nextToken();
	}
	
	static int readInt() throws NumberFormatException, IOException {
		return Integer.parseInt(next());
	}
}


	
	
