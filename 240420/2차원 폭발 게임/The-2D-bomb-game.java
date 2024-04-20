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
        k = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        while (k-- > 0) {
            bomb();
            drop();
            rotate();
            drop();
        }

        bomb();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) count++;
            }
        }

        System.out.println(count);
    }

    /*
        90도 돌리기
        (0, 0) -> (0, n - 1) (0, 1) -> (1, n - 1 - 1)
    */
    public static void rotate() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = board[i][j];
            }
        }

        board = temp;
    }

    public static void drop() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int tempIdx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] != 0)
                    temp[tempIdx--][i] = board[j][i];
            }
        }

        board = temp;
    }

    public static void bomb() {

        for (int i = 0; i < n; i++) {
            int count = 1;
            int startIdx = 0;
            for (int j = 1; j < n ;j++) {
                if (board[startIdx][i] == board[j][i]) {
                    count++;
                } else {
                    if (count >= m) {
                        for (int k = startIdx; k < j; k++) {
                            board[k][i] = 0;
                        }
                    }

                    count = 1;
                    startIdx = j;
                }
            }

            if (count >= m) {
                for (int k = startIdx; k < n; k++) {
                    board[k][i] = 0;
                }
            }
        }
    }
}