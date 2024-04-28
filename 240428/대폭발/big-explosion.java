import java.util.*;

/*
    폭발은 번진다.
    t초가 되면 t - 1 초에 폭탄이 있던 위치에서 4방향으로 1, 2, 4 ...
*/

public class Main {
    public static int n;
    public static int m;
    public static int r;
    public static int c;

    public static int[][] board;
    
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        r--;
        c--;

        board = new int[n][n];

        for (int i = 0; i < n ; i++) {
            Arrays.fill(board[i], -1);
        }

        board[r][c] = 0;

        for (int i = 1; i <= m; i++) {
            simulate(i);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 0) count++;
            }
        }

        System.out.println(count);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void createBomb(int r, int c, int t) {
        int range = boomRange(t);

        for (int i = 0; i < 4; i++) {
            int nr = r + (dx[i] * range);
            int nc = c + (dy[i] * range);

            if (inRange(nr, nc) && board[nr][nc] == -1) {
                board[nr][nc] = t;
            }
        }
    }

    public static void simulate(int t) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 0 && board[i][j] < t) {
                    createBomb(i, j, t);
                }
            }
        }
    }

    public static int boomRange(int t) {
        double range = Math.pow(2, t - 1);
    
        return (int) range;
    }
}