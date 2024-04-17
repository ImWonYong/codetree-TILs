import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static boolean[][] checked;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        board = new int[n][n];
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        checkExplode(r, c);     

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (checked[i][j])
                    removeBlock(i, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void removeBlock(int r, int c) {
        
        int[] temp = new int[n];
        int tempIndex = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (i != r)
                temp[tempIndex--] = board[i][c];
        }

        for (int i = 0; i < n; i++) {
            board[i][c] = temp[i];
        }
    }

    public static void checkExplode(int r, int c) {
        int length = board[r][c] - 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        checked[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int tempR = r;
            int tempC = c;
            for (int j = 0; j < length; j++) {
                int nr = tempR + dx[i];
                int nc = tempC + dy[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    checked[nr][nc] = true;
                    tempR = nr;
                    tempC = nc;
                }
            }
        }
    }
}