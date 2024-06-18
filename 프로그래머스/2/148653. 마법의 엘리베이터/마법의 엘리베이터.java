import java.util.*; 

class Solution {
    /*
        storey : 민수와 마법의 엘리베이터가 있는 층
        
        return 어떤 층에서 엘리베이터를 타고 0층으로 내려가는데 필요한 마법의 돌의 최소 개수
    */
    public int solution(int storey) {
        
        return bfs(storey);
    }
    
    static int bfs(int start){
        
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{start, 0}); 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int height = cur[0];
            // System.out.printf("현재층 : %d, 사용횟수 : %d\n", cur[0], cur[1]);
            
            if(height == 0){
                return cur[1]; 
            }
            
            
            if((height % 10) == 0){
                q.offer(new int[]{height / 10, cur[1]}); 
            }else if((height % 10) == 5){
                if((height/10)%10 >= 5){
                    q.offer(new int[]{(height+5)/10, cur[1]+5});
                }else{
                    q.offer(new int[]{height/10, cur[1]+5});
                }
                
            }else if((height % 10) > 5){
                int gap = 10-(height%10); 
                q.offer(new int[]{(height+gap)/10,  cur[1]+gap}); 
            }else{ 
                q.offer(new int[]{height / 10, cur[1]+(height%10)}); 
            } 
        }
        
        return -1; 
    }
}