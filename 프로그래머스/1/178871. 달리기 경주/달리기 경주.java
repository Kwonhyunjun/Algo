import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<players.length; i++){
            map.put(players[i], i+1); 
        }
        
        for(String calling : callings){
            int score = map.get(calling);
            int idx = score - 1; 
            
            String prev = players[idx-1];
            players[idx-1] = calling;
            players[idx] = prev;
            
            map.put(calling, score-1);
            map.put(prev, score);
        }
        
        answer = players; 
        
        return answer;
    }
}