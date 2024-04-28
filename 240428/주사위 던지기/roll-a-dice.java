import java.util.*;

/*
    6개의 면으로 이뤄진 주사위 면끼리 적히면 숫자 합은 7
    반대 면 = 7 - 현재 면

    현재 아래가 6이면 보이는 면은
    
*/
public class Main {

    public static int n;
    public static int m;
    public static int r;
    public static int c;

    public static char[] command;
    public static int[][] board;
    public static int[][] map = {
        {0, 5, 0},
        {4, 1, 3},
        {0, 2, 0}
    };

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        board = new int[n][n];
        command = new char[m];

        for (int i = 0; i < m; i++) {
            command[i] = sc.next().charAt(0);
        }

        for (int i = 0; i < m; i++) {
            board[r][c] = getOtherSide(map[1][1]);

            if (command[i] == 'U') {
                int nr = r + dx[0];
                int nc = c + dy[0];

                if (inRange(nr, nc)) {
                    r = nr;
                    c = nc;
                    up();
                }
            } else if (command[i] == 'D') {
                int nr = r + dx[1];
                int nc = c + dy[1];

                if (inRange(nr, nc)) {
                    r = nr;
                    c = nc;
                    down();
                }
            } else if (command[i] == 'L') {
                int nr = r + dx[2];
                int nc = c + dy[2];

                if (inRange(nr, nc)) {
                    r = nr;
                    c = nc;
                    left();
                }
            } else if (command[i] == 'R') {
                int nr = r + dx[3];
                int nc = c + dy[3];

                if (inRange(nr, nc)) {
                    r = nr;
                    c = nc;
                    right();
                }
            }

            board[r][c] = getOtherSide(map[1][1]);
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += board[i][j];
            }
        }

        System.out.println(sum);
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static int getOtherSide(int n) {
        return 7 - n;
    }

    public static void up() {
        int temp = getOtherSide(map[1][1]);

        for (int i = 0; i < 2; i++) {
            map[i][1] = map[i + 1][1];
        }
        map[2][1] = temp;
    }

    public static void down() {
        int temp = getOtherSide(map[1][1]);

        for (int i = 2; i >= 1; i--) {
            map[i][1] = map[i - 1][1];
        }
        map[0][1] = temp;
    }

    public static void left() {
        int temp = getOtherSide(map[1][1]);

        for (int i = 0; i < 2; i++) {
            map[1][i] = map[1][i + 1];
        }
        map[1][2] = temp;
    }

    public static void right() {
        int temp = getOtherSide(map[1][1]);

        for (int i = 2; i >= 1; i--) {
            map[1][i] = map[1][i - 1];
        }
        map[1][0] = temp;
    }

}