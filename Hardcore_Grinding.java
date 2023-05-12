import java.util.*;
import java.io.*;

public class Hardcore_Grinding {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			int start = readInt();
			int end = readInt();
			boolean needNew = true;
			
			inner: for(int j=0; j<list.size(); j++) {
				if (list.get(j) <= start) {
					needNew = false;
					list.set(j, end);
					break inner;
				}
			}

			if (needNew) {
				list.add(end);
			}
		}
		
		System.out.println(list.size());
		
//		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//		int counter = 0;
//		for(int i=0; i<N; i++) {
//			int start = readInt();
//			int end = readInt();
//			boolean hasKey = false;;
//			for(int j=start; j>0; j--) {
//				if (map.containsKey(start)) {
//					if (map.get(start) == 1) {
//						map.remove(start);
//						
//					}
//					else {
//						map.put(start, map.get(start)-1);
//					}
//					map.put(end, map.get(end)+1);
//					hasKey = true;
//					break;
//				}
//				
//			}
//			
//			if(!hasKey) {
//				counter ++;
//				map.put(end, 1);
//			}
//		}
		
		
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
