
import java.io.*;
import java.util.*;

public class Acc3p3_redo {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		
		int N = readInt();
		LinkedList<Character>[] strings = new LinkedList[N];
		HashMap<Integer, Integer>[] map = new HashMap[N];
		
		
		
		for (int i=0; i<N; i++) {
			
			strings[i] = new LinkedList<Character>();
			map[i] = new HashMap<Integer, Integer>();
			
			char[] input = readLine().toCharArray();
			
			for (int j=input.length-1; j>=0; j--) {
				char c = input[j];
				map[i].put(c - 'a', map[i].getOrDefault(c - 'a', 0) + 1);
				strings[i].push(c);
			}
						
		}
		
		boolean hasAnswer = false;
		int index = 'z' - 'a';
		outer: while(index >= 0) {
		
			boolean allContains = true;
			
			for (int j=0; j<strings.length; j++) {
				
				if (map[j].getOrDefault(index, 0) == 0) {
					
					allContains = false;
					break;
				}
			}
			
			if (!allContains) {
				index --;
				continue;
			}
			
			boolean finished = false;
			for (int j=0; j<strings.length; j++) {
				
				int c = strings[j].peekFirst() - 'a';
				while (c != index) {
					map[j].put(c, map[j].get(c) - 1);
					strings[j].pollFirst();
					
					if (strings[j].size() > 0) c = strings[j].peekFirst() - 'a';
					else break;
				}
				strings[j].pollFirst();
				map[j].put(c, map[j].get(c) - 1);
				
				if (strings[j].size() == 0) finished = true;
			}
			
			System.out.print((char)(index+'a'));
			hasAnswer = true;
			
			if (finished) break outer;
			
		}
		
		if (!hasAnswer) System.out.print(-1);
		
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


	
	
