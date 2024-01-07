
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, ans ;
    static int[][] map;
    static boolean[] v;
    static List<int[]> homes, chickens;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = Integer.MAX_VALUE;
        map = new int[N][N];
        homes = new ArrayList<>();
        chickens = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    homes.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    chickens.add(new int[]{i, j});
                }
            }
        } // Input End
        v = new boolean[chickens.size()];
//        System.out.println(chickens.size());

        dfs(0, 0, M);

        System.out.println(ans);
    }

    /*
    가게 - 집 거리 체크
    집마다 돌면서 가게마다 최소 거리 구해서 더함
    마지막에 도시의 치킨거리 구함
     */

    /**
     * @param idx 가게순번
     * @param cnt 열린 가게
     * @param limit 최대 열 수 있는 가게
     */
    static void dfs(int idx, int cnt, int limit){
        if(cnt > limit) return;
        if(idx == chickens.size()){
            if(cnt != 0){
//                System.out.println(Arrays.toString(v));
                // 치킨거리 구하기
                int[] min = new int[homes.size()]; // 각자 집에서 최소 치킨 거리

                Arrays.fill(min, Integer.MAX_VALUE);
                for(int i=0; i<chickens.size(); i++){ // 치킨집을 순회하면서
                    if(v[i]){ // 열려있다면
                        int[] chi = chickens.get(i); // 치킨집 좌표
                        for(int j=0; j<homes.size(); j++){
                            int[] ho = homes.get(j);

                            int dist = Math.abs(ho[1] - chi[1]) + Math.abs(ho[0] - chi[0]);

                            min[j] = Math.min(dist, min[j]);
                        }

                    }
                }
                int sum = 0;
                for(int i=0; i< homes.size(); i++){
                    sum += min[i];
                }
                ans = Math.min(ans, sum);
            }
            return;
        }
        v[idx] = true;
        dfs(idx+1, cnt+1, limit);

        v[idx] = false;
        dfs(idx+1, cnt, limit);
    }
}