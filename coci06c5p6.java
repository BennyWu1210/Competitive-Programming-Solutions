
import java.io.*;
import java.util.*;

public class coci06c5p6 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)2e5 + 5; 
	static final long MOD1 = (long)1e9 + 7, MOD2 = (long)1e9 + 9, MOD3 = (long)2035536509, BASE1 = 131, BASE2 = 97, BASE3 = 937; 
	static int ans;
	static long[] hash1 = new long[MN], hash2 = new long[MN], hash3 = new long[MN], pow1 = new long[MN], pow2 = new long[MN], pow3 = new long[MN];
	
	static long getHash(int l, int r) {
		long f = ((hash1[r] - hash1[l-1] * pow1[r-l+1] % MOD1) + MOD1) % MOD1;
		long s = ((hash2[r] - hash2[l-1] * pow2[r-l+1] % MOD2) + MOD2) % MOD2;
		long a = ((hash3[r] - hash3[l-1] * pow3[r-l+1] % MOD3) + MOD3) % MOD3;
		return f * MOD1 + s * MOD2 + a;
	}
	
	public static void main(String[] args) throws IOException {

		int n = readInt();
		char[] s = readLine().toCharArray();
		List<Integer>[] indices = new ArrayList[26];
		for (int i=0; i<26; i++) indices[i] = new ArrayList();
		
		pow1[0] = 1;
		pow2[0] = 1;
		pow3[0] = 1;
		
		for (int i=1; i<=s.length; i++) {
			hash1[i] = (hash1[i-1] * BASE1 + s[i-1]) % MOD1;
			hash2[i] = (hash2[i-1] * BASE2 + s[i-1]) % MOD2;
			hash3[i] = (hash3[i-1] * BASE3 + s[i-1]) % MOD3;
			pow1[i] = pow1[i-1] * BASE1 % MOD1;
			pow2[i] = pow2[i-1] * BASE2 % MOD2;
			pow3[i] = pow3[i-1] * BASE3 % MOD3;
			
			indices[s[i-1] - 'a'].add(i);
		}
		
		
		
		
		for (int i=0; i<26; i++) {
			int l = 0, r = n, len = 0;
			if (indices[i].size() == 0) continue;
			
			while (l <= r) {
				int mid = (l + r) / 2;
				boolean hasAns = false;
				Set<Long> hashes = new HashSet();
				outer: for (int j=0; j<indices[i].size(); j++) {
					int ind = indices[i].get(j);
					if (ind + mid - 1 > s.length) continue;
					long id = getHash(ind, ind + mid - 1);
					if (hashes.contains(id)) {
						hasAns = true;
						len = mid;
						break outer;
					} 
					
					hashes.add(id);
				}
				
				if (hasAns) {
					l = mid + 1;
					len = mid;
				} else {
					r = mid - 1;
				}
			}
			ans = Math.max(ans, len);
		}
		
		System.out.println(ans);
		
		
		
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


	
	
