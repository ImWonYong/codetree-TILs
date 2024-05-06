import java.util.*;

/*
    매 초 구슬들이 움직이고 같은 위치에 여러 구슬이 위치해 있을 때, 
    동일한 위치에 구슬이 k개 이하면 문제없이 다음 진행.
    k개 넘으면, 우선순위가 높은 구슬 k개만 살고 전부 사라짐.
    (우선순위는 구슬 속도가 빠를 수록! 속도가 같으면 번호가 더 큰 구슬)
    구슬 순서는 입력된 순서대로 부여
*/

public class Main {
    public static int n, m, t, k;

    public static PriorityQueue<Marble>[][] marbles;
    public static PriorityQueue<Marble>[][] nextMarbles;
    public static int[][] marbleCount;

    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};

    public static class Marble {
        int num;
        int d;
        int v;

        public Marble(int num, int d, int v) {
            this.num = num;
            this.d = d;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        k = sc.nextInt();

        marbles = new PriorityQueue[n + 1][n + 1];
        nextMarbles = new PriorityQueue[n + 1][n + 1];
        marbleCount = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                marbles[i][j] = new PriorityQueue<>((m1, m2) -> {
                    if (m1.v == m2.v) {
                        return Integer.compare(m1.num, m2.num);
                    }
                    return Integer.compare(m1.v, m2.v);
                });
            }
        }

        for (int i = 1; i <= m; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int d = mapDirToInt(sc.next().charAt(0));
            int v = sc.nextInt();

            marbles[r][c].add(new Marble(i, d, v));
        }

        while (t-- > 0) {
            simulate();
        }

        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                count += marbles[i][j].size();
            }
        }

        System.out.println(count);
    }

    public static void simulate() {
        moveAll();

        removeDuplicateMarbles();
    }

    public static void removeDuplicateMarbles() {
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                PriorityQueue pq = marbles[i][j];

                while (pq.size() > k) {
                    pq.poll();
                }
            }
        }
    }

    public static void moveAll() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                nextMarbles[i][j] = new PriorityQueue<>((m1, m2) -> {
                    if (m1.v == m2.v) {
                        return Integer.compare(m1.num, m2.num);
                    }
                    return Integer.compare(m1.v, m2.v);
                });
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < marbles[i][j].size(); k++) {
                    move(i, j, marbles[i][j].poll());
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                marbles[i][j] = nextMarbles[i][j];
            }
        }
    }

    public static void move(int r, int c, Marble marble) {
        int num = marble.num;
        int d = marble.d;
        int v = marble.v;

        for (int i = 0; i < v; i++) {
            int nr = r + dx[d];
            int nc = c + dy[d];

            if (!inRange(nr, nc)) {
                d = 3 - d;
                nr = r + dx[d];
                nc = c + dy[d];
            }

            if (inRange(nr, nc)) {
                r = nr;
                c = nc;
            }
        }

        nextMarbles[r][c].add(new Marble(num, d, v));
    }

    public static boolean inRange(int r, int c) {
        return r >= 1 && r <= n && c >= 1 && c <= n;
    }

    public static int mapDirToInt(char d) {
        if (d == 'U')
            return 0;
        else if (d == 'D')
            return 3;
        else if (d == 'L')
            return 1;
        else if (d == 'R')
            return 2;
    
        return -1;
    }
}