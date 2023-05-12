import java.util.*;
import java.io.*;

public class Spoj_Minimum_Knight_Moves {

	public static void main(String[] args) throws IOException{
		// Use BFS

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().split(" ")[0]);
		
		for(int i=0; i<T; i++) {
			int[][] moves = new int[8][8];
			String[] input = br.readLine().split("");
			int[] start = new int[] {(int)input[0].charAt(0) - 97 + 1, 9-Integer.parseInt(input[1])}; // Convert from ASCII
			int[] end = new int[] {(int)input[3].charAt(0) - 97 + 1, 9-Integer.parseInt(input[4])};
			
//			System.out.println(Arrays.toString(start));
//			System.out.println(Arrays.toString(end));
			
			for(int j=0; j<moves.length; j++) {
				Arrays.fill(moves[j], Integer.MAX_VALUE);
			}
			
			LinkedList<int[]> queue = new LinkedList<int[]>();
			queue.add(new int[] {start[0]-1, start[1]-1});
			moves[start[0]-1][start[1]-1] = 0;
			
			if (start[0] == end[0] && start[1] == end[1]) {
				System.out.println(0);
				continue;
			}
			
			while(!queue.isEmpty()) {
				int[] pos = queue.poll();
				int x = pos[0];
				int y = pos[1];
//				System.out.println(x + " " + y);
//				System.out.println(moves[x][y]);
				if (x-2 >= 0 && y-1 >= 0 && moves[x-2][y-1] > moves[x][y] + 1) {
					moves[x-2][y-1] = moves[x][y] + 1;
					queue.add(new int[] {x-2, y-1});
					// System.out.println('0');
					if (x-2 == end[0]-1 && y-1 == end[1]-1) {
						System.out.println(moves[x-2][y-1]);
						break;
					}
				}
				if (x-2 >= 0 && y+1 < 8 && moves[x-2][y+1] > moves[x][y] + 1) {
					moves[x-2][y+1] = moves[x][y] + 1;
					queue.add(new int[] {x-2, y+1});
					// System.out.println('a');
					if (x-2 == end[0]-1 && y+1 == end[1]-1) {
						System.out.println(moves[x-2][y+1]);
						break;
					}
				}
				if (x-1 >= 0 && y-2 >= 0 && moves[x-1][y-2] > moves[x][y] + 1) {
					moves[x-1][y-2] = moves[x][y] + 1;
					queue.add(new int[] {x-1, y-2});
					// System.out.println('b');
					if (x-1 == end[0]-1 && y-2 == end[1]-1) {
						System.out.println(moves[x-1][y-2]);
						break;
					}
				}
				if (x-1 >= 0 && y+2 < 8 && moves[x-1][y+2] > moves[x][y] + 1) {
					moves[x-1][y+2] = moves[x][y] + 1;
					queue.add(new int[] {x-1, y+2});
					// System.out.println('c');
					if (x-1 == end[0]-1 && y+2 == end[1]-1) {
						System.out.println(moves[x-1][y+2]);
						break;
					}
				}
				if (x+2 < 8 && y-1 >= 0 && moves[x+2][y-1] > moves[x][y] + 1) {
					moves[x+2][y-1] = moves[x][y] + 1;
					queue.add(new int[] {x+2, y-1});
					// System.out.println('d');
					if (x+2 == end[0]-1 && y-1 == end[1]-1) {
						System.out.println(moves[x+2][y-1]);
						break;
					}
				}
				if (x+2 < 8 && y+1 < 8 && moves[x+2][y+1] > moves[x][y] + 1) {
					moves[x+2][y+1] = moves[x][y] + 1;
					queue.add(new int[] {x+2, y+1});
					// System.out.println('e');
					if (x+2 == end[0]-1 && y+1 == end[1]-1) {
						System.out.println(moves[x+2][y+1]);
						break;
					}
				}
				if (x+1 < 8 && y-2 >= 0 && moves[x+1][y-2] > moves[x][y] + 1) {
					moves[x+1][y-2] = moves[x][y] + 1;
					queue.add(new int[] {x+1, y-2});
					// System.out.println('f');
					if (x+1 == end[0]-1 && y-2 == end[1]-1) {
						System.out.println(moves[x+1][y-2]);
						break;
					}
				}
				if (x+1 < 8 && y+2 < 8 && moves[x+1][y+2] > moves[x][y] + 1) {
					moves[x+1][y+2] = moves[x][y] + 1;
					queue.add(new int[] {x+1, y+2});
					// System.out.println('g');
					if (x+1 == end[0]-1 && y+2 == end[1]-1) {
						System.out.println(moves[x+1][y+2]);
						break;
					}
				}
				
				
			}
			
			// System.out.println("no answer?");
			
		}
		
	}

}
