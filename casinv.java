
import java.io.*;
import java.util.*;

public class casinv {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e6+5;
	static pair[] h = new pair[MM];
	
	static class pair{
		long v, count;
		
		public pair(int v, int count){
			this.v = v;
			this.count = count;
		}
	}
	
	static void update(int ind, int v) {
		for (int i=ind; i<MM; i+=(i&-i)) {
			if (h[i] == null) h[i] = new pair(0, 0);
			
			h[i].v += v;
			h[i].count ++;
		}
	}
	
	static pair query(int ind) {
		pair res = new pair(0, 0);
		
		for (int i=ind; i>0; i-=(i&-i)) {
			if (h[i] == null) continue;
			res.count += h[i].count;
			res.v += h[i].v;
		}
		
		return res;
	}
	
	public static void main(String[] args) throws IOException {

		Reader r = new Reader();
		int N = r.nextInt();
		int max = -1;
		
		for (int i=0; i<N; i++) {
			int height = r.nextInt();
			update(height, height);
			max = Math.max(max, height);
		}
		
		int[] right = new int[N];
		
		int maxRight = -1;
		for (int i=0; i<N; i++) {
			int height = r.nextInt();
			right[i] = height;
			maxRight = Math.max(maxRight, height);
		}
		
		if (maxRight != max) {
			System.out.println(-1);
			return;
		}
		
		long res = 0;
		for (int i=0; i<N; i++) {
			pair ans = query(right[i]);
			
			res += (long)right[i] * (N - ans.count) + ans.v;
		}
		
		System.out.println(res);
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


	
	
