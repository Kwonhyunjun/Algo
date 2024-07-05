import java.util.*; 

class Solution {
    
    static int X, Y, N, answer;
    static boolean[] v; 
    
    public int solution(int x, int y, int n) {
        answer = Integer.MAX_VALUE;
        v = new boolean[10000001];
        
        X = x; 
        Y = y; 
        N = n; 
        
        return bfs();
    }
    
    
    static int bfs(){
        Queue<int[]> q = new ArrayDeque<>(); 
        
        q.add(new int[]{X, 0});
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(cur[0] == Y){
                // System.out.printf("[%d, %d]", cur[0], cur[1]);
                return cur[1];
            }
            
            int num = cur[0]*2; 
            if(num <= Y && !v[num]){
                q.offer(new int[]{num, cur[1]+1});
                v[num] = true; 
            }
            
            num = cur[0]*3; 
            if(num <= Y && !v[num]){
                q.offer(new int[]{num, cur[1]+1});
                v[num] = true; 
            }
            
            num = cur[0]+N; 
            if(num <= Y && !v[num]){
                q.offer(new int[]{num, cur[1]+1});
                v[num] = true; 
            }
        }
        
        return -1;
    }
    
}