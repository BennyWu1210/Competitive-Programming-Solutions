
import java.io.*;
import java.util.*;
public class Bob_and_bus_stops {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static int bSearch(int start, int end, int[] arr, int key, boolean s) {
		if (end - start <= 1) {
			if (arr[start] < key) {
				if (s) return end;
				if (!s) return end;
				
			}
			if (arr[start] > key){
				if (s) return start+1;
				if (!s) return start;
			}
			
			if (arr[start] == key) return start;
			
			return end;
		}
		
		int mid = (start+end)/2;
		int num = arr[mid];
		if (num < key) return bSearch(mid+1, end, arr, key, s);
		if (num > key) return bSearch(start, mid, arr, key, s);
		else {
			
			if (!s) return mid;
			if (s) return mid-1;
		}
		return -1;
	}
	public static void main(String[] args) throws IOException {
		
		int N = readInt();
		int Q = readInt();
		int[] pos = new int[N];
		
		for(int i=0; i<N; i++) {
			pos[i] = readInt();
		}

		Arrays.sort(pos);
//		System.out.println(Arrays.toString(pos));
//		System.out.println(bSearch(0, N-1, pos, 1, true));
//		System.out.println(bSearch(0, N-1, pos, 3, false));
		//System.out.println("------++=====");
		for(int i=0; i<Q; i++) {
			int start = readInt();
			int end = readInt();
			int bIndex = bSearch(0, N-1, pos, start, true);
			int eIndex = bSearch(0, N-1, pos, end, false);
			if (start > pos[N-1]) {
				System.out.println(0);
				continue;
			}
			// System.out.println(bIndex + " " + eIndex);
			System.out.println(eIndex - bIndex + 1);
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
