
import java.io.*;
import java.util.*;

public class cco13p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int len;
	static int[] arr, wins;
	static Player[] players;
	static int maxIndex;

	static class Player{
		int i, val;
		
		public Player(int i, int val) {
			this.i = i;
			this.val = val;
			
		}
	}
	static void build() {
		int n = 1;
		maxIndex = 0;
		
		while (n < arr.length) {
			n *= 2;
			maxIndex += n;
		}
		players = new Player[2 * n];
		wins = new int[len+1];
		
		build(0, 0, n);
		
		
	}
	static void build(int x, int lx, int rx) {
		if (rx - lx == 1) {
			if (lx < arr.length) {
				players[x] = new Player(x - maxIndex + len, arr[lx]);
			}
			return;
		}
		
		int m = (lx + rx) / 2;
		build(2*x+1, lx, m);
		build(2*x+2, m, rx);
		
		if (players[2*x+1].val > players[2*x+2].val) {
			players[x] = players[2*x+1];
			wins[players[x].i] ++;
		}
		else {
			players[x] = players[2*x+2];
			wins[players[x].i] ++;
		}
	}
	
	static void update(int i, int v, int x, int lx, int rx) {
		if (rx - lx == 1) {
			
			players[x].val = v;
			return;
		}
		
		int m = (lx + rx) / 2;
		if (i < m) {
			update(i, v, 2*x+1, lx, m);
		}
		else {
			update(i, v, 2*x+2, m, rx);
		}
		
		if (players[2*x+1].val > players[2*x+2].val) {
			players[x] = players[2*x+1];
			wins[players[x].i] ++;
		}
		else {
			players[x] = players[2*x+2];
			wins[players[x].i] ++;
		}
		
	}
	
	
	static int getMax(int l, int r, int x, int lx, int rx) {
		if (lx >= r || rx <= l) return 0;
		if (lx >= l && rx <= r) return players[x].val;
		
		int m = (lx + rx) / 2;
		return Math.max(getMax(l, r, 2*x+1, lx, m), getMax(l, r, 2*x+2, m, rx));
	}
	
	
	public static void main(String[] args) throws IOException {


		int N = readInt(), M = readInt();
		len = 1 << N;
		arr = new int[len];
		
		for (int i=0; i<len; i++) {
			arr[i] = readInt();
		}
		
		build();
		for (int i=0; i<M; i++) {
			String[] input = readLine().split(" ");
			char c = input[0].charAt(0);
			
			if (c == 'W') {
				System.out.println(players[0].i);
			}
			else if (c == 'R') {
				int ind = Integer.parseInt(input[1]), val = Integer.parseInt(input[2]);
				wins = new int[len+1];
				update(ind-1, val, 0, 0, players.length/2);
			}
			else {
				int ind = Integer.parseInt(input[1]);
				System.out.println(wins[ind]);
			}
			
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


	
	
