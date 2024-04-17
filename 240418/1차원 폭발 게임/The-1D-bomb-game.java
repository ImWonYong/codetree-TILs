import java.util.*;

public class Main {
    public static int N;
    public static int M;
    public static int[] arr;
    public static int endOfArray;

    public static int getEndIdxOfExplosion(int startIdx, int currNum) {
        int endIdx = startIdx + 1;
        while (endIdx < endOfArray) {
            if (arr[endIdx] == currNum)
                endIdx++;
            else {
                break;
            }
        }

        return endIdx - 1;
    }

    public static void cutArray(int startIdx, int endIdx) {
        int cutLen = endIdx - startIdx + 1;
        for (int i = endIdx + 1; i < endOfArray; i++) {
            arr[i - cutLen] = arr[i];
        }

        endOfArray -= cutLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        endOfArray = N;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        boolean didExplode;
        int curIdx;
        do {
            didExplode = false;
            curIdx = 0;

            while (curIdx < endOfArray) {
                int endIdx = getEndIdxOfExplosion(curIdx, arr[curIdx]);

                if (endIdx - curIdx + 1 >= M) {
                    cutArray(curIdx, endIdx);
                    didExplode = true;
                } else {
                    curIdx = endIdx + 1;
                }
            }
        }
        while(didExplode);


        System.out.println(endOfArray);
        for (int i = 0; i < endOfArray; i++) {
            System.out.println(arr[i]);
        }
    }
}