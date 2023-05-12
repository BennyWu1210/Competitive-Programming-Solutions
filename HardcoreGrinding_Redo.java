
import java.io.*;
import java.util.*;
public class HardcoreGrinding_Redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Interval implements Comparable<Interval>{ // Maybe unnecessary
		
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Interval o) {
			// TODO Auto-generated method stub
			return this.start - o.start;
		}
		
		
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ArrayList<int[]> list = new ArrayList<int[]>();
		int N = readInt();
		
		
		for(int i=0; i<N; i++) {
			int start = readInt();
			int end = readInt();
			
			list.add(new int[] {start, end});
		}
		
		int counter = 0;
		while(list.size()>0) {
			int[] target = list.get(0);
			int i = 0;
			while(i<list.size()){
				if (target[1] <= list.get(i)[0]) {
					list.remove(target);
					target = list.get(i-1);
				}
				i ++;
			}
			list.remove(target);
			counter ++;
		}
		
		System.out.println(counter);
		
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
