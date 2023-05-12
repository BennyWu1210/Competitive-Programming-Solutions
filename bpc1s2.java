
import java.io.*;
import java.util.*;

public class bpc1s2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int N, C, Q;
	static List<Integer> stations = new ArrayList();
	static void solve(int l, int r) throws IOException {
		if (stations.size() == N) return;
		
		int mid = (l + r) / 2;
		System.out.println("? " + l + " " + mid);
		System.out.flush();
		
		int dist = readInt();
		if (mid - l != dist) { // have stations
			System.out.println("? " + l + " " + (mid + dist));
			System.out.flush();
			int newDist = readInt();
			int newStation;
			
			if (newDist == 0) newStation = mid + dist;
			else newStation = mid - dist;
			stations.add(newStation);
			
			solve(l, newStation);
			solve(newStation, r);
		}
	}
	public static void main(String[] args) throws IOException {

		N = readInt(); C = readInt(); Q = readInt();
		
		
		// find first and last stations
		
		System.out.println("? " + 0 + " " + C);
		System.out.flush();
		
		int endDist = readInt();
		
		int l = 0, r = C + 1;
		
		while (l < r) {
			int mid = (l + r) / 2;
			System.out.println("? " + 0 + " " + mid);
			System.out.flush();
			int dist = readInt();
			
			if (C - mid == endDist - dist) { // good
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		
		int firstStation = endDist - (C - r), lastStation = r;
		stations.add(firstStation);
		stations.add(lastStation);
		
		solve(firstStation, lastStation);
		
		
		System.out.print("!");
		for (int s: stations) {
			System.out.print(" " + s);
		}
		System.out.println();
		
		
		
		
		
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


	
	
