
import java.io.*;
import java.util.*;

public class XorMin {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static class Node{
		int idx = Integer.MAX_VALUE;
		Node[] children;
		
		public Node() {
			children = new Node[2];
			children[0] = null;
			children[1] = null;
		}
	}
	
	static void insert(Node cur, int index, int num, int bit) {
		if (bit == 0) {
			cur.idx = Math.min(cur.idx, index);
			return;
		}
		
		int idx = (num & bit) == 0 ? 0 : 1;
		
		if (cur.children[idx] == null) {
			cur.children[idx] = new Node();
		}
		
		Node next = cur.children[idx];

		insert(next, index, num, bit >> 1);
		
	}
	
	static int search(Node cur, int bit, int xor) {
		if (bit == 0) {
			return cur.idx;
		}
		
		int v = (xor & bit) == 0 ? 0 : 1;
		
		
		Node next = cur.children[v];
		
		
		if (next != null) {
			return search(next, bit >> 1, xor);
		}
		
		v = (xor & bit) == 0 ? 1 : 0;
		next = cur.children[v];
		return search(next, bit >> 1, xor);
	}
	public static void main(String[] args) throws IOException {

		
		int N = readInt(), Q = readInt();
		
		Node root = new Node();
		for (int i=0; i<N; i++) {
			int num = readInt();
			insert(root, i, num, 1<<30);
		}
		
		
		int totalXor = 0;
		for (int i=0; i<Q; i++) {
			int val = readInt();
			totalXor ^= val;
			
			System.out.println(search(root, 1<<30, totalXor));
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


	
	
