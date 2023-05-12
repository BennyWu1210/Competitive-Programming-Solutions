import java.io.*;
import java.util.*;
public class Ccc15s4 {

	// Not use priority queue for now
	// Bruh I think we are supposed to use dijkstra instead
	public static int K;
	public static int N;
	public static int M;
	public static ArrayList<Node>[] routes;
	public static int[] minTime;
	public static int[] dist;
	public static boolean[] mstSet;
	public static int[] total_h;
	public static Node[] mst;
	
	public static class Node implements Comparable<Node>{
		int bv;
		int cost;
		int h;
		
		public Node(int bv, int cost, int h) {
			this.bv = bv;
			this.cost = cost;
			this.h = h;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
		
	}
	
	public static int findMinimum() {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int i=0; i<dist.length; i++) {
			if (!mstSet[i] && dist[i]<=minValue) {
				minValue = dist[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		K = Integer.parseInt(input1[0]);
		N = Integer.parseInt(input1[1]);
		M = Integer.parseInt(input1[2]);
		
		routes = new ArrayList[N];
		for(int i=0; i<N; i++) {
			routes[i] = new ArrayList<Node>();
		}
		
		for(int i=0; i<M; i++) {
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0])-1;
			int b = Integer.parseInt(input[1])-1;
			int t = Integer.parseInt(input[2]);
			int h = Integer.parseInt(input[3]);
			routes[a].add(new Node(b, t, h));
			routes[b].add(new Node(a, t, h));
		}
		
		input1 = br.readLine().split(" ");
		int start = Integer.parseInt(input1[0]);
		int end = Integer.parseInt(input1[1]);
		dist = new int[N];
		minTime = new int[N];
		mstSet = new boolean[N];
		mst = new Node[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Arrays.fill(minTime, Integer.MAX_VALUE);
		minTime[0] = 0;
		dist[start-1] = 0;
		int total_time = 0;
		int total_h = 0;
		while(true) {
			int next = findMinimum();
			if(next == -1) {
				break;
			}
			
			mstSet[next] = true;
			//total_time += minTime[next];
			for(Node n: routes[next]) {
				if (!mstSet[n.bv] && dist[next] + n.cost < dist[n.bv]) {
					dist[n.bv] = dist[next] + n.cost;
					mst[n.bv] = n;
				}
			}
			
			
		}
		
		mst[0] = new Node(-1, -1, -1);
		for(Node a: mst) {
			System.out.println((a.bv+1) + " " + a.cost + " " + a.h);
		}
		
		// Do some back tracking
		
	}

}
