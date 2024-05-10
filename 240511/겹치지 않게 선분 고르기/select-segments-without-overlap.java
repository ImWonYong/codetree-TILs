import java.util.*;

public class Main {
    public static int n;

    public static ArrayList<int[]> lines = new ArrayList<>();
    public static HashSet<Integer> set = new HashSet<>();
    public static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            lines.add(new int[]{s, e});
        }

        recursive(0);

        System.out.println(answer);
    }

    public static boolean isOverlap(ArrayList<int[]> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] l1 = list.get(i);

            for (int j = i + 1; j < list.size(); j++) {
                int[] l2 = list.get(j);

                if (l1[0] >= l2[1] || l1[1] >= l2[0]) {
                    return true;
                }    
            }
        }
        return false;
    }

    public static void recursive(int num) {
        if (num == n) {
            ArrayList<int[]> temp = new ArrayList<>();
            for (int v: set) {
                temp.add(lines.get(v));
            }

            if (!isOverlap(temp))
                answer = Math.max(answer, set.size());

        }

        for (int i = num; i < n; i++) {
            set.add(i);
            recursive(num + 1);
            set.remove(i);
        }
        


    }
}