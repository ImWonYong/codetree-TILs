import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static int[][] checked;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        checked = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int a = i; a < n; a++) {
                    for (int b = j; b < m; b++) {
                        max = Math.max(max, countAnotherSquare(i, j, a, b));
                    }
                }
            }
        }

        System.out.println(max);
    }

    public static int countAnotherSquare(int x1, int y1, int x2, int y2) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int a = i; a < n; a++) {
                    for (int b = j; b < m; b++) {

                        if (!isOverlap(x1, y1, x2, y2, i, j, a, b)) {
                            max = Math.max(max, countSquare());
                        }
                    }
                }
            }
        }

        return max;
    }

    public static boolean isOverlap(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                checked[i][j] = 0;
            }
        }

        draw(x1, y1, x2, y2);
        draw(x3, y3, x4, y4);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checked[i][j] > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void draw(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                checked[i][j]++;
            }
        }
    }

    public static int countSquare() {
        int sum = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checked[i][j] == 1) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}