
import java.io.*;
import java.util.*;

public class B_Integer {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {

		int T = readInt();
		
		while (T --> 0) {
			int n = readInt();
			int lMin = Integer.MAX_VALUE, rMax = Integer.MIN_VALUE, ans = 0;
			int lInd = -1, rInd = -1;
			int lLen = 0, rLen = 0;
			int lCost = 0, rCost = 0;
			
			for (int i=0; i<n; i++) {
				int l = readInt(), r = readInt(), c = readInt();
				
				if (l <= lMin && r >= rMax) {
					if (l == lMin && r == rMax) {
						if (lInd == rInd && c > lCost) continue;
						else if (c >= lCost + rCost) continue;
					}
					ans -= lCost; 
					if (lInd != rInd) ans -= rCost;
					ans += c;
					lCost = rCost = c;
					lInd = rInd = i;
					lLen = rLen = r - l + 1;
					lMin = l; rMax = r;
					System.out.println(ans);
					continue;
				}
				
				if (l < lMin) {
					if (lInd != rInd) ans -= lCost; // Where the left and right segments are not the same
					ans += c;
					lMin = l;
					lCost = c;
					lLen = (r - l + 1);
					lInd = i;
					if (r >= rMax) {
						ans -= rCost;
						rMax = r;
						rCost = c;
						rInd = i;
						rLen = (r - l + 1);
					}
				} else if (l == lMin && c < lCost && lInd != rInd) {
					if (lInd != rInd) ans -= lCost;
					ans += c;
					lMin = l;
					lCost = c;
					lInd = i;
					lLen = (r - l + 1);
					
					if (r >= rMax) {
						ans -= rCost;
						rMax = r;
						rCost = c;
						rInd = i;
						rLen = (r - l + 1);
					}
				}
				if (r > rMax) {
					if (rInd != lInd) ans -= rCost;
					ans += c;
					rMax = r;
					rCost = c;
					rInd = i;
					rLen = (r - l + 1);
					
					if (l <= lMin) {
						ans -= lCost;
						lCost = c;
						lInd = i;
						lLen = (r - l + 1);
					}
				} else if (r == rMax && c < rCost && lInd != rInd) {
					ans -= rCost;
					ans += c;
					rMax = r;
					rCost = c;
					rInd = i;
					rLen = (r - l + 1);
					
					if (l == lMin) {
						ans -= lCost;
						lCost = c;
						lInd = i;
						lLen = (r - l + 1);
					}
				}
				
				System.out.println(ans);
			}
		}
		
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}

}


	
	
