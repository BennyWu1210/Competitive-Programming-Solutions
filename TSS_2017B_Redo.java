
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSS_2017B_Redo {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        long [] psa = new long[1414215];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken()), y = Long.parseLong(st.nextToken());
            double z = Math.sqrt(x*x+y*y);
            if (Math.ceil(z)>=psa.length) continue;
            psa[(int) Math.ceil(z)] ++;
        }
        for (int i = 1; i < psa.length; i++) {
            psa[i] += psa[i-1];
        }
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r>=1414214) {
                System.out.println(N);
                continue;
            }
            System.out.println(psa[r]);
        }
    }
}