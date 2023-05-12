
import java.io.*;
import java.util.*;


public class Bts17p4_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		// Originally used pq, got AC but realized that it was unnecessary
		// So I removed it lol
		
		int N = readInt();
		int M = readInt();
		int J = readInt();
		
		int[] time = new int[N];
		for(int i=0; i<M; i++) {
			int p = readInt();
			int t = readInt();
			time[p-1] = t;
		}
		
		
//		Comparator<int[]> compareArray = new Comparator<int[]>() {
//
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// TODO Auto-generated method stub
//				return o1[0] - o2[0];
//			}
//			
//		};
		// PriorityQueue<int[]> pq = new PriorityQueue<int[]>(compareArray);
		
		int maxTime = 0;
		int idx = -1;
		while(idx < N) {
			int i = idx+1;
			if (N-i < J) break;
			int bestTime = Integer.MAX_VALUE;
			int bestIndex = -1;
			while(i - idx-1 < J && i <= N) { // Set up for the jumps
				if (i == N) break;
				if (time[i] == 0) {i ++; continue;}
				// pq.add(new int[] {time[i], i});
				if (time[i] < bestTime) {
					bestTime = time[i];
					bestIndex = i;
				}
				i ++;
				
			}

			if (bestTime < Integer.MAX_VALUE) {
				idx = bestIndex;
				if (bestTime > maxTime) {
					maxTime = bestTime;
				}
			}
			else {
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(maxTime);
		
		
		
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


	
	
