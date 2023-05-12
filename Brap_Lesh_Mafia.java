import java.util.*;
public class Brap_Lesh_Mafia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double K = sc.nextDouble();
		
		double ans = 0;
		
		for(int i=0; i<N; i++) {
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			ans = (a*b+ans)%K;
		}
		
		System.out.println((int)ans);
		
		
	}

}
