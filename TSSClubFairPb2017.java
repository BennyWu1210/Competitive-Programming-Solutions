import java.io.*;
public class TSSClubFairPb2017 {

	static int MM = (int)1.5e6;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] input = br.readLine().split(" ");

		int N = Integer.parseInt(input[0]);
		int Q = Integer.parseInt(input[1]);
		int  [] cordLength = new int [MM];
		int [] psa = new int[MM];
		for(int i=0; i<N;i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			
			double dLength = Math.sqrt((long)x*x+(long)y*y);
			
			cordLength[(int) Math.ceil(dLength)]++;
		
		}
	

		for(int i=1;i<1414219;i++) {
			psa[i]=psa[i-1]+cordLength[i];
		}

		
		int	[] radius = new int[Q];
		for(int i=0;i<Q;i++) {
			radius[i]= Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<Q;i++) {
			System.out.println(psa[radius[i]]);
		}
	}

}