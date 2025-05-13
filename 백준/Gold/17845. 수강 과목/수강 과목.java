import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;

    static int[] ts;
    static int[] is;
    static int[][] dp;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        ts = new int[k];
        is = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            is[i] = Integer.parseInt(st.nextToken());
            ts[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[k+1][n+1];
        for (int i = 1; i < k+1; i++) {

            int time = ts[i-1];
            int important = is[i-1];

            for (int j = 1; j < n+1; j++) {
                dp[i][j] = dp[i-1][j];
                if(j - time >= 0)dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - time] + important);
            }
        }
        System.out.println(dp[k][n]);
    }

}