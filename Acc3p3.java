
import java.io.*;
import java.util.*;

public class Acc3p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static class Node{
		int count = 1;
		HashMap<Integer, Integer> contain = new HashMap<>();
		Node child;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		
		int N = readInt();
		
		Node[] nodes = new Node[N];
		
		for (int i=0; i<N; i++) {
			
			char[] str = readLine().toCharArray();
			Node n = new Node();
			nodes[i] = n;
			
			for (char c: str) {
				n.contain.put(c - 'a', n.contain.getOrDefault(c - 'a', 0) + 1);
			}
			
			for (int c=str.length-1; c>=0; c--) {
				n.child = new Node();
				n.child.contain = (HashMap<Integer, Integer>) n.contain.clone();
				n.child.contain.put((int)str[c] - 'a', n.child.contain.get((int)str[c] - 'a') - 1);
				n = n.child;
			}
			
			
			
		}
		boolean hasAnswer = false;
		
		for (int i='z'-'a'; i>=0; i--) {
			
			boolean allContains = true;
			
			for (Node n: nodes) {
				if (!n.contain.containsKey(i)) {
					allContains = false;
					break;
				}
			}
			
			if (!allContains) {
				continue;
			}
			else {
				System.out.print((char)(i+'a'));
				hasAnswer = true;
			}
			
			for (int n=0; n<nodes.length; n++) {
				Node prev = nodes[n];
				while(prev.child != null && prev.contain.get(i) == prev.child.contain.get(i)) {
					prev = prev.child;
				}
				
				nodes[n] = prev;
			}
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


	
	
