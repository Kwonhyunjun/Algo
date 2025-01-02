import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        for(int i=1; i<=Math.sqrt(yellow); i++){
            int row = yellow / i; 
            if(yellow%i != 0) continue; 
            
            if((row+2+i) * 2 == brown){
                answer = new int[]{row+2, i+2};
                break;
            }
        }
        return answer;
    }
}