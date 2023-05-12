
import java.io.*;
import java.util.*;

public class ioi98p4 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Event{
		int y1, y2, x, type;
		public Event(int y1, int y2, int x, int type) {
			this.y1 = y1; this.y2 = y2; this.x = x; this.type = type;
		}
	}
	
	static final int MN = 5005, MC = 20004;
	static int n, layers[] = new int[MC];
	static List<Event> v1 = new ArrayList(), v2 = new ArrayList();
	
	static int solve(List<Event> v) {
		int ans = 0;
		for (Event e: v) {
			if (e.type == 1) {
				for (int i=e.y1; i<e.y2; i++) if (layers[i] == 0) ans++;
				for (int i=e.y1; i<e.y2; i++) layers[i] ++;
			} else {
				for (int i=e.y1; i<e.y2; i++) layers[i] --;
				for (int i=e.y1; i<e.y2; i++) if (layers[i] == 0) ans ++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) throws IOException {
		
		n = readInt();
		
		for (int i=1; i<=n; i++) {
			int x1 = readInt() + 10000, y1 = readInt() + 10000, x2 = readInt() + 10000, y2 = readInt() + 10000;
			v1.add(new Event(y1, y2, x1, 1));
			v1.add(new Event(y1, y2, x2, 2));
			v2.add(new Event(x1, x2, y1, 1));
			v2.add(new Event(x1, x2, y2, 2));
			
		}
		
		Collections.sort(v1, (a, b)->{
			if (a.x != b.x) return a.x - b.x;
			return a.type - b.type;
		});
		Collections.sort(v2, (a, b)->{
			if (a.x != b.x) return a.x - b.x;
			return a.type - b.type;
		});
		
		System.out.println(solve(v1) + solve(v2));
		
		
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


	
	
