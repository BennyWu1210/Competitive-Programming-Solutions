
import java.io.*;
import java.util.*;


public class The_Dmoj_Driveway {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		Deque<String> q = new LinkedList<String>();
		int t = readInt(), m = readInt();
		for(int i=t; i>0; i--) {
			String name = next();
			String command = next();
			
			if (command.equals("in")) {
				q.push(name);
			}
			else {
				if (m > 0 && q.peek().equals(name)) {
					q.pop();
					m --;
				}
				else if(q.peekLast().equals(name)) {
					q.removeLast();
				}
			}
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.pollLast());
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


	
	
