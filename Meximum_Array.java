
import java.io.*;
import java.util.*;

public class Meximum_Array {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static void update(int ind, int[] bit) {
		ind ++;
		for (int i=ind; i<bit.length; i+=i&-i) {
			bit[i] += 1;
		}
	}
	
	static int query(int ind, int[] bit) {
		ind ++;
		int res = 0;
		for (int i=ind; i>0; i-=i&-i) {
			res += bit[i];
		}
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int n = readInt();
			int[] a = new int[n+1];
			int[] freq = new int[n+1], temp_freq = new int[n+1];
			int[] bit = new int[n+10];
			
			for (int i=1; i<=n; i++) {
				a[i] = readInt();
				freq[a[i]] ++;
			}
			
			int ans = 0, nxt = 0;
			List<Integer> res = new ArrayList();
			
			for (int i=1; i<=n; i++) {
				if (a[i] == ans) {
					int l = a[i] + 1, r = n;
					while (l <= r) {
						int mid = (l + r) / 2;
						if (query(mid, bit) == mid) {
							l = mid + 1;
						} else {
							r = mid - 1;
							ans = mid;
						}
					}
					
				}
				
				
				freq[a[i]] --;

				if (freq[ans] == 0) {
					res.add(ans);
					ans = 0;
					temp_freq = new int[n+1];
					bit = new int[n+10];
				} else {
					if (temp_freq[a[i]] == 0) {
						update(a[i], bit);
					}
					temp_freq[a[i]] ++;
				}
				
			}
			
			System.out.println(res.size());
			for (int j=0; j<res.size()-1; j++) {
				System.out.print(res.get(j) + " ");
			}
			System.out.println(res.get(res.size()-1));
			
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


	
	
