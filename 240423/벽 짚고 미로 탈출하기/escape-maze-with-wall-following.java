import java.util.*;

public class Main {
    public static int n;
    public static int x;
    public static int y;
    public static char[][] board;
    public static boolean[][] checked;
    public static int dir;

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;

        board = new char[n][n];
        checked = new boolean[n][n];
        dir = 0;

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        int count = 0;
        int timeCount = 0;
        while (!isEscape(x, y)) {
            if (timeCount++ >= n * n) {
                count = -1;
                break;
            }

            if (checkRightWall(x, y)) {
                if (isEscape(x + dx[dir], y + dy[dir]) || board[x + dx[dir]][y + dy[dir]] != '#') {
                    x = x + dx[dir];
                    y = y + dy[dir];
                    count++;
                } else if (board[x + dx[dir]][y + dy[dir]] == '#') {
                    changeAntiClockwise();
                }
            }
            else {
                changeClockwise();
                x = x + dx[dir];
                y = y + dy[dir];
                count++;
            }
        }

        System.out.println(count);
    }

    public static boolean checkRightWall(int x, int y) {
        switch (dir) {
            case 0:
                return isRange(x + 1, y) && board[x + 1][y] == '#';
            case 1:
                return isRange(x, y + 1) && board[x][y + 1] == '#';
            case 2:
                return isRange(x - 1, y) && board[x - 1][y] == '#';
            case 3:
                return isRange(x, y - 1) && board[x][y - 1] == '#';
        }

        return false;
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void changeAntiClockwise() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public static void changeClockwise() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public static boolean isEscape(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }
}

/*

    오른쪽 벽을 짚고 쭉 따라가는 방식.
    격자 밖을 벗어났을 때 미로를 탈출

    1. 바라보고 있는 방향으로 이동하는 것이 가능하지 않으면 반 시계 방향 90도 회전
    2. 바라보고 있는 방향으로 이동 가능한 경우
        - 격자 밖이면 탈출
        - 이동했을 때를 기준으로 짚을 벽이 있으면 그 방향으로 한 칸 이동
        - 오른쪽에 벽이 존재하지 않으면, 현재 방향으로 한칸 이동 후 시계 방향으로 90도 틀어 한칸 전진하여 오른쪽 벽이 있게 함

    
    언제 영원히 돌게될까??
    1. 모든 사방이 벽으로 둘러쌓여있을 때
    2. 같은 곳을 뱅글뱅글 돌 때
*/