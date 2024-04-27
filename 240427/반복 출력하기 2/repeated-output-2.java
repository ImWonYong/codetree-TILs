import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        print(sc.nextInt());

    }

    public static void print(int num) {
        if (num == 0)
            return;

        print(num - 1);
        System.out.println("HelloWorld");
    }
}