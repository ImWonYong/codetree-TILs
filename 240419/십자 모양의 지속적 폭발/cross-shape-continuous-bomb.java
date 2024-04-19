import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;

    public static void drop() {
        int[][] temp = new int[n][n];

        for (int j = 0; j < n; j++) {
            int tempIdx = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] != 0)
                    temp[tempIdx--][j] = board[i][j];
            }
        }

        board = temp;
    }

    public static boolean isBombRange(int x, int y, int r, int c, int d) {
        if ((x == r || y == c) && (Math.abs(x - r) + Math.abs(y - c) < d)) return true;
        return false;
    }

    public static int findRow(int c) {
        for (int i = 0; i < n; i++) {
            if (board[i][c] != 0) {
                return i;
            }
        }

        return -1;
    }

    public static void bomb(int c) {

        int r = findRow(c);

        if (r != -1) {
            int d = board[r][c];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isBombRange(r, c, i, j, d))
                        board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int c = sc.nextInt() - 1;

            bomb(c);

            drop();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}