
import java.io.*;
import java.util.*;

import static java.lang.Double.POSITIVE_INFINITY;
import static java.lang.Double.NEGATIVE_INFINITY;

public class Spoj_AliceInAmsterdam {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class FloydWarshall{
		
		double[][] dist;
		int N;
		String result = "";
		HashMap<Integer, String> map = new HashMap<Integer, String>();

		
		public FloydWarshall(int N) {
			this.N = N;
		}
		
		public void takeInput() throws IOException {
			this.dist = createGraph(this.N);
			for(int i=0; i<N; i++) {
				String name = next();
				map.put(i, name);
				for (int j=0; j<N; j++) {
					Double d = readDouble();
					
					if (d == 0 && i!=j) {
						this.dist[i][j] = POSITIVE_INFINITY;
					}
					else {
						this.dist[i][j] = d;
					}
					
					if (i == j && d>0) this.dist[i][j] = 0;
				}
				
				
			}
		}
		
		public double[][] getSolution() {
			
			// for(double[] d: dist) System.out.println(Arrays.toString(d));
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(dist[i][j] > dist[k][j] + dist[i][k]) {
							dist[i][j] = dist[k][j] + dist[i][k];
						}
					}
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(dist[i][k] != POSITIVE_INFINITY && dist[k][j] != POSITIVE_INFINITY && dist[k][k] < 0) {
							dist[i][j] = NEGATIVE_INFINITY;
						}
					}
				}
			}
			return dist;
		}
		
		public String printSolution(int a, int b) {
			String result = map.get(a) + "-" + map.get(b);
			if (dist[a][b] == NEGATIVE_INFINITY) return "NEGATIVE CYCLE";
			
			if (dist[a][b] == 0 || dist[a][b] == POSITIVE_INFINITY) {
				if (a == b) {
					return String.join(" ", result, "0");
				}
				return String.join(" ", result, "NOT REACHABLE");
			}
			
			return String.join(" ", result, Integer.toString((int)dist[a][b]));
		}
		
	}
	
	public static double[][] createGraph(int N){
		double[][] graph = new double[N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(graph[i], POSITIVE_INFINITY);
			graph[i][i] = 0;
		}
		
		return graph;
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		// Use Floyd-Warshall Algorithm
		// APSP (All pair shortest path
		
		int index = 0;
		while(true) {
			
			int N = readInt();
			if (N == 0) { // Stop the program
				break; 
			}
			
			index ++;
			
			FloydWarshall fw = new FloydWarshall(N);
			fw.takeInput();
			fw.getSolution();
			
			
			int queries = readInt();
			System.out.println("Case #" + index + ":");
			
			String[] results = new String[queries];
			boolean allNegative = false;
			inner: for(int i=0; i<queries; i++) {
				int start = readInt();
				int end = readInt();
				if(allNegative) continue; 
				String result = fw.printSolution(start, end);
				if (result.equals("NEGATIVE CYCLE")) {
					Arrays.fill(results, "NEGATIVE CYCLE");
					allNegative = true;
				}
				else {
					results[i] = result;

				}
				
			}
			for(String str: results) System.out.println(str);
			
			
			
		} // End of while loop

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
