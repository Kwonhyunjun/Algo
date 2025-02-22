import java.io.*;
import java.util.*;

public class Main {

    static int x_cnt;
    static char[][] map = new char[5][9];
    static HashMap<Integer, int[]> points = new HashMap<>();
    static boolean[] v;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        v = new boolean[13];

        int idx = 1;
        for (int i = 0; i < 5; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                char cur = map[i][j];

                if (cur == '.') continue;

                if (cur != 'x') {
                    int num = cur - 'A' + 1;
                    v[num] = true; // 사용된 문자 체크
                } else {
                    x_cnt++;
                    points.put(x_cnt, new int[]{i, j});
                }
            }
        }

        solve(1, 0);
    }

    static void solve(int idx, int cnt) {
        if (cnt == x_cnt) { // 올바른 종료 조건
            if (isPossible()) {
                print();
            }
            return;
        }

        if (!points.containsKey(idx)) return; // 방어 코드

        int x = points.get(idx)[0];
        int y = points.get(idx)[1];

        for (int i = 1; i <= 12; i++) {
            if (v[i]) continue;
            v[i] = true;
            map[x][y] = (char) (i + 'A' - 1);
            solve(idx + 1, cnt + 1);
            v[i] = false;
            map[x][y] = 'x';
        }
    }

    static boolean isPossible() {
        return (map[0][4] - 'A' + 1) + (map[1][3] - 'A' + 1) + (map[2][2] - 'A' + 1) + (map[3][1] - 'A' + 1) == 26 &&
               (map[0][4] - 'A' + 1) + (map[1][5] - 'A' + 1) + (map[2][6] - 'A' + 1) + (map[3][7] - 'A' + 1) == 26 &&
               (map[1][1] - 'A' + 1) + (map[1][3] - 'A' + 1) + (map[1][5] - 'A' + 1) + (map[1][7] - 'A' + 1) == 26 &&
               (map[3][1] - 'A' + 1) + (map[3][3] - 'A' + 1) + (map[3][5] - 'A' + 1) + (map[3][7] - 'A' + 1) == 26 &&
               (map[4][4] - 'A' + 1) + (map[3][3] - 'A' + 1) + (map[2][2] - 'A' + 1) + (map[1][1] - 'A' + 1) == 26 &&
               (map[4][4] - 'A' + 1) + (map[3][5] - 'A' + 1) + (map[2][6] - 'A' + 1) + (map[1][7] - 'A' + 1) == 26;
    }

    static void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        System.exit(0); 
    }
}