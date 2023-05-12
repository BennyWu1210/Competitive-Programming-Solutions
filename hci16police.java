
import java.io.*;
import java.util.*;

public class hci16police {



	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MN = (int)1e5 + 5; static final long INF = (long)1e18;
	static long[] dp[] = new long[MN][2], pos = new long[MN];
	static int N, H;
	
	static double slope(int j) {
		return -2 * pos[j];
	}
	
	static double yInt(int j) {
		return pos[j] * pos[j] + dp[j][1];
	}
	
	static double Intersect(int a, int b) {
		return (yInt(b) - yInt(a)) / (slope(a) - slope(b));
	}
	
	public static void main(String[] args) throws IOException {
		
		Reader r = new Reader();
		N = r.nextInt(); H = r.nextInt();
		
		for (int i=1; i<=N; i++) {
			pos[i] = r.nextLong();
			dp[i][0] = dp[i][1] = INF;
		}
		
		dp[1][0] = INF;
		dp[1][1] = H;
		
		// Brute force solution
//		for (int i=2; i<=N; i++) {
//			for (int j=1; j<i; j++) {
//				long dif = pos[i] - pos[j];
//				dp[i][0] = Math.min(dp[i][0], dp[j][1] + dif * dif);
//			}
//			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + H;
//		}
//		
//		System.out.println(Math.min(dp[N][0], dp[N][1]));
		
		LinkedList<Integer> hull = new LinkedList();
		hull.add(1);
		
		for (int i=2; i<=N; i++) {
			while (hull.size() >= 2 && Intersect(hull.get(0), hull.get(1)) < pos[i]) {
				hull.pollFirst();
			}
			
			long dif = pos[i] - pos[hull.peekFirst()];
			dp[i][0] = dif * dif + dp[hull.peekFirst()][1];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + H;
			
			while (hull.size() >= 2 && Intersect(hull.get(hull.size()-1), hull.get(hull.size()-2)) > Intersect(hull.get(hull.size()-2), i)) {
				hull.pollLast();
			}
			
			hull.addLast(i);
		}
		
		System.out.println(Math.min(dp[N][0], dp[N][1]));
		
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


	
	
