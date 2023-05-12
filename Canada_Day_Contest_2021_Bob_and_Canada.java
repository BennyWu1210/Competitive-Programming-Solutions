import java.io.*;
import java.util.*;
public class Canada_Day_Contest_2021_Bob_and_Canada {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int T = readInt();
        for (int t = 0; t<T; t++) {
            int N = readInt();
            String flag = next();
            int [] W = new int [flag.length()];
            int [] R = new int [flag.length()];
            for (int i=0; i<flag.length(); i++) {
                char c= flag.charAt(i);
                if (i==0) {
                    if (c=='R') R[i] = 1;
                    else W[i] = 1;
                }
                else {
                    if (c=='R') {
                        R[i] = R[i-1] + 1;
                        W[i] = W[i-1];
                    }
                    else {
                        W[i] = W[i-1] + 1;
                        R[i] = R[i-1];
                    }
                }
                
            }
//            System.out.println("White: " + Arrays.toString(W));
//            System.out.println("Red: " + Arrays.toString(R));
            int min = W[0] + R[1] - R[0] + W[N-1] - W[1], A_Best = Integer.MIN_VALUE;
//            System.out.println("Initial Min: " + min);
//            System.out.println();
            int a = 0, b = 1;
            boolean isAMoved = false;
            while(true) {
                if (b + 1 > N - 1) break;
//                System.out.println("R[b-1] - W[b-1]: " + (R[b-1] - W[b-1]));
//                System.out.println("A_Best: " + A_Best);
                if (R[b-1] - W[b-1] >= A_Best && !isAMoved) {
                    
                    A_Best = R[b-1] - W[b-1];
                    a = b-1;
                    isAMoved = true;
                    min = Math.min(min, W[a] + R[b] - R[a] + W[N-1] - W[b]);
                }else {
                    
                    isAMoved = false;
                    // if (min == 0) min = W[a] + R[b] - R[a] + W[N-1] - W[b];
                    min = Math.min(min, W[a] + R[b] - R[a] + W[N-1] - W[b]);
                    b++;
//                    System.out.println("Inside");
//                    System.out.println("A index: " + a);
//                    System.out.println("B index: " + b);
//                    System.out.println("Min: " + min);
//                    
//                    System.out.println();
//                    min = min == 0 ? min = W[a] + R[b] - R[a] + W[N-1] - W[b] : Math.min(min, W[a] + R[b] - R[a] + W[N-1] - W[b]);
                    
                }
//                System.out.println("Answer: " + (W[a] + R[b] - R[a] + W[N-1] - W[b]));
//                System.out.println("A index: " + a);
//                System.out.println("B index: " + b);
//                System.out.println("Min: " + min);
//                System.out.println();
            }
            System.out.println(min);
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