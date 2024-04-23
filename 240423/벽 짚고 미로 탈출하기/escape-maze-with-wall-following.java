import java.util.*;

public class Main {
    public static int n;
    public static int x;
    public static int y;
    public static char[][] board;
    public static boolean[][][] checked;
    public static int dir;
    public static int escapeTime;

    public static int[] dx = {0, -1, 0, 1};
    public static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        x = sc.nextInt() - 1;
        y = sc.nextInt() - 1;

        board = new char[n][n];
        checked = new boolean[n][n][4];
        dir = 0;

        for (int i = 0; i < n; i++) {
            board[i] = sc.next().toCharArray();
        }

        do {
            simulate();
        } while (isRange(x, y));

        System.out.println(escapeTime);
    }

    public static void simulate() {

        if (checked[x][y][dir]) {
            System.out.println(-1);
            System.exit(0);
        }

        checked[x][y][dir] = true;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (wallExist(nx, ny))
            dir = (dir - 1 + 4) % 4;

        else if (!isRange(nx, ny)) {
            x = nx;
            y = ny;
            escapeTime++;
        } else {
            int rx = nx + dx[(dir + 1) % 4];
            int ry = ny + dy[(dir + 1) % 4];

            if (wallExist(rx, ry)) {
                x = nx;
                y = ny;
                escapeTime++;
            } else {
                x = rx;
                x = ry;
                dir = (dir + 1) % 4;
                escapeTime += 2;
            }
        }
    }

    public static boolean wallExist(int x, int y) {
        return isRange(x, y) && board[x][y] == '#';
    }

    public static boolean isRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
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