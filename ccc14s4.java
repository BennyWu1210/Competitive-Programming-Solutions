import java.io.*;
import java.util.*;

public class ccc14s4{
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer stk;
	
	static final int MN = 1002;
	static int N, T;
	static long ans;
	static List<Integer> xLen = new ArrayList(), yLen = new ArrayList();
	static Window[] windows = new Window[MN];
	static Map<Integer, Integer> mapX = new HashMap(), mapY = new HashMap();
	static Map<Integer, Integer> mapX2 = new HashMap(), mapY2 = new HashMap();
	
	static class Window{
		int x1, y1, x2, y2, t;
		public Window(int x1, int y1, int x2, int y2, int t) {
			this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2; this.t = t;
		}
	}
	
	public static void main(String[] args) throws IOException {
		N = readInt(); T = readInt();
		
		Map<Integer, Integer> mmX = new HashMap(), mmY = new HashMap();
		for (int i=0; i<N; i++) {
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt(), t = readInt();
			windows[i] = new Window(x1, y1, x2, y2, t);
			if (!mmX.containsKey(x1)) {mmX.put(x1, 1); xLen.add(x1);} 
			if (!mmX.containsKey(x2)) {mmX.put(x2, 1); xLen.add(x2);} 
			if (!mmY.containsKey(y1)) {mmY.put(y1, 1); yLen.add(y1);} 
			if (!mmY.containsKey(y2)) {mmY.put(y2, 1); yLen.add(y2);} 

		}
		
		Collections.sort(xLen);
		Collections.sort(yLen);
		
		List<Integer> lstX = new ArrayList(), lstY = new ArrayList();
		int v = 0, prev = -1, ind = 0;
		for (int i=0; i<xLen.size(); i++) {
			if (xLen.get(i) == prev) continue;
			else {
				v ++;
				mapX.put(xLen.get(i), v);
				lstX.add(xLen.get(i));
				mapX2.put(v, ind); ind++;
				prev = xLen.get(i);
			}
		}
		
		v = 0; prev = -1; ind = 0;
		for (int i=0; i<yLen.size(); i++) {
			if (yLen.get(i) == prev) continue;
			else {
				v ++;
				mapY.put(yLen.get(i), v);
				lstY.add(yLen.get(i));
				mapY2.put(v, ind); ind++;
				prev = yLen.get(i);
			}
		}
		
		long[][] psa = new long[2*N+2][2*N+2];
		
		for (int i=0; i<N; i++) {
			Window w = windows[i];
			int x1 = mapX.get(w.x1), y1 = mapY.get(w.y1), x2 = mapX.get(w.x2)-1, y2 = mapY.get(w.y2)-1;

			psa[x1][y1] += w.t;
			psa[x1][y2+1] -= w.t;
			psa[x2+1][y1] -= w.t;
			psa[x2+1][y2+1] += w.t;
		}
		
		for (int i=1; i<psa.length; i++) {
			for (int j=1; j<psa.length; j++) {
				psa[i][j] += psa[i-1][j] + psa[i][j-1] - psa[i-1][j-1];
				if (psa[i][j] >= T) {
					int indX = mapX2.get(i), indY = mapY2.get(j);
					long x2 = lstX.get(indX+1), y2 = lstY.get(indY+1) ;
					long x1 = lstX.get(indX), y1 = lstY.get(indY);
					ans += (x2 - x1) * (y2 - y1);
				}
			}
		}

		System.out.println(ans);
	}
	
	static String read() throws IOException {
		while (stk == null || !stk.hasMoreTokens()) stk = new StringTokenizer(br.readLine());
		return stk.nextToken();
	}
	
	static int readInt() throws IOException {
		return Integer.parseInt(read());
	}
	
}