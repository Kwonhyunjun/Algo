import java.util.*; 

class Solution {
    
    static int answer, min, dungeons[][]; 
    static boolean[] v; 
    // static HashMap<Integer, Integer> map = new HashMap<>();
    
    
    
    /*
        k : 현재 피로도
        dungeons : 각 던전별 [0] - 최소 필요 피로도 / [1] - 소모 피로도
        
        return 유저가 탐험할 수 있는 최대 던전 수
    */
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        this.dungeons = dungeons;
        v = new boolean[dungeons.length]; 
        
        for(int i=0; i<dungeons.length; i++){
            min = Math.min(min, dungeons[i][0]);
        }
        
        dfs(0, k); 
        
        return answer;
    }
    
    /*
        fatigue : 남은 피로도
        cnt : 던전 방문 횟수
    */
    void dfs(int cnt, int fatigue){ 
        // if(fatigue < min){
        //     // answer = Math.max(map.size(), answer);
        //     int count = 0; 
        //     for(int i=0; i<v.length; i++){
        //         if(v[i]) count++; 
        //     }
        //     answer = Math.max(count, answer);
        //     return; 
        // }
        
        answer = Math.max(cnt, answer); 
        
        for(int i=0; i<dungeons.length; i++){
            if(!v[i] && fatigue >= dungeons[i][0]){
                // map.put(i, map.getOrDefault(i, 0)+1); 
                v[i] = true; 
                dfs(cnt+1, fatigue-dungeons[i][1]); 
                // map.put(i, map.get(i)-1);
                // if(map.get(i) == 0){
                //     map.remove(i); 
                // }
                v[i] = false;
            }
            
        }
        
        
    }
}