import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int T;

    public static int[][] board;
    public static int[][] nextBoard;
    public static int[][] count;
    public static int[][] nextCount;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            board = new int[n][n];
            nextBoard = new int[n][n];
            count = new int[n][n];
            nextCount = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = -1;
                }
            }

            for (int i = 0; i < m; i++) {
                int r = sc.nextInt() - 1;
                int c = sc.nextInt() - 1;
                char d = sc.next().charAt(0);
                board[r][c] = getDir(d);
            }

            for (int i = 0; i < 500; i++) {
                simulate();
            }


            int totalCount = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (count[i][j] == 1)
                        totalCount++;
                }
            }

            System.out.println(totalCount);
        }
    }

    public static void simulate() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextCount[i][j] = 0;
                nextBoard[i][j] = -1;
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != -1) {
                    move(i, j, board[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                if (nextCount[i][j] >= 2) {
                    nextCount[i][j] = 0;
                    nextBoard[i][j] = -1;
                }
                board[i][j] = nextBoard[i][j];
                count[i][j] = nextCount[i][j];
            }
        }
    }

    public static void move(int r, int c, int d) {
        int nr = r + dx[d];
        int nc = c + dy[d];

        if (outRange(nr, nc)) {
            d = changeDir(d);
            nextCount[r][c] += 1;
            nextBoard[r][c] = d;
        } else {
            nextCount[nr][nc] += 1;
            nextBoard[nr][nc] = d;
        }
    }

    public static int changeDir(int d) {
        /*
            0 -> 1
            1 -> 0

            2 -> 3
            3 -> 2
        */

        if (d == 0)
            return 1;
        else if (d == 1)
            return 0;
        else if (d == 2)
            return 3;
        else if (d == 3)
            return 2;

        return -1;
    }

    public static boolean outRange(int r, int c) {
        return !(r >= 0 && r < n && c >= 0 && c < n);
    }

    public static int getDir(char d) {
        if (d == 'U')
            return 0;
        else if (d == 'D')
            return 1;
        else if (d == 'L')
            return 2;
        else if (d == 'R')
            return 3;

        return -1;
    }
}