import java.io.*;
import java.util.*;

public class SurpriseTeleport {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");
		int R = Integer.parseInt(input[0]);
		int C = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int startR = Integer.parseInt(input[0]);
		int startC = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		int endR = Integer.parseInt(input[0]);
		int endC = Integer.parseInt(input[1]);

		boolean [][] grid = new boolean [R][C];
		int [][] step = new int [R][C];

		for(int i=0;i<R;i++) {
			char [] c = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(c[j]=='O') {
					grid[i][j]=true;
				}
				step[i][j] = Integer.MAX_VALUE;
			}
		}
		
		
		int [] xDir = {1, -1, 0, 0};
		int [] yDir = {0, 0, 1, -1};
		
		Queue<int []> q = new LinkedList<>();
		boolean [][] vis = new boolean [R][C];
		int [] cor = {startR,startC};
		q.add(cor);
		vis[startR][startC]=true;
		step[startR][startC] = 0;
		
		
		while(!q.isEmpty()) {
			int [] cur =q.poll();
			for(int i=0;i<4;i++) {
				int nxtX= xDir[i]+cur[0];
				int nxtY= yDir[i]+cur[1];
				
				if(nxtX<R && nxtX>=0 && nxtY<C && nxtY>=0 && grid[nxtX][nxtY] && !vis[nxtX][nxtY]) {
					step[nxtX][nxtY]=step[cur[0]][cur[1]]+1;
					vis[nxtX][nxtY]=true;
					q.add(new int[] {nxtX,nxtY});
				}
			}
		}

		int min=Integer.MAX_VALUE;
		int output=0;
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			input = br.readLine().split(" ");
			int tR = Integer.parseInt(input[0]);
			int tC = Integer.parseInt(input[1]);
			output=step[tR][tC];
			if(min>output) {
				min=output;
			}
		}
		if(step[endR][endC]<min) {
			System.out.println(0);
		}else {
		System.out.println(step[endR][endC]-min);
		}
	

	}

}