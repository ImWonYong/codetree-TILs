import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();

        int min = 11;
        for (int i = 0; i < A.length(); i++) {
            String a = A.substring(A.length() - 1);
            String b = A.substring(0, A.length() - 1);

            A = a + b;
            
            min = Math.min(min, runLengthEncoding(A));
        }

        System.out.println(min);
    }

    public static int runLengthEncoding(String A) {
        String encode = "";
        for (int i = 0; i < A.length();) {
            int count = 1;
            int j;
            for (j = i + 1; j < A.length(); j++) {
                if (A.charAt(i) == A.charAt(j)) {
                    count++;
                } else {
                    encode += A.charAt(i);
                    encode += count;
                    i = j;
                    break;
                }
            }

            if (i < j) {
                encode += A.charAt(i);
                encode += count;
                break;
            }
        }

        return encode.length();
    }
}