import java.util.*; 

class Solution {
    
    static int r, c; 
    static int[] oils, map[];
    static boolean[][] v; 
    static HashSet<Integer> set;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        r = land.length; 
        c = land[0].length; 
        // System.out.println(r +" "+c);
        
        oils = new int[c];
        v = new boolean[r][c];
        map = land; 
        set = new HashSet<>(); 
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                // System.out.println("현재땅: " + map[i][j]); 
                if(map[i][j] == 0) continue; // 빈땅 
                if(v[i][j]) continue; // 이미 시추 완료
                // System.out.println("시추 시작 : " + i + " " + j); 
                int amount = bfs(i, j);
                // System.out.println("시추 완료 : " +amount);
                // System.out.println(set); 
                for(int pos : set){
                    oils[pos] += amount; 
                }
                set.clear();
            }
        }
        
        // System.out.println(Arrays.toString(oils));
        for(int oil : oils){
            answer = Math.max(answer, oil);
        }
        
        return answer;
    }
    
    static int[] dr = {-1, 0, 1, 0}; 
    static int[] dc = {0, 1, 0, -1};
    
    static int bfs(int sr, int sc){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc}); 
        v[sr][sc] = true;
        set.add(sc); 
        int amount = 1; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            // System.out.println(cur[0] + " "+ cur[1]);
            for(int d=0; d<4; d++){
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d]; 
                
                if(nr>=r || nr<0 || nc>=c || nc<0) continue; 
                if(map[nr][nc] == 0) continue; 
                if(v[nr][nc]) continue;
                
                q.offer(new int[]{nr, nc}); 
                v[nr][nc] = true; 
                amount++;
                set.add(nc); 
            }
        }
        
        
        return amount;
    }
}