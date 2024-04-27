import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        printAscending(num);
        System.out.println();
        printDescending(num);
    }

    public static void printAscending(int num) {
        if (num == 0) {
            return;
        }

        printAscending(num - 1);
        System.out.print(num + " ");
    }

    public static void printDescending(int num) {
        if (num == 0) {
            return;
        }

        System.out.print(num + " ");
        printDescending(num - 1);

    }
}