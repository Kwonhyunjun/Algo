import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {
    static int N, ans;
    static int[][] adjMatrix;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 동기

        adjMatrix = new int[N+1][N+1];

        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m ;i++){
            st = new StringTokenizer(br.readLine());

            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            adjMatrix[to][from] = 1;
            adjMatrix[from][to] = 1;
        }

        v = new boolean[N+1];
        bfs();
        System.out.println(ans-1);
    }

    static boolean[] v;

    private static void bfs() {

        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        v[1] = true;

        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();

            if(depth > 2) return;

            for(int j =0; j<size; j++){
                int cur = q.poll();
//                System.out.println(cur);
                ans++;

                for(int i=1; i<N+1; i++){
                    if(adjMatrix[cur][i] == 0) continue;
                    if(v[i]) continue;

                    q.offer(i);
                    v[i] = true;
                }
            }

            depth++;

//            System.out.println("depth = " + depth);
        }

    }
}