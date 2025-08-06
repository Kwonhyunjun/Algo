import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        long[] height = new long[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            height[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        for (long h : height) {
            sum += h;
        }

        long surfaceArea = sum * 2;           // 위 + 아래
        surfaceArea += cnt * 2;               // 앞 + 뒤
        surfaceArea += height[0];             // 왼쪽
        surfaceArea += height[cnt - 1];       // 오른쪽

        for (int i = 0; i < cnt - 1; i++) {
            surfaceArea += Math.abs(height[i] - height[i + 1]); // 양 옆 차이
        }

        System.out.println(surfaceArea);
    }
}
