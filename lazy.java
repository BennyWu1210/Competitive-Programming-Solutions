
import java.io.*;
import java.util.*;

public class lazy {

	static int MM = (int)1e5 + 5;
	static Node[] st = new Node[4 * MM];
	static long[] arr = new long[MM];
	
	static class Node{
		long v;
		long lzy1 = 0, lzy2 = 0;
		
		public Node(long v, int lzy1, int lzy2) {
			this.v = v;
			this.lzy1 = lzy1;
			this.lzy2 = lzy2;
		}
	}
	
	
	static void build(int l, int r, int x) {
		if (l == r) st[x] = new Node(arr[l], 0, 0);
		else {
			int mid = (l + r) / 2;
			build(l, mid, 2*x);
			build(mid+1, r, 2*x+1);
			
			st[x] = new Node(0, 0, 0);
			st[x].v = Math.min(st[2*x].v, st[2*x+1].v);
		}
	}
	
	static void push_down(int l, int r, int x) {
		if (st[x].lzy2 != 0) {
			st[x].v = st[x].lzy2;
			
			if (l != r) {
				st[2*x].lzy2 = st[2*x+1].lzy2 = st[x].lzy2;
				st[2*x].lzy1 = st[2*x+1].lzy1 = 0;
			}
			
			st[x].lzy2 = 0;
		}
		
		if (st[x].lzy1 != 0) {
			st[x].v += st[x].lzy1;
			
			if (l != r) {
				st[2*x].lzy1 += st[x].lzy1;
				st[2*x+1].lzy1 += st[x].lzy1;
			}
			
			st[x].lzy1 = 0;
		}
	}
	
	static void update1(int l, int r, int x, int lef, int rit, long v) {
		push_down(l, r, x);
		if (l > rit || r < lef) return;
		if (l >= lef && r <= rit) {
			st[x].lzy1 = v;
			push_down(l, r, x);
			return;
		}
		
		int mid = (l + r) / 2;
		update1(l, mid, 2*x, lef, rit, v);
		update1(mid+1, r, 2*x+1, lef, rit, v);
		
		st[x].v = Math.min(st[2*x].v, st[2*x+1].v);
	}

	static void update2(int l, int r, int x, int lef, int rit, long v) {
		push_down(l, r, x);
		if (l > rit || r < lef) return;
		if (l >= lef && r <= rit) {
			st[x].lzy2 = v;
			push_down(l, r, x);
			return;
		}
		
		int mid = (l + r) / 2;
		update2(l, mid, 2*x, lef, rit, v);
		update2(mid+1, r, 2*x+1, lef, rit, v);
		
		st[x].v = Math.min(st[2*x].v, st[2*x+1].v);
	}
	
	static long query(int l, int r, int x, int lef, int rit) {
		push_down(l, r, x);
		
		if (l > rit || r < lef) return Long.MAX_VALUE;
		if (l >= lef && r <= rit) return st[x].v;
		int mid = (l + r) / 2;
		
		return Math.min(query(l, mid, 2*x, lef, rit), query(mid+1, r, 2*x+1, lef, rit));
	}
	
	public static void main(String[] args) throws IOException {

		Reader r = new Reader();
		int N = r.nextInt(), Q = r.nextInt();
		
		for (int i=1; i<=N; i++) {
			arr[i] = r.nextInt();
		}
		
		build(1, N, 1);
		
		
		for (int i=1; i<=Q; i++) {
			int c = r.nextInt(), a = r.nextInt(), b = r.nextInt();
		
			if (c == 1) {
				int v = r.nextInt();
				update1(1, N, 1, a, b, v);
			}
			else if (c == 2) {
				int v = r.nextInt();
				update2(1, N, 1, a, b, v);
			}
			else {
				System.out.println(query(1, N, 1, a, b));
			}
		}

	}
	static class Reader { 
        final private int BUFFER_SIZE = 1 << 16; 
        private DataInputStream din; 
        private byte[] buffer; 
        private int bufferPointer, bytesRead; 

        public Reader() { 
            din = new DataInputStream(System.in); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        }
    
        public int nextInt() throws IOException { 
            int ret = 0; 
            byte c = Read(); 
            while (c <= ' ') 
                c = Read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = Read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            }  while ((c = Read()) >= '0' && c <= '9'); 
            return neg ? -ret : ret;
        }
    
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
            if (bytesRead == -1) 
                buffer[0] = -1; 
        } 
    
        private byte Read() throws IOException {
            if (bufferPointer == bytesRead) 
                fillBuffer(); 
            return buffer[bufferPointer++]; 
        } 
    
        public void close() throws IOException { 
            if (din == null) 
                return; 
            din.close(); 
        } 
    }
}


	
	
