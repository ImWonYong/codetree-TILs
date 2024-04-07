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

            boolean rowHappy = false;
            boolean colHappy = false;

            for (int j = 1; j < n; j++) {
                if (map[i][j] == row) {
                    rowHappy = true;
                } else {
                    row = map[i][j];
                }

                if (map[j][i] == col) {
                    colHappy = true;
                } else {
                    col = map[j][i];
                }
            }

            if (rowHappy) {
                totalHappy++;
            }

            if (colHappy) {
                totalHappy++;
            }
        }

        System.out.println(totalHappy);
    }
}