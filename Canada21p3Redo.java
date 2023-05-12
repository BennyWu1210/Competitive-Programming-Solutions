import java.io.*;
import java.util.*;
public class Canada21p3Redo
{

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for(int t=0; t<T; t++) {
			char[] input = readLine().toCharArray();
			int len = input.length;
			LinkedList<Integer> front = new LinkedList<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			
			for(int i=len-1; i>=0; i--) {
				front.push(Character.getNumericValue(input[i]));
			}
		
			int K = readInt();
			int kCounter = K;
			int index = 1;
			while(index < front.size() && kCounter > 0) {
				
				if(index <= 0) break;
				int one = front.get(index-1); // First number
				int two = front.get(index);
				// System.out.println(one + " " + two);
				
				if (index < front.size() && kCounter > 0 && !front.isEmpty() && two < one) {
					pq.add(one); // Second number
					front.remove(index-1);
					kCounter --;
					index -= 2;
					if (index < 0) index = 0;

				}
				
//				else{
//					front.push(num);
//				}
				index ++;
			}
			if (kCounter > 0) {
				if(front.getLast() > pq.peek()) pq.add(front.removeLast());
			}
			

			
//			System.out.println(front);
//			System.out.println(pq);
			while(!front.isEmpty()) System.out.print(front.poll());
			while(!pq.isEmpty()) System.out.print(pq.poll());
			System.out.println();
		
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
