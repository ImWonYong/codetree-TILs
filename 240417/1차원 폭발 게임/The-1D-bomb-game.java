import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int length;

    public static void removeBlock(List<int[]> list) {
        int count = 0;
        for (int[] range: list) {
            for (int i = range[0]; i <= range[1]; i++) {
                arr[i] = 0;
                count++;
            }
        }

        length = length - count;

        int[] temp = new int[length];
        int tempIdx = 0;

        for (int i = 0; i < length; i++) {
            if (arr[i] != 0) {
                temp[tempIdx++] = arr[i];
            }
        }

        arr = temp;
    }

    public static List<int[]> checkBombRange() {
        List<int[]> list = new ArrayList<>();
    
        int startIdx = 0;
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (arr[startIdx] == arr[i]) {
                count++;
            } else {
                if (count >= M) {
                    list.add(new int[]{startIdx, i - 1});
                }

                startIdx = i;
                count = 1;
            }
        }

        if (count >= M) {
            list.add(new int[]{startIdx, length - 1});
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        length = N;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        while (true) {
            List<int[]> list = checkBombRange();

            if (list.size() == 0)
                break;

            removeBlock(list);
        }

        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}