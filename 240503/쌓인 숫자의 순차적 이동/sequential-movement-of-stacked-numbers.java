import java.util.*;

/*
    8방향으로 인접한 칸들 중 가장 큰 값이 적혀있는 숫자가 있는 곳으로 이동하는 것.
*/
public class Main {
    public static int n;
    public static int m;

    public static List<Integer>[][] board;

    public static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    public static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new ArrayList[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j].add(sc.nextInt());
            }
        }

        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            simulate(num);
        }

        for (int i = 0; i < n ;i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = board[i][j];

                if (list.isEmpty())
                    System.out.println("None");
                else {
                    for (int k = list.size() - 1; k >= 0; k--) {
                        System.out.print(list.get(k) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public static void simulate(int num) {

        Pos p = findNum(num);

        Pos maxPos = new Pos(-1, -1, -1);
        int max = -1;
        for (int i = 0; i < 8; i++) {
            int nr = p.r + dx[i];
            int nc = p.c + dy[i];

            if (inRange(nr, nc)) {
                List<Integer> list = board[nr][nc];

                for (int k = 0; k < list.size(); k++) {
                    if (max < list.get(k)) {
                        max = list.get(k);
                        maxPos = new Pos(nr, nc, k);
                    }
                }
            }
        }

        if (maxPos.r == -1 && maxPos.c == -1)
            return;

        List<Integer> list1 = board[p.r][p.c];
        List<Integer> list2 = board[maxPos.r][maxPos.c];
        list2.addAll(list1.subList(p.i, list1.size()));
        board[p.r][p.c] = new ArrayList(list1.subList(0, p.i));
        
    }

    public static boolean inRange(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static Pos findNum(int num) {

        Pos p = new Pos(-1, -1, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<Integer> list = board[i][j];

                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k) == num) {
                        p = new Pos(i, j, k);
                    }
                }
            }
        }

        return p;
    }

    public static class Pos {
        int r;
        int c;
        int i;

        public Pos(int r, int c, int i) {
            this.r = r;
            this.c = c;
            this.i = i;
        }
    }
}