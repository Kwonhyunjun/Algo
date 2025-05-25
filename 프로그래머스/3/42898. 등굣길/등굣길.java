import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] puddle : puddles){
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            if(dp[i][1] == -1) break;
            dp[i][1] = 1;
        }
        
        for(int i=1; i<=m; i++){
            if(dp[1][i] == -1) break;
            dp[1][i] = 1;
        }
        
        for(int i=2; i<=n; i++){
            for(int j=2; j<=m; j++){
                if(dp[i][j] == -1) continue;
                
                int up = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
                int left = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
                
                dp[i][j] = (up + left) % 1_000_000_007;
            }
        }
        
        answer = dp[n][m];
        
        
        return answer;
    }
}