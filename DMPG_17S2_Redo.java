import java.io.*;
import java.util.*;
public class DMPG_17S2_Redo {
	static int N;
	static int Q;
	static int[] parent;
	
	// LOL I don't think we need Kruskal

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		Q = Integer.parseInt(input[1]);
		
		parent = new int[N];
		Arrays.fill(parent, -1);
		
		for (int i=0; i<Q; i++) {
			String[] input1 = br.readLine().split(" ");
			char command = input1[0].charAt(0);
			int x = Integer.parseInt(input1[1])-1;
			int y = Integer.parseInt(input1[2])-1;
//			for(int j: parent) System.out.println(j);
//			System.out.println("---__----");
			if(command == 'A') {	
				int bv = find(x);
				int ev = find(y);
				if(bv != ev) {
					union(bv, ev);
				}
			}
			else if(command == 'Q') {
				int bv = find(x);
				int ev = find(y);
				if (bv == ev) {
					System.out.println('Y');
				}
				else {
					System.out.println('N');
				}
			}
		}
		
		
	}
	
	public static int find(int v) {
		if(parent[v] == -1) {
			return v;
		}
		return parent[v] = find(parent[v]);
	}
	
	public static void union(int bv, int ev) {
		parent[bv] = ev;
	}

}
