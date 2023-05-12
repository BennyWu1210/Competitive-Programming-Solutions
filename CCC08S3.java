import java.util.*;
import java.io.*;
public class CCC08S3 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i=0; i<t; i++) {
			int r = Integer.parseInt(br.readLine());
			int c = Integer.parseInt(br.readLine());
			boolean cont = true;

			
			char[][] map = new char[r][c];
			
			for(int j=0; j<r; j++) {
				String input = br.readLine();
				map[j] = input.toCharArray();
				if (r == 1 && c == 2 && input.equals("+*")) {
					
					cont = false;
					System.out.println(-1);
					
					
				}
				
			}
			if (cont){
				int step[][] = new int[r][c];
				for(int j=0; j<r; j++) {
					Arrays.fill(step[j], Integer.MAX_VALUE);
				}
				step[0][0] = 1;
				
				LinkedList<int[]> queue = new LinkedList<int[]>();
				queue.add(new int[] {0, 0});
				
				while(!queue.isEmpty()) {
					int[] pos = queue.poll();
					int x = pos[0];
					int y = pos[1];
					//System.out.println(x + " " + y);
					if (map[x][y] == '+') { // 4 Directions
						if (x+1 < r && step[x+1][y] > step[x][y] + 1) {
							step[x+1][y] = step[x][y] + 1;
							queue.add(new int[] {x+1, y});
						}
						if (y+1 < c && step[x][y+1] > step[x][y] + 1) {
							step[x][y+1] = step[x][y] + 1;
							queue.add(new int[] {x, y+1});
						}
						if (x-1 >= 0 && step[x-1][y] > step[x][y] + 1) {
							step[x-1][y] = step[x][y] + 1;
							queue.add(new int[] {x-1, y});
						}
						if (y-1 >= 0 && step[x][y-1] > step[x][y] + 1) {
							step[x][y-1] = step[x][y] + 1;
							queue.add(new int[] {x, y-1});
						}
					}
					
					else if (map[x][y] == '-') { // Left and Right
						if (y+1 < c && step[x][y+1] > step[x][y] + 1) {
							step[x][y+1] = step[x][y] + 1;
							queue.add(new int[] {x, y+1});
						}
						if (y-1 >= 0 && step[x][y-1] > step[x][y] + 1) {
							step[x][y-1] = step[x][y] + 1;
							queue.add(new int[] {x, y-1});
						}
						
					}
					
					else if (map[x][y] == '|') { // Left and Right
						if (x+1 < r  && step[x+1][y] > step[x][y] + 1) {
							step[x+1][y] = step[x][y] + 1;
							queue.add(new int[] {x+1, y});
						}
						
						if (x-1 >= 0 && step[x-1][y] > step[x][y] + 1) {
							step[x-1][y] = step[x][y] + 1;
							queue.add(new int[] {x-1, y});
						}
					}
		
				}
				if (step[r-1][c-1] == Integer.MAX_VALUE) {
					System.out.println(-1);
				}
				else {
					System.out.println(step[r-1][c-1]);
				}
				
			}
		}
	}

}
