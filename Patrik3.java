import java.util.*;
import java.io.*;

public class Patrik3 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = readInt();
        long ans=0;
        Stack<Integer> s = new Stack();
        for (int i = 0; i < N; i++) {
            int num = readInt();
            if (i==0) {
                s.push(num);
                continue;
            }
            int num1=s.peek();
            int cnt=1;
            int amount=0;
            while(!(s.isEmpty())&&num>num1){
                amount++;
                ans+=cnt;
                cnt++;
                s.pop();
                if (s.isEmpty()) {
                    break;
                }
                num1=s.peek();
            }
            ans+=s.size()*(long)amount;
            s.push(num);
        }
        int cnt=0;
        while(!s.isEmpty()){
            ans+=cnt;
            cnt++;
            s.pop();
        }
        System.out.println(ans);
        
    }
    
    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }
        return st.nextToken();
    }

    static long readLong() throws IOException {
        return Long.parseLong(next());
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }

    static double readDouble() throws IOException {
        return Double.parseDouble(next());
    }

    static char readCharacter() throws IOException {
        return next().charAt(0);
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

}