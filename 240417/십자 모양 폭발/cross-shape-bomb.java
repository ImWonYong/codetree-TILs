import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] tempBoard;

    public static boolean isBombRange(int x, int y, int r, int c, int bombRange) {
        return (x == r || y == c) && Math.abs(x - r) + Math.abs(y - c) < bombRange;
    }

    public static void bomb(int r, int c) {
        int bombRange = board[r][c];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isBombRange(i, j, r, c, bombRange))
                    board[i][j] = 0;
            }
        }

        for (int j = 0; j < n; j++) {
            int nextRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (board[i][j] > 0)
                    tempBoard[nextRow--][j] = board[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = tempBoard[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new int[n][n];
        tempBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        bomb(r, c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}