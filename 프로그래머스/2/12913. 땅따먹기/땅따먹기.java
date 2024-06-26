import java.util.*;

class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int R = land.length;
        int C = land[0].length;
        
        int[][] map = new int[R][C];
        
        int first = 0; 
        int firstIdx = 0; 
        int second = 0; 
        
        for(int i=0; i<4; i++){
            map[0][i] = land[0][i];
        }
        
        for(int i=1; i<R; i++){
            int cur = land[i][0]; 
            map[i][0] = Math.max(cur+map[i-1][3], Math.max(cur+map[i-1][1], cur+map[i-1][2])); 
            cur = land[i][1]; 
            map[i][1] = Math.max(cur+map[i-1][3], Math.max(cur+map[i-1][0], cur+map[i-1][2])); 
            cur = land[i][2];
            map[i][2] = Math.max(cur+map[i-1][3], Math.max(cur+map[i-1][0], cur+map[i-1][1]));
            cur = land[i][3];
            map[i][3] = Math.max(cur+map[i-1][2], Math.max(cur+map[i-1][0], cur+map[i-1][1])); 
        }
        
        // System.out.printf("%d %d %d", first, firstIdx, second); 
        
        // System.out.printf("%s\n", Arrays.toString(map[R-1]));
        
        for(int i=0; i<R; i++){
                
        }
        
        
        answer = Integer.MIN_VALUE; 
        
        for(int i=0; i<4; i++){
            answer = Math.max(answer, map[R-1][i]); 
        }
        

        return answer;
    }
}