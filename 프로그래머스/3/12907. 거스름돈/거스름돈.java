import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int m : money){
            
            for(int i=1; i<=n; i++){
                if(i-m >= 0){
                    dp[i] = dp[i] + dp[i-m];
                }
            }
            
        }
        
        // System.out.println(Arrays.toString(dp));
        
        return dp[n];
    }
}