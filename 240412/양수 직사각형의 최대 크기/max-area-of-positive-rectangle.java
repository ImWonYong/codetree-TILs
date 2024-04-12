import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int maxSquare = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = i; k < n; k++) {
                    for (int l = j; l < m; l++) {
                        if (isPositiveSquare(i, j, k, l))
                            maxSquare = Math.max(maxSquare, getSize(i, j, k, l)); 
                    }
                }
            }
        }

        System.out.println(maxSquare == 0 ? -1 : maxSquare);
    }

    public static boolean isPositiveSquare(int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] <= 0) return false;
            }
        }

        return true;
    }

    public static int getSize(int x1, int y1, int x2, int y2) {
        return (x2 - x1 + 1) * (y2 - y1 + 1);
    }
}