import java.util.*;

public class Main {

    public static int n;
    public static int m;

    public static int[][] board;

    public static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    public static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n;j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n * n; j++) {
                Pair p = findPos(j);
                simulate(p);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void simulate(Pair p) {
        int max = -1;
        int maxR = -1;
        int maxC = -1;
        for (int i = 0; i < 8; i++) {
            int nr = p.r + dx[i];
            int nc = p.c + dy[i];

            if (inRange(nr, nc) && max < board[nr][nc]) {
                max = board[nr][nc];
                maxR = nr;
                maxC = nc;
            }
        }

        board[maxR][maxC] = board[p.r][p.c];
        board[p.r][p.c] = max;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static Pair findPos(int num) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == num)
                    return new Pair(i, j);
            }
        }

        return new Pair(-1, -1);
    }

    public static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}