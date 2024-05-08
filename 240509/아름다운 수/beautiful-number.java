import java.util.*;

public class Main {
    public static int n;
    public static List<Integer> list = new ArrayList<>();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        recursive(0);

        System.out.println(count);
    }

    public static void printNum() {
        for (int num: list) {
            System.out.print(num);
        }
        System.out.println();
    }

    public static void recursive(int num) {
        if (num == n) {
            if (checkPerfectNum()) {
                count++;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            list.add(i);
            recursive(num + 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean checkPerfectNum() {
        boolean isPerfect = true;

        int num = list.get(0);
        int numCount = 1;

        if (list.size() == 1) {
            if (num == 1) return true;
            
            return false;
        }

        for (int i = 1; i < list.size(); i++) {
            if (num == list.get(i)) {
                numCount++;
            } else {
                if (numCount % num != 0) {
                    isPerfect = false;
                    break;
                }
                num = list.get(i);
                numCount = 1;
            }
        }

        if (numCount % num != 0)
            isPerfect = false;

        return isPerfect;
    }
}