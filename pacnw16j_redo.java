import java.io.*;
import java.util.*;

public class pacnw16j_redo {
    static final int MN = 100005;
    static int[] a = new int[MN];
    static int[] st = new int[MN * 4];
    static int n, m, x, y;
    static char c;
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        
		Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        build(1, n, 1);
        for (int i = 1; i <= m; i++) {
            c = in.next().charAt(0);
            x = in.nextInt();
            y = in.nextInt();
            if (c == 'M') update(1, n, x+1, y, 1);
            else System.out.println(query(1, n, x+1, y+1, 1));
        }
    }
    public static void build(int l, int r, int idx) {
        if (l == r) {st[idx] = a[l]; return;}
        int mid = (l + r) / 2;
        build(l, mid, idx * 2);
        build(mid + 1, r, idx * 2 + 1);
        st[idx] = Math.min(st[idx * 2], st[idx * 2 + 1]);
    }
    public static void update(int l, int r, int x, int val, int idx) {
        if (l == r) {st[idx] = val; return;}
        int mid = (l + r) / 2;
        if (mid >= x) update(l, mid, x, val, idx * 2);
        else update(mid + 1, r, x, val, idx * 2 + 1);
        st[idx] = Math.min(st[idx * 2], st[idx * 2 + 1]);
    }
    public static int query(int l, int r, int x, int y, int idx) {
        if (r < x || l > y) return Integer.MAX_VALUE;
        if (r <= y && l >= x) return st[idx];
        int mid = (l + r) / 2;
        int lmin = query(l, mid, x, y, idx * 2);
        int rmin = query(mid + 1, r, x, y, idx * 2 + 1);
        return Math.min(lmin, rmin);
    }
}