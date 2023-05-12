
import java.io.*;
import java.util.*;

public class ArrayTest0312 {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(); long M = readLong(); long[] arr = new long [N];
        for (int i=0; i < N; i++)
            arr[i] = readLong();
        Arrays.sort(arr);
        long counter = 0;

        for (int i = 0; i < N - 1; i++)
        {
            if (arr[i] > M - arr[i])
            {
                break;
            }

            int index = Arrays.binarySearch(arr, M - arr[i] + 1);
            if (index<0) index = - index - 1;
            
            while(index > 0 && index < arr.length && arr[index] == arr[index-1]) index--;
            // arr.length + 1
            // {0, 1, 2, (3)}
            
            counter += index - 1 - i;
        }
        System.out.println(counter);

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