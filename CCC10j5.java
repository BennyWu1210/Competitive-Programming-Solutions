import java.util.*;
import java.io.*;
public class CCC10j5 {

	static int[][] step;
	static LinkedList<int[]> queue;
	static int[] startPos;
	static int[] endPos;
	public static void fill(int curX, int curY, int x, int y) {
		if (0 <= x && x < 8 && 0 <= y && y < 8) {
			if (step[x][y] > step[curX][curY] + 1) {
				step[x][y] = step[curX][curY] + 1;
				queue.add(new int[] {x, y});
				if (x == 8-endPos[0] && y == endPos[1]-1){
					System.out.println(step[x][y]);
					//System.out.println("yay");
					System.exit(0);
				}
			}
		}
	
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] input1 = br.readLine().split(" ");
		String[] input2 = br.readLine().split(" ");
		startPos = new int[]{Integer.parseInt(input1[0]), Integer.parseInt(input1[1])};
		endPos = new int[]{Integer.parseInt(input2[0]), Integer.parseInt(input2[1])};
//		System.out.println(startPos[0] + " " + startPos[1]);
//		System.out.println(endPos[0] + " " + endPos[1]);
		
		step = new int[8][8];
		
		for (int i=0; i<step.length; i++) {
			for (int j=0; j<step[i].length; j++) {
				step[i][j] = Integer.MAX_VALUE;
			}
		}
		step[8-startPos[0]][startPos[1]-1] = 0;
		queue = new LinkedList<int[]>();
		queue.add(new int[] {8-startPos[0], startPos[1]-1});
		if (startPos[0] == endPos[0] && startPos[1] == endPos[1]) {
			System.out.println(0);
			System.exit(0);
		}
		
		while(!queue.isEmpty()) {
			int[] pos = queue.poll();
			//System.out.println(pos[0] + " " + pos[1]);
			fill(pos[0], pos[1], pos[0]+1, pos[1]+2);
			fill(pos[0], pos[1], pos[0]+1, pos[1]-2);
			fill(pos[0], pos[1], pos[0]-1, pos[1]+2);
			fill(pos[0], pos[1], pos[0]-1, pos[1]-2);
			fill(pos[0], pos[1], pos[0]+2, pos[1]+1);
			fill(pos[0], pos[1], pos[0]+2, pos[1]-1);
			fill(pos[0], pos[1], pos[0]-2, pos[1]+1);
			fill(pos[0], pos[1], pos[0]-2, pos[1]-1);
			
			
		}
		
		
		
	}
	

}
