import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int totalHappy = 0;

        for (int i = 0; i < n; i++) {
            int row = map[i][0];
            int col = map[0][i];

            int rowHappy = 0;
            int colHappy = 0;

            for (int j = 1; j < n; j++) {
                if (map[i][j] == row) {
                    rowHappy++;
                } else {
                    row = map[i][j];
                    rowHappy = 0;
                }

                if (map[j][i] == col) {
                    colHappy++;
                } else {
                    col = map[j][i];
                    colHappy = 0;
                }
            }

            if (rowHappy => m) {
                totalHappy++;
            }

            if (colHappy => m) {
                totalHappy++;
            }
        }

        System.out.println(totalHappy);
    }
}