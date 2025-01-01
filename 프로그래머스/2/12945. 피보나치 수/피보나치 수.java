import java.util.*;

class Solution {
    static int memo[]; 
    
    public int solution(int n) {
        int answer = 0;
        
        memo = new int[n+1]; 
        
        Arrays.fill(memo, -1);
        
        answer = fibbo(n);
        
        return answer;
    }
    
    static int fibbo(int n){
        if(memo[n] != -1){
            return memo[n];
        }
        
        if(n <= 1){
            return n; 
        }
        
        return memo[n] = (fibbo(n-1) + fibbo(n-2)) % 1234567; 
    }    
}