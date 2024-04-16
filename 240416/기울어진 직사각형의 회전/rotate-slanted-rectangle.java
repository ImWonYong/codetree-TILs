import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();

        rotate(r, c, m1, m2, m3, m4, dir);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int r, int c, int m1, int m2, int m3, int m4, int dir) {
        if (dir == 1) {
            rotateClockwise(r, c, m1, m2, m3, m4);
        } else {
            rotateAnticlockwise(r, c, m1, m2, m3, m4);
        }
    }

    public static void rotateClockwise(int r, int c, int m1, int m2, int m3, int m4) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        int temp = board[r][c];

        for (int i = 0; i < m1; i++) {
            int nx = r + dx[0];
            int ny = c + dy[0];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m2; i++) {
            int nx = r + dx[1];
            int ny = c + dy[1];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m3; i++) {
            int nx = r + dx[2];
            int ny = c + dy[2];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m4 - 1; i++) {
            int nx = r + dx[3];
            int ny = c + dy[3];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        board[r][c] = temp;

    }

    public static void rotateAnticlockwise(int r, int c, int m1, int m2, int m3, int m4) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, 1, -1};

        int temp = board[r][c];

        for (int i = 0; i < m4; i++) {
            int nx = r + dx[0];
            int ny = c + dy[0];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m3; i++) {
            int nx = r + dx[1];
            int ny = c + dy[1];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m2; i++) {
            int nx = r + dx[2];
            int ny = c + dy[2];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        for (int i = 0; i < m1 - 1; i++) {
            int nx = r + dx[3];
            int ny = c + dy[3];

            board[r][c] = board[nx][ny];
            r = nx;
            c = ny;
        }

        board[r][c] = temp;
    }
}