import java.util.*;

public class test3130 {

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        Map<Long, Integer> map = new HashMap();
      
        int N = sc.nextInt();
        int P = sc.nextInt();

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        String maxname = "";
        String minname = "";

        
        for (int i = 0; i < N; i++)
        {
            String name = sc.next();
            long M = sc.nextLong();
            long CS = sc.nextLong();
            long E = sc.nextLong();

            double S = (4 * (Math.sqrt(M) - E) + 3 * Math.pow(CS, P));
            long value = (long)Math.floor(S);

            
//            if (map.containsKey(value)) throw new AssertionError();
//            map.put(value, 1);
//            
            if (S > max)
            {
                max = value;
                maxname = name;
            }
            else if (S < min)
            {
                min = value;
                minname = name;
            }

        }

        
        System.out.println(maxname + " " + max);

        System.out.println(minname + " " + min);

    }

}