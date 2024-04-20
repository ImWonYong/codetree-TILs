import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int k;
    public static int[][] board;
    public static int[][] preBoard;
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

            while (beExplode()) {
                bomb();
                drop();
            }
            rotate();
            drop();
        }

        bomb();
        drop();

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) count++;
            }
        }

        System.out.println(count);
    }
    
    public static void isSameBoard() {

    }

    public static void print(String s) {
        System.out.println(s);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
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
            explode(i);
        }
    }

    public static void explode(int c) {
        int startIdx = n - 1;
        int count = 1;

        for (int i = n - 2; i >= 0; i--) {
            if (board[i][c] == 0) break;

            if (board[startIdx][c] == board[i][c]) {
                count++;
            } else {
                if (count >= m) {
                    for (int k = startIdx; k > i; k--) {
                        board[k][c] = 0;
                    }
                }
                startIdx = i;
                count = 1;
            }
        }

        if (count >= m) {
            for (int k = startIdx; k >= 0; k--) {
                board[k][c] = 0;
            }
        }
    }

    public static boolean beExplode() {
        for (int j = 0; j < n; j++) {
            int startIdx = n - 1;
            if (board[startIdx][j] == 0) continue;

            int count = 1;

            for (int i = n - 2; i >= 0; i--) {
                if (board[i][j] == 0) break;
                if (board[startIdx][j] == board[i][j]) {
                    count++;
                } else {
                    if (count >= m) {
                        return true;
                    }
                    startIdx = i;
                    count = 1;
                }
            }

            if (count >= m) return true;
        }

        return false;
    }

}