import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
//https://pastebin.com/RPF33MkK
public class MockCCC18S5 {
	//this is for adj list
	public static class Edge1 {
		int ev, cost;
		public Edge1(int ev, int cost) {
			this.ev = ev; this.cost = cost;
		}
	}

	public static class Edge implements Comparable<Edge> {
		public int bv;
		public int ev;
		public int cost;
		public Edge(int bv, int ev, int cost) {
			this.bv = bv;
			this.ev = ev;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return o.cost-this.cost;
		}  
	}
	public static ArrayList<Edge> edges; 
	public static ArrayList<Edge> temp; 
	public static int V;
	public static int E;
	public static int[] parent;
	public static ArrayList<Edge1>[] adj;
	public static boolean[] vis;
	public static int bsearch(int l, int r, Edge v) {
		while(l <= r) {
			int mid = (l+r)/2;
			if(temp.get(mid).cost > v.cost) l=mid+1;
			else if(temp.get(mid).cost < v.cost) r = mid-1;
			else {
				if(temp.get(mid).cost > v.cost) r = mid-1;
				else if(temp.get(mid).cost < v.cost) l = mid+1;
				return mid;
			}
		}
		return l;
	}
	public static void mst() {
		for(int i=0;i<temp.size();i++) {
			Edge cur = temp.get(i);
			// System.out.println("value check: " + cur.x + " " + cur.y + " " + cur.z);
			if(find(cur.bv) != find(cur.ev)) {
				adj[cur.bv].add(new Edge1(cur.ev, cur.cost));
				adj[cur.ev].add(new Edge1(cur.bv, cur.cost));
				union(cur.bv, cur.ev);
			}
		}
	}
	public static int find(int v) {
		if(parent[v]==-1) return v;
		return parent[v] = find(parent[v]);
	}

	public static void union(int a, int b) {
		a = find(a); b = find(b);
		parent[b] = a;
	}

	public static void update() {
		parent = new int[V+1]; adj = new ArrayList[V+1];
		for(int j=1;j<=V;j++) {
			adj[j] = new ArrayList<Edge1>();  
		}
		Arrays.fill(parent, -1);
		mst();
	}

	public static void dfs(int v, int b, int w) {
		// System.out.println(adj[v].size());
		for(Edge1 cur: adj[v]) {
			if(!vis[cur.ev] && cur.cost >= w) {
				// System.out.println("dfs check: " + bv + " " + cur.ev + " " + cur.cost);
				vis[cur.ev] = true;
				if(vis[b]) break;
				dfs(cur.ev, b, w);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] A = br.readLine().split(" ");
		V = Integer.parseInt(A[0]);
		E = Integer.parseInt(A[1]);

		edges = new ArrayList<Edge>(); 
		for(int i=0;i<E;i++) {
			A = br.readLine().split(" ");
			int bv = Integer.parseInt(A[0]);
			int ev = Integer.parseInt(A[1]);
			int cost = Integer.parseInt(A[2]);;
			edges.add(new Edge(bv, ev, cost));
		}

		temp = new ArrayList<Edge>(edges);
		Collections.sort(temp);
		update();

		int Q = Integer.parseInt(br.readLine());
		for(int i=0;i<Q;i++) {
			A = br.readLine().split(" ");
			int op = Integer.parseInt(A[0]);
			if(op == 1) {
				int m = Integer.parseInt(A[1]);
				int x = Integer.parseInt(A[2]);
				Edge r = edges.remove(m-1);   //original edge   remove the number m-1 Edge
				Edge r2 = new Edge(r.bv,r.ev,x);   //new edge    base on the orignal m-1 edge to create the new edge with weight x
				edges.add(m-1, r2);    //add new edge into original edge ArrayList


				int ind = bsearch(0, E-1, r);   //from temp original edge location
				temp.remove(ind);
				ind = bsearch(0, E-2, r2);
				temp.add(ind, r2);
				update();   //max spaning tree
				// System.out.println("update check: " + edges.get(m-1).x + " " + edges.get(m-1).y + " " + edges.get(m-1).z);
			} 
			else {
				int a = Integer.parseInt(A[1]);
				int b = Integer.parseInt(A[2]);
				int w = Integer.parseInt(A[3]);
				vis = new boolean[V+1];
				dfs(a,b,w);
				System.out.println(vis[b]?1:0);
			}

		}
//		for(int i: parent) {
//			System.out.println(i);
//		}


	}
}