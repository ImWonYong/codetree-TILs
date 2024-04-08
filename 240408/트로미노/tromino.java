import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;

    public static int[][][] triminos = {
        {
            {1, 0},
            {1, 1}
        },
        {
            {1, 1},
            {1, 0}
        },
        {
            {1, 1},
            {0, 1}
        },
        {
            {0, 1},
            {1, 1}
        },
        {
            {1, 1, 1}
        },
        {
            {1},
            {1},
            {1}
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(max, calMax(i, j, map));
            }
        }

        System.out.println(max);
    }

    public static int calMax(int r, int c, int[][] map) {
        int max = 0;

        for (int[][] trimino: triminos) {
            int w = trimino[0].length;
            int h = trimino.length;
            int sum = 0;
            if (r + h < n && c + w < m) {
                for (int i = r; i < r + h; i++) {
                    for (int j = c; j < c + w; j++) {
                        sum += map[i][j];
                    }
                }

                max = Math.max(max, sum);
            }
        }

        return max;
    }
}