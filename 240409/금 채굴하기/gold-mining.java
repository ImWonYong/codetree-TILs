import java.util.*;

public class Main {
    public static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        m = sc.nextInt();

        int[][] map = new int[n][n];

        int totalSum = 0;
        int totalGold = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 1) {
                    totalSum += m;
                }
            }
        }

        int k = 0;
        while (true) {
            int totalExpense = k * k + (k + 1) * (k + 1);
            if (totalExpense > totalSum)
                break;

            int[][] rhombus = makeRhombus(k++);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    totalGold = Math.max(totalGold, calMaxGold(i, j, totalExpense, rhombus, map));
                }
            }
        }

        System.out.println(totalGold);
    }

    public static int calMaxGold(int x, int y, int totalExpense, int[][] rhombus, int[][] map) {
        int n = rhombus.length;
        int mid = n / 2;

        int nx = x - mid;
        int ny = y - mid;

        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rhombus[i][j] == 0) continue;

                int tempX = nx + i;
                int tempY = ny + j;

                if (tempX < 0 || tempX >= map.length || tempY < 0 || tempY >= map.length) continue;

                if (map[tempX][tempY] == 1) {
                    sum += m;
                    count++;
                }
            }
        }
        
        if (totalExpense <= sum) {
            return count;
        }

        return 0;
    }

    public static int[][] makeRhombus(int k) {
        int length = k * 2 + 1;
        int[][] rhombus = new int[length][length];

        for (int i = 0; i < length; i++) {
            int start = Math.abs(i - k);
            for (int j = start; j < 2 * k - start + 1; j++) {
                rhombus[i][j] = 1;
            }
        }

        return rhombus;
    }
}