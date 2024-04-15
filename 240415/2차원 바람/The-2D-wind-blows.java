import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int Q;

    public static int[][] board;
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int q = 0;

        while (q++ < Q) {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;

            rotateBoard(r1, c1, r2, c2);
            calculateBoard(r1, c1, r2, c2);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateBoard(int r1, int c1, int r2, int c2) {

        int temp1 = board[r1][c2];

        for (int i = c2; i >= c1 + 1; i--) {
            board[r1][i] = board[r1][i - 1];
        }

        int temp2 = board[r2][c2];
        for (int i = r2; i >= r1 + 2; i--) {
            board[i][c2] = board[i - 1][c2];
        }
        board[r1 + 1][c2] = temp1;

        int temp3 = board[r2][c1];
        for (int i = c1; i <= c2 - 2; i++) {
            board[r2][i] = board[r2][i + 1];
        }
        board[r2][c2 - 1] = temp2;

        for (int i = r1; i <= r2 - 2; i++) {
            board[i][c1] = board[i + 1][c1];
        }
        board[r2 - 1][c1] = temp3;
    }

    public static void calculateBoard(int r1, int c1, int r2, int c2) {
        int[][] temp = new int[N][M];

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int sum = board[i][j];
                int count = 1;
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        sum += board[nx][ny];
                        count++;
                    }

                }

                temp[i][j] = sum / count;
            }
        }

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                board[i][j] = temp[i][j];
            }
        }
    }
}