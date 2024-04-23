import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt() - 1;

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int row = -1;
        for(int i = 0; i < n; i++) {
            boolean isPossible = false;

            for (int j = k; j < k + m; j++) {
                if (isRange(i, j)) {
                    isPossible = true;
                } else {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) row = i;
            else break;
        }

        for (int i = k; i < k + m; i++) {
            if (row == -1) break;
            board[row][i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isRange(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < n) && (board[x][y] == 0);
    }
}