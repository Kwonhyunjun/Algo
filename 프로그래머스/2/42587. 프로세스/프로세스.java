import java.util.*; 
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>(); 
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i, priorities[i]}); 
        }
        
        // while(!q.isEmpty()){
        //     System.out.println(Arrays.toString(q.poll())); 
        // }
        
        Arrays.sort(priorities);
        int p = priorities.length-1; 
        
        int order = 0; 
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            // System.out.println(Arrays.toString(cur)); 
            
            
            // 만약 우선순위라면? 
            if(priorities[p] == cur[1]){
                order++; 
                if(cur[0] == location){
                    return order; 
                }
                // System.out.println("우선순위 일치"); 
                p--; 
            }else{
                // System.out.println("우선순위 불일치"); 
                q.offer(cur); 
            }
            
        }
        
        return answer;
    }
}