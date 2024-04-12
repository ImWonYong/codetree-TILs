import java.util.*;

public class Main {
    public static int n;
    public static int t;
    
    public static int[] u;
    public static int[] m;
    public static int[] d;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        t = sc.nextInt();

        u = new int[n];
        m = new int[n];
        d = new int[n];

        for (int i = 0; i < n; i++) {
            u[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            m[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        

        while (t-- > 0) {
            int temp1 = u[n - 1];
            int temp2 = m[n - 1];

            for (int i = n - 1; i >= 1; i--) {
                u[i] = u[i - 1];
            }
            u[0] = d[n - 1];

            for (int i = n - 1; i >= 1; i--) {
                m[i] = m[i - 1];
            }
            m[0] = temp1;

            for (int i = n - 1; i >= 1; i--) {
                d[i] = d[i - 1];
            }
            d[0] = temp2;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(u[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(m[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println();
    }
}