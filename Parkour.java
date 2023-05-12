import java.util.*;
import java.io.*;
public class Parkour {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input1 = br.readLine().split(" ");
		int X = Integer.parseInt(input1[0]);
		int Y = Integer.parseInt(input1[1]);
		int H = Integer.parseInt(input1[2]);
		int V = Integer.parseInt(input1[3]);
		String[] input2 = br.readLine().split(" ");
		int T = Integer.parseInt(input2[0]);
		
		int dH = H;
		int dV = V;
		if (H>6) {
			dH = 3;
		}
		if (V>6) {
			dV = 3;
		}
		
		int[][] step = new int[X+10][Y+10];
		LinkedList<int[]> queue = new LinkedList<int[]>();
		
		for(int i=0; i<X+10; i++) {
			for(int j=0; j<Y+10; j++) {
				step[i][j] = Integer.MAX_VALUE;
			}
		}
		queue.add(new int[] {0,0});
		step[0][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			//System.out.println(x + " " + y);
			
			if (x+2 < X+10 && y+1 < Y+10 && step[x+2][y+1] > step[x][y] + 1) {
				step[x+2][y+1] = step[x][y]+1;
				queue.add(new int[] {x+2, y+1});
			}
			
			if (x+1 < X+10 && y+2 < Y+10 && step[x+1][y+2] > step[x][y] + 1) {
				step[x+1][y+2] = step[x][y]+1;
				queue.add(new int[] {x+1, y+2});
			}
			
			
		}
		
//		for(int[] a: step) {
//			System.out.println(Arrays.toString(a));
//		}
//		
		int minStep = Integer.MAX_VALUE;
		for (int i=X; i<X+10; i++) {
			if (step[i][Y] < minStep) {
				minStep = step[i][Y];
			}
		}
		
		for (int i=Y; i<Y+10; i++) {
			if (step[X][i] != -1 && step[X][i] < minStep) {
				minStep = step[X][i];
			}
		}
//		System.out.println(minStep);
//		System.out.println(T);
		if(minStep < T) System.out.println("YES");
		else System.out.println("NO");
		
	}

}
