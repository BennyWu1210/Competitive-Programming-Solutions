import java.util.*;


public class CCC10S4
{
	public static int[] parent;
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
			return this.cost-o.cost;
		}
	}
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		HashMap<String, ArrayList<int[]>> map = new HashMap<String, ArrayList<int[]>>();

		int M = in.nextInt();
		for(int i=0;i<M;i++)
		{
			int e = in.nextInt();
			int[] corner = new int[e], cost = new int[e];
			
			for(int j=0;j<e;j++)
				corner[j] = in.nextInt();
			
			for(int j=0;j<e;j++)
				cost[j] = in.nextInt();

			for(int j=0;j<e;j++)
			{
				int a = corner[j], b = corner[(j+1)%e], c = cost[j];
				String edge = Math.min(a,b)+" "+Math.max(a,b);
				if(!map.containsKey(edge))
					map.put(edge, new ArrayList<int[]>());
				map.get(edge).add(new int[]{i,c});
			}
		}
		
		LinkedList<Edge> edge = new LinkedList<Edge>();
		for(ArrayList<int[]> edges : map.values()) {
			if(edges.size() == 1)
			{
				int[] v = edges.get(0);
				edge.add(new Edge(v[0], M, v[1]));
			}
			else
			{
				int[] v1 = edges.get(0), v2 = edges.get(1);
				edge.add(new Edge(v1[0],v2[0],v1[1]));		
			}
		}
		parent = new int[map.size()];
		Arrays.fill(parent, -1);
		
		Collections.sort(edge);
//		for (Edge e:edge) {
//			System.out.println(e.bv+" "+e.ev+" "+e.cost);
//		}
		int cnt = 0;
        int cost = 0;
        boolean work = false;
        for(Edge e:edge) {
            if(e.ev==M) continue; //ignore
            int pb = find(e.bv);
            int pe = find(e.ev);
            if(pb==pe) continue; //ignore
            union(pb,pe);
            cost+=e.cost;
            cnt++;
            if(cnt==M-1) {
                work = true;
                break;
            }
        }
        //case 2: including outside
        parent = new int[map.size()+1];
        Arrays.fill(parent,-1);
        int cnt2 = 0;
        int cost2 = 0;
        for(Edge e:edge) {
            int pb = find(e.bv);
            int pe = find(e.ev);
            if(pb==pe) continue;
            //System.out.println(e.bv+" "+e.ev);
            union(pb,pe);
            cost2+=e.cost;
            cnt2++;
            if(cnt2==M) {
                if(work) System.out.println(Math.min(cost,cost2));
                else System.out.println(cost2);
                return;
            }
        }
        //System.out.println(cost);
	}
	
	public static int find(int v) {
		if (parent[v]==-1) {
			return v;
		} else {
			return parent[v] = find(parent[v]);
		}
	}
	
	public static void union(int pb, int pe) {
		parent[pb] = pe;
	}
}