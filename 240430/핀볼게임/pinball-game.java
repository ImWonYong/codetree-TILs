import java.util.*;

public class Main {
    public static int n;

    public static int[][] board;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        n = sc.nextInt();

        board = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int max = -1;
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                if (simulateRange(i, j))
                    max = Math.max(max, simulate(i, j));
            }
        }

        System.out.println(max);
    }

    public static int simulate(int r, int c) {
        int d = findDiraction(r, c);

        int t = 0;

        int nr;
        int nc;

        do {
            t++;

            nr = r + dx[d];
            nc = c + dy[d];

            if (board[nr][nc] != 0) {
                d = changeDirection(board[nr][nc], d);
            }

            r = nr;
            c = nc;

        } while (inRange(r, c));

        return t;
    }

    public static int changeDirection(int type, int curDir) {
        if (type == 1) {
            if (curDir == 1)
                return 2;
            else if (curDir == 0)
                return 3;
            else if (curDir == 2)
                return 1;
            else if (curDir == 3)
                return 0;
        }
        else if (type == 2) {
            if (curDir == 1)
                return 3;
            else if (curDir == 0)
                return 2;
            else if (curDir == 3)
                return 1;
            else if (curDir == 2)
                return 0;
        }

        return -1;
    }

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= n;
    }

    public static int findDiraction(int r, int c) {
        if (r == 0) {
            return 1;
        } else if (r == n - 1) {
            return 0;
        } else if (c == 0) {
            return 3;
        }
        return 2;
    }

    public static boolean simulateRange(int i, int j) {
        return ((i == 0 || i == n + 1) && (j >= 1 && j <= n) || ((j == 0 || j == n + 1) && (i >= 1 && i <= n)));
    }
}