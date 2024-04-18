import java.util.*;

public class Main {

    public static int n = 4;
    public static int[][] board;
    public static char dir;

    public static void calBoard() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int tempIdx = 0;
            int start = 0;

            while (start < n - 1) {
                if (board[i][start] == board[i][start + 1]) {
                    temp[i][tempIdx++] = 2 * board[i][start];
                    start += 2;
                } else {
                    temp[i][tempIdx++] = board[i][start];
                    start++;
                }
            }

            if (start == n - 1) temp[i][tempIdx] = board[i][start];
        }

        board = temp;
    }

    public static void pressRow() {
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int tempIdx = 0;
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0)
                    temp[i][tempIdx++] = board[i][j];
            }
        }

        board = temp;
    }

    public static void play() {
        pressRow();
        calBoard();
    }

    // -90도 돌리기
    /*
        (0, 0) -> (3, 0) (0, 1) -> (2, 0) (0, 2) -> (1, 0) (0, 3) -> (0, 0)

        (i, j) -> (n - 1  - j, i)
    */
    public static void rotateLeftBoard() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[n - 1 - j][i] = board[i][j];
            }
        }

        board = temp;
    }

    // +90도 돌리기
    public static void rotateRightBoard() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = board[i][j];
            }
        }

        board = temp;
    }

    // 좌우 반전
    public static void reverseBoard() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][n - 1 - j] = board[i][j];
            }
        }

        board = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        dir = sc.next().charAt(0);

        switch(dir) {
            case 'L':
                play();
                break;
            case 'R':
                reverseBoard();
                play();
                reverseBoard();
                break;
            case 'U':
                rotateLeftBoard();
                play();
                rotateRightBoard();
                break;
            case 'D':
                rotateRightBoard();
                play();
                rotateLeftBoard();
                break;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}