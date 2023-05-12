
import java.io.*;
import java.util.*;

public class ccc17s5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MM = 150005;
	static int[] num = new int[MM], line = new int[MM], pos = new int[MM], upd = new int[MM];
	static List<Integer>[] stations = new ArrayList[MM];
	
	static void update(int x) {
		upd[x] ++;
		upd[x] %= stations[line[x]].size();
	}
	
	static int query(int l, int r) {
		int ret = 0;
		for (int i=l; i<=r; i++) {
			int nxt = ((pos[i] - upd[line[i]] + stations[line[i]].size()) % stations[line[i]].size());
			ret += num[stations[line[i]].get(nxt)];
		}
		return ret;
	}
	
	public static void main(String[] args) throws IOException {
		
		int N = readInt(), M = readInt(), Q = readInt();
		for (int i=0; i<MM; i++) stations[i] = new ArrayList();
		for (int i=0; i<N; i++) {
			int s = readInt();
			s --;
			stations[s].add(i);
			line[i] = s;
			pos[i] = stations[s].size()-1;
		}
		for (int i=0; i<N; i++) num[i] = readInt();
		for (int i=0; i<Q; i++) {
			int c = readInt();
			if (c == 1) {
				System.out.println(query(readInt()-1, readInt()-1));
			}
			else {
				update(readInt()-1);
			}
		}
		
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


	
	
