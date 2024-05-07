import java.util.*;

/*
    격자는 벽으로 쌓여있다.
    구슬은 1초에 1칸씩 움직이고, 벽에 부딪히면 반대로 뒤집힌다 -> 이때 방향 전환에 1초 걸림
    1초의 시간이 지나 두 개 이상의 구슬이 같은 위치로 오면 충돌이 발생
    충돌 발생 시 구슬은 전부 합쳐지고(무게가 다 더해짐).
    새로운 구슬 번호는 가장 큰 번호, 방향은 가장 큰 번호가 매겨진 구슬 방향.
*/
public class Main {
    public static int ASCII_NUM = 128;
    
    public static int n;
    public static int m;
    public static int t;

    public static Marble[][] marbles;
    public static Marble[][] nextMarbles;

    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= n;
    }

    public static Marble sumMarble(Marble m1, Marble m2) {
        int num = m1.num > m2.num ? m1.num : m2.num;
        int dir = m1.num > m2.num ? m1.dir : m2.dir;
        int weight = m1.weight + m2.weight;

        return new Marble(num, dir, weight);
    }

    public static void move(int r, int c) {
        Marble m = marbles[r][c];
        int num = m.num;
        int dir = m.dir;
        int weight = m.weight;

        int nr = r + dx[dir];
        int nc = c + dy[dir];

        if (!inRange(nr, nc)) {
            dir = 3 - dir;
            nr = r;
            nc = c;
        }

        if (nextMarbles[nr][nc] == null) {
            nextMarbles[nr][nc] = new Marble(num, dir, weight);
        } else {
            nextMarbles[nr][nc] = sumMarble(nextMarbles[nr][nc], new Marble(num, dir, weight));
        }
    }

    public static void moveAll() {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (marbles[i][j] != null) {
                    move(i, j);
                }
            }
        }
    }

    public static void simulate() {
        nextMarbles = new Marble[n + 1][n + 1];

        moveAll();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                marbles[i][j] = nextMarbles[i][j];
            }
        }

        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         if (marbles[i][j] == null) {
        //             System.out.print(0 + " ");
        //         } else {
        //             System.out.print(marbles[i][j].weight + " ");
        //         }
        //     }
        //     System.out.println();
        // }
        // System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dirMapper = new int[ASCII_NUM];

        dirMapper['U'] = 0;
        dirMapper['L'] = 1;
        dirMapper['R'] = 2;
        dirMapper['D'] = 3;

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();

        marbles = new Marble[n + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int dir = dirMapper[sc.next().charAt(0)];
            int weight = sc.nextInt();

            marbles[r][c] = new Marble(i, dir, weight);
        }

        while (t-- > 0) {
            simulate();
        }

        int count = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (marbles[i][j] != null) {
                    count++;
                    max = Math.max(max, marbles[i][j].weight);
                }
            }
        }

        System.out.println(count + " " + max);
    }
}

class Marble {
    int num;
    int dir;
    int weight;

    public Marble (int num, int dir, int weight) {
        this.num = num;
        this.dir = dir;
        this.weight = weight;
    }
}