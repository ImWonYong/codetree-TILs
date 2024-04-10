import java.util.*;

public class Main {
    public static int n;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int maxSquareCost = 0;
        for (int i = n - 1; i > 1; i--) {
            for (int j = 1; j < n - 1; j++) {
                maxSquareCost = Math.max(maxSquareCost, getMaxSquareCost(i, j));
            }
        }

        System.out.println(maxSquareCost);
    }

    public static boolean isRange(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;

        return false;
    }

    public static int getMaxSquareCost(int x, int y) {
        int max = 0;

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                int nx = x;
                int ny = y;
                int sum = 0;

                boolean isSquare = true;

                for (int a = 0; a < i; a++) {
                    nx += dx[0];
                    ny += dy[0];

                    if (!isRange(nx, ny)) {
                        isSquare = false;
                        break;
                    }

                    sum += map[nx][ny];
                }

                if (!isSquare) {
                    sum = map[x][y];
                    continue;
                }

                for (int b = 0; b < j; b++) {
                    nx += dx[1];
                    ny += dy[1];

                    if (!isRange(nx, ny)) {
                        isSquare = false;
                        break;
                    }

                    sum += map[nx][ny];
                }

                if (!isSquare) {
                    sum = map[x][y];
                    continue;
                }

                for (int c = 0; c < i; c++) {
                    nx += dx[2];
                    ny += dy[2];

                    if (!isRange(nx, ny)) {
                        isSquare = false;
                        break;
                    }

                    sum += map[nx][ny];
                }

                if (!isSquare) {
                    sum = map[x][y];
                    continue;
                }

                for (int d = 0; d < j; d++) {
                    nx += dx[3];
                    ny += dy[3];

                    if (!isRange(nx, ny)) {
                        isSquare = false;
                        break;
                    }

                    sum += map[nx][ny];
                }

                if (!isSquare) {
                    sum = map[x][y];
                    continue;
                }

                max = Math.max(max, sum);
            }
        }
      
        return max;
    }
}