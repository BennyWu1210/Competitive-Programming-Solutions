import java.io.*;
import java.util.*;

public class mccc4j4  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	static StringTokenizer st;

	public static class Team implements Comparable<Team> {
		int tnumber;
		int point;
		public Team(int tnumber, int point) {
			this.tnumber = tnumber;
			this.point = point;
		}
		@Override
		public int compareTo(Team o) {
			// TODO Auto-generated method stub
			if (this.point>o.point) {
				return -1;
			} else if (this.point<o.point) {
				return 1;
			} else {
				return this.tnumber-o.tnumber;
			}
		}
	}


	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int N = readInt();
		int S = readInt();
		LinkedList<Integer>[] A = new LinkedList[N/S];
		for (int i=0; i<N/S; i++) {   //N/S groups
			A[i] = new LinkedList<Integer>();
			for (int j=0; j<S; j++) {   //S in a group
				A[i].add(readInt());
			}
		}

		Team[][] B = new Team[N/S][S];    //N/S is amount of group   S is amount of team
		for (int i=0; i<N/S; i++) {    //i is group number
			int[] count = new int[N+1];    //total team amount if N
			for (int j=0; j<S*(S-1)/2; j++) {   //index of count is the team number
				int a = readInt();
				int b = readInt();
				char c = readCharacter();
				if (c=='W') {
					count[a]+=3;
				} else if (c=='T'){
					count[a]++;
					count[b]++;
				} else {
					count[b]+=3;
				}
			}
			for (int j=0; j<S; j++) {
				B[i][j] = new Team(A[i].get(j), count[A[i].get(j)]);
			}
		}
		int K = readInt();
		
		for (int r=0; r<N/S; r++) {
			System.out.println(B[r][K-1].tnumber + " " + B[r][K-1].point);
		}
		for (int r=0; r<N/S-1; r++) {
			Arrays.sort(B[r]);
			System.out.print(B[r][K-1].tnumber+" ");
		}
		
		
		Arrays.sort(B[N/S-1]);
		System.out.print(B[N/S-1][K-1].tnumber);
		System.out.println();
		
		for (int r=0; r<N/S; r++) {
			System.out.println(B[r][K-1].tnumber + " " + B[r][K-1].point);
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