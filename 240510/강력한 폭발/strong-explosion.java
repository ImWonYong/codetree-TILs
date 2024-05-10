import java.util.*;

public class Main {
    public static final int BOOM_TYPE = 3;

    public static int n;

    public static int[][] board;
    public static ArrayList<int[]> list = new ArrayList<>();
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1)
                    list.add(new int[]{i, j});
            }
        }

        simulate();

        System.out.println(answer);
    }

    public static int countBoom() {
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] >= 1)
                    count++;
            }
        }

        return count;
    }

    public static void simulate() {
        if (list.size() == 0) {
            int count = countBoom();
            if (answer < count) {
                answer = count;
            }

            return;
        }

        int[] boom = list.remove(list.size() - 1);
        for (int i = 0; i < BOOM_TYPE; i++) {
            boom(boom[0], boom[1], i, false);
            simulate();
            boom(boom[0], boom[1], i, true);
        }
        list.add(boom);
    }

    public static void boom(int r, int c, int boomType, boolean cleanMode) {
        switch (boomType) {
            case 0:
                boom1(r, c, cleanMode);
                return;
            case 1:
                boom2(r, c, cleanMode);
                return;
            default:
                boom3(r, c, cleanMode);
                return;
        }
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void boom1(int r, int c, boolean cleanMode) {

        for (int i = 1; i <= 2; i++) {
            int nr = r - i;
            int nc = c;

            if (inRange(nr, nc)) {
                if (cleanMode) {
                    board[nr][nc]--;
                } else {
                    board[nr][nc]++;
                }
            }
        }

        for (int i = 1; i <= 2; i++) {
            int nr = r + i;
            int nc = c;

            if (inRange(nr, nc)) {
                if (cleanMode) {
                    board[nr][nc]--;
                } else {
                    board[nr][nc]++;
                }
            }
                
        }
    }

    public static void boom2(int r, int c, boolean cleanMode) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, 1, -1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (inRange(nr, nc)) {
                if (cleanMode) {
                    board[nr][nc]--;
                } else {
                    board[nr][nc]++;
                }
            }
        }

    }

    public static void boom3(int r, int c, boolean cleanMode) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (inRange(nr, nc)) {
                if (cleanMode) {
                    board[nr][nc]--;
                } else {
                    board[nr][nc]++;
                }
            }
        }
    }
}