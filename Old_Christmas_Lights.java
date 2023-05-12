import java.io.*;
import java.util.*;

public class Old_Christmas_Lights {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static int MM = (int)1e5 + 5;
	static int[] a = new int[MM], left = new int[MM], right = new int[MM];
	static pair spt[][] = new pair[17][MM];
	static Deque<Integer> min = new LinkedList<>(), max = new LinkedList<>();
	
	
	static class pair{
		int a, b;
		
		public pair(int a, int b) {this.a = a; this.b = b;}
	}
	
	static pair RMQ(int l, int r) {
		int k = (int)(Math.log(r-l+1)*1D/Math.log(2));
		
		if (spt[k][l].a < spt[k][r-(1<<k)+1].a) {
			return spt[k][r-(1<<k)+1];
		}
		else if (spt[k][l].a > spt[k][r-(1<<k)+1].a){
			return spt[k][l];
		}
		else {
			if (spt[k][l].b < spt[k][r-(1<<k)+1].b) {
				return spt[k][r-(1<<k)+1];
			}
			else {
				return spt[k][l];
			}
		}
	}
	
	public static void main(String[] args) throws IOException {

		int N = readInt(), K = readInt();
		
		for (int i=1; i<=N; i++) a[i] = readInt();
		
		int l = 1, r = 1;
		for (; r<=N; r++) {
			while (!min.isEmpty() && a[min.peekLast()] > a[r]) min.pollLast();
			while (!max.isEmpty() && a[max.peekLast()] < a[r]) max.pollLast();
			min.addLast(r); max.addLast(r);
			
			while (a[max.peekFirst()] - a[min.peekFirst()] > K) {
				if (max.peekFirst() == l) max.pollFirst();
				if (min.peekFirst() == l) min.pollFirst();
				right[l] = r - l;
				l ++;
			}
			
			left[r] = r - l + 1;
		}
		
		for (; l<=N; l++) right[l] = N+1-l;
		
		for (int i=1; i<=N; i++) spt[0][i] = new pair(right[i], -i);
		for (int k=1; k<17; k++) {
			for (int i=1; i+(1<<k)-1 <= N; i++) {
				if (spt[k-1][i].a > spt[k-1][i+(1<<k-1)].a) {
					spt[k][i] = spt[k-1][i];
				}
				else if(spt[k-1][i].a < spt[k-1][i+(1<<k-1)].a) {
					spt[k][i] = spt[k-1][i+(1<<k-1)];
				}
				else {
					if (spt[k-1][i].b > spt[k-1][i+(1<<k-1)].b) {
						spt[k][i] = spt[k-1][i];
					}
					else {
						spt[k][i] = spt[k-1][i+(1<<k-1)];
					}
				}
				
				
			}
		}
		
		int Q = readInt();
		for (int i=1; i<=Q; i++) {
			int x = readInt(), y = readInt();
			if (right[x] >= y-x+1) System.out.println(x + " " + y);
			else {
				pair res = RMQ(x, y-left[y]);
				if (res.a >= left[y]) System.out.println(-res.b + " " + (-res.b + res.a - 1));
				else System.out.println(y-left[y]+1 + " " + y);
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