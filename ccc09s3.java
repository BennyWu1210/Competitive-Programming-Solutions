
import java.io.*;
import java.util.*;

public class ccc09s3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {

		
		ArrayList<Integer>[] adj = new ArrayList[55];
		
		for (int i=0; i<adj.length; i++) adj[i] = new ArrayList<>();
		
		adj[1].add(6); adj[6].add(1); adj[2].add(6); adj[6].add(2); 
        adj[3].add(6); adj[6].add(3); adj[4].add(6); adj[6].add(4); 
        adj[3].add(4); adj[4].add(3); adj[4].add(5); adj[5].add(4); 
        adj[5].add(6); adj[6].add(5); adj[7].add(6); adj[6].add(7); 
        adj[3].add(5); adj[5].add(3); adj[7].add(8); adj[8].add(7); 
        adj[3].add(15); adj[15].add(3); adj[9].add(8); adj[8].add(9); 
        adj[13].add(15); adj[15].add(13); adj[9].add(12); adj[12].add(9); 
        adj[13].add(12); adj[12].add(13); adj[9].add(10); adj[10].add(9); 
        adj[10].add(11); adj[11].add(10); adj[14].add(13); adj[13].add(14); 
        adj[18].add(16); adj[16].add(18); adj[18].add(17); adj[17].add(18); 
        adj[16].add(17); adj[17].add(16); adj[11].add(12); adj[12].add(11);
		
		while (true) {
			char c = readCharacter();
			
			if (c == 'i') {
				int x = readInt(), y = readInt();
				adj[x].add(y);
				adj[y].add(x);
			}
			else if (c == 'd') {
				int x = readInt(), y = readInt();
				adj[x].remove(new Integer(y));
				adj[y].remove(new Integer(x));
			}
			else if (c == 'n') {
				int x = readInt();
				System.out.println(adj[x].size());
			}
			
			else if (c == 'f') {
				int x = readInt();
				int ans = 0;
				boolean[] vis = new boolean[55];
				
				for (int u: adj[x]) {
					for (int v: adj[u]) {
						if (!vis[v] && !adj[x].contains(v) && x != v) {
							vis[v] = true;
							ans ++;
						}
					}
				}
				System.out.println(ans);
			}
			else if (c == 's') {
				int x = readInt(), y = readInt();
				int[] steps = new int[55];
				LinkedList<Integer> q = new LinkedList<>();
				
				Arrays.fill(steps, Integer.MAX_VALUE);
				q.add(x);
				steps[x] = 0;
				
				
				outer: while (!q.isEmpty()) {
					int u = q.poll();
					
					for (int v: adj[u]) {
						if (steps[v] > steps[u] + 1) {
							steps[v] = steps[u] + 1;
							q.add(v);
						}
						if (v == y) {
							break outer;
						}
					}
				}
				
				if (steps[y] != Integer.MAX_VALUE) System.out.println(steps[y]);
				else System.out.println("Not connected");
			}
			else {
				return;
			}
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


	
	
