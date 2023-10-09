import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    static int D, W, K, ans;
    static int[][] map; 
    static int[] process; // 해당 칸에 어떤 약품처리를 할 지 저장하는 배열
    static StringBuilder sb = new StringBuilder();
 
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        int test_case = Integer.parseInt(sc.readLine());
        for (int t = 1; t <= test_case; t++) {
            st = new StringTokenizer(sc.readLine());
            D = Integer.parseInt(st.nextToken()); // 필름 두께 (행)
            W = Integer.parseInt(st.nextToken()); // 가로 크기 (열)
            K = Integer.parseInt(st.nextToken()); // 합격 기준
             
            map = new int[D][W]; 
            process = new int[D]; 
            ans = Integer.MAX_VALUE;
             
            for(int i=0; i<D; i++) {
                st = new StringTokenizer(sc.readLine());
                for(int j=0; j<W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken()); 
                }
            }
             
// ___________________________________ Input End ___________________________________
            solve(0, 0);
            sb.append("#" + t + " " + ans + "\n");
             
        }
 
        System.out.println(sb);
    }
 
    /**
     * @TODO 약품 처리
     * @param cur 현재 처리할 행의 숫자
     * @param change 약품 투입 횟수
     */
     
    static void solve(int cur, int change) {
        if(change >= ans ) return; 
        if(cur == D) { // 모든 칸 약품 처리 완료 // cur == D로 처리하면 끝까지 처리하지 않음
            // 안정성 검사 시작
//          System.out.println(Arrays.toString(process));
            if(check()) {
                ans = Integer.min(change, ans); 
            }
            return; 
        }
         
        // 그대로 처리
        process[cur] = -1; 
        solve(cur+1, change);
         
        // 약품 A로 처리
        process[cur] = 0; 
        solve(cur+1, change+1);
         
        // 약품 B로 처리 
        process[cur] = 1; 
        solve(cur+1, change+1);
    }
 
    private static boolean check() {
        boolean isAvailable = false;
         
        for(int c=0; c<W; c++) { // 해당 열
            int cnt = 1;
            for(int r=1; r<D; r++) {
                if(cnt >= K) {
                    isAvailable = true;
                    break;
                }
                // 이전 행
                int prev = (process[r-1]==-1) ? map[r-1][c] : process[r-1];
                // 현재 행 
                int cur = (process[r]==-1) ? map[r][c] : process[r];
                 
                if(prev == cur) {
                    cnt++; 
                }else {
                    cnt = 1; 
                }
            }
            // 해당 열의 기준을 통가하지 못하면 break
            if(cnt < K) {
                isAvailable = false; 
                break; 
            }
        }
         
        return isAvailable;
    }
}