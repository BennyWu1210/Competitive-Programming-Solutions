import java.util.*;
import java.io.*;
public class Simon_and_Marcy {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int c = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[] princesses = new int[c];
		int[] minutes = new int[c];
		boolean[] used = new boolean[c];
		int counter = 0;
		
		//System.out.println(c + " " + m);
		
		for(int i=0; i<c; i++) {
			String[] input1 = br.readLine().split(" ");
			int p = Integer.parseInt(input1[0]);
			int s = Integer.parseInt(input1[1]);
			princesses[i] = p;
			minutes[i] = s;
			//System.out.println(p + " " + s);
		}
		
		
		while(true) {
			double maximum = Integer.MIN_VALUE;
			int maxIndex = -1;
			for(int i=0; i<c; i++) {
				if (!used[i] && ((double)princesses[i]/minutes[i]) >= maximum && m-minutes[i] >= 0) {
					//System.out.println(princesses[i]);
					if((double)princesses[i]/minutes[i] == maximum) {
						if (princesses[i] > princesses[maxIndex]) {
							maximum = (double)princesses[i]/minutes[i];
							maxIndex = i;
						}
						else {
							continue;
						}
					}

					maximum = (double)princesses[i]/minutes[i];
					maxIndex = i;
				}
			}
			
			//System.out.println(maximum + " " + princesses[maxIndex]);
			if (maxIndex == -1) {
				break;
			}
			else {
				counter += princesses[maxIndex];
				m -= minutes[maxIndex];
				used[maxIndex] = true;
			}
			
		}
		System.out.println(counter);
		
	}
	

}
