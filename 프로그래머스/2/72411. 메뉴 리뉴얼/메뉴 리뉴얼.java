import java.util.*;

/*
    가장 많이 함께 주문한 단품메뉴끼리
    최소 2가지 이상의 단품메뉴
    최소 2명 이상의 손님으로부터 주문된 단품메뉴
*/

class Solution {
    
    static String[] orders;
    static int[] course; 
    static HashMap<String, Integer>[] maps;
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        this.orders = orders;
        this.course = course; 
        
        maps = new HashMap[11];
        for(int c : course){
            maps[c] = new HashMap<>(); 
            maps[c].put("cnt", -1); 
        }
        
        for(String order : orders){
            for(int c : course){
                solve(-1, 0, c, order, new String()); 
            }
        }
        
        List<String> list = new ArrayList<>(); 
       
        for(int c : course){
            // System.out.println(maps[c].get("cnt"));
            if(maps[c].get("cnt") < 2) continue; 
            HashMap<String, Integer> map = maps[c]; 
            
            for(Map.Entry<String, Integer> entry : maps[c].entrySet()){
                if(entry.getValue() == maps[c].get("cnt") && !entry.getKey().equals("cnt")){
                    list.add(entry.getKey());
                }
            }
            
        }
        
        Collections.sort(list);
        // System.out.println(list);
        answer = new String[list.size()]; 
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    static void solve(int idx, int n, int cnt, String order, String result){
        if(n >= cnt){
            char[] c = result.toCharArray(); 
            Arrays.sort(c); 
            String key = new String(c);
            maps[cnt].put(key, maps[cnt].getOrDefault(key, 0)+1);
            if(maps[cnt].get("cnt") < maps[cnt].get(key)){
                maps[cnt].put("cnt", maps[cnt].get(key)); 
            }
            return; 
        }
        
        for(int i=idx+1; i<order.length(); i++){
            solve(i, n+1, cnt, order, result+order.charAt(i));
        }
    }
}