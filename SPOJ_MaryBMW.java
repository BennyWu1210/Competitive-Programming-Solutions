import java.util.*;
import java.io.*;
import java.lang.*;

class SPOJ_MaryBMW {
	/* Perform maximum spanning first 
	 * Use BFS to find the minimum speed along the path between 1 to N
	 */
	public static class Edge implements Comparable<Edge>{
		int bv;
		int ev;
		long cost;
		public Edge(int bv, int ev, long cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.cost > o.cost) {
				return -1;
			}
			else if(this.cost < o.cost) {
				return 1;
			}
			return 0;
		}
	}
	
	public static int find(int v, int[] parent) {
		if (parent[v] == -1) {
			return v;
		}
		return parent[v] = find(parent[v], parent);
	}
	
	public static void union(int bv, int ev, int[] parent) {
		parent[bv] = ev;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tests = Integer.parseInt(br.readLine().split(" ")[0]);
		
		for (int i=0; i<tests; i++) {
			String[] input1 = br.readLine().split(" ");
			int N = Integer.parseInt(input1[0]);
			int M = Integer.parseInt(input1[1]);
			Edge[] edges = new Edge[M];
			int[] parent = new int[N];
			Arrays.fill(parent, -1);
			LinkedList<Edge> mst = new LinkedList<Edge>();
			ArrayList<Integer>[] adjList = new ArrayList[N];
			
			for(int j=0; j<N; j++) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			for (int j=0; j<M; j++) {
				String[] input = br.readLine().split(" ");
				int bv = Integer.parseInt(input[0])-1;
				int ev = Integer.parseInt(input[1])-1;
				long cost = Long.parseLong(input[2]);
				edges[j] = new Edge(bv, ev, cost);
//				adjList[bv].add(ev);
//				adjList[ev].add(bv);
			}
			
			// Perform Kruskal's algorithm

			Arrays.sort(edges);
			for(Edge e: edges) {
				int broot = find(e.bv, parent);
				int eroot = find(e.ev, parent);
				if(broot != eroot) {
					mst.add(e);
					union(broot, eroot, parent);
					if (mst.size() == N-1) {
						break;
					}
				}
				
			}
			
			if(mst.size() != N-1) {
				System.out.println(-1);
				continue;
			}
			// MST obtained
			// Use BFS to look throught the path
			long minFirst = Integer.MAX_VALUE;
//			for(Edge e: mst) {
//				if(e.bv == 1 || e.ev == 1 && e.cost < minFirst) {
//					minFirst = e.cost;
//				}
//			}
			long[] maxSpeed = new long[N]; // Store all the maximum speed up to city "i"
			boolean[] visited = new boolean[N];
			//Arrays.fill(maxSpeed, (long)Math.pow(10, 16));
			Arrays.fill(maxSpeed, -1);
			LinkedList<Integer> queue = new LinkedList<Integer>();
			queue.add(0);
			maxSpeed[0] = Integer.MAX_VALUE;
			visited[0] = true;
			

			// Perform BFS
//			for(Edge e: mst) {
//				System.out.println(e.bv + " " + e.ev + " " + e.cost);
//			}
			boolean connected = false;
			outer: while(!queue.isEmpty()) {
				int city = queue.poll();
				//System.out.println(city);

				for (Edge e: mst) {
					if (e.bv == city) {
						if(e.cost > maxSpeed[city] && !visited[e.ev]) {
							maxSpeed[e.ev] = maxSpeed[city];
							queue.add(e.ev);
							visited[e.ev] = true; 
							
						}
						else if(e.cost < maxSpeed[city] && !visited[e.ev]) {
							maxSpeed[e.ev] = e.cost;
							queue.add(e.ev);
							visited[e.ev] = true;
						}
						if (e.ev == N-1) {
							System.out.println(maxSpeed[e.ev]);
							connected = true;
							break outer;
						}
						
					}
					else if (e.ev == city) {
						if(e.cost > maxSpeed[city] && !visited[e.bv]) {
							maxSpeed[e.bv] = maxSpeed[city];
							queue.add(e.bv);
							visited[e.bv] = true;
							
						}
						else if(e.cost < maxSpeed[city] && !visited[e.bv]) {
							maxSpeed[e.bv] = e.cost;
							queue.add(e.bv);
							visited[e.bv] = true;
						}
						if (e.ev == N-1) {
							System.out.println(maxSpeed[e.ev]);
							connected = true;
							break outer;
						}
						
					}
					
				}
				
			}
//			if (!connected) {
//				System.out.println(-1);
//			}
			
			// Attempting to use the solution from ccc03s5 - trucking trouble
//			boolean[] visited = new boolean[N];
//			long minSpeed = Integer.MAX_VALUE;
//			visited[0] = true;
//			for(Edge e: mst) {
//				int d = e.bv;
//				while(!visited[d]) {
//					minSpeed = Math.min(minSpeed, e.cost);
//					System.out.println(d +" " + minSpeed);
//					visited[d] = true;
//					d = e.ev;
//				}
//			}
//			System.out.println(minSpeed);
					
//			3
//			4 5
//			1 2 80
//			3 1 20
//			2 3 60
//			4 3 300
//			2 4 90
//			4 5
//			1 2 80
//			3 1 20
//			2 3 60
//			4 3 300
//			2 4 90
//			4 5
//			1 2 80
//			3 1 20
//			2 3 60
//			4 3 300
//			2 4 90

			
		}
	}

}
