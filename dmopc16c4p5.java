
import java.io.*;
import java.util.*;

public class dmopc16c4p5 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static class Edge implements Comparable<Edge>{
		int u, v, p;
		
		public Edge(int u, int v, int p) {
			this.u = u;
			this.v = v;
			this.p = p;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return - (this.p - o.p);
		}
	}
	
	static int[] par, ans, hasOne;
	static ArrayList<Integer>[] sets;
	
	static int find(int u) {
		if (par[u] == u) return u;
		return par[u] = find(par[u]);
	}
	
	static void merge(int u, int v, int val) {
		
		u = find(u);
		v = find(v);

		
		if (sets[u].size() > sets[v].size()) {
			int temp = u;
			u = v;
			v = temp;
		}
		
		if (hasOne[u] == 1) for (int a: sets[v]) ans[a] = val;
		else for (int a: sets[u]) ans[a] = val;
		
		sets[v].addAll(sets[u]);
		par[u] = v;
		hasOne[v] |= hasOne[u];
		
		
	}
	
	public static void main(String[] args) throws IOException {

		Reader r = new Reader();
		int n = r.nextInt(), m = r.nextInt();
		
		List<Edge> edges = new ArrayList();
		ans = new int[n+1];
		par = new int[n+1];
		hasOne = new int[n+1];
		sets = new ArrayList[n+1];
		
		hasOne[1] = 1;
		for (int i=1; i<=n; i++) {
			par[i] = i;
			sets[i] = new ArrayList();
			sets[i].add(i);
		}
		
		for (int i=0; i<m; i++) {
			int u = r.nextInt(), v = r.nextInt(), p = r.nextInt();
			edges.add(new Edge(u, v, p));
		}
		
		Collections.sort(edges);
		
		for (Edge e: edges) {
			int u = find(e.u), v = find(e.v);
			
			if (u != v) {
				merge(e.u, e.v, e.p);
			}
		}
		
		for (int i=1; i<=n; i++) System.out.println(ans[i]);
	}
	
	
	static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}


	
	
