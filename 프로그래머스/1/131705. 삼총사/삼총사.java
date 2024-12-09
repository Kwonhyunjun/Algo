import java.util.*;

class Solution {
    
    static int answer; 
    static int[] number;
    
    public int solution(int[] number) {
        answer = 0;
        this.number = number; 
        
        solve(0, new ArrayList<>());
        
        return answer;
    }
    
    static void solve(int start, ArrayList<Integer> list){
        if(list.size() == 3){
            int sum = 0;
            for(int num : list){
                sum += num;
            }
            if(sum == 0) answer++;
            return; 
        }
        
        for(int i=start; i<number.length; i++){
            list.add(number[i]);
            solve(i+1, list); 
            list.remove(list.size()-1);
        }
    }
}