import java.util.*; 

class Solution {
    
    static int N;
    static int[][] arr;
    
    public int[] solution(int n) {
        int[] answer = {};
        N = n; 
        arr = new int[N][N];
        
        solve(0);
        
        // for(int[] a : arr){
        //     System.out.println(Arrays.toString(a));
        // }
        
        answer = new int[N*(N+1)/2]; 
        
        int idx = 0; 
        for(int i=0; i<N; i++){
            for(int j=0; j<i+1; j++){
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
    
    static int[] dr = new int[]{1, 0, -1};
    static int[] dc = new int[]{0, 1, -1}; 
    
    static void solve(int start){
        int r = start; 
        int c = start; 
        int d = 0; 
        
        arr[0][0] = 1;
        
        for(int i=1; i< N*(N+1)/2+1; i++){
            // System.out.printf("arr[%d][%d] == %d\n", r, c, i);
            arr[r][c] = i; 
            
            int nr = r + dr[d]; 
            int nc = c + dc[d];
            
            if((nr < 0 || nc < 0 || nr >= N || nc >= N) || (arr[nr][nc] != 0)){
                // System.out.printf("방향전환\n");
                d = (d+1) % 3; 
                nr = r + dr[d];
                nc = c + dc[d];
            } 
            
            // System.out.printf("다음 위치 arr[%d][%d]\n", nr, nc);
            
            r = nr;
            c = nc; 
        }
        
    }
}