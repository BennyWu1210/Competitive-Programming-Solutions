
import java.io.*;
import java.util.*;
public class Bob_and_Canada {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// Number of inputs
		int t = readInt();
		for(int time=0; time<t; time++) {
			// input the length of string, and string itself
			int len = readInt();
			String str = readLine();
			
			
			// Total counter
			int counter = 0;
			
			// Checks for the beginning and ending first
			if (str.charAt(0) == 'W') {
				counter ++;
				// str = ("R" + str.substring(1, str.length()-1));
			}
			if (str.charAt(str.length()-1) == 'W'){
				counter ++;
				// str = (str.substring(0, str.length()-2) + "R");
			}

			// Check for beginning and trailling R's
			int startingIndex = 1;
			while(startingIndex < str.length()-1 && str.charAt(startingIndex) == 'R') {
				startingIndex ++;
			}
			//System.out.println(startingIndex);
			if(startingIndex == str.length()-1) {
				System.out.println(counter + 1);
				continue;
			}
			
			int endingIndex = str.length()-2;
			while(endingIndex > 0 && str.charAt(endingIndex) == 'R') {
				endingIndex --;
			}
				
			// Look for the longest W within startingIndex and endingIndex
			
			int temp_counter = 0;
			int largestW = -1;
			int i = startingIndex;
			int startW = -1;
			int endW = -1;
			int l = 0;
//			System.out.println(startingIndex);
//			System.out.println(endingIndex);
			
			while(i <= endingIndex) {
				//System.out.println(str.charAt(i));
				if (str.charAt(i) == 'W') {
					
					temp_counter ++;
					l ++;
					if (i == endingIndex && temp_counter > largestW) {
						
						endW = i;
						startW = i-l;
						largestW = temp_counter;
//						System.out.println(l);
						break;
					}
				}
				else if (temp_counter > 0 && temp_counter > largestW){
					endW = i-1;
					startW = i-l;
					largestW = temp_counter;
					temp_counter = 0;
					l = 0;
				}
				else {
					l = 0;
					temp_counter = 0;
				}
				i ++;
			}
			if (largestW == -1) {
				largestW = temp_counter;
				System.out.println(counter);
				continue;
			}
			
			// System.out.println(largestW);
			
			// Count the R's and W's
			int countR = 0;
			int countW = 0;
			for(int j=startingIndex; j<startW; j++) {
				if (str.charAt(j) == 'R') {
					countR ++;
				}
				else {
					countW ++;
				}
			}
			
			for(int j=endW+1; j<=endingIndex; j++) {
				if (str.charAt(j) == 'R') {
					countR ++;
				}
				else {
					countW ++;
				}
			}
//			System.out.println(startingIndex + " " + endingIndex);
//			System.out.println(startW + " " + endW);
			counter += Math.min(countR, countW);
			System.out.println(counter);
			
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
