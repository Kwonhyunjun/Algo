import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        char[][] map = new char[park.length][park[0].length()];
        
        int curR = 0;
        int curC = 0;
        for(int i=0; i<park.length; i++){
            map[i] = park[i].toCharArray();
            for(int j=0; j<map[i].length; j++){
                if(map[i][j] == 'S'){
                    curR = i; curC = j;
                }
            }
        }
        
        int[] dr = new int[]{-1, 1, 0, 0};
        int[] dc = new int[]{0, 0, -1, 1};
        
        StringTokenizer st;
        for(String route : routes){
            st = new StringTokenizer(route);
            char dir = st.nextToken().charAt(0);
            int move = Integer.parseInt(st.nextToken());
            int d = (dir == 'N') ? 0 : (dir == 'S') ? 1 : (dir == 'W') ? 2 : 3; 
            
            boolean flag = true;
            int nr = curR;
            int nc = curC; 
            for(int i=0; i<move; i++){
                nr += dr[d];
                nc += dc[d];
                if((nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length) || map[nr][nc] == 'X'){
                    flag = false; 
                    break; 
                };     
                
            }
            
            if(flag){
                curR = nr;
                curC = nc; 
            }
            
        }
        
        answer = new int[]{curR, curC};
        
        return answer;
    }
}