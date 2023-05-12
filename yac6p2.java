import java.io.*;
import java.util.*;

public class yac6p2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	
	static int[] a, b;
	static List<Integer>[] revB;
	
	static int[] state;
	static long start;

	static boolean dfs(int u) {

		state[u] = 1;
		
		for (int v: revB[u]) {
			
			if (state[v] == 1) return false;
			if (state[v] == 0) {
				boolean res = dfs(v);
				if (!res) return false;
			}
		}
		
		state[u] = 2;
		return true;
	}
	
	public static void main(String[] args) throws IOException {

		start = System.currentTimeMillis();
		Reader r = new Reader();
		
		
		int N = r.nextInt();
		a = new int[N + 1]; b = new int[N + 1];
		state = new int[N + 1];
		revB  = new ArrayList[N + 1];
		
		int boss = -1;
		int bossB = -1;
		for (int i = 1; i <= N; i++) {
			revB[i] = new ArrayList();
			a[i] = r.nextInt();
			if (a[i] == -1) boss = i;
			
		}
		
		
		for (int i = 1; i <= N; i++) {
			b[i] = r.nextInt();
			if (b[i] == -1) bossB = i;
			else revB[b[i]].add(i);
			
		}
		
		
		// simply check if the new graph is valid (check cycle):
		boolean res = dfs(2);
		
		if (!res) {
			pr.println(-1);
			pr.flush();
			return;
		}
		
		int steps = 0;
		
		for (int i = 1; i <= N; i++) {
			
			
			if (state[i] != 2) {
				pr.println(-1);
				pr.flush();
				return;
			}
			
			// if b[i] is the manager of i, false!
			if (i == boss || a[i] == b[i]) continue;
			
			// otherwise, step++
			steps++;
		}
		

		
		pr.println(steps);
		pr.flush();
		for (int i = 1; i <= N; i++) {
			if (i != boss && a[i] != b[i]) {
				pr.println(i + " " + boss);
			}
			
		}
		
		pr.flush();
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


	
	/*
6
-1 1 1 3 3 4
-1 3 2 5 6 4
*/
