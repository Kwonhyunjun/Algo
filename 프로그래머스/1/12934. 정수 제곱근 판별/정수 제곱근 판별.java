import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        long s = (long) Math.sqrt(n); 
        
        answer = (n == (long) Math.pow((double) s, 2)) ? (long) Math.pow((double) s+1, 2) : -1; 
        
        // System.out.println(s); 
        
        return answer;
    }
}