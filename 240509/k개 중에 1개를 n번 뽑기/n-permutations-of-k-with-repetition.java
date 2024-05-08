import java.util.*;

public class Main {
    public static int k;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        k = sc.nextInt();
        n = sc.nextInt();

        recursive(0, "");
    }

    public static void recursive(int num, String s) {
        if (num == n) {
            System.out.println(s);
            return;
        }

        for (int i = 1; i <= k; i++) {
            String temp = String.valueOf(i) + " ";
            recursive(num + 1, s + temp);
        }
    }
}