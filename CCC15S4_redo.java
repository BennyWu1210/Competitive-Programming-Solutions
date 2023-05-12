import java.util.*;
import java.io.*;

public class CCC15S4_redo {

	public static class Node implements Comparable<Node>{
		int island;
		int time;
		int hull;
		public Node(int i, int t, int h) {
			this.island = i;
			this.time = t;
			this.hull = h;
		}
		
		public int compareTo(Node o) {
			return this.time - o.time;
		}
		
	}
	
	public static ArrayList<Node>[] adjList;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int K = Integer.parseInt(input[0]); int N = Integer.parseInt(input[1]); int M = Integer.parseInt(input[2]);
		adjList = new ArrayList[N];
		
		for(int i=0; i<N; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			String[] input1 = br.readLine().split(" ");
			int bv = Integer.parseInt(input1[0])-1;
			int ev = Integer.parseInt(input1[1])-1;
			int time = Integer.parseInt(input1[2]);
			int hull = Integer.parseInt(input1[3]);
			
			adjList[bv].add(new Node(ev, time, hull));
			adjList[ev].add(new Node(bv, time, hull));
		}
		
		int[][] map = new int[N][K+1];
		for(int i=0; i<N; i++) {
			Arrays.fill(map[i], 1<<30);
		}
		
		input = br.readLine().split(" ");
		int start = Integer.parseInt(input[0])-1;
		int end = Integer.parseInt(input[1])-1;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(start, 0, K));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(n.island == end) {
				System.out.println(n.time);
				return;
			}
			
			if(map[n.island][n.hull] < n.time) {
				continue;
			}
			
			for(Node node: adjList[n.island]) {
				int hull = n.hull - node.hull;
				if (hull > 0 && map[node.island][hull] > n.time + node.time) {
					map[node.island][hull] = n.time + node.time;
					pq.add(new Node(node.island, map[node.island][hull], hull));
				}
			}
		}
		System.out.println(-1);
		
		
		
	}

}
