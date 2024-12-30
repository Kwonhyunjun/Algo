import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idx = new HashMap<>();
        HashMap<String, HashSet<String>> map = new HashMap<>();
        
        int i = 0;
        for(String id : id_list){
            idx.put(id, i++);
        }
        
        StringTokenizer st;
        for(String report : reports){
            st = new StringTokenizer(report);
            
            String from = st.nextToken();
            String to = st.nextToken(); 
    
            if(!map.containsKey(to)){
                map.put(to, new HashSet<>());
            }
           map.get(to).add(from);
        }
        
        for(Map.Entry<String, HashSet<String>> entry : map.entrySet()){
            
            String key = entry.getKey(); 
            HashSet<String> value = entry.getValue(); 
        
            if(value.size() < k) continue; 
            
            for(String from : value){
                answer[idx.get(from)]++;
            }
        }
        
        
        
        return answer;
    }
}