import java.util.*;

public class Main {
    public static int n;
    public static int T;
    public static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        T = sc.nextInt();

        board = new int[2][n];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int t = 0; t < T; t++) {

            int temp = board[0][n - 1];
            
            for (int i = n - 1; i >= 1; i--) {
                board[0][i] = board[0][i - 1];
            }

            board[0][0] = board[1][n - 1];

            for (int i = n - 1; i >= 1; i--) {
                board[1][i] = board[1][i - 1];
            }

            board[1][0] = temp;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}