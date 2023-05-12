
import java.io.*;
import java.util.*;
public class Canada21p3 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int T = readInt();
		
		for(int t=0; t<T; t++) {
			char[] input = readLine().toCharArray();
			int K = readInt();
			int k = K;
			int len = input.length;
			LinkedList<Integer> list = new LinkedList<Integer>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
			int i = 1;
			int stopIndex = -1;
					
			while(i<=len) {
				System.out.println(list);
				System.out.println(pq);
				if (i==len) {
//					if(K > 0 && pq.size() > 0 && Character.getNumericValue(input[i-1]) < pq.peek()) {
//						pq.add(Character.getNumericValue(input[i-1]));
//						K --;
//					}
//					else {
//						list.add(Character.getNumericValue(input[i-1]));
//					}
//					break;
//					if (pq.size() > 0 && list.get(list.size()) < pq.peek()) {
//						pq.add(Character.getNumericValue(input[i-1]));
//					}
//					else {
//						list.add(Character.getNumericValue(input[i-1]));
//					}
//					break;
//					if (pq.size() > 0 && input[i-1] > pq.peek()) {
//						pq.add(Character.getNumericValue(input[i-1]));
//						K --;
//					}
//					else {
//						list.add(Character.getNumericValue(input[i-1]));
//					}
					
					list.add(Character.getNumericValue(input[i-1]));
					int index = 1;
					while(K > 0 && list.size() > 0 && index<list.size()) {
						int num = list.get(index-1);
						if (num > list.get(index)) {
							pq.add(num);
							list.remove(index-1);
							K --;
							
						}
						index++;
					}
					break;
				}
				if (K > 0 && input[i] < input[i-1]) {
					pq.add(Character.getNumericValue(input[i-1]));
					K --;
				}
				else {
					list.add(Character.getNumericValue(input[i-1]));
				}
				
				i++;
			}
			System.out.println("===");
			System.out.println(list);
			System.out.println(pq);
			
			int lSize = list.size();
			for(int h=0; h<lSize; h++) {
				System.out.print(list.poll());
			}
			int pSize = pq.size();
			for(int h=0; h<pSize; h++) {
				System.out.print(pq.poll());
			}
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
