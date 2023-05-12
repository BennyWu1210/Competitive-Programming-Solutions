import java.util.*;
import java.io.*;
public class SPOJ_Help_the_old_King {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class City implements Comparable<City>{
		int bv;
		int ev;
		long cost;
		
		public City(int bv, int ev, long cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(City o) {
			// TODO Auto-generated method stub
			if (this.cost > o.cost) {
				return 1;
			}
			if (this.cost < o.cost) {
				return -1;
			}
			return 0;
			//return (int) (this.cost - o.cost);
		}
		
	}
	
	public static int find(int v, int[] parent) {
		if (parent[v] == -1) {
			return v;
		}
		return parent[v] = find(parent[v], parent);
	}
	
	public static void union(int a, int b, int[] parent) {
		parent[a] = b;
	}	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		
		int T = readInt();
		
		for (int times=0; times<T; times++) {
			// Take input

			
			int cities = readInt();
			int roads = readInt();
			
			// Prepare supporting data structures
			int[] parent = new int[cities];
			City[] edges = new City[roads];
			Arrays.fill(parent, -1);
			
			for (int i=0; i<roads; i++) {
				int a = readInt()-1;
				int b = readInt()-1;
				long c = readLong();
				edges[i] = new City(a, b, c);

			}
			
			
			// Sort array of cities
			if(edges.length > 1) {
				Arrays.sort(edges);
			}
			
			
			// Apply Kruskal's algorithm 
			
			int connected = 0;
			long total_cost = 1;
			
			for(City city: edges) {
				int rootB = find(city.bv, parent);
				int rootE = find(city.ev, parent);
				
				if (rootB != rootE) {
					union(rootB, rootE, parent);
//					if (total_cost == 0) {
//						total_cost = 1;
//					}
					
					total_cost *= city.cost;
					connected ++;
					
					if (connected == cities - 1) {
						break;
					}
				}
			}
			
			// Find the number of divisors of this output
			// Perform Sieve of Eratosthenes to find the prime nums
			// If prime, add (Total - cur)/cur + 1 to the counter
			// Otherwise, continue
			
			
			// Try common way first
//			int counter = 1;
//			for (int i = 1; i<=total_cost/2; i++) {
//				if (total_cost % i == 0) {
//					counter ++;
//				}
//			}
//			
//			System.out.println(counter);
			
			
			// Didn't read question properly LOL, note that all cost is in a power of 2
			// Try the following solution instead
			
			int output = (int) (Math.log(total_cost) / Math.log(2)) + 1;
			System.out.println(output);
			
			// Still time limit exceeded...
			
			
			
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
