import java.util.*; 

class Solution {
    static int N, M; 
    static int[][] map; 
    static boolean[][] v; 
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1};
    
    static class Data{
        int r; 
        int c;
        int dist; 
        
        public Data(int r, int c, int dist){
            this.r = r; 
            this.c = c;
            this.dist = dist; 
        }   
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        map = maps; 
        N = maps.length; 
        M = maps[0].length; 

        answer = bfs(); 
        
        return answer;
    }
    
    static int bfs(){
        v = new boolean[N][M]; 
        
        Queue<Data> q = new ArrayDeque<>();
        q.add(new Data(0, 0, 1)); 
        
        while(!q.isEmpty()){
            
            Data cur = q.poll(); 
            // System.out.println(cur.r + " " + cur.c + " " + cur.dist); 
            
            if(cur.r == N-1 && cur.c == M-1){
                return cur.dist; 
            }
            
            for(int d=0; d<4; d++){
                int nr = cur.r + dr[d]; 
                int nc = cur.c + dc[d]; 
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M ) continue; // 범위 체크
                if(v[nr][nc]) continue; // 방문체크
                if(map[nr][nc] == 0) continue; // 벽 체크        
                
                q.add(new Data(nr, nc, cur.dist+1)); 
                v[nr][nc] = true; 
            }
            
        }
        
        return -1; 
    }   
}