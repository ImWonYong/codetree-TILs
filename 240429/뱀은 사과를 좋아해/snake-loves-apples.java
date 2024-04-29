import java.util.*;

/*
    뱀은 (0, 0)에서 길이 1의 상태로 시작

    이동시: 머리를 특정 방향으로 한 칸 옮기고, 끝에 꼬리 사라짐
    사과를 먹을시: 꼬리가 사라지지 않고 몸의 길이가 1 늘어남
*/

public class Main {
    public static int n;
    public static int m;
    public static int k;

    public static int[][] board;
    public static boolean[][] appleBoard;
    public static LinkedList<Pair> snake = new LinkedList<>();

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static int t = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        board = new int[n][n];
        appleBoard = new boolean[n][n];

        for (int i = 0; i < m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            r--; c--;

            appleBoard[r][c] = true;
        }

        snake.addFirst(new Pair(0, 0));

        for (int i = 0; i < k; i++) {
            char command = sc.next().charAt(0);
            int step = sc.nextInt();

            moveSnake(command, step);
        }

        System.out.println(t);
    }

    public static void moveSnake(char command, int step) {
        int d = changeCommandToInt(command);

        for (int s = 0; s < step; s++) {
            t++;

            Pair head = snake.getFirst();

            int nr = head.r + dx[d];
            int nc = head.c + dy[d];

            if (!inRange(nr, nc)) {
                System.out.println(t);
                System.exit(0);
            }

            if (!appleBoard[nr][nc]) {
                Pair tail = snake.removeLast();
            } else {
                appleBoard[nr][nc] = false;
            }

            snake.addFirst(new Pair(nr, nc));

            if (isCrash(nr, nc)) {
                System.out.println(t);
                System.exit(0);
            }
        }
    }

    public static boolean isCrash(int r, int c) {
        
        Pair temp = snake.removeFirst();

        for (Pair node: snake) {
            if (node.r == r && node.c == c) {
                return true;
            }
        }

        snake.addFirst(temp);

        return false;
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static int changeCommandToInt(char command) {
        switch (command) {
            case 'U':
                return 0;
            case 'D':
                return 1;
            case 'L':
                return 2;
            case 'R':
                return 3;
        }

        return -1;
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