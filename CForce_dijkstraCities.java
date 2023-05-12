import java.util.*;
import java.io.*;
public class CForce_dijkstraCities {

	public static class Node implements Comparable<Node>{
		int city;
		long length;
		
		public Node(int city, long length) {
			this.city = city;
			this.length = length;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.length, o.length);
		}
		
		
	}
	
	
	public static ArrayList<Node>[] adjList;
	public static int[] trainRoutes;
	public static long[] roads;
	public static boolean[] sptSet;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Perform Dijksta's Algorithm first
		// Compare the train routes length to the shortest path of city i
		// Delete it if it is larger or equal to the shortest path
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int k = Integer.parseInt(input[2]);
		
		roads = new long[n];
		trainRoutes = new int[n];  // Optional
		adjList = new ArrayList[n];
		sptSet = new boolean[n];
		Arrays.fill(roads, Integer.MAX_VALUE);
		Arrays.fill(trainRoutes, Integer.MAX_VALUE);
		for(int i=0; i<adjList.length; i++) {
			adjList[i] = new ArrayList<Node>();
		}
		for(int i=0; i<m; i++) {
			String[] input1 = br.readLine().split(" ");
			int bv = Integer.parseInt(input1[0])-1;
			int ev = Integer.parseInt(input1[1])-1;
			long cost = Long.parseLong(input1[2]);
			//System.out.println(bv + " " + ev);
			adjList[ev].add(new Node(bv, cost));
			adjList[bv].add(new Node(ev, cost));
		}
		
//		System.out.println("-----");
//		for(Node nn: adjList[0]) System.out.println(nn.city);
		
		//System.out.println("-----");
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0, 0));
		roads[0] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			long cost = cur.length;
			if (cost != roads[cur.city]) continue;
			
			for(Node next: adjList[cur.city]) {
				//System.out.println((next.length + cost) + " " + roads[next.city] + " city: " + cur.city + " " + next.city);
				//System.out.println(next.length);
				if (next.length + cost < roads[next.city]) {
					//System.out.println(cost);
					roads[next.city] = next.length + cost;
					pq.add(new Node(next.city, roads[next.city]));
				}
			}
			
		}
		//System.out.println("-----");
		boolean[] connected = new boolean[n];
		long counter = 0;
		for(int i=0; i<k; i++) {
			String[] input2 = br.readLine().split(" ");
			int city = Integer.parseInt(input2[0])-1;
			long cost = Long.parseLong(input2[1]);
			if (roads[city] <= cost){
				connected[city] = true;
				counter ++;
			}
			else if(connected[city]) {
				counter ++;
			}
			
		}
//		for (int c: roads) System.out.println(c);
//		System.out.println("-----");
		System.out.println(counter);
		
	}

}
