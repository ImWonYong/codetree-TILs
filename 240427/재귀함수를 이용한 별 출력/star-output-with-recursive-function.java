import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        printStar(sc.nextInt());
    }

    public static void printStar(int num) {
        if (num == 0) {
            return;
        }

        printStar(num - 1);

        for (int i = 0; i < num; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}