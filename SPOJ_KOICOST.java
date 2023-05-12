import java.util.*;
import java.lang.*;
import java.io.*;
public class SPOJ_KOICOST {
	/*
	 * Some ideas:
	 * Build a maximum spanning tree instead of deleting edges
	 * 
	 */
	public static int N;
	public static int M;
	public static Node[] nodes;
	public static int[] parents;
	public static class Node implements Comparable<Node>{
		int bv;
		int ev;
		int cost;
		public Node(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		for(int i=0; i<M; i++) {
			String[] input1 = br.readLine().split(" ");
			int bv = Integer.parseInt(input1[0]);
			int ev = Integer.parseInt(input1[1]);
			int cost = Integer.parseInt(input1[2]);
			nodes[i] = new Node(bv, ev, cost);
		}
		
		
	}

}
