import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;

        int length = n;
        length = removeBlock(arr, length, s1, e1);
        length = removeBlock(arr, length, s2, e2);

        System.out.println(length);

        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static int removeBlock(int[] arr, int length,  int s, int e) {
        int[] temp = new int[arr.length];

        int tempIndex = 0;

        for (int i = 0; i < length; i++) {
            if (i >= s && i <= e)
                continue;
            temp[tempIndex++] = arr[i]; 
        }

        for (int i = 0; i < temp.length; i++) {
            arr[i] = temp[i];
        }

        return tempIndex;
    }
}