
import java.io.*;
import java.util.*;


public class Ncco4d1p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static class Node implements Comparable<Node>{
		int v; 
		long cost;

		public Node(int v, long cost) {
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}

	static ArrayList<Node>[] adj;
	static long[] dis1, dis2;
	static boolean[] set;

	// slightly modified for cco12p2
	public static void main(String[] args) throws IOException {
		int N = readInt(), M = readInt();

		adj = new ArrayList[N];
		dis1 = new long[N];
		dis2 = new long[N];
		Arrays.fill(dis1, (int)1e9);
		Arrays.fill(dis2, (int)1e9);

		for(int i=0; i<N; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for(int i=0; i<M; i++) {
			int bv = readInt()-1, ev = readInt()-1, cost = readInt();
			adj[bv].add(new Node(ev, cost));
			// adj[ev].add(new Node(bv, cost));
		}

		dis1[0] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		set = new boolean[N];
		pq.add(new Node(0, 0));

		while(!pq.isEmpty()) {
			Node curNode = pq.poll();
			long curCost = curNode.cost;
			int curV = curNode.v;

			// if (curCost != dis1[curV]) continue;

			set[curV] = true;

			for(Node next: adj[curV]) {
				int nv = next.v;
				long nw = next.cost;

				if (dis1[nv] > dis1[curV] + nw) {
					dis2[nv] = dis1[nv];
					dis1[nv] = dis1[curV] + nw;
					pq.add(new Node(nv, dis1[nv]));
				}
				else if(dis2[nv] > dis1[curV] + nw && dis1[nv] != dis1[curV] + nw) {
					
					dis2[nv] = dis1[curV] + nw;
					pq.add(new Node(nv, dis1[nv]));
					// System.out.println(dis1[curV] + " " + nw);
				}


				if (dis2[nv] > dis2[curV] + nw && dis1[nv] != dis2[curV] + nw) {
					pq.add(new Node(nv, dis1[nv]));
					dis2[nv] = dis2[curV] + nw;
				}
			}


		}
//		System.out.println(Arrays.toString(dis1));
//		System.out.println(Arrays.toString(dis2));
		if (dis2[N-1] == 1e9) System.out.println(-1);
		else System.out.println(dis2[N-1]);



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




