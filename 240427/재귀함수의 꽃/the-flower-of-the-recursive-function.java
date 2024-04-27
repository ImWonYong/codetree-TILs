import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int num = sc.nextInt();

        print(num);
    }

    public static void print(int n) {
        if (n == 0)
            return;

        System.out.print(n + " ");
        print(n - 1);
        System.out.print(n + " ");
    }
}