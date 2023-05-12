
import java.io.*;
import java.util.*;

public class Raiders {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	static int N, M;
	static ArrayList<Integer>[] adj, rAdj, pAdj;
	static ArrayList<ArrayList<Integer>> newAdj = new ArrayList<>();
	
	static boolean[] vis;
	static Pair[][] dp;
	static Stack<Integer> s;
	static final int INF = (int)1e9;
	static final int MOD = (int)1e9 + 7;
	static final int MAX = (int)1e6 + 5;
	static int[] prov = new int[MAX];
	static int[] val;
	static int[] pVal = new int[MAX];

	static class Pair{
		int first, second;

		public Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static void dfs(int u) {
		for(int v: adj[u]) {
			if (!vis[v]) {
				vis[v] = true;
				dfs(v);
			}
		}

		s.push(u);

	}

	static Pair query(int cur, int choose) {
		// System.out.println(cur + " :: " + choose);
		if (cur == prov[N]) {
			if (choose == 1) {
				return new Pair(pVal[cur], 1);
			}
			return new Pair(0, 1);
		}
		
		if (dp[cur][choose].first != -1 && dp[cur][choose].second != -1) {
			return dp[cur][choose];
		}

		Pair ans = new Pair(-INF, 0), hold;
		for (int i=0; i<pAdj[cur].size(); i++) {
			if (choose == 1) {
				hold = query(pAdj[cur].get(i), 0);
				hold.first += pVal[cur];
				if (hold.first > ans.first) {
					ans = hold;
				}
				else if (hold.first == ans.first) {
					ans.second += hold.second;
					ans.second %= MOD;
				}
			}
			hold = query(pAdj[cur].get(i), 1);
			if (hold.first > ans.first) {
				ans = hold;
			}
			else if (hold.first == ans.first) {
				ans.second += hold.second;
				ans.second %= MOD;
			}

		}

		return dp[cur][choose] = ans;
	}

	public static void main(String[] args) throws IOException {

		N = readInt(); M = readInt();

		val = new int[N+1];
		adj = new ArrayList[N+1];
		rAdj = new ArrayList[N+1];
		pAdj = new ArrayList[MAX+1];
		s = new Stack<Integer>();

		vis = new boolean[N+1];
		dp = new Pair[MAX][2];

		for (int i=1; i<=N; i++) {
			val[i] = readInt();
			adj[i] = new ArrayList<>();
			rAdj[i] = new ArrayList<>();

		}

		for (int i=0; i<=N; i++) {
			dp[i][0] = new Pair(-1, -1);
			dp[i][1] = new Pair(-1, -1);
		}

		for (int i=0; i<=MAX; i++) {
			pAdj[i] = new ArrayList<>();

		}

		for (int i=0; i<M; i++) {
			int bv = readInt(), ev = readInt();
			adj[bv].add(ev);
			rAdj[ev].add(bv);
		}

		for (int i=1; i<=N; i++) {
			if (!vis[i]) {
				vis[i] = true;
				dfs(i);
			}
		}

		Arrays.fill(vis, false);

		LinkedList<Integer> q = new LinkedList<Integer>();
		int countProv = 0;


		while (!s.isEmpty()) {
			int next = s.pop();
			if (!vis[next]) {
				vis[next] = true;
				newAdj.add(new ArrayList<Integer>());
				q.push(next);
				while (!q.isEmpty()) {
					int u = q.pop();
					newAdj.get(newAdj.size()-1).add(u);
					// System.out.println(countProv + " " + val[u]);
					pVal[countProv] += val[u];
					prov[u] = countProv;
					for (int v: rAdj[u]) {
						if (!vis[v]) {
							vis[v] = true;
							q.push(v);
						}
					}
				}
				countProv ++;
			}
		}

		Set<Integer> det = new HashSet<>();
		for (int i=0; i<newAdj.size(); i++) {
			int u = i;
			det.clear();
			for (int j=0; j<newAdj.get(i).size(); j++) {
				for (int k=0; k<adj[newAdj.get(i).get(j)].size(); k++) {
					int v = prov[adj[newAdj.get(i).get(j)].get(k)];
					if (u != v && !det.contains(v)) {
						det.add(v);
						pAdj[u].add(v);
					}
				}
			}
		}
//		for(int i=0; i<2; i++) {
//			System.out.println(pAdj[i]);
//		}
//		
//		System.out.println("==");
//		
//		for(int i=0; i<2; i++) {
//			System.out.println(pVal[i]);
//		}
//		
//		System.out.println("==");
//		for(int i=1; i<7; i++) {
//			System.out.println(prov[i]);
//		}
//		System.out.println("==");

		Pair ans = query(prov[1], 1);
		System.out.printf("%d %d\n", ans.first, ans.second);


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




