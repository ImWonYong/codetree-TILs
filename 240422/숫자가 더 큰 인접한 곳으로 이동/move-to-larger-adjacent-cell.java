import java.util.*;

public class Main {
    public static int n;
    public static int r;
    public static int c;
    public static int[][] board;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.print(board[r][c] + " ");

        while (true) {
            int curX = r;
            int curY = c;
            int max = board[curX][curY];
            for (int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && max < board[nx][ny]) {
                    curX = nx;
                    curY = ny;
                    max = board[nx][ny];
                    System.out.print(max + " ");
                }
            }

            if (curX == r && curY == c) break;

            r = curX;
            c = curY;
        }
    }
}