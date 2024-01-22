import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] adjMatrix, res;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];
        res  = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                sb.append(res[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

    private static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] v = new boolean[N];

        q.offer(start);

        int cnt = 0;
        while(!q.isEmpty()){
            int cur = q.poll();
//            System.out.println("cur = " + cur);

            if(cnt != 0){
                res[start][cur] = 1;
            }

            for(int i=0; i<N; i++){
                if(adjMatrix[cur][i] == 1){
                    if(v[i]) continue;;

                    q.offer(i);
                    v[i] = true;
                }
            }
            cnt++;
        }
    }
}