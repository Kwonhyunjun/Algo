import java.io.*;
import java.util.*;

public class Main {

    static class Wheel {
        char[] poles;
        int left;
        int right;
        int middle;

        public Wheel(String poles) {
            this.poles = poles.toCharArray();
            left = 6;    // 9시 방향
            right = 2;   // 3시 방향
            middle = 0;  // 12시 방향
        }
    }

    static Wheel[] wheels;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        wheels = new Wheel[4];

        for (int i = 0; i < 4; i++) {
            wheels[i] = new Wheel(br.readLine());
        }

        int N = Integer.parseInt(br.readLine());
        int[] change = new int[4];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            Arrays.fill(change, 0);
            change[num] = dir;

            // 오른쪽 전파
            int rightD = num + 1;
            while (rightD < 4) {
                Wheel prev = wheels[rightD - 1];
                Wheel curr = wheels[rightD];

                if (prev.poles[prev.right] == curr.poles[curr.left]) break;

                change[rightD] = -change[rightD - 1];
                rightD++;
            }

            // 왼쪽 전파
            int leftD = num - 1;
            while (leftD >= 0) {
                Wheel next = wheels[leftD + 1];
                Wheel curr = wheels[leftD];

                if (next.poles[next.left] == curr.poles[curr.right]) break;

                change[leftD] = -change[leftD + 1];
                leftD--;
            }

            // 회전 수행
            for (int j = 0; j < 4; j++) {
                if (change[j] == 0) continue;

                if (change[j] == 1) {
                    rotate(j);
                } else {
                    rotateReverse(j);
                }
            }
        }

        // 결과 계산
        int answer = 0;
        int[] scores = {1, 2, 4, 8};

        for (int i = 0; i < 4; i++) {
            Wheel w = wheels[i];
            if (w.poles[w.middle] == '1') {
                answer += scores[i];
            }
        }

        System.out.println(answer);
    }

    static void rotate(int cur) {
        Wheel w = wheels[cur];
        w.right = (w.right + 7) % 8;
        w.middle = (w.middle + 7) % 8;
        w.left = (w.left + 7) % 8;
    }

    static void rotateReverse(int cur) {
        Wheel w = wheels[cur];
        w.right = (w.right + 1) % 8;
        w.middle = (w.middle + 1) % 8;
        w.left = (w.left + 1) % 8;
    }
}
