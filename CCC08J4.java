
import java.io.*;
import java.util.*;

public class CCC08J4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;


	public static void main(String[] args) throws IOException {
		while(true) {
			String[] input = readLine().split(" ");
			char[] c = new char[input.length];

			for(int i=0; i<c.length; i++) {
				c[i] = input[i].charAt(0);
			}

			if (c.length == 1 && c[0] == '0') break;

			Deque<String> solution = new LinkedList<>();
			//			char[] sol = new char[c.length];
			//			
			//			// find first number
			//			int count = 0;
			//			int index = 0;
			//			boolean base = false;
			//			for(int i=0; i<c.length; i++) {
			//				if (!base && i != 0 && c[i] != '+' && c[i] != '-' && c[i-1] != '+' && c[i-1] != '-') {
			//					base = true;
			//					sol[index++] = c[i];
			//					for(int j=0; j<count && !solution.isEmpty(); j++) {
			//						sol[index++] = solution.pollLast();
			//					}
			//					count = 0;
			//					continue;
			//				}
			//				
			//				if (c[i] != '+' && c[i] != '-') {
			//					sol[index++] = c[i];
			//					count ++;
			//					if (base) {
			//						for(int j=0; j<count && !solution.isEmpty(); j++) {
			//							sol[index++] = solution.pollLast();
			//						}
			//					}
			//				}
			//				else {
			//					solution.add(c[i]);
			//				}
			//				
			//			}
			//			
			//			while(!solution.isEmpty()) {
			//				sol[index++] = solution.pollLast();
			//			}


			//			for(int i=0; i<sol.length-1; i++) System.out.print(sol[i] + " ");
			//			System.out.println(sol[sol.length-1]);
			//			
			for(int i=c.length-1; i>=0; i--) {
				if (isOperator(c[i])) {
					String a = solution.poll();
					String b = solution.poll();

					solution.push(a + " " + b + " " + c[i]);
				}
				else {
					solution.push(c[i] + "");
				}
			}

			while(!solution.isEmpty()) {
				System.out.print(solution.pollLast());
			}
			System.out.println();
		}


	}





static boolean isOperator(char c) {
	switch (c){
	case '+':
	case '-':
		return true;
	}
	return false;
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




