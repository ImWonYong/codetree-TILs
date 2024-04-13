import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int Q;

    public static int[][] board;
    public static Wind[] info;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        Q = sc.nextInt();

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        info = new Wind[Q];

        for (int i = 0; i < Q; i++) {
            int r = sc.nextInt();
            char d = sc.next().charAt(0);

            info[i] = new Wind(r, d);
        }

        int q = 0;
        while (q < Q) {
            
            Wind wind = info[q++];

            int r = wind.r - 1;
            char d = wind.d;

            if (d == 'L') {
                shiftRight(board[r]);
            } else {
                shiftLeft(board[r]);
            }

            spreadUp(r, d);
            spreadDown(r, d);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkSameValue(int[] arr1, int[] arr2) {

        for (int i = 0; i < m; i++) {
            if (arr1[i] == arr2[i]) return true;
        }

        return false;
    }

    public static void spreadUp(int r, char d) {

        // L일 경우 왼쪽에서 바람이 불었다는 뜻.
        boolean isLeft = d == 'L' ? true : false;
        for (int i = r - 1; i >= 0; i--) {
            if (!checkSameValue(board[i], board[i + 1])) break;
            
            if (isLeft) {
                shiftLeft(board[i]);
            }
            else {
                shiftRight(board[i]);
            }

            isLeft = !isLeft;
        }
    }

    public static void spreadDown(int r, char d) {

        boolean isLeft = d == 'L' ? true : false;
        for (int i = r + 1; i < n; i++) {
            if (!checkSameValue(board[i], board[i - 1])) break;

            if (isLeft) {
                shiftLeft(board[i]);
            }
            else {
                shiftRight(board[i]);
            }

            isLeft = !isLeft;
        }
    }

    public static void shiftLeft(int[] arr) {
        int temp = arr[0];

        for (int i = 0; i < m - 1; i++) {
            arr[i] = arr[i + 1];
        }

        arr[m - 1] = temp;
    }

    public static void shiftRight(int[] arr) {
        int temp = arr[m - 1];

        for (int i = m - 1; i >= 1; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    public static class Wind {
        int r;
        char d;

        public Wind(int r, char d) {
            this.r = r;
            this.d = d;
        }
    }
}