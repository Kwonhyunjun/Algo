import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        for(int i=1; i<food.length; i++){
            String str = String.valueOf(i).repeat(food[i]/2);
            sb.append(str);
            reverse.append(str);
        }
        
        sb.append(0); 
        sb.append(reverse.reverse());
        answer = sb.toString();
        
        return answer;
    }
}