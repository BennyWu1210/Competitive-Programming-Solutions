
import java.io.*;
import java.util.*;


public class CCC09S4 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static class Node implements Comparable<Node>{
		int city;
		int cost;
		
		public Node(int city, int cost) {
			this.city = city;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
	
	// global variables
	public static ArrayList<Node>[] adjList;
	public static int[] keys;
	public static boolean[] set;
	public static PriorityQueue<Node> pq;
	public static int[] buy;
	
	public static void main(String[] args) throws IOException {
		
		FastReader fr = new FastReader();
		int n = fr.nextInt(), t = fr.nextInt();
		
		adjList = new ArrayList[n];
		pq = new PriorityQueue<Node>();
		keys = new int[n];
		buy = new int[n];
		for(int i=0; i<n; i++) {
			adjList[i] = new ArrayList<Node>();
			buy[i] = -1;
			keys[i] = Integer.MAX_VALUE;
		}
		
		for(int i=0; i<t; i++) {
			int bv = fr.nextInt()-1, ev = fr.nextInt()-1, cost = fr.nextInt();
			adjList[bv].add(new Node(ev, cost));
			adjList[ev].add(new Node(bv, cost));
		}
		
		int k = fr.nextInt();
		
		
		
		for(int i=0; i<k; i++) {
			int city = fr.nextInt()-1, cost = fr.nextInt();
			
			buy[city] = cost;
			// keys[city] = cost;
		}
	
		
		int des = fr.nextInt()-1;
		
		set = new boolean[n];
		pq.add(new Node(des, 0));
		keys[des] = 0;
		
		
		while(!pq.isEmpty()) {
			Node next = pq.poll();
			
			int city = next.city;
			int cost = next.cost;
			
			set[city] = true;
			if (keys[city] != next.cost) continue;
			
			
			for(Node node: adjList[city]) {
				if (!set[node.city] && keys[node.city] > node.cost + keys[city]) {
					keys[node.city] = node.cost + keys[city];
					pq.add(new Node(node.city, keys[node.city]));
				}
			}
		}
				
		
		int minCost = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if (set[i] && buy[i] != -1) {
				minCost = Math.min(minCost, buy[i] + keys[i]);
			}
		}
		System.out.println(minCost);
		
	}
	
	static class FastReader {
        final InputStream in = System.in;
        final int bufSize = 100000;
        byte[] buf = new byte[bufSize];
        int pos = 0;
        int byteCount = bufSize;

        int nextInt() throws IOException {
            byte ch = readByte();
            while(ch <= ' ') ch = readByte();

            boolean isNegative = ch == '-';
            if(isNegative) ch = readByte();

            int result = ch - '0';

            while ((ch = readByte()) >= '0' && ch <= '9') {
                result = result*10 + ch - '0';
            }
            return isNegative ? -result : result;
        }

        FastReader() throws IOException {
            fill();
        }

        void fill() throws IOException {
            byteCount = in.read(buf, 0, bufSize);
        }

        byte readByte() throws IOException {
            if (pos == byteCount) {
                fill();
                pos = 0;
            }
            return buf[pos++];
        }
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


	
	
