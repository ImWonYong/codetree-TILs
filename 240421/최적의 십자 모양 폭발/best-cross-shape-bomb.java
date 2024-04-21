import java.util.*;

public class Main {
    public static int n;
    public static int[][] board;
    public static int[][] tempBoard;

    public static boolean isBombRange(int x, int y, int r, int c, int v) {
        if ((x == r || y == c) && (Math.abs(x - r) + Math.abs(y - c) < v)) return true;
        return false;
    }

    public static void bomb(int x, int y) {
        int v = tempBoard[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isBombRange(x, y, i, j, v))
                    tempBoard[i][j] = 0;
            }
        }
    }

    public static void drop() {
        int[][] temp = new int[n][n];

        for (int i = 0; i < n; i++) {
            int tempIdx = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (tempBoard[j][i] != 0) {
                    temp[tempIdx--][i] = tempBoard[j][i];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = temp[i][j];
            }
        }
    }

    public static int countPair() {
        boolean[][] rowCheck = new boolean[n][n];
        boolean[][] colCheck = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {

                if (tempBoard[i][j] != 0 && (!colCheck[i][j] || !colCheck[i][j + 1])) {
                    if (tempBoard[i][j] == tempBoard[i][j + 1]) {
                        count++;
                        colCheck[i][j] = true;
                        colCheck[i][j + 1] = true;
                    }
                }

                if (tempBoard[j][i] != 0 && (!rowCheck[j][i] || ! rowCheck[j + 1][i])) {
                    if (tempBoard[j][i] == tempBoard[j + 1][i]) {
                        count++;
                        rowCheck[j][i] = true;
                        rowCheck[j + 1][i] = true;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        tempBoard = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copyBoard();
                bomb(i, j);
                drop();
                max = Math.max(max, countPair());
            }
        }

        System.out.println(max);
    }

    public static void print() {
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(tempBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void copyBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tempBoard[i][j] = board[i][j];
            }
        }
    }
}