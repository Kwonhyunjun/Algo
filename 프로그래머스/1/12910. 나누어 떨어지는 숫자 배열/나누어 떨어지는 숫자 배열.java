import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int num : arr){
            if(num % divisor == 0){
                list.add(num);
            }
        }
    
        if(list.size() == 0){
            answer = new int[]{-1}; 
        }else{
            Collections.sort(list);

            answer = new int[list.size()];
            for(int i=0; i<list.size(); i++){
                answer[i] = list.get(i);
            }    
        }
        
        
        return answer;
    }
}