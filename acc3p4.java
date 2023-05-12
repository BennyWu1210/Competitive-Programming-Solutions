
import java.io.*;
import java.util.*;

public class acc3p4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	static final int MM = (int)1e6 + 6;
	static int N, Q;
	static long[] arr = new long[MM], seg = new long[4*MM], lzy = new long[4*MM];
	
	static void build(int l, int r, int x) {
		if (l == r) seg[x] = arr[l];
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			
			seg[x] = seg[2*x] + seg[2*x+1];
		}
	}
	
	static void update(int l, int r, int x, int lef, int rit, long v) {
		push_down(l, r, x);
		if (l > rit || r < lef) return;
		
		int mid = (l + r) / 2;
		
		if (l >= lef && r <= rit) {
			seg[x] += calc(l - lef + 1, r - lef + 1, v);
			
			if (l != r) {
				lzy[2*x] += calc(l - lef + 1, mid - lef + 1, v);
				lzy[2*x+1] += calc(l - lef + 1, r - lef + 1, v);
			}
			
			return;
		}
		
		update(l, mid, 2*x, lef, rit, v);
		update(mid+1, r, 2*x+1, lef, rit, v);
		
		seg[x] = seg[2*x] + seg[2*x+1];
	}
	
	static long query(int l, int r, int x, int lef, int rit) {
		push_down(l, r, x);
		if (l > rit || r < lef) return 0;
		if (l >= lef && r <= rit) return seg[x];
		
		int mid = (l + r) / 2;
		return query(l, mid, 2*x, lef, rit) + query(mid+1, r, 2*x+1, lef, rit);
	}
	
	static void push_down(int l, int r, int x) {
		if (lzy[x] == 0) return;
		
		seg[x] += lzy[x];
		long tot = (l + r) * (r - l + 1);
		
		if (l != r) {
			int mid = (l + r) / 2;
			lzy[2*x] += ((l + mid) * (mid - l + 1) / tot) * lzy[x];
			lzy[2*x+1] += ((mid + r) * (r - mid + 1) / tot) * lzy[x];
		}
		
		lzy[x] = 0;
	}
	
	static long calc(int l, int r, long v) {
		return (l + r) * (r - l + 1) * v / 2;
	}

	public static void main(String[] args) throws IOException {

		N = readInt(); Q = readInt();
		

		
		for (int i=1; i<=Q; i++) {
			int c = readInt();
			
			if (c == 1) {
				int l = readInt(), r = readInt(), a = readInt();
				update(1, N, 1, l, r, a);
			}
			else {
				int l = readInt(), r = readInt();
				System.out.println(query(1, N, 1, l, r));
			}
		}
		
	}
	
	final private static int BUFFER_SIZE = 1 << 16;
    private static DataInputStream din = new DataInputStream(System.in);
    private static byte[] buffer = new byte[BUFFER_SIZE];
    private static int bufferPointer = 0, bytesRead = 0;
    
	public static String next() throws IOException{
		byte[] ret = new byte[10001];
        int idx = 0;
        byte c = Read();
        while (c <= ' ') {
            c = Read();
        }
        do {
            ret[idx++] = c;
            c = Read();
        } while (c != -1 && c != ' ' && c != '\n' && c != '\r');
        return new String(ret, 0, idx);
	}
	public static int readInt() throws IOException {
        int ret = 0;
        byte c = Read();
        while (c <= ' ')
            c = Read();
        boolean neg = (c == '-');
        if (neg)
            c = Read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = Read()) >= '0' && c <= '9');
 
        if(neg)
            return -ret;
        return ret;
    }
    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1)
            buffer[0] = -1;
    }
 
    private static byte Read() throws IOException {
        if (bufferPointer == bytesRead)
            fillBuffer();
        return buffer[bufferPointer++];
    }
}


	
	
