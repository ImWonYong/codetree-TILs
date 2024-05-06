import java.util.*;

/*
    구슬은 무게를 가짐
    2초에 한 칸씩 동일한 속도로 움직임
    두 개 이상의 구슬이 충돌 시 영향력이 큰 구슬만 하나 남게 됨
    영향력 = 무게가 가장 크거나 무게가 같은 구슬이 여러개면 구슬의 번호가 가장 클 경우
    충돌 = 이동하는 도중에 발생할 수 있음
*/

public class Main {
    public static int T;
    public static int n;
    
    public static List<Marble> marbles;

    public static int lastCrash;
    public static int timer;

    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();

            marbles = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int w = sc.nextInt();
                int d = mapToInt(sc.next().charAt(0));

                marbles.add(new Marble(2 * x, 2 * y, w, d, i));
            }

            lastCrash = -1;
            timer = 0;
            while (marbles.size() > 1)
                simulate();

            System.out.println(lastCrash);
        }
    }

    public static void simulate() {
        
        for (int i = 0; i < 2; i++) {
            timer++;

            moveAll();

            if (isCrash())
                lastCrash = timer;
        }
    }

    public static boolean isCrash() {
        List<Marble> temp = new ArrayList<>();

        boolean isCrash = false;

        while (marbles.size() != 0) {
            Marble maxMarble = marbles.get(0);
            int maxX = maxMarble.x;
            int maxY = maxMarble.y;
            int maxW = maxMarble.w;
            int maxD = maxMarble.d;
            int maxNum = maxMarble.num;

            for (int i = 1; i < marbles.size(); i++) {
                Marble m = marbles.get(i);
                
                if (maxX == m.x && maxY == m.y) {
                    isCrash = true;

                    if (maxW < m.w) {
                        maxW = m.w;
                        maxD = m.d;
                        maxNum = m.num;
                    } else if (maxW == m.w && maxNum < m.num) {
                        maxW = m.w;
                        maxD = m.d;
                        maxNum = m.num;
                    }

                    marbles.remove(m);
                }
            }
            temp.add(new Marble(maxX, maxY, maxW, maxD, maxNum));
            marbles.remove(maxMarble);
        }
        

        // for (int i = 0; i < marbles.size(); i++) {
        //     Marble m1 = marbles.get(i);
        //     int maxW = m1.w;
        //     int maxD = m1.d;
        //     int maxNum = m1.num;

        //     PriorityQueue<Marble> pq = new PriorityQueue<>((marble1, marble2) -> {
        //         if (marble1.w == marble2.w) {
        //             return marble2.num - marble1.num;
        //         }

        //         return marble2.w - marble1.w;
        //     });

        //     pq.add(m1);

        //     for (int j = i + 1; j < marbles.size(); j++) {
        //         Marble m2 = marbles.get(j);

        //         if (m1.x == m2.x && m1.y == m2.y) {
        //             pq.add(m2);
        //         }
        //     }

        //     Marble maxMarble = pq.poll();
        //     System.out.println("maxMarble : " + maxMarble.w + " " + maxMarble.num);
        //     temp.add(maxMarble);
        // }

        marbles = temp;

        return isCrash;
    }

    public static void moveAll() {
        List<Marble> next = new ArrayList<>();

        for (Marble m: marbles) {
            int x = m.x;
            int y = m.y;
            int w = m.w;
            int d = m.d;
            int num = m.num;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (inRange(nx, ny))
                next.add(new Marble(nx, ny, w, d, num));
        }

        marbles = next;

        // System.out.println("timer: " + timer);
        // for (Marble m: marbles) {
        //     System.out.println(m.x + " " + m.y + " " + m.w + " " + m.num);
        // }
        // System.out.println();
    }

    public static boolean inRange(int x, int y) {
        return x >= -2000 && x <= 2000 && y >= -2000 && y <= 2000;
    }

    public static int mapToInt(char d) {
        if (d == 'U')
            return 0;
        else if (d == 'D')
            return 1;
        else if (d == 'L')
            return 2;
        else if (d == 'R')
            return 3;
        return -1;
    }

    public static class Marble {
        int x;
        int y;
        int w;
        int d;
        int num;

        public Marble(int x, int y, int w, int d, int num) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.d = d;
            this.num = num;
        }
    }
}