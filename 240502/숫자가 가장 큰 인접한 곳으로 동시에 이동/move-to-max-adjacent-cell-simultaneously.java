import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int t;

    public static int[][] board;
    public static int[][] next;
    public static int[][] nextCount;

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();


        board = new int[n][n];
        next = new int[n][n];
        nextCount = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;

            next[r][c] = 1;
        }

        for (int i = 0; i < t; i++) {
            moveAll();
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (next[i][j] == 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void move(int r, int c) {
        int maxR = r;
        int maxC = c;
        int max = board[r][c];

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (max < board[nr][nc]) {
                    maxR = nr;
                    maxC = nc;
                    max = board[nr][nc];
                }  
            }
        }

        nextCount[maxR][maxC] += 1;
    }

    public static void moveAll() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nextCount[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (next[i][j] == 1) {
                    move(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nextCount[i][j] >= 2)
                    nextCount[i][j] = 0;
                next[i][j] = nextCount[i][j];
            }
        }
    }
}