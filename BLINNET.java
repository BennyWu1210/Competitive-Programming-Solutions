import java.util.*;
import java.io.*;
public class BLINNET {

	public static class Node{
		int edge;
		int cost;
		
		public Node(int edge, int cost) {
			this.edge = edge;
			this.cost = cost;
		}
	}
	
	
	public static int findNext(int[] costs, boolean[] mst) {
		int minIndex = -1;
		int minValue = Integer.MAX_VALUE;
		
		for(int i=0; i<costs.length; i++) {
			if(!mst[i] && costs[i] < minValue) {
				minIndex = i;
				minValue = costs[i];
			}
		}
		
		return minIndex;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine().split(" ")[0]);
		
		for (int t=0; t<test_case; t++) {
			br.readLine(); // Empty line between each test cases
					
			int n = Integer.parseInt(br.readLine().split(" ")[0]);
			ArrayList<Node>[] AdjList = new ArrayList[n];
			int[] minKey = new int[n];
			int[] parent = new int[n];
			boolean[] mstSet = new boolean[n];
			
			for (int i=0; i<n; i++) { // Initialize all elements in the ndoe
				AdjList[i] = new ArrayList<Node>();
			}
			
			for (int i=0; i<n; i++) {
				br.readLine(); // City name does not matter
				int p = Integer.parseInt(br.readLine().split(" ")[0]);
				for (int j=0; j<p; j++) {
					String[] input = br.readLine().split(" ");
					int v = Integer.parseInt(input[0])-1;
					int c = Integer.parseInt(input[1]);
					AdjList[j].add(new Node(v, c));
				}
			}
			
			// Perform Prim's Algorithm
			// Try it without priority queue first
			Arrays.fill(minKey, Integer.MAX_VALUE);
			minKey[0] = 0;
			while (true) {
				int nextNode = findNext(minKey, mstSet);
				
				if(nextNode == -1) {
					break;
				}
				
				mstSet[nextNode] = true;
				
				for(Node N: AdjList[nextNode]) {
					//System.out.println(minKey[N.edge] + " " + N.cost);
					if(!mstSet[N.edge] && minKey[N.edge] > N.cost) {
						minKey[N.edge] = N.cost;
						parent[N.edge] = nextNode;
					}
				}
			}
			 
			//Arrays.sort(minKey);
			long totalCost = 0;
			for (int i=0; i<n; i++) {
				totalCost += minKey[i];
				//System.out.println(minKey[i]);
			}
			//System.out.println("-------");
			System.out.println(totalCost);

			
			
				
			
		
			
		}
		
	}

}
