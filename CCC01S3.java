
import java.io.*;
import java.util.*;

public class CCC01S3 {


	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;



	static ArrayList<Character>[] adjList;
	static void dfs(char v, boolean[] visited, ArrayList<Character>[] adjList) {
		visited[v] = true;
		for(char next: adjList[v]) {
			if (!visited[next]) {
				dfs(next, visited, adjList);
			}
		}
	}



	public static void main(String[] args) throws IOException {

		adjList = new ArrayList[91];
		for(int i=0; i<91; i++) {
			adjList[i] = new ArrayList<Character>();
		}

		String input = readLine();
		while(!input.equals("**")) {
			char bv = input.charAt(0), ev = input.charAt(1);
			adjList[bv].add(ev);
			adjList[ev].add(bv);
			input = readLine();
		}

		boolean[] visited = new boolean[91];
		dfs('A', visited, adjList);
		if (!visited['B']) {
			System.out.println("There are 0 disconnecting roads.");
			return;
		}

		int counter = 0;
		HashMap<String, Boolean> map = new HashMap<>();

		for(int i='A'; i<adjList.length; i++) {
			for(char next: adjList[i]) {
				if (map.get((char)i+ "" +next) != null || map.get(next+""+(char)i) != null) {
					continue;
				}
				map.put(next+""+(char)i, true);
				map.put((char)i+ "" +next, true);

				ArrayList<Character>[] list = new ArrayList[91];
				for(int j=0; j<adjList.length; j++) {
					list[j] = new ArrayList<Character>();
					list[j].addAll(adjList[j]);
				}

				char bv = (char)i, ev = next;
				list[bv].remove(new Character(ev));
				list[ev].remove(new Character(bv));
				visited = new boolean[91];
				dfs('A', visited, list);
				if (!visited['B']) {
					System.out.println(bv + "" + ev);
					counter++;
				}


			}
		}

		System.out.println("There are " + counter + " disconnecting roads.");


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




