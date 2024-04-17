import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int length;

    public static void removeBlock(List<int[]> list) {

        int count = 0;

        for (int[] range: list) {
            for (int i = range[0]; i < range[0] + range[1]; i++) {
                arr[i] = 0;
                count++;
            }
        }

        length -= count;

        int[] temp = new int[N];
        int tempIdx = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0)
                temp[tempIdx++] = arr[i];
        }

        for (int i = 0; i < N; i++) {
            arr[i] = temp[i];
        }
    }

    public static List<int[]> checkBombRange() {
        List<int[]> list = new ArrayList<>();
        if (length == 0) return list;

        int idx = 0;
        int count = 1;

        for (int i = 1; i < length; i++) {
            if (arr[idx] == arr[i]) {
                count++;
            } else {
                if (count >= M) {
                    list.add(new int[]{idx, count});
                }

                idx = i;
                count = 1;
            }
        }

        if (count >= M)
            list.add(new int[]{idx, count});

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