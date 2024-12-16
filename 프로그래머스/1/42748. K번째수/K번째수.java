import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] command = commands[i]; 
            
            PriorityQueue<Integer> pq = new PriorityQueue<>(); 
            
            for(int j = command[0]-1; j<command[1]; j++){
                pq.offer(array[j]);
            }
            
            int n = command[2]; 
            while(n > 1){
                pq.poll();
                n--;
            }
            answer[i] = pq.poll();
        }
        
        return answer;
    }
}