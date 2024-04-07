import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int sum = 0;
                if (j + 2 < N && i + 2 < N) {
                    for (int l = i; l < i + 3; l++) {
                        for (int k = j; k < j + 3; k++) {
                            sum += map[l][k];
                        }
                    }
                }

                max = Math.max(max, sum);
            }
        }

        System.out.println(max);
    }
}