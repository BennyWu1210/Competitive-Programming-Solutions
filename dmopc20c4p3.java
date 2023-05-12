import java.io.*;
import java.util.*;

public class dmopc20c4p3{
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;

	static final int MN = 2*(int)1e5 + 5;
	static int n, m;
	static int[] bit = new int[2*MN];
	static List<Event> events = new ArrayList();
	static List<Integer> ys = new ArrayList();
	static Map<Integer, Integer> map = new HashMap();
	
	static class Event implements Comparable<Event>{
		int x, y, type;
		public Event(int x, int y, int type) {
			this.x = x; this.y = y; this.type = type;
		}
		@Override
		public int compareTo(Event o) {
			if (this.x != o.x) return this.x - o.x;
			return o.type - this.type;
		}
	}
	
	static void update(int ind, int v) {
		for (int i=ind; i<bit.length; i+=i&-i) bit[i] += v;
	}
	
	static int query(int ind) {
		int ret = 0;
		for (int i=ind; i>0; i-=i&-i) ret += bit[i];
		return ret;
	}
	
	static long solve() {
		long ans = 0;
		for (Event e: events) {
			e.y = map.get(e.y);
			if (e.type == 1) {
				update(e.y, -1);
			} else {
				ans += query(e.y);
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		n = readInt(); m = readInt();
		
		for (int i=0; i<n; i++) {
			int x = readInt(), y = readInt();
			events.add(new Event(x, y, 1));
			ys.add(y);
		}
		
		for (int i=0; i<m; i++) {
			int x = readInt(), y = readInt();
			events.add(new Event(x, y, 2));
			ys.add(y);
		}
		
		Collections.sort(ys);
		int val = 1, prev = -1;
		
		for (int i=0; i<ys.size(); i++) {
			int cur = ys.get(i);
			if (cur == prev) continue;
			else {
				prev = cur;
				map.put(cur, val++);
			}
		}
		
		for (int i=0; i<events.size(); i++) {
			if (events.get(i).type == 1) update(map.get(events.get(i).y), 1);
		}
		
		Collections.sort(events);
		long ans = solve();
		System.out.println(ans);
		
		

	}
	
	static String next() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
	
}